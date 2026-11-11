Feature: Saucedemo login

Scenario Outline: verify the login with valid details
Given User is on login page 
And User enters the "<username>" of user 
And User enters the "<password>" of password 
When User clicks the sign-in button 
Then User will navigate to the dashboard with "<result>"

Examples:
|username|password|result|
|standard_user|secret_sauce|valid|
