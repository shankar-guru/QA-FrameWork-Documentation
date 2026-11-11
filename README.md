# Mobile Automation Framework

## 1. Project Overview

This project is designed to automate mobile application testing using Appium with Java. It follows the Behaviour-Driven Development (BDD) approach using Cucumber and TestNG.

The framework uses the Page Object Model (POM) design pattern to maintain reusable, scalable, and maintainable automation scripts.

## 2. Technology Stack

| Technology | Purpose |
|---|---|
| Java | Programming Language |
| Appium | Mobile Automation |
| Selenium WebDriver | Element Interaction |
| Cucumber | BDD Framework |
| TestNG | Test Execution |
| Maven | Dependency Management |
| Allure | Test Reporting |
| Eclipse IDE | Development Environment |
| Android Studio | Emulator Management |

## 3. Framework Architecture

The framework follows the Page Object Model (POM) architecture.

- **Feature Files:** Define test scenarios using Gherkin syntax.
- **Step Definitions:** Implement the steps defined in feature files.
- **Page Classes:** Maintain mobile application locators and page actions.
- **Utilities:** Provide reusable methods for element interactions.
- **Hooks:** Manage test setup and teardown.
- **Driver Manager:** Initialize and manage the Appium driver.
- **Test Runner:** Configure and execute Cucumber scenarios.

## 4. Project Structure

```text
MobileHybridFrameWork-TestNG
│
├── src
│   ├── main
│   │   └── java
│   │       ├── base
│   │       ├── pages
│   │       ├── utilities
│   │       └── driver
│   │
│   └── test
│       ├── java
│       │   ├── hooks
│       │   ├── stepDefintion
│       │   └── testRunner
│       │
│       └── resources
│           └── features
│
├── allure-results
├── allure-report
├── target
├── pom.xml
├── testng.xml
└── README.md
```

## 5. Prerequisites

Install and configure the following tools before executing the framework:

1. Java JDK
2. Eclipse IDE
3. Apache Maven
4. Node.js and npm
5. Appium Server
6. Android Studio
7. Android SDK
8. Android Emulator or Physical Android Device
9. Allure Command Line

## 6. Environment Configuration

Before execution, configure the following details:

- Appium Server URL
- Android Device Name
- Platform Name
- Platform Version
- Application APK path
- Application Package
- Application Activity

Ensure that the Android emulator or physical device is connected and accessible.

Verify the device connection:

```bash
adb devices
```

Verify Appium installation:

```bash
appium --version
```

## 7. Dependency Installation

Navigate to the project root directory and execute:

```bash
mvn clean install
```

This command downloads the required Maven dependencies and builds the project.

## 8. Test Execution

### Execute through Maven

```bash
mvn clean test
```

### Execute through TestNG

1. Open the project in Eclipse.
2. Locate `testng.xml`.
3. Right-click the file.
4. Select Run As → TestNG Suite.

## 9. Failed Scenario Execution

The framework supports failed scenario reruns using the configured Cucumber rerun mechanism.

Execute the TestNG suite to run the configured initial and failed-scenario runners.

Check the configured failed-scenario file under the `target` directory.

## 10. Allure Reporting

Allure is used to generate detailed test execution reports.

### Step 1: Generate Allure Report

```bash
npx allure generate ./allure-results --clean
```

### Allure Report Includes

- Total test cases
- Passed test cases
- Failed test cases
- Execution details
- Failure information
- Screenshots and attachments (when configured)

## 11. Test Coverage

The framework can be used to automate mobile application scenarios such as:

- Login and Logout
- Dashboard Validation
- Navigation
- Form Validation
- User Interaction
- Functional Workflows

Actual automation coverage depends on the implemented feature files and test scripts.

## 12. Best Practices

- Follow Page Object Model principles.
- Maintain reusable utility methods.
- Avoid hardcoding test data.
- Use meaningful test case and scenario names.
- Maintain proper locator strategies.
- Capture screenshots for failed scenarios.
- Keep test data and configuration separate.
- Update test documentation when scenarios change.

## 13. Reporting and Test Evidence

Maintain execution reports and supporting evidence for each test cycle.

Recommended evidence:
- Allure execution report
- Failure screenshots
- Test execution logs
- Defect references
- Test execution summary

## 14. Maintained By

**QA Automation Team**

Project: Mobile Automation Framework

Framework: Appium + Java + Cucumber + TestNG
