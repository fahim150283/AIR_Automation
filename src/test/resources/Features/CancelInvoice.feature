Feature: Cancel Invoice Test

  Scenario: Create a new cancel Invoice
    Given login for cancellation of an Invoice
    And create new cancel Invoice

  Scenario: Search a cancelled Invoice for AIR
    Given Login to Search cancelled Invoice
    When search for cancelled Invoice
    And verify that the cancelled invoice is searched

  Scenario: view a cancelled Invoice for AIR
    Given Login to Search cancelled Invoice
    And description of a cancelled Invoice

#  Scenario: future and previous date validation for cancelling an invoice
#    Given login for cancellation of an Invoice
#    When set previous date and future date for cancel order

  Scenario: Check the items and price calculation
    Given login for cancellation of an Invoice
    When check and verify that the cancel invoice items and price are correct