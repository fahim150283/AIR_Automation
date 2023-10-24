Feature: Finish Goods Store Test


  Scenario: Description of a FG Store and print details
    Given Login to Search a FG Store
    When search for FG Store
    And description of a store and print
    Then close window for searching a FG Store

  Scenario: Edit a FG Store
    Given Login to edit a FG Store
    When search for a FG Store
    And edit a store
    Then close window for editing a FG Store