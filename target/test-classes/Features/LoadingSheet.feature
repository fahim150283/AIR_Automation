Feature: Loading sheet Test


  Scenario: Create a new Loading sheet
    Given login for creating new  Loading sheet
    When create new Loading sheet
    And verify that the Loading sheet is created and listed in the Loading sheet list
    Then close driver for creating Loading sheet

  Scenario: view a Loading Sheet
    Given login for viewing new  Loading sheet
    When Search for a loading sheet
    And Click the view button of the loading sheet
    Then close driver for viewing a Loading sheet

  Scenario: print all Loading Sheets
    Given login for printing new  Loading sheet
    And Click the print button of the loading sheet
    Then close driver for viewing a Loading sheet


