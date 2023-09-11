Feature: Apps Test


  Scenario: Create a new  app
    Given login for creating new  app
#    When create new  app
    And verify that the app is created and listed in the apps list
    Then close driver for apps

  Scenario: Edit an app
    Given login for editing an app
    When search for the app
    And edit the app
    Then close driver for editing apps