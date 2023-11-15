Feature: Products Test


  Scenario: Create a new Product
    Given login for creating new  Product
    When create new  Product
    And verify that the Product is created and listed in the Products list
    Then close driver for creating Product

  Scenario: Edit a Product
    Given login for editing a Product
    When create new  Product
    When edit the Product
    Then close driver for editing Product

#  Scenario: check if the Product is found while ordering
    Given login to check if the Product is available for order
    When check if the product is available for order
    Then Close the driver for checking if the Product is found while ordering