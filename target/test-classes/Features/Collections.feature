Feature: Collection Test


  Scenario: Search a Collection for AIR
    Given Login to Search Collection
    When search for Collection
    And description of a Collection
    Then close Collection

  Scenario: Create a new Collection
    Given login for creating Collection
    And create new Collection
    Then close the Collection window