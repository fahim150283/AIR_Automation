Feature: CancelOrder Test


  Scenario: Search an CancelOrder for AIR
    Given Login to Search CancelOrder
    When search for CancelOrder
    And description of a cancelled Order
    Then close CancelOrder for search

  Scenario: Create a new cancelled Order
    Given login for Cancelling a Order
    And create new Cancel Order
    Then close the CancelOrder window