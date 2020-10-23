
Feature: Login with valid credentials


  Scenario: Login with valid credentials
    When the user on main page
    And click on sign in button on top
    And enter valid credentials
    Then click sign in button and the user should able to logged in

  Scenario: Try to Login with unvalid credentials
    When the user on main page
    And click on sign in button on top
    And enter unvalid credentials
    And click sign in button
    Then the user should not login and should see error message

  Scenario: Try to Login without enter credentials
    When the user on main page
    And click on sign in button on top
    And click sign in button
    Then the user should not login and should see error message

