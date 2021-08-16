#!/bin/bash
set -e
COMMAND="$1"
CURRENT_DIR=$(pwd)

#================================================================================
## Configs
#================================================================================
TOMCAT_VERSION="tomcat-9.0.37"
LIFERAY_HOME=bundles
LICENSE_XML=~/.liferay/activation/activation-key-dxpdevelopment-7.3-developeractivationkeys.xml
#FIXPACK_FILE=~/.liferay/fix-packs/liferay-fix-pack-dxp-5-7210.zip
#HOTFIX_FILE=~/.liferay/hotfixes/liferay-hotfix-4004-7210.zip
PROJECT=lsw
DB_NAME=lportal
MYSQL_VERSION=8
MYSQL_PORT=3306

#================================================================================
## Tasks
#================================================================================

load_backup(){
	log_info "=> TASK: load_backup"

	if [ ! -d "dump" ]; then
	  log_info "Creating dump directory...";
	  log_debug mkdir dump
	fi

	log_info "Extracting backups/${PROJECT}_mysql.tgz..."
	log_debug tar -C dump -xvf backups/${PROJECT}_mysql.tgz

	if [ ! -d "bundles/data" ]; then
	  log_debug mkdir -p bundles/data
	fi

	log_info "Info: Importing document and library";
	if [ ! -d "bundles/data/document_library" ]; then
	  log_debug mkdir -p bundles/data/document_library
	fi
	log_debug rm -rf bundles/data/document_library/*
	log_debug tar -C bundles/data/document_library -xvf backups/"$PROJECT"_document_library.tgz
}

save_backup(){
	log_info "=> TASK: save_backup"
	log_info "Generating backup..."

	log_info "Creating backups directory..."
	log_debug mkdir -p backups

	log_info "Creating Mysql dump..."
	log_info "docker exec "${PROJECT}"_mysql /usr/bin/mysqldump -uroot -proot --databases --add-drop-database ${DB_NAME}  > "${PROJECT}"_mysql.sql"
	docker exec "${PROJECT}"_mysql /usr/bin/mysqldump -uroot -proot --databases --add-drop-database ${DB_NAME} > "${PROJECT}"_mysql.sql

	log_info "Compressing ${PROJECT}_mysql.sql to backups/${PROJECT}_mysql_mysql.tgz..."
	log_debug tar -czvf backups/"${PROJECT}"_mysql.tgz "${PROJECT}"_mysql.sql

	log_info "Removing ${PROJECT}_mysql.sql dump from liferay root directory..."
	log_debug rm "${PROJECT}"_mysql.sql

	log_info "Info: Exporting document and library";
	if [ -d "bundles/data/document_library" ]; then
	  log_debug tar -czvf backups/"$PROJECT"_document_library.tgz $LIFERAY_HOME/data/document_library*
	fi
}

#
#--------------------------------------------------------------------------------
#
show_logs() {
log_info "=> TASK: show_logs"
while ! log_debug tail -f bundles/$TOMCAT_VERSION/logs/catalina.out ; do sleep 1 ; done
}

#
#--------------------------------------------------------------------------------
#
build_project() {
log_info "=> TASK: build_project"
log_debug blade gw deploy -x packageRunTest
}

#
#--------------------------------------------------------------------------------
#
clean_temps(){
log_info "=> TASK: clean_temps"

log_info "Cleaning temp files..."
log_debug rm -rf $LIFERAY_HOME/work/*
log_debug rm -rf $LIFERAY_HOME/osgi/state/*
log_debug rm -rf $LIFERAY_HOME/tomcat-$TOMCAT_VERSION/temp/*
log_debug rm -rf $LIFERAY_HOME/tomcat-$TOMCAT_VERSION/work/*
}

#
#--------------------------------------------------------------------------------
#
start_server() {
log_info "=> TASK: start_server"
log_debug blade server start -d
}

#--------------------------------------------------------------------------------
# Patching tool
#--------------------------------------------------------------------------------
apply_patches(){
log_info "=> TASK: apply_patches"
# log_info "Install $HOTFIX_FILE"
# cp $HOTFIX_FILE bundles/patching-tool/patches
# cp $FIXPACK_FILE bundles/patching-tool/patches
# ./bundles/patching-tool/patching-tool.sh install
# ./bundles/patching-tool/patching-tool.sh info
}

#--------------------------------------------------------------------------------
# Deploy liferay license
#--------------------------------------------------------------------------------
deploy_license() {
log_info "=> TASK: deploy_license"
log_info "Locating Liferay license..."

if [ -f $LICENSE_XML ]; then
	log_info "Deploying license file: \"$LICENSE_XML\""
	log_debug cp $LICENSE_XML bundles/deploy/
else
	log_error "License not found at \"$LICENSE_XML\". Please deploy it manually"
	exit 2
fi

}

#--------------------------------------------------------------------------------
# Create docker - db container
#--------------------------------------------------------------------------------
create_docker_db() {
log_info "=> TASK: create_docker_db"
if [ ! "$(docker ps -q -f name=\"$PROJECT\"_"mysql")" ]; then
	  echo "Info: Starting mysql container...";
	  log_debug docker run \
		-v "$CURRENT_DIR"/dump:/docker-entrypoint-initdb.d \
		--name "$PROJECT"_mysql \
		-p "$MYSQL_PORT":3306 \
		-e MYSQL_DATABASE=$DB_NAME \
		-e MYSQL_ROOT_PASSWORD=root \
		-d mysql:$MYSQL_VERSION \
		--character-set-server=utf8 \
		--collation-server=utf8_general_ci \
		--lower-case-table-names=0
	  secs=$((30))
	  while [ $secs -gt 0 ]; do
		echo -ne "$secs\033[0K\r"
		sleep 1
		secs=$((secs-1))
	  done
fi
}

#--------------------------------------------------------------------------------
# Init bundle
#--------------------------------------------------------------------------------
init_bundle() {
log_info "=> TASK: setup_bundle"
log_info "Setup bundle $LIFERAY_BUNDLE"

if log_debug blade gw initBundle \
		-Pliferay.workspace.environment=local; then
	log_info "Bundle set up successfully"
else
	log_error "Bundle failed to initialize\n"
fi

}

#--------------------------------------------------------------------------------
# Remover docker - db container
#--------------------------------------------------------------------------------
remove_docker_db() {
log_info "=> TASK: remove_docker_db"

# Check if docker is running
log_info "docker ps -a"
if ! docker ps -a | grep -q CONTAINER
then
		log_error "Docker does not seem to be running, run it first and retry"
		exit 1
fi

if docker ps -a -f name="$PROJECT"_"mysql" | grep -q "$PROJECT"_"mysql"
then
	log_debug docker stop "$PROJECT"_"mysql"
	log_debug docker rm "$PROJECT"_"mysql"
fi
}

#--------------------------------------------------------------------------------
# Remove the bundle directory if it already exists
#--------------------------------------------------------------------------------
remove_bundle() {
log_info "=> TASK: remove_bundle"
log_info "The $LIFERAY_HOME directory will be erased."
log_debug rm -rf $LIFERAY_HOME

log_info "The build/node_modules/dist directories will be erased."
log_debug find . -name 'build' -type d -prune -exec rm -rf '{}' +
log_debug find . -name 'node_modules' -type d -prune -exec rm -rf '{}' +
log_debug find . -name 'dist' -type d -prune -exec rm -rf '{}' +
}

#--------------------------------------------------------------------------------
# Stop tomcat server
#--------------------------------------------------------------------------------
stop_server() {
log_info "=> TASK: stop_server"
log_info "Stopping liferay..."
if [ -d "bundles" ]; then
	log_debug blade server stop
fi
}

load_state_command() {
stop_server
remove_docker_db
clean_temps
load_backup
create_docker_db
start_server
show_logs
}

save_state_command() {
save_backup
}

#
#--------------------------------------------------------------------------------
#
init_command() {
stop_server
remove_bundle
remove_docker_db
init_bundle
#load_backup
create_docker_db
deploy_license
#apply_patches
build_project
start_server
show_logs
}

#================================================================================
## Logs
#================================================================================
blue=$'\e[1;34m'
cyan=$'\e[1;36m'
white=$'\e[0m'
red=$'\e[31m'

log_date() {
echo $(date '+%Y-%m-%d %H:%M:%S') "$@"
}

log_debug() {
log_date "DEBUG.: " "$cyan" "$@" "$white"
"$@"
}

log_info() {
echo "-------------------"
log_date "INFO..: " "$blue" "$@" "$white"
echo "-------------------"
}

log_error() {
echo "-------------------"
log_date "ERROR..: " "$red" "$@" "$white"
echo "-------------------"
}

#================================================================================
## Interface
#================================================================================

case "${COMMAND}" in
init ) init_command
		log_info "Finished project initialization."
		exit 0
		;;
saveState ) save_state_command
		log_info "State saved."
		exit 0
		;;
loadState ) load_state_command
		log_info "State saved."
		exit 0
		;;
*)
	  echo $"Usage:" "$0" "{init, saveState, loadState}"
	  exit 1
esac
exit 0
