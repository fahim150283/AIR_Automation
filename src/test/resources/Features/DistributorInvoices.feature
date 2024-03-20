Feature: Invoice Test

  Scenario: Search an Invoice for AIR
    Given Login to Search Invoice
    When search for Invoice
    Then verify if the invoice is searched accordingly

  Scenario: view an Invoice for AIR
    Given login for Invoice
    When search for Invoice
    And description of an Invoice

  Scenario: While creating an invoice, check if the orders in the selected date are visible only or not
    Given Login to Search Order
    When check if only the orders that are created within the selected date are visible, while creating an invoice,
#    When check if the orders that are created after the selected date are not visible, while creating an invoice,
#
#  Scenario: While creating an invoice, check if if the invoice can be saved without selecting a store
#    Given login for Invoice
#    When check if the invoice can be created without selecting a store
#
#  Scenario: Create a new Invoice where offer type is cash
#    Given login for Invoice
#    And create new Invoice for cash offer
#    Then verify the creation of invoice
#
#  Scenario: Create a new Invoice where offer type is gift
#    Given login for Invoice
#    And create new Invoice for gift offer
#    Then verify the creation of invoice
#
#  Scenario: Create a new Invoice where offer type is gift
#    Given login for Invoice
#    And create new Invoice for product offer
#    Then verify the creation of invoice
#
#  Scenario: new Invoice price calculation
#    Given login for Invoice
#    And create new Invoice
#    Then verify the creation of invoice
#
#  Scenario: Creation of a new Invoice with no products in it
#    Given login for Invoice
#    And create a new Invoice with no products in it
#    Then verify the creation of invoice
#
#  Scenario: Getting an error message for the products with less stock
#    Given login for Invoice
#    And creation of an invoice where the product quantity is greater than the stock quantity
#    Then verify that the error message is there for low stock