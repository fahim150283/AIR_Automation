Feature: Sales Return Test


  Scenario: Search a Sales Return for AIR
    Given Login to Search Sales Return
    When search for Sales Return
    And description of a Sales Return
    Then close Sales Return

  Scenario: Create a new Sales Return
    Given login for creating Sales Return
    And create new Sales Return
    Then close the Sales Return window

#  Scenario: Verify the Sales Return
#    Given login for creating Sales Return
#    When create new Sales Return
#    And Check if the stock in store is updated accordingly
#    Then close the Sales Return window