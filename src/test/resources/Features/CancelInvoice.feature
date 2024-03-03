Feature: Cancel Invoice Test

  Scenario: Create a new cancel Invoice
    Given login for cancellation of an Invoice
    And create new cancel Invoice
    Then close the cancel Invoice window

  Scenario: Search a cancelled Invoice for AIR
    Given Login to Search cancelled Invoice
    When search for cancelled Invoice
    And description of a cancelled Invoice
    Then close cancelled Invoice for search
