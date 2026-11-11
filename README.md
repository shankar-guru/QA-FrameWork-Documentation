# QA Framework & Testing Documentation

## 1. Project Overview

This repository serves as a centralized platform for maintaining Quality Assurance (QA) documentation, test cases, automation frameworks and testing execution reports.

It covers multiple testing activities, including Manual Testing, Web Automation (Normal Framework, Hybrid Framework and Playwright), Mobile Automation, API Testing and Performance Testing.

The repository aims to standardize testing documentation, improve test traceability, maintain reusable automation frameworks and provide easy access to QA deliverables.

## 2. Repository Structure

```text
QA-FrameWork-Documentation/
│
├── 01_Manual_Test_Cases/
│   ├── README.md
│   └── Test_Cases.xlsx
│
├── 02_Web_Automation/
│   ├── README.md
│   ├── Normal_Framework/
│   │   └── Automation Framework
│   ├── Hybrid_Framework/
│   │   └── Automation Framework
│   └── Playwright_Framework/
│       └── Automation Framework
│
├── 03_Mobile_Automation/
│   ├── README.md
│   └── Automation Framework
│
├── 04_API_Testing/
│   ├── README.md
│   └── API Test Cases and Postman Collections
│
├── 05_Performance_Testing/
│   ├── README.md
│   └── Performance Test Cases and Reports
│
└── README.md
```

## 3. Testing Activities Overview

| Testing Activity | Description | Tools |
|---|---|---|
| Manual Testing | Functional test case preparation and execution for Web and Mobile applications | Excel |
| Web Automation – Normal Framework | Automated functional testing of Web applications using a basic Selenium framework | Java, Selenium |
| Web Automation – Hybrid Framework | Reusable automation framework using Page Object Model, utilities and BDD-based execution | Java, Selenium, Cucumber, TestNG, Maven |
| Web Automation – Playwright | Automated Web application testing using Playwright | Playwright, JavaScript/TypeScript |
| Mobile Automation | Automated functional testing of Android applications | Java, Appium, Cucumber, TestNG |
| API Testing | API endpoint, request and response validation | Postman |
| Performance Testing | Backend and Frontend performance evaluation | Apache JMeter |

## 4. Repository Objectives

- Maintain centralized QA documentation.
- Standardize manual test case formats.
- Maintain reusable Selenium, Hybrid and Playwright automation frameworks.
- Maintain reusable Mobile automation frameworks.
- Document API test scenarios and execution results.
- Maintain Backend and Frontend performance test documentation.
- Track test execution results and defects.
- Maintain version history and traceability.
- Support collaboration and knowledge sharing within the QA team.

## 5. Repository Cloning and Setup

### Prerequisites

Install the following tools before cloning:

- Git
- GitHub account with repository access
- Java JDK and Maven for Java-based frameworks
- Node.js and npm for Playwright projects
- Eclipse IDE or IntelliJ IDEA for Java frameworks
- VS Code or another suitable IDE for Playwright

Verify Git installation:

```bash
git --version
```

### Clone the Complete Repository

Open CMD or a terminal and execute:

```bash
git clone https://github.com/shankar-guru/QA-FrameWork-Documentation.git
```

Navigate to the repository:

```bash
cd QA-FrameWork-Documentation
```

Check available branches:

```bash
git branch -a
```

### Clone a Specific Branch

**Manual Testing**

```bash
git clone -b Manual-Test-Cases https://github.com/shankar-guru/QA-FrameWork-Documentation.git
```

**Web Automation – Normal Framework**

```bash
git clone -b Web-Automation https://github.com/shankar-guru/QA-FrameWork-Documentation.git
```

**Web Automation – Hybrid Framework**

```bash
git clone -b Web-Hybrid-Automation https://github.com/shankar-guru/QA-FrameWork-Documentation.git
```

**Web Automation – Playwright**

```bash
git clone -b Playwright-Automation https://github.com/shankar-guru/QA-FrameWork-Documentation.git
```

**Mobile Automation**

```bash
git clone -b Mobile-Automation https://github.com/shankar-guru/QA-FrameWork-Documentation.git
```

**API Testing**

```bash
git clone -b API-Testing https://github.com/shankar-guru/QA-FrameWork-Documentation.git
```

**Performance Testing**

```bash
git clone -b Performance-Testing https://github.com/shankar-guru/QA-FrameWork-Documentation.git
```

### Switch Between Branches

If the repository is already cloned:

```bash
git fetch origin
git branch -a
```

Switch to the required branch:

```bash
git switch Web-Automation
```

If the branch exists remotely but not locally:

```bash
git switch -c Web-Hybrid-Automation --track origin/Web-Hybrid-Automation
```

### Pull Latest Changes

Before starting work, pull the latest updates from your working branch:

```bash
git pull origin Web-Automation
```

Replace the branch name with your respective working branch.

## 6. Documentation Guidelines

- Follow the respective README instructions available in each testing directory.
- Maintain consistent test case identification and documentation formats.
- Update documentation whenever testing scenarios or application functionality changes.
- Maintain meaningful Git commit messages.
- Use appropriate branches for individual testing activities.
- Review changes before merging into the main branch.
- Avoid committing credentials, sensitive information and unnecessary generated files.
- Keep automation framework dependencies and setup instructions updated.

## 7. Version Control

GitHub is used for source code and documentation version control.

| Branch | Purpose |
|---|---|
| main | Main repository and approved deliverables |
| Web-Automation | Normal Selenium automation |
| Web-Hybrid-Automation | Hybrid Selenium automation |
| Playwright-Automation | Playwright automation |
| Mobile-Automation | Mobile automation |
| Manual-Test-Cases | Manual testing documentation |
| API-Testing | API testing |
| Performance-Testing | Performance testing |

### Git Contribution Workflow

1. Clone the repository or switch to the required branch.
2. Pull the latest changes.
3. Implement the required changes.
4. Verify the modified files.
5. Commit changes with a meaningful message.
6. Push changes to the respective branch.
7. Create a Pull Request for review and merging.

Example:

```bash
git status
git add .
git commit -m "Updated automation framework"
git push origin Web-Automation
```

## 8. Maintained By

**QA Team**

**Repository:** QA-FrameWork-Documentation

**Documentation Scope:** Manual Testing, Web Automation (Normal, Hybrid and Playwright), Mobile Automation, API Testing and Performance Testing.

**Version:** 1.1
