Feature: Audit Stock Update Test


  Scenario: Search an Audit Stock for AIR
    Given login for Audit Stock
    When search for Audit Stock
    And description of an Audit Stock
    Then close Audit Stock window


  Scenario: Create a new Audit Stock
    Given login for Audit Stock
    And create new Audit Stock
    Then close Audit Stock window