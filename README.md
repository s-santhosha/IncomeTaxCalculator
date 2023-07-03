# ATO Income Tax Calculator Cucumber Java Project #


This project is an example of UI automated functional test of ATO Income Tax Calculator tool using Cucumber and Selenium.

Test Scenarios are described in BDD framework as feature files located at "src/test/resources/features"

Feature files implemented using Background and Scenario Outline 

## Installation Requirements ##
- Java 8 SDK
- Chromedriver
- Maven
- Pom.xml contains required plugins to run the automation scripts

To install all dependencies, please run

```Console or Command line
$ mvn clean install
```

## To Run Tests ##

```Console or Command line
$ mvn test
```

By default tests run on chrome browser, multiple browsers can be configured as required.

Specific tests can be run using tags `-Dcucumber.options="--tags @tag-name`.



 
