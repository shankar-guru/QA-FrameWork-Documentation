# Performance Testing Documentation

## 1. Overview

This directory contains performance testing documentation for Web Application Backend and Frontend components.

Performance testing is performed using Apache JMeter to evaluate application behaviour under different workloads, identify performance bottlenecks and assess system responsiveness.

## 2. Documentation Structure

```text
03_Performance_Testing/
│
├── README.md
├── Performance_Test_Cases.xlsx
├── Backend_Execution_Reports/
└── Frontend_Execution_Reports/
```

## 3. Testing Tools

| Tool | Purpose |
|---|---|
| Apache JMeter | Performance and load testing |
| Excel | Test case documentation and execution summary |
| Browser | Frontend validation |
| GitHub | Version control and documentation management |

## 4. Excel Workbook Structure

The Performance Testing workbook contains four worksheets.

### 4.1 BACKEND-SUMMARY REPORT

Provides project information and backend performance execution summary.

Project information includes:
- Project Name
- Application
- Testing Type
- Environment
- Build Version
- Testing Tool
- Execution Date
- Prepared By
- Reviewed By

Test Type Summary includes:
- Test Type
- Virtual Users
- Total Test Cases
- Passed
- Failed
- Blocked
- Not Executed
- Pass Percentage
- Run Coverage
- Breaking Point (VU)

### 4.2 BACK-END TESTCASE

Contains detailed backend performance test scenarios.

Documented fields include:
- Test Case ID
- Test Type
- Module
- Scenario
- Method
- Endpoint
- Authentication
- Virtual Users
- Target RPS
- Ramp-up
- Duration
- Iterations
- Expected Average Response Time
- Expected P95
- Expected P99

### 4.3 FRONTEND-SUMMARY REPORT

Provides project information and frontend performance execution summary.

The summary includes:
- Test Type
- Virtual Users
- Total Test Cases
- Passed
- Failed
- Blocked
- Not Executed
- Pass Percentage
- Run Coverage
- Breaking Point (VU)

### 4.4 FRONT-END TESTCASE

Contains detailed frontend performance test scenarios.

Documented fields include:
- Test Case ID
- Test Type
- Module
- Scenario
- Method
- Endpoint
- Virtual Users
- Duration
- Expected Page Load Time
- Expected FCP
- Expected LCP
- Expected CLS
- Expected INP
- Expected JavaScript Errors
- Expected HTTP Status / Response Message

## 5. Performance Testing Types

The workbook includes performance test categories such as:

| Test Type | Purpose |
|---|---|
| Baseline Test | Establishes initial performance measurements |
| Load Test | Evaluates performance under expected workload |
| Stress Test | Evaluates behaviour beyond expected workload |
| Spike Test | Evaluates response to sudden workload changes |

## 6. Performance Metrics

The following metrics are used for evaluating application performance:

| Metric | Description |
|---|---|
| Average Response Time | Average time taken to respond |
| P95 | Response time within which 95% of requests complete |
| P99 | Response time within which 99% of requests complete |
| RPS | Requests per second |
| Virtual Users | Number of simulated concurrent users |
| Ramp-up | Time taken to reach the target virtual users |
| Page Load Time | Time taken for the page to load |
| FCP | First Contentful Paint |
| LCP | Largest Contentful Paint |
| CLS | Cumulative Layout Shift |
| INP | Interaction to Next Paint |
| Breaking Point | Workload level at which the system no longer meets defined acceptance criteria |

## 7. Execution Status

| Status | Description |
|---|---|
| Pass | Actual performance meets defined expected criteria |
| Fail | Actual performance does not meet expected criteria |
| Blocked | Test execution cannot proceed |
| Not Executed | Test case has not been executed |

## 8. Execution Summary Calculations

**Pass Percentage:**

Passed Test Cases / Executed Test Cases × 100

**Run Coverage:**

Executed Test Cases / Total Test Cases × 100

Performance acceptance criteria should be defined before execution based on project requirements.

## 9. Execution Guidelines

1. Identify the application environment and build version.
2. Define the performance test objectives.
3. Configure the required virtual users, ramp-up and duration.
4. Execute the relevant JMeter test scenarios.
5. Capture response times and performance metrics.
6. Compare actual results against expected thresholds.
7. Record execution status and observations.
8. Document performance bottlenecks and defects.
9. Prepare the execution summary.

## 10. Reporting and Evidence

Maintain the following execution evidence:

- JMeter test plan (.jmx)
- JMeter execution results
- HTML dashboard report
- Response time analysis
- Throughput analysis
- Error percentage
- Performance observations
- Defect references

## 11. Version History

| Version | Date | Updated By | Changes |
|---|---|---|---|
| 1.0 | 11-11-2026 | QA Team | Initial performance testing template |
| 1.1 | - | - | Additional test scenarios |
| 1.2 | - | - | Test case updates |

## 12. Review and Approval

1. Performance test case preparation.
2. QA review.
3. Performance criteria validation.
4. Test execution.
5. Results analysis.
6. QA Lead review and approval.

## 13. Maintained By

**QA Team**

Testing Type: Backend and Frontend Performance Testing

Tool: Apache JMeter
