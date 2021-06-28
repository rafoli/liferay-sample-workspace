# Welcome to the Liferay Automated Tests repository.

# Overview
This project contains automation based on Liferay GS Selenium Commons Framework. In this project you will find the module with functional tests - TDD.

# Functional Tests
Functional tests are used to demonstrate tasks performed by the end user. In this case, web elements and actions are tested. No code will be directly tested.

##Functional Tests with TDD
[/functional-test-TDD]

### Tests
1. This package is responsible for organizing the tests from the features (Jira's project).
2. Business rule
3. Should extend from FunctionalTest class - It provides a retry of each test method when anyone fails. Example: `public class CreateNewViewTest extends FunctionalTest`
4. `@afterTest` - will force the user logout. To guarantee the integrity of that scenario.
5. The method TasksBuilder createTaskBuilder provide to the test, create a dynamic object for the NewTask.
6. JavaFaker - a lib to provide dynamic objects.

### Model
1. Builder Class - Design Pattern to create dynamically objects

### Pages (work with Page Objects)
1. It's not working with Fluent Pattern
2. Create separate components to check the page objects components.
3. All xpaths is on the class

### Tests Suite
__1. RunAllTests:__ It is used to define test suites, e.g.: sanity test suite.
Test classes should be added on *@Suite.SuiteClasses(LoginTest.class)*

### Utils

__1. CommonMethods:__ It has methods that facilitate the interaction with the elements of a page and there are logical rules to reuse in many different classes.
ex.: wait until an element is visible to click on it.

# How to use

## TDD Functional test

### Enviroment setted by default (file: SeleniumPropertyKeys.properties, go to -> modules > test > SeleniumProperties)

`browser=defaultGC` #Will open the Chrome browser

`time-out=15` #timeout implicit to wait elements

`username=` #default user to access the portal

`password=` #default password to access the portal

`number-of-failed-tests-retry-test-execution=2` #

`number-of-browser-in-parallel=1` #To set the quantity of browsers will work at the same time in parallel - should be set if run in headless

`environment=https://webserver-liferayportal-qa.lfr.cloud` #Dev environment

### The magic happens...

- How to setup the chrome driver on the project:

>> `blade gw setupPerformTestWithGoogleChrome`

- How to run the automated tests, by command line:

>> `blade gw performTest`

- How to run a specific automated tests class, by command line:

>> `blade gw performTestClass -PclassToBeTested=RunAllTests`
>> `blade gw performTestClass -PclassToBeTested=DeleteNewViewTest`

- Verify if the code has been implemented in the US project standard:

>> `gw formatSource --rerun-tasks`

### Standardization - Must to have
- New branch's name

>> `git checkout -b lw-#` - name of the task on the Jira

- Thing to to Before to commit

>> Remind to **rebase** your branch

>> Check the item US project standard

- The commit standard:

>> `git commit -m "lw-# Add new scenario to ABC"`. ticket task number + what you did

- Thing to to before to open the PR:

>> Remove any problem that your code should has

- Author Name

>> Every class should have the @author who created

- Tickets - Cycle of Life

>> After opening the Pull Request - move the ticket status from Doing to Review.

- Tests method naming

>> Try to use the same sentence from the ticket - already created by PO.
>> Example: (from ticket) Verify that all sections are expanded - (from the project) verifyThatAllSectionsAreExpanded()

- CI (Continuos Integration)

>> Everytime, after opening the PR, check if the CI will approve the implementation. If not, fix it.