Feature: Add new Customer

Background: Below are the common Login steps for every scenario
		Given User navigates to login page
    When User enters valid email address "admin@yourstore.com" into email field
		And User enters valid password "admin" into password field
		And User clicks on Login button
		Then User should get successfully logged in    

Scenario: Add a new customer
    When User click on customers Menu
    And click on customers Menu Item
    And click on Add new button
    Then User can view Add new customer page
    When User enters the details into below fields
    |password		|susmis12			|
    |firstName		|sush				|
    |lastName		|mish				|
    |companyName	|testComp			|
    |adminComment	|testComment		|
    And click on Save button
    Then User can view confirmation message "The new customer has been added successfully."
    
Scenario: Add a duplicate customer
    When User click on customers Menu
    And click on customers Menu Item
    And click on Add new button
    Then User can view Add new customer page
    When User enters existing customer details into below fields
    |email			|victoria_victoria@nopCommerce.com	|
    |password		|susmis12			|
    |firstName		|sush				|
    |lastName		|mish				|
    |companyName	|testComp			|
    |adminComment	|testComment		|
    And click on Save button
    Then User should get a proper warning about duplicate email

Scenario: Add a customer without filling any details
    When User click on customers Menu
    And click on customers Menu Item
    And click on Add new button
    Then User can view Add new customer page
    When User dont enter any details into fields
    And click on Save button
    Then User should get proper warning messages for every mandatory field