Feature: Search Customer

Background: Below are the common Login steps for every scenario
		Given User navigates to login page
    When User enters valid email address "admin@yourstore.com" into email field
		And User enters valid password "admin" into password field
		And User clicks on Login button
		Then User should get successfully logged in
	
    	
Scenario: Search Customer by valid name
    When User click on customers Menu
    And click on customers Menu Item
    When Enter valid customer firstname "Victoria" into the field
    And Click on search button
    Then User should get matching customers in the Search result

Scenario: Search Customer by invalid name
    When User click on customers Menu
    And click on customers Menu Item
    When Enter invalid customer firstname "Victoria12345" into the field
    And Click on search button
    Then User should get a message about no data available