# Hybrid Automation Framework

## 1. Project Overview

This repository contains a Java-based Hybrid Automation Framework developed using Selenium WebDriver, Cucumber BDD, TestNG and Maven.

The framework follows the Page Object Model (POM) design pattern and provides reusable browser operations, element handling utilities, configuration management, screenshot capture, parallel execution and failed-scenario rerun capabilities.

It is designed to improve automation reusability, maintainability and test execution efficiency.

## 2. Technology Stack

| Technology | Purpose |
|---|---|
| Java 17 | Programming language |
| Selenium WebDriver | Web browser automation |
| Cucumber BDD | Behaviour-driven testing |
| TestNG | Test execution and parallel execution |
| Maven | Build and dependency management |
| Page Object Model | Page and locator management |
| WebDriverManager | Browser driver management |
| Allure | Test reporting |
| Log4j / SLF4J | Logging |
| Git & GitHub | Version control |
| Eclipse IDE | Development environment |

## 3. Project Information

**Framework:** Hybrid Automation Framework  
**Language:** Java 17  
**Automation Tool:** Selenium WebDriver  
**BDD:** Cucumber  
**Test Runner:** TestNG  
**Design Pattern:** Page Object Model  
**Build Tool:** Maven  
**Reporting:** Allure  
**Version Control:** Git & GitHub

## 4. Framework Structure

```text
Hybrid_FrameWork_TestNG/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── DriverFactory/
│   │       ├── Pages/
│   │       └── utilities/
│   │
│   └── test/
│       ├── java/
│       │   ├── hooks/
│       │   ├── stepDefinition/
│       │   └── testRunner/
│       │
│       └── resources/
│           ├── features/
│           └── config.properties
│
├── allure-results/
├── target/
├── test-output/
├── pom.xml
├── testng.xml
└── README.md
```

## 5. Framework Components

### DriverFactory

Responsible for browser initialization and WebDriver lifecycle management.

Responsibilities:
- Chrome browser initialization.
- Firefox browser initialization.
- Edge browser initialization.
- WebDriverManager integration.
- ThreadLocal WebDriver management.
- Retrieving the active WebDriver instance.
- Closing browser sessions and removing thread references.

### Pages

Contains page-specific locators and reusable page interaction methods.

Responsibilities:
- Maintaining page elements.
- Implementing page-level actions.
- Separating UI interactions from test logic.
- Improving locator and method reusability.

### Utilities

Contains reusable framework utilities and configuration handling.

Responsibilities:
- Element interaction methods.
- Explicit wait operations.
- Window and tab handling.
- Dropdown handling.
- File upload and download.
- Screenshot and browser utility operations.
- Configuration property reading.

### Hooks

Manages scenario-level setup and teardown.

Responsibilities:
- Initializing the browser before scenario execution.
- Navigating to the configured application URL.
- Capturing screenshots when scenarios fail.
- Attaching screenshots to Cucumber reports.
- Closing browser sessions after execution.

### Step Definition

Connects Gherkin feature steps with Java automation methods.

Responsibilities:
- Implementing Given, When, Then and And steps.
- Calling corresponding page methods.
- Performing test validations.
- Maintaining reusable step definitions.

### Test Runner

Responsible for configuring and executing Cucumber scenarios through TestNG.

Responsibilities:
- Feature file configuration.
- Glue package configuration.
- Cucumber plugin configuration.
- Test execution management.
- Allure reporting integration.
- Parallel execution configuration.

### Features

Contains test scenarios written in Gherkin syntax.

Responsibilities:
- Defining application test scenarios.
- Maintaining positive and negative test cases.
- Organizing scenarios using feature files.
- Supporting reusable scenario execution.

### config.properties

Maintains external application and browser configurations.

Example:

```properties
browser=chrome
qaurl=https://example.com
```

### pom.xml

Manages Maven dependencies, framework libraries and build configurations.

### testng.xml

Defines TestNG suite execution, runner classes and parallel execution settings.

## 6. Browser Support

The framework supports the following browsers:

- Google Chrome
- Mozilla Firefox
- Microsoft Edge

Browser selection is managed through `config.properties`.

## 7. Prerequisites

Install the following before executing the framework:

1. Java JDK 17.
2. Eclipse IDE.
3. Apache Maven.
4. Google Chrome, Firefox or Microsoft Edge.
5. Git.
6. Allure Commandline.

Verify installations:

```bash
java -version
mvn -version
git --version
```

## 8. Clone the Repository

```bash
git clone <YOUR_GITHUB_REPOSITORY_URL>
```

Navigate to the project:

```bash
cd Hybrid_FrameWork_TestNG
```

## 9. Import into Eclipse

1. Open Eclipse IDE.
2. Select File → Import.
3. Choose Maven → Existing Maven Projects.
4. Browse to the cloned project directory.
5. Select `pom.xml`.
6. Click Finish.
7. Wait for Maven dependencies to download.

## 10. Test Execution

### Through Eclipse

1. Open `testng.xml`.
2. Right-click the file.
3. Select Run As → TestNG Suite.
4. Monitor execution in the TestNG results window.

### Through Maven

```bash
mvn clean test
```

Ensure the Maven Surefire configuration is set up to execute the intended TestNG suite.

## 11. Parallel Execution

The framework supports Cucumber scenario execution through TestNG DataProvider.

Example:

```java
@Override
@DataProvider(parallel = true)
public Object[][] scenarios(ITestContext context) {
    return super.scenarios(context);
}
```

The thread count can be configured in `testng.xml`.

The DriverFactory uses ThreadLocal WebDriver management to maintain separate browser instances for individual execution threads.

## 12. Failed Scenario Rerun

The framework supports rerunning failed Cucumber scenarios.

Execution flow:

1. Initial TestRunner executes all configured scenarios.
2. Failed scenarios are recorded in `target/failed_scenarios.txt`.
3. FailedTestRunner reads the recorded scenario locations.
4. Only failed scenarios are executed again.
5. A separate rerun report is generated.

Both runners should be configured in the TestNG XML in the correct execution order.

## 13. Allure Reporting

Allure is integrated to provide detailed test execution reports.

Generate the report:

```bash
allure generate target/allure-results --clean -o allure-report
```

Open the report:

```bash
allure open allure-report
```

Report information includes:
- Execution summary.
- Passed, failed and skipped scenarios.
- Scenario-level details.
- Failure screenshots.
- Execution evidence and attachments.

## 14. Git Contribution Guidelines

Pull the latest changes:

```bash
git pull origin Web-Automation
```

Check modified files:

```bash
git status
```

Stage changes:

```bash
git add .
```

Commit changes:

```bash
git commit -m "Updated hybrid automation framework"
```

Push changes:

```bash
git push origin Web-Automation
```

For shared development, use Pull Requests and review changes before merging.

## 15. Framework Guidelines

- Follow the Page Object Model design pattern.
- Maintain reusable methods in the Utilities package.
- Keep browser initialization and cleanup in DriverFactory.
- Maintain page-specific locators in Pages.
- Store application and browser configurations in config.properties.
- Use ThreadLocal WebDriver for parallel execution.
- Maintain meaningful feature and scenario names.
- Avoid hardcoding sensitive credentials.
- Capture screenshots for failed scenarios.
- Review Allure reports after execution.
- Follow consistent coding and naming conventions.

## 16. Maintained By 

 ** QA Team **


