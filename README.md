# Manual Testing Documentation

## 1. Overview

This directory contains standardized manual test case documentation for Web and Mobile application testing.

The documentation covers functional validation, positive and negative scenarios, responsive UI testing, test execution results, defect tracking and automation feasibility.

It provides a structured approach to test case preparation, execution, reporting and defect management to maintain consistency across QA activities.

## 2. Documentation Structure

```text
01_Manual_Test_Cases/
│
├── README.md
│
├── Manual_Test_Cases.xlsx
│
├── Responsive_Testing/
│   ├── Responsive_Testcase_Format.xlsx
│   └── Responsive_Testing_Defect_Log.xlsx
│
└── Test_Evidence/
    └── Responsive_Screenshots/
```

## 3. Manual Testing Structure

The manual test case workbook contains the following worksheets.

### 3.1 Overall Module-wise Test Case Summary

Provides module-wise test execution information.

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

## 4. Responsive Testing Documentation

Responsive testing validates application UI behaviour across different screen sizes, resolutions and device categories.

It helps identify layout inconsistencies, alignment issues, content overflow and responsiveness-related issues across desktop, laptop, tablet and mobile viewports.

### 4.1 Responsive Test Case Workbook

The Responsive Testing Test Case workbook is used to document and execute responsive UI validation across different screen resolutions.

Project information includes:
- Project
- Module
- Tester Name
- Total Test Cases
- Passed Test Cases
- Browser

### 4.2 Screen Resolution Coverage

The following screen resolutions are used for responsive validation:

| Device Category | Screen Resolution |
|---|---|
| 4K | 2560 px |
| Laptop L | 1440 px |
| Laptop | 1024 px |
| Tablet | 768 px |
| Mobile L | 425 px |
| Mobile M | 375 px |

### 4.3 Responsive Test Scenarios

Responsive validation covers the following areas:

- Login screen alignment.
- Dashboard layout.
- Header and footer responsiveness.
- Navigation menu and hamburger menu.
- Button and input field alignment.
- Text readability and content visibility.
- Image scaling and aspect ratio.
- Form and dropdown responsiveness.
- Table and grid alignment.
- Modal and popup responsiveness.
- Horizontal and vertical scrolling.
- Portrait and landscape orientation.

### 4.4 Responsive Testing Guidelines

- Validate UI alignment across different screen resolutions.
- Verify that page elements fit within the viewport.
- Check for unwanted horizontal scrolling.
- Validate text readability and content visibility.
- Verify image scaling without distortion.
- Check button, input and dropdown alignment.
- Validate navigation menu responsiveness.
- Verify portrait and landscape orientation where applicable.
- Record resolution-specific issues with screenshots.
- Ensure application functionality remains accessible across supported viewports.

## 5. Responsive Testing Defect Log

The Responsive Testing Defect Log is used to document and track UI issues identified during responsive testing.

It provides a centralized record of responsive defects and their supporting attachments.

### 5.1 Defect Log Information

The defect log includes the following fields:

| Field | Description |
|---|---|
| Date | Date when the defect was identified |
| Project | Application or project name |
| Name | Tester name |
| Module | Affected application module |
| Total | Defect count or applicable total |
| Bug ID | Unique defect reference |
| Attachment | Screenshot or supporting evidence |

### 5.2 Defect Documentation Guidelines

For every identified responsive issue:

1. Assign a unique Bug ID.
2. Mention the affected project and module.
3. Record the screen resolution where the issue occurs.
4. Attach a screenshot showing the issue.
5. Clearly describe the actual UI behaviour.
6. Mention the expected UI behaviour.
7. Link the defect to the corresponding test case wherever applicable.
8. Update the defect status based on retesting results.

### 5.3 Example Responsive Defect

| Field | Example |
|---|---|
| Bug ID | BUG_001 |
| Project | Merchant |
| Module | Login Screen |
| Screen Resolution | 2560 × 1440 |
| Issue | Unnecessary blank space appears on the left and right sides of the login screen. |
| Expected Result | Login screen should be properly aligned without excessive blank space. |
| Attachment | Screenshot of the issue |

## 6. Test Case ID Convention

Use unique identifiers for each platform and module.

Examples:

- TC_WEB_LOGIN_001
- TC_WEB_DASHBOARD_001
- TC_MOBILE_LOGIN_001
- TC_MOBILE_DASHBOARD_001
- TC_RESP_LOGIN_001
- TC_RESP_DASHBOARD_001

## 7. Execution Status

| Status | Description |
|---|---|
| Pass | Actual result matches expected result |
| Fail | Actual result differs from expected result |
| Blocked | Test execution cannot proceed |
| Not Executed | Test case has not been executed |

## 8. Priority Classification

| Priority | Description |
|---|---|
| High | Critical functionality |
| Medium | Important functionality |
| Low | Less critical functionality |

## 9. Defect Severity

| Severity | Description |
|---|---|
| Critical | Application crash or critical business failure |
| Major | Important functionality failure |
| Medium | Functional issue with moderate impact |
| Minor | Limited functional or UI issue |

## 10. Automation Feasibility

Each test case should be evaluated for automation feasibility.

- Yes: Suitable for automation.
- No: Not suitable or not recommended for automation.

Automation feasibility should be reviewed based on test stability, repeatability and technical requirements.

## 11. Execution Metrics

Maintain the following execution metrics for manual and responsive testing:

- Total Test Cases
- Passed Test Cases
- Failed Test Cases
- Blocked Test Cases
- Not Executed Test Cases
- Pass Percentage
- Execution Completion Percentage
- Automation Feasibility Count
- Total Responsive Test Cases
- Total Screen Resolutions Covered
- Total Defects Identified
- Open Defects
- Closed Defects
- Retest Pending

**Pass Percentage:**

Passed Test Cases / Executed Test Cases × 100

**Execution Completion Percentage:**

Executed Test Cases / Total Test Cases × 100

**Responsive Defect Count:**

Total number of responsive UI defects identified during execution.

## 12. Test Evidence and Attachments

Maintain supporting evidence for failed test cases and responsive UI issues.

Guidelines:
- Capture screenshots for failed test cases.
- Include screen resolution details for responsive defects.
- Use meaningful screenshot filenames.
- Maintain screenshots in the respective project or module folders.
- Link evidence to the corresponding test case or defect ID.
- Avoid storing duplicate or unnecessary screenshots.

Example:

```text
Test_Evidence/
│
└── Responsive_Screenshots/
    ├── Login/
    ├── Dashboard/
    ├── Navigation/
    └── Forms/
```

## 13. Version History

Maintain version history whenever test cases are added, modified or reviewed.

| Version | Date | Updated By | Changes |
|---|---|---|---|
| 1.0 | 11-11-2026 | QA Team | Initial test case template |
| 1.1 | 12-11-2026 | QA Team | Added responsive test case and defect log formats |
| 1.2 | - | - | Additional test scenarios and documentation updates |

## 14. Documentation Guidelines

- Maintain unique test case IDs.
- Write clear and reproducible test steps.
- Define measurable expected results.
- Include positive, negative and boundary scenarios.
- Avoid duplicate test cases.
- Update actual results after execution.
- Link failed test cases with Jira defect IDs.
- Maintain resolution-specific responsive observations.
- Attach screenshots for identified UI issues.
- Maintain version history for every significant update.
- Review test cases before execution.

## 15. Review and Approval

Recommended review process:

1. Test case preparation.
2. Peer review.
3. QA Lead review.
4. Corrections and updates.
5. Approval and execution.
6. Defect review and retesting.
7. Final test execution report.

## 16. Maintained By

**QA Team**

**Documentation:** Manual Testing and Responsive Testing

**Platforms:** Web and Mobile

**Version:** 1.1
