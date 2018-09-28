# EtsySeleniumChallenge
## How it is organized
The code is organized in two packages:

**/src/main/java**
* Constants.java: has all the important Constants you need to use in order to run the test. Before running it, make sure the e-mail address is not used, so you can register the account successfully.
* EtsyMethods.java: has the implementation of the different business flows defined.
* EtsyObjects.java: has the definition for every used object in the project.

**/src/test/java**
* EtsyTest.java: has the validations for the tests and it is the main class for the project

## How to make it work
This project is made with Eclipse, Selenium WebDriver, JUnit and Gradle. Gradle manages library dependencies, so you need to make sure you have it installed.
To run the project, right click EtsyTest.java class and run it as a JUnit class.
