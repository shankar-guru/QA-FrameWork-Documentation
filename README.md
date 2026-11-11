# Manual Testing Documentation

## 1. Overview

This directory contains standardized manual test case documentation for Web and Mobile application testing.

The test cases cover functional validation, positive and negative scenarios, execution results, defect tracking and automation feasibility.

## 2. Documentation Structure

```text
01_Manual_Test_Cases/
│
├── README.md
└── Manual_Test_Cases.xlsx
```

## 3. Excel Workbook Structure

The manual test case workbook contains the following worksheets:

### 3.1 Overall Module-wise Test Case Summary

Provides module-wise execution information.

Fields:
- Project Name
- Module
- Tester Name
- Execution Date
- Total Test Cases
- Total Pass
- Total Fail

### 3.2 Summary Report

Provides project information and overall test execution details.

Project information includes:
- Project Name
- Application Name
- Project Type
- Environment
- Build Version
- Testing Start Date
- Testing End Date
- Prepared By
- Reviewed By

### 3.3 Module-wise Test Cases

Each application module has a separate worksheet containing detailed test cases.

The test case documentation includes:

| Field | Description |
|---|---|
| Test Case ID | Unique test case identifier |
| Module | Application module |
| Test Scenario | Scenario being validated |
| Test Case Description | Test objective |
| Preconditions | Conditions before execution |
| Test Steps | Step-by-step instructions |
| Input Value | Test data |
| Input Type | Type of input |
| Expected Result | Expected application behaviour |
| Actual Result | Observed application behaviour |
| Status | Pass / Fail / Blocked / Not Executed |
| Priority | High / Medium / Low |
| Severity | Critical / Major / Medium / Minor |
| Automation Feasibility | Yes / No |
| Jira Bug ID | Associated defect reference |
| Remarks | Additional observations |

## 4. Test Case ID Convention

Use unique identifiers for each platform and module.

Examples:

- TC_WEB_LOGIN_001
- TC_WEB_DASHBOARD_001
- TC_MOBILE_LOGIN_001
- TC_MOBILE_DASHBOARD_001

## 5. Execution Status

| Status | Description |
|---|---|
| Pass | Actual result matches expected result |
| Fail | Actual result differs from expected result |
| Blocked | Test execution cannot proceed |
| Not Executed | Test case has not been executed |

## 6. Priority Classification

| Priority | Description |
|---|---|
| High | Critical functionality |
| Medium | Important functionality |
| Low | Less critical functionality |

## 7. Defect Severity

| Severity | Description |
|---|---|
| Critical | Application crash or critical business failure |
| Major | Important functionality failure |
| Medium | Functional issue with moderate impact |
| Minor | Limited functional or UI issue |

## 8. Automation Feasibility

Each test case should be evaluated for automation feasibility.

- Yes: Suitable for automation.
- No: Not suitable or not recommended for automation.

Automation feasibility should be reviewed based on test stability, repeatability and technical requirements.

## 9. Execution Metrics

Maintain the following execution metrics:

- Total Test Cases
- Passed Test Cases
- Failed Test Cases
- Blocked Test Cases
- Not Executed Test Cases
- Pass Percentage
- Execution Completion Percentage
- Automation Feasibility Count

**Pass Percentage:**

Passed / Executed Test Cases × 100

**Execution Completion Percentage:**

Executed / Total Test Cases × 100

## 10. Version History

Maintain version history whenever test cases are added, modified or reviewed.

| Version | Date | Updated By | Changes |
|---|---|---|---|
| 1.0 | 11-11-2026 | QA Team | Initial test case template |
| 1.1 | - | - | Additional test scenarios |
| 1.2 | - | - | Test case updates |

## 11. Documentation Guidelines

- Maintain unique test case IDs.
- Write clear and reproducible test steps.
- Define measurable expected results.
- Include positive, negative and boundary scenarios.
- Avoid duplicate test cases.
- Update actual results after execution.
- Link failed test cases with Jira defect IDs.
- Maintain version history for every significant update.
- Review test cases before execution.

## 12. Review and Approval

Recommended review process:

1. Test case preparation.
2. Peer review.
3. QA Lead review.
4. Corrections and updates.
5. Approval and execution.

## 13. Maintained By

**QA Team**

Documentation: Manual Testing

Platforms: Web and Mobile
