
# Web Automation Framework – Playwright

## 1. Project Overview

This project is a Web Automation Testing Framework developed using Playwright, JavaScript, BDD (Behavior Driven Development), and Page Object Model (POM).

The framework is designed to automate web application test scenarios with reusable components, maintainable test scripts, cross-browser execution, and reporting capabilities.

## 2. Technology Stack

- Playwright – Browser Automation
- JavaScript – Programming Language
- playwright-bdd – BDD Test Integration
- Cucumber – BDD Feature and Step Definitions
- Page Object Model (POM) – Framework Design Pattern
- Allure – Test Reporting
- Git & GitHub – Version Control
- GitHub Actions – CI/CD Integration

## 3. Project Structure

```text
Demo_Playwright/
│
├── .github/
│   └── workflows/
│       └── playwright.yml
│
├── features/
│   └── Features.feature
│
├── pages/
│   ├── BasePage.js
│   └── LoginPage.js
│
├── steps/
│   └── step.spec.js
│
├── playwright.config.js
├── package.json
├── package-lock.json
├── .gitignore
└── README.md
```

## 4. Prerequisites

Make sure the following tools are installed:

- Node.js (LTS version)
- npm
- Visual Studio Code
- Git

Verify the installation:

```bash
node --version
npm --version
```

## 5. Installation

Clone the repository:

```bash
git clone <YOUR_GITHUB_REPOSITORY_URL>
```

Navigate to the project directory:

```bash
cd Demo_Playwright
```

Install dependencies:

```bash
npm install
```

Install Playwright browsers:

```bash
npx playwright install
```

## 6. Framework Architecture

### Page Object Model (POM)

The framework follows the Page Object Model design pattern.

- BasePage.js – Contains reusable browser actions such as click, fill, and navigation.
- LoginPage.js – Contains login page locators and login-related methods.
- step.spec.js – Contains BDD step definitions.
- Features.feature – Contains test scenarios written in Given, When, and Then format.

### BDD Approach

BDD helps describe application behavior using readable feature files.

Example:

```gherkin
Feature: Demo App

  Scenario: User can open the demo app
    Given user navigates to the login page
    When user enters the username
    And user enters the password
    And user clicks the login button
```

## 7. Test Execution

Generate tests from feature files:

```bash
npx bddgen
```

Execute all test cases:

```bash
npx playwright test
```

Execute tests in headed mode:

```bash
npx playwright test --headed
```

Execute tests in Chromium:

```bash
npx playwright test --project=chromium
```

Execute tests in Firefox:

```bash
npx playwright test --project=firefox
```

Execute tests in WebKit:

```bash
npx playwright test --project=webkit
```

## 8. Cross-Browser Testing

The framework supports the following browsers:

- Chromium
- Firefox
- WebKit

This helps validate application functionality across multiple browsers.

## 9. Test Reports

### Playwright HTML Report

Open the HTML report:

```bash
npx playwright show-report
```

### Allure Report

Generate the Allure report:

```bash
npx allure generate my-allure-results --clean -o allure-report
```

Open the Allure report:

```bash
npx allure open allure-report
```

## 10. GitHub Actions – CI/CD

The project includes GitHub Actions workflow integration.

Workflow location:

```text
.github/workflows/playwright.yml
```

The workflow is configured to:

- Install Node.js dependencies.
- Install Playwright browsers.
- Execute automated test cases.
- Generate test results.
- Upload Playwright HTML reports as workflow artifacts.

For the Web-Automation branch, configure the workflow branch filters to include:

```yaml
on:
  push:
    branches: [main, master, Web-Automation]
  pull_request:
    branches: [main, master, Web-Automation]
```

## 11. Important Commands

| Command | Description |
|---|---|
| npm install | Install dependencies |
| npx playwright install | Install browsers |
| npx bddgen | Generate BDD tests |
| npx playwright test | Execute test cases |
| npx playwright test --headed | Run tests with browser UI |
| npx playwright show-report | View HTML report |
| npx allure generate | Generate Allure report |
| git add . | Stage changes |
| git commit -m "message" | Commit changes |
| git push | Push code to GitHub |

## 12. Future Enhancements

- Implement complete end-to-end test scenarios.
- Add API automation testing.
- Implement data-driven testing.
- Integrate environment-based configuration.
- Improve test coverage.
- Add reusable test utilities.
- Enhance CI/CD pipeline.
- Implement detailed test execution reporting.

## 13. Conclusion

This Playwright automation framework provides a structured and reusable approach to web application testing using JavaScript, BDD, and Page Object Model.

It supports cross-browser execution, automated reporting, and CI/CD integration, helping improve test maintainability, scalability, and execution efficiency.

## 14. Maintained By

QA Team
Platform: Web automation using playwright with javascript


