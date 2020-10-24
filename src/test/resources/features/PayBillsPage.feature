Feature: Pay Bills Page Page
  Background:
    Given the user is logged in

    Scenario: Pay Bills make a payment
      And on the Account summary page Zerobank should be displayed as a title
      And User should able to make a payment
      Then After payments user should able to see The payment was succesfully submitted message
      @wip
    Scenario: Make a payment without entering required fields
      When user tries to make a payment without netering amount or date
      Then user should receive Please fill out this field message
      And Amount fields should not accept alphabetical and special characters
      And Date field should not accept alphabetical
