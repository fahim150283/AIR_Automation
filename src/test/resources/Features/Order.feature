Feature: Order Test


  Scenario: Create a new regular Order
    Given login for creating new Order
    And create new Order
    Then close the Order window

  Scenario: Create a new Order with zero products or no products in it
    Given login for creating new Order
    When create new Order with no products in it
    And click the plus (add) button without selecting any products
    And creation of an order with zero product quantity in it
    Then close the Order window

  Scenario: future and previous date validation
    Given Login to Search Order
    When set previous date for order creation
    And set future date for order creation
    Then close the Order window

  Scenario: Description of an Order for AIR
    Given Login to Search Order
    When search for Order
    And verify if the order is searched accordingly
    And description of a Order
    Then close Order for search