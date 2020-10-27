@AccountActivity
Feature: Navigating to specific accounts in Accounts Activity
  Background:
    Given the user is logged in
  Scenario: Savings account redirect
    When the user clicks on Savings link on the Account Summary page
    Then the Account Activity page should be displayed
    And Account drop down should have Savings selected
  Scenario: Brokerage account redirect
    When the user clicks on Brokerage link on the Account Summary page
    Then the Account Activity page should be displayed
    And Account drop down should have Brokerage selected
  Scenario: Checking account redirect
    When the user clicks on Checking link on the Account Summary page
    Then the Account Activity page should be displayed
    And Account drop down should have Checking selected
  Scenario: Credit Card account redirect
    When the user clicks on Credit card link on the Account Summary page
    Then the Account Activity page should be displayed
    And Account drop down should have Credit Card selected
  Scenario: Loan account redirect
    When the user clicks on Loan link on the Account Summary page
    Then the Account Activity page should be displayed
    And Account drop down should have Loan selected
    @wip
  Scenario: Account Activity
      When And clicks Account Activity Tab
    When on the Account summary page Zerobank should be displayed as a title
    Then Default option of Account dropdown should be Savings
    Then Dropdown sholud have following options
    |Savings|
    |Checking|
    |Loan    |
    |Credit Card|
    |Brokerage  |
    Then Transcations table must have following options
    |Date|
    |Description|
    |Deposit    |
    |Withdrawal |
