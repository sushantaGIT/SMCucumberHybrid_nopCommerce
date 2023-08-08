Feature: Login functionality

@sanity
Scenario: Login with valid credentials
Given User navigates to login page
When User enters valid email address "admin@yourstore.com" into email field
And User enters valid password "admin" into password field
And User clicks on Login button
Then User should get successfully logged in

Scenario Outline: Data Driven Test - Login with multiple credentials
Given User navigates to login page
When User enters valid email text <UserName> into email field
And User enters valid password text <Password> into password field
And User clicks on Login button
Then User should get successfully logged in
Examples:
|UserName									|Password	|
|admin@yourstore.com			|admin		|
|QAadmin@yourstore.com		|admin12	|
|admin@yourstore.com			|admin1		|

Scenario: Login with invalid credentials
Given User navigates to login page
When User enters invalid email address into email field
And User enters invalid password "admin12" into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch


Scenario: Login with valid email and invalid password
Given User navigates to login page
When User enters valid email address "admin@yourstore.com" into email field
And User enters invalid password "demo12" into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login with invalid email and valid password
Given User navigates to login page
When User enters invalid email address into email field
And User enters valid password "admin" into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login without providing any credentials
Given User navigates to login page
When User dont enter email address into email field
And User dont enter password into password field
And User clicks on Login button
Then User should get a proper warning message about blank input 