# API Testing Documentation

## 1. Overview

This directory contains API testing documentation for validating application endpoints, request handling, response structures, authentication and API functionality.

API test cases are documented and executed using Postman.

The objective is to validate API behaviour, response status codes, request and response data, authentication and error handling.

## 2. Documentation Structure

```text
04_API_Testing/
│
├── README.md
└── API_Test_Cases.xlsx
```

## 3. Testing Tools

| Tool | Purpose |
|---|---|
| Postman | API request execution and validation |
| Excel | API test case documentation |
| GitHub | Version control |
| JIRA | Defect tracking |

## 4. Excel Workbook Structure

The API Testing workbook contains two worksheets.

### 4.1 Summary

Provides project information and API collection-wise test execution summary.

Project information includes:
- Project Name
- Application Name
- Project Type
- Environment
- Build Version
- Testing Tool
- Testing Start Date
- Testing End Date
- Prepared By
- Reviewed By

API Module-wise Test Execution Summary includes:
- Collection
- Total Test Cases
- Pass
- Fail
- Not Executed
- Pass Percentage

Each collection represents a logical API module or functional area.

### 4.2 Test Case Details

Contains detailed API test cases for the System Health collection.

Documented fields include:
- Scenario
- Test Case ID
- API Endpoint
- HTTP Method
- Description
- Request Body
- Input Data
- Expected Response
- Actual Response
- Status
- Comments
- QA Resource
- JIRA Bug ID

## 5. API Testing Coverage

API testing scenarios may include:

- Endpoint validation
- HTTP method validation
- Positive and negative scenarios
- Authentication and authorization
- Request body validation
- Response status code validation
- Response message validation
- Response data validation
- Invalid endpoint validation
- Unsupported HTTP method validation
- Missing or invalid authentication

The actual coverage should be based on the implemented API collections and test cases.

## 6. HTTP Methods

| Method | Purpose |
|---|---|
| GET | Retrieve resources |
| POST | Create or submit resources |
| PUT | Replace or update resources |
| PATCH | Partially update resources |
| DELETE | Remove resources |

## 7. HTTP Status Code Validation

Common response status codes:

| Status Code | Description |
|---|---|
| 200 | OK |
| 201 | Created |
| 204 | No Content |
| 400 | Bad Request |
| 401 | Unauthorized |
| 403 | Forbidden |
| 404 | Not Found |
| 405 | Method Not Allowed |
| 500 | Internal Server Error |
| 503 | Service Unavailable |

Expected status codes must be defined according to the API specification.

## 8. Test Execution Status

| Status | Description |
|---|---|
| Pass | Actual response matches expected result |
| Fail | Actual response differs from expected result |
| Not Executed | Test case has not been executed |

## 9. API Execution Guidelines

1. Review the API documentation or specification.
2. Identify API endpoints and HTTP methods.
3. Configure the required environment and base URL.
4. Configure authentication and authorization.
5. Prepare valid and invalid request payloads.
6. Execute API requests using Postman.
7. Validate response status codes.
8. Validate response body and data.
9. Validate error messages and negative scenarios.
10. Record actual responses and execution status.
11. Link failed test cases with JIRA defect IDs.
12. Update the collection-wise execution summary.

## 10. Execution Reports and Evidence

Maintain the following evidence:

- Postman Collection JSON files
- Postman Environment files (without secrets)
- Execution results
- Request and response samples with sensitive data masked
- API test case Excel workbook
- Defect references
- Execution summary

## 11. Version History

| Version | Date | Updated By | Changes |
|---|---|---|---|
| 1.0 | 11-11-2026 | QA Team | Initial API test case template |
| 1.1 | - | - | Additional API scenarios |
| 1.2 | - | - | Test case updates |

## 12. Review and Approval

1. API test case preparation.
2. Peer review.
3. QA Lead review.
4. Test data and environment validation.
5. API execution.
6. Result verification.
7. Defect reporting and approval.

## 13. Maintained By

**QA Team**

Testing Type: API Testing

Tool: Postman
