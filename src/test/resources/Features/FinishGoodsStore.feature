Feature: Finish Goods Store Test


  Scenario: Search a Store for AIR
    Given Login to Search Store
    When search for store
    And description of a store
    Then close Sales Return

  Scenario: Create a new Sales Return
    Given login for creating Sales Return
    And create new Sales Return
    Then close the Sales Return window