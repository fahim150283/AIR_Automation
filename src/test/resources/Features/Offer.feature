Feature: Full Offer Test

  Scenario: create a new offer
    Given login for creation of an offer
    And create new offer
    Then close the offer window

  Scenario: check if the offer is created verify in orders
    Given login to check if the offer is created
    And search for the offer
    And Copy required elements
    When navigate to order and click new order button
    And populate the fields

