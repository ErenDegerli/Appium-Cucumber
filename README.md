# Getir Test Case
###Appium Test Framework

This is the task prepared for Getir test case request. It includes the steps of Sign In, Cart Controls, Adding/Removing Products etc. Please check the instruction below for running the script.

(Java, Selenium, Appium, JUnit5, Log4j, Allure Reports)

## Running the tests

In order to run the test please use the code below on the command prompt

- mvn clean test

##To See Report
- install allure from here https://docs.qameta.io/allure/#_installing_a_commandline

When the test execution finished, enter the command below inside the project in order to see Allure Results:

- allure serve target/allure-reports/

### Break down into end to end tests

JUnit5 is used in this case due to the easing mechanism of the display name, description, tags annotation and also concurrent execution option. All the steps are created separately, dynamically and understandably.

The plain language is provided by using cucumber and gherkin language. Also, descriptive approach is supported with Log4j logs and allure reports. Each clause are applied one by one to make it easier to understand and maintain.

```
 User signs in with "hello@getir.com" username and "hello" password
```

### Coding Style

There are OOP and POM principles are used in this coding.

```
OOP can be seen with the page classes, Base and driver classes
POM can be seen with the implementation of the elements on their own specific pages such as LoginPage, DashboardPage, CartPage and etc.
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Authors

* **Eren Can Degerli** - *Initial work*