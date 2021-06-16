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
6. You should be redirected to the *Home* page of your Liferay DXP instance.

## Deploy Modules
1. Go back to the first tab of your terminal, execute `blade gw deploy` command to download and install the dependencies needed to deploy the modules.
2. Next, you can check the activated modules via Gogo Shell, typing `blade sh lb sample`.
3. You should see *five* Liferay Sample Modules from this project with `Active` state.

## Adding Liferay Sample Module into Liferay Portal
1. Go back to the *Home* page of your Liferay DXP instance opened in your browser.
2. In the Control Menu, click on the *Edit* button.
3. Search for *Liferay Sample Module JS*.
4. Drag and drop the widget inside the page, and then click on *Publish".
5. You should see a **mock data** set representing a sample response from the module (soon, you shall see it corresponds to a sample response of a sample GET request).

## Importing Collection into Postman
1. Launch Postman and go to your workspace, if it's already created.
2. Click on *Import* button and search for `Liferay.postman_collection.json` within the `postman` folder. 
3. After importing, you should see two collections of *five* requests (GET, POST, PUT and DELETE) which correspond to the *five* methods implemented in this project, using ***mock data*** and REST APIs architecture.
4. Also, you should see in *Environments* tab, a *Sample Module Mock Server*, which has a `baseUrl` variable defined.

## Granting Access to the Web Service
1. To use these APIs, you have to grant access to them. 
2. Otherwise, a *Access Denied* message will display as a response to your request. 
3. In order to grant access, go to *Auth* tab of each request and insert into *Username* and *Password* fields the email and password of the user who you've just created in your Liferay DXP instance (Step 5 of **Starting Liferay Local Instance** topic).
4. After that, you should submit a request and then have as a response the ***mock data*** defined within each sample method.

## Making Requests via Postman
* You can make requests for both `Sample Module External API` and `Sample Module Liferay API` collection, just opening the desired request and click on *Send* (Note: your Liferay DXP instance must be running!).
* For instance, the response for the `GET Samples` request (for both collections) would be:

> ![image](https://user-images.githubusercontent.com/83607914/122273806-3bf2bc00-ceb8-11eb-89eb-32212b161c5d.png)

* The **mock data** is defined within the `OK` example file from the `Sample Module External API` collection to represent the response of each request.

## Making Requests via Frontend (Angular)
...

## Liferay REST API Architecture Overview
The scheme below illustrates the workflow of a Liferay web service.

![Sample Module](https://user-images.githubusercontent.com/83607914/122243070-34241f00-ce9a-11eb-87bf-9c563813cb2a.png)

### liferay-sample-module-js-web
* The `liferay-sample-module-js-web` module corresponds to the frontend layer of the entire module, i.e., the **view** layer of the MVC portlet architecture. 
* It is responsable to display the data on the page, using Angular technology (a JavaScript framework) and send the users' request to `liferay-sample-module-web-rest` .

### liferay-sample-module-web-rest
* The `liferay-sample-module-web-rest` module corresponds to the application component, i.e., the **controller** layer of the MVC portlet architecture. 
* It is responsable to send the users' request to the `liferay-sample-module-api` module.

### liferay-sample-module-api
* The `liferay-sample-module-api` module contains the model and service definition, in this project the `SampleObject` model and the `SampleService` interface.
* With `liferay-sample-module-service` module, both of these modules corresponds to the **model** layer of the MVC portlet architecture.

### liferay-sample-module-service
* The `liferay-sample-module-service` is responsable for implementing those methods defined within the `SampleService` interface, at `liferay-sample-module-api` module. 
* Also, the `liferay-sample-module-service` module sends the users' request to the `liferay-sample-module-ws-client` module and takes its response, sending back to the previous modules.
* The `liferay-sample-module-service` module includes a `SampleServiceMapper` class, which maps specific entities' properties from the client-side to corresponding attributes defined within the `SampleObject` model.
* Those attributes are the ones displayed within the Angular frontend layer (`liferay-sample-module-js-web`).

### liferay-sample-module-ws-client
* The `liferay-sample-module-ws-client` module is the responsable for sending requests to external APIs and sending a `response` object back to the previous modules.









