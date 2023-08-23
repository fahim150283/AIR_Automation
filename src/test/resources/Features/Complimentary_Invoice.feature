Feature: Complementary Invoice Test


  Scenario: Search a Complementary Invoice for AIR
    Given Login to Search Complementary Invoice
    When search for Complementary Invoice
    And description of a Complementary Invoice
    Then close Complementary Invoice for search

  Scenario: Create a new Complementary Invoice
    Given login for creation of an Complementary Invoice
    And create new Complementary Invoice
    Then close the Complementary Invoice window