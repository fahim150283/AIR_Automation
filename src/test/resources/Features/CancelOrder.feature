Feature: CancelOrder Test

  Scenario: Create a new cancelled Order
    Given login for Cancelling a Order
    And create new Cancel Order
    Then verify that the cancel order is created

  Scenario: Search an CancelOrder for AIR
    Given Login to Search CancelOrder
    When search for CancelOrder
    Then Verify that the cancel order is searched accordingly

  Scenario: view a CancelOrder for AIR
    Given Login to Search CancelOrder
    When search for CancelOrder
    And description of a cancelled Order
