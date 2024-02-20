Feature: Invoice Test

  Scenario: Create a new Invoice
    Given login for Invoice
    And create new Invoice
    Then close the Invoice window

  Scenario: Search an Invoice for AIR
    Given Login to Search Invoice
    When search for Invoice
    And description of an Invoice
    Then close Invoice for search
