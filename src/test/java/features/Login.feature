 Feature: Login functionality 
 
 Scenario Outline: Login with valid and invalid credentials
 Given User is on the Saucedemo login page 
 When User enters the username "<name>"
 And User enters the password "<pwd>"
 And User clicks on login button 
 Then User should be navigated to the home page "<result>"
 
Examples:
| name          | pwd          | result  |
|               | secret_sauce | invalid |
| 123455        | secret_sauce | invalid |
| @#$           | secret_sauce | invalid |
| abcds         | demoPwd      | invalid |
| standard_user |              | invalid |
| standard_user | 1234         | invalid |
| standard_user | @#$5         | invalid |
| standard_user | bhdfa        | invalid |
| random        | demoPwd      | invalid |
| standard_user | secret_sauce | valid   | 