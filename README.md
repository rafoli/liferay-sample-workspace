# Liferay Sample Workspace

## Current stable version: v1.0.0

## Getting Started
1. On your terminal, clone this repository into a local directory of your choice (preferably, use your home directory or subfolder).
2. Inside this directory and the `liferay-sample-workspace` folder, run `blade gw initBundle` to download and install a `bundles` subfolder into your workspace folder, containing all the components needed to start a Liferay local instance on your local machine.

## Starting a Liferay Local Instance
1. Open a new tab in your terminal, and go to `./bundles/tomcat-9.X.X/bin` subfolder.
2. Run `./catalina.sh run` (for Linux users) to start a Liferay DXP local instance.
3. Copy an activation key to the `deploy` folder to register a Liferay license for DXP Development.
4. Open a tab in your browser and type `localhost:8080`.
5. Follow the ***Basic Configuration*** steps, inserting an email and a password, and then accepting the ***Terms of Use***.
6. You should be redirected to the Home page of your Liferay DXP instance.

## Deploy Modules
1. Go back to the first tab of your terminal, execute `blade gw deploy` command to download and install the dependencies needed to deploy the modules.
2. Next, you can check the activated modules via Gogo Shell, typing `blade sh lb sample`.
3. You should see *five* Liferay Sample Modules from this project with `Active` state.

## Adding Liferay Sample Module into Liferay Portal
1. Go back to the Homepage of your Liferay DXP instance opened in your browser.
2. In the Control Menu, click on the *Edit* button.
3. Search for *Liferay Sample Module JS*.
4. Drag and down the widget into the page, and then click on *Publish".
5. 

## Importing Collection into Postman
1. Launch Postman and go to your workspace, if already created.
2. Click on *Import* button and search for `Liferay.postman_collection.json` within your `liferay-sample-workspace` directory. 
3. After importing, you should see *four* requests (GET, POST, PUT and DELETE) which correspond to the *four* methods implemented in this project, using ***mock data*** and REST APIs architecture.

## Granting Access to the Web Service
1. To use these APIs, you have to grant access to them. 
2. Otherwise, a *Access Denied* message will display as a response to your request. 
3. In order to grant access, go to *Auth* tab of each request and insert into *Username* and *Password* fields the email and password of the user who you've just created in your Liferay DXP instance (Step 5 of **Starting Liferay Local Instance** topic).
4. After that, you should submit a request and then have as a response the ***mock data*** defined within each sample method.

## Making Requests via Postman
...

## Making Requests via Frontend (Angular)
...

## Liferay REST API Architecture Overview
...
![Sample Module](https://user-images.githubusercontent.com/83607914/122243070-34241f00-ce9a-11eb-87bf-9c563813cb2a.png)

