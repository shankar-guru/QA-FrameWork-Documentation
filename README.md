# Web Automation Framework

## 1. Project Overview

This repository contains a Java-based Web Automation Framework developed using Selenium WebDriver and Cucumber BDD. It follows the Page Object Model (POM) design pattern to organize page elements and reusable browser interactions.

The framework currently includes automated login testing for the SauceDemo application, covering both valid and invalid login scenarios. It also integrates Allure for test execution reporting and failure screenshot attachments.

## 2. Technology Stack

| Technology | Purpose |
|---|---|
| Java | Programming language |
| Selenium WebDriver 4.39.0 | Browser automation |
| Cucumber 7 | BDD and feature-based testing |
| JUnit 4 | Test execution |
| Maven | Dependency management and build |
| Page Object Model (POM) | Page and locator management |
| Allure 2.35.4 | Test reporting |
| Log4j 2 | Logging dependencies |
| Apache Commons IO | File handling utilities |
| Eclipse IDE | Development environment |

## 3. Project Information

**Framework:** Web Automation Framework  
**Language:** Java  
**Automation Tool:** Selenium WebDriver  
**BDD Tool:** Cucumber  
**Design Pattern:** Page Object Model  
**Test Runner:** JUnit  
**Reporting:** Allure

## 4. Framework Structure

```text
Demo_Script/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       ├── BaseClass/
│   │   │       │   └── BaseClass.java
│   │   │       │
│   │   │       └── PomClass/
│   │   │           └── PomClass.java
│   │   │
│   │   └── resources/
│   │
│   └── test/
│       ├── java/
│       │   ├── SwagLabs/
│       │   │   └── Login.feature
│       │   │
│       │   └── com/
│       │       ├── Hooks/
│       │       │   └── Hooks.java
│       │       │
│       │       ├── StepDefinition/
│       │       │   └── StepDefinition.java
│       │       │
│       │       └── TestRunner/
│       │           └── TestRunner.java
│       │
│       └── resources/
│           └── allure.properties
│
├── pom.xml
├── .gitignore
└── README.md
```

## 5. Framework Components

### BaseClass
Contains reusable Selenium WebDriver methods and browser management functionality.

Key functionalities include:
- Browser launch and close.
- Click and text entry operations.
- Clear and retrieve element values.
- Explicit waits.
- Dropdown handling.
- Mouse hover and keyboard actions.
- Drag and drop.
- JavaScript execution.
- Alert and frame handling.
- Window handling.
- File upload and download verification.
- Screenshot capture.

### POM Class
Maintains web page elements using Selenium PageFactory and `@FindBy` annotations.

Currently includes:
- Login page elements.
- Username and password fields.
- Login button.
- Home page title.
- Product listing.
- Login error message.

### Step Definition
Connects Gherkin feature steps with Java automation methods.

Responsibilities:
- Executes the steps defined in feature files.
- Performs user interactions.
- Validates expected results.
- Handles valid and invalid login scenarios.

### Hooks
Manages scenario-level execution support.

Current implementation:
- Captures screenshots when a Cucumber scenario fails.
- Attaches screenshots to the Cucumber scenario.

### Test Runner
Configures and executes Cucumber scenarios through JUnit.

Responsibilities:
- Feature file configuration.
- Glue package configuration.
- Cucumber plugin configuration.
- Browser launch and closure.
- Allure integration.

### Feature Files
Contains test scenarios written in Gherkin syntax.

Current coverage:
- Empty username validation.
- Invalid username validation.
- Invalid password validation.
- Empty password validation.
- Valid login.
- Invalid login.

## 6. Prerequisites

Before cloning and executing the framework, ensure the following are installed:

1. Java JDK compatible with the project dependencies.
2. Eclipse IDE or another Java IDE.
3. Apache Maven.
4. Google Chrome browser.
5. Git.
6. Allure Commandline (required for generating and opening Allure reports).

Verify the installations:

```bash
java -version
mvn -version
git --version
```

## 7. Clone the Repository

Clone the framework from the central GitHub repository:

```bash
git clone <YOUR_GITHUB_REPOSITORY_URL>
```

Navigate into the cloned project:

```bash
cd <PROJECT_FOLDER>
```

If the repository uses a dedicated Web Automation branch:

```bash
git clone -b Web-Automation <YOUR_GITHUB_REPOSITORY_URL>
```

Replace the repository URL with the actual GitHub repository URL.

## 8. Import the Project into Eclipse

1. Open Eclipse IDE.
2. Select **File → Import**.
3. Choose **Maven → Existing Maven Projects**.
4. Browse to the cloned project directory.
5. Select the `pom.xml` file.
6. Click **Finish**.
7. Wait for Maven dependencies to download.
8. Verify that the project has no dependency or build errors.

## 9. Execute the Automation Tests

### Option 1: Execute through Eclipse

1. Open `TestRunner.java`.
2. Right-click the file.
3. Select **Run As → JUnit Test**.
4. Check the execution results in the JUnit window.

### Option 2: Execute through Maven

From the project root directory:

```bash
mvn clean test
```

To explicitly execute the configured runner class:

```bash
mvn -Dtest=TestRunner test
```

Note: The project currently uses a JUnit Cucumber runner. The explicit runner command is useful because the class is named `TestRunner.java`, which does not match Maven Surefire's usual default test class naming patterns.

## 10. Allure Report Generation

The framework is configured to store Allure results in:

```text
target/allure-results
```

The reporting integration uses the Allure Cucumber 7 adapter.

### Generate the report

After test execution, run:

```bash
allure generate target/allure-results --clean -o allure-report
```

### Open the report

```bash
allure open allure-report
```

The Allure report provides:
- Overall execution summary.
- Passed, failed and broken test results.
- Test scenario details.
- Execution information.
- Attached failure screenshots.

## 11. Adding New Test Scenarios

Follow these steps when adding new automation scenarios:

1. Create or update a feature file under `src/test/java`.
2. Write scenarios using Gherkin syntax.
3. Implement corresponding step definitions.
4. Add or update page elements in the relevant POM class.
5. Reuse existing BaseClass methods wherever applicable.
6. Execute the test through the TestRunner.
7. Review execution results and generated Allure reports.

## 12. Git Contribution Guidelines

Before making changes, pull the latest branch:

```bash
git pull origin Web-Automation
```

Check the modified files:

```bash
git status
```

Stage the required changes:

```bash
git add .
```

Commit the changes:

```bash
git commit -m "Added web automation test scenarios"
```

Push the changes:

```bash
git push origin Web-Automation
```

For shared framework development, create a Pull Request and get the changes reviewed before merging.

## 13. Framework Guidelines

- Follow the Page Object Model design pattern.
- Maintain reusable methods in the BaseClass.
- Keep locators and page elements in their respective POM classes.
- Maintain clear and reusable Cucumber step definitions.
- Use meaningful scenario names and test data.
- Avoid hardcoding sensitive credentials.
- Capture screenshots for failed scenarios.
- Maintain proper Git commit messages.
- Review Allure reports after execution.
- Update documentation whenever framework functionality changes.


## 14. Maintained By

QA Team 
