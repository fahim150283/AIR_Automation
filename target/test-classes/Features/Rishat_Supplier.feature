Feature: supplier Test


  Scenario: Create a new  supplier
    Given login for creating new  supplier
    And create new  supplier
    Then print the supplier list and close the supplier window

  Scenario: Search a  supplier
    Given Login to Search supplier
    When search for supplier and copy important elements suppliers
    Then close  supplier for search after verification

  Scenario: Edit the supplier
    Given Login to edit supplier

