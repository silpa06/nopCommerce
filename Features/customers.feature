Feature: Customers

  Background: Below are common steps for every scenario
    Given User Launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/"
    And User enters Email "admin@yourstore.com" and Password "admin"
    And Click on Login
    Then User can view the Dashboad
@sanity
  Scenario: Add a new Customer
    When User clicks on Customers Menu
    And User clicks on Customers Menu Item
    And Click on Add new button
    Then User can view Add new Customer page
    When User enter Customer info
    And Click on Save button
    Then User can view confirmation message "The new customer has been added successfully."
    And Close browser
@regression
  Scenario: Search Customer by EmailID
    When User clicks on Customers Menu
    And User clicks on Customers Menu Item
    And Enter Customer Email
    When Click on search button
    Then User should found Email in the search table
    And Close browser
@regression
  Scenario: Search Customer by Name
    When User clicks on Customers Menu
    And User clicks on Customers Menu Item
    And Enter Customer FirstName
    And Enter Customer LastName
    When Click on search button
    Then User should found Name in the search table
    And Close browser
