Feature: Distributors Test

  Scenario: Create a new Distributor
    Given login for creation of a Distributor
    And create new Distributor
    Then close the Distributor window

  Scenario: Search a Distributor for AIR
    Given Login to Search Distributor
    When search for Distributor
    And description of a Distributor
    Then close Distributor for search

  Scenario: edit a  Distributor for AIR
    Given Login to edit a Distributor
    When search for a Distributor to edit
    And edit
    Then close Distributor for editing