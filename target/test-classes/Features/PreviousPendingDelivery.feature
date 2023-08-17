Feature: Previous Pending Delivery Test


  Scenario: Search a Previous Pending Delivery for AIR
    Given Login to Search Previous Pending Delivery
    When search for Previous Pending Delivery
    And description of a Previous Pending Delivery
    Then close Previous Pending Delivery for search

  Scenario: Create a new Previous Pending Delivery
    Given login for creating new Previous Pending Delivery
    And create new Previous Pending Delivery
    Then close the Previous Pending Delivery window