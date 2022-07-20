Feature: Login
@sanity
  Scenario: Successful Login with valid Credentials
    Given User Launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/"
    And User enters Email "admin@yourstore.com" and Password "admin"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User Click on Logout link
    Then Page Title should be "Your store. Login"
    And Close browser
@regression
  Scenario Outline: Login Data Driven
    Given User Launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/"
    And User enters Email "<email>" and Password "<password>"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User Click on Logout link
    Then Page Title should be "Your store. Login"
    And Close browser

    Examples: 
      | email               | password |
      | admin@yourstore.com | admin    |
      | abc@yourstore.com   | admin    |
