Feature: Account summary Page

  Background:
    Given the user is logged in
  Scenario: Account summary requirements displayed
    Then on the Account summary page Zerobank should be displayed as a title
    Then Account Summary page should have following options
      | Cash Accounts        |
      | Investment Accounts |
      | Credit Accounts      |
      | Loan Accounts        |
    And Credit Account table should contains specified column
      | Account     |
      | Credit Card |
      | Balance     |

