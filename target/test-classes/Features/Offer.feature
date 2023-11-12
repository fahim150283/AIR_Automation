Feature: Full Offer Test

  Scenario: create a new offer
    Given login for creation of an offer
    When create new offer
    And search for the offer
    And Copy required elements
    When navigate to order and click new order button
    And populate the fields
    Then close the offer window