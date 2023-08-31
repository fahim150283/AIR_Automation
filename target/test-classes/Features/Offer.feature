Feature: Full Offer Test

  Scenario: create a new offer
    Given login for creation of an offer
    And create new offer
    Then close the offer window

  Scenario: check if the offer is created
    Given login to check if the offer is created
    And search for the offer
    Then close the window to search for the offer

  Scenario: check if the order is shown for creating an order
    Given
    And
    Then