Feature: Collection Test


  Scenario: Search a Collection for AIR
    Given Login to Search Collection
    When search for Collection
    And description of a Collection

  Scenario: Create a new Collection for advance payment in cash
    Given login for creating Collection
    And create new Collection for advance payment in cash

  Scenario: Creation of a Collection for order which will be adjusted from advance in cash
#    Given login for creating Collection
#    And create new Collection
#    Then close the Collection window

  Scenario: creation of a Collection for order in cash
#    Given login for creating Collection
#    And create new Collection
#    Then close the Collection window

  Scenario: Creation of a Collection for advance payment in Instrument
#    Given login for creating Collection
#    And create new Collection
#    Then close the Collection window

  Scenario: Orders of a distributor will be visible according to the created date while making a collection
#    Given login for creating Collection
#    And create new Collection
#    Then close the Collection window