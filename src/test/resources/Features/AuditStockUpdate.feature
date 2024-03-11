Feature: Audit Stock Update Test


  Scenario: Search an Audit Stock for AIR and view it
    Given login for Audit Stock
    When search for Audit Stock
    And verify that the searched result is correct
    When view an Audit Stock update
    And verify that the audit stock update is viewed
    Then close Audit Stock window


  Scenario: Create a new Audit Stock
    Given login for Audit Stock
    And create new Audit Stock
    And verify that the Fg Store is updated
    Then close Audit Stock window