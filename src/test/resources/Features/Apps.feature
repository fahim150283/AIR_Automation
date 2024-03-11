Feature: Apps Test


  Scenario: Create a new  app
    Given login for creating new app
    When create new  app
    And verify that the app is created and listed in the apps list
    Then close driver for creating apps

  Scenario: Edit an app
    Given login for editing an app
    When search for the app
    And edit the app
    Then verify that the app is edited
    And close the driver for editing apps

  Scenario: Create a new  app
    Given login for creating new app
    When create new  app
    And verify that the app is created and listed in the apps list
    Then close driver for creating apps

  Scenario: Give permission to a user for an App
    Given login for giving access to an user
    When search for the app to give access
    And add permission
    Then Close the driver for app permission

  Scenario: Revoke permission of a user for an App
    Given login for giving access to an user
    When search for the app to give access
    And Revoke user permission
    Then Close the driver for app permission

  Scenario: Give permission to a user for an App
    Given login for giving access to an user
    When search for the app to give access
    And add permission
    Then Close the driver for app permission

  Scenario: verify if the user has access to the app
    Given login for checking access of first user
    And verify from the side panel
    And close driver for verification of app permission for first user
    Then login for checking access of 2nd user
    And verify from the side panel
    And close driver for verification of app permission for 2nd user