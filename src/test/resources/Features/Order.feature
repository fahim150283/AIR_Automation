Feature: Order Test


  Scenario: Create a new Order
    Given login for creating new Order
    And create new Order
    Then close the Order window

  Scenario: Description of an Order for AIR
    Given Login to Search Order
    When search for Order
    And description of a Order
    Then close Order for search