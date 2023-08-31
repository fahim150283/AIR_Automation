Feature: Full Goods Requisition Test

  Scenario: Send a new Goods Requisition
    Given login for creation of a Goods Requisition
    And create new Goods Requisition
    Then close the Goods Requisition window

  Scenario: Cancel a requested Goods Requisition
    Given login for cancellation of a requested Goods Requisition
    And cancel the good requisition
    Then close the Goods Requisition window for the cancellation of the request

  Scenario: Send a new Goods Requisition
    Given login for creation of a Goods Requisition
    And create new Goods Requisition
    Then close the Goods Requisition window

  Scenario: Accept a requested Goods Requisition
    Given login for accepting of a requested Goods Requisition
    And Accept the good requisition
    Then close the Goods Requisition window for accepting the request

  Scenario: vehicle load for Goods Requisition
    Given login for vehicle load for a requested Goods Requisition
    And vehicle load for the good requisition
    Then close the Goods Requisition window for vehicle load

  Scenario: vehicle unload for Goods Requisition
    Given login for vehicle unload for a requested Goods Requisition
    And vehicle unload for the good requisition
    Then close the Goods Requisition window for vehicle unload

  Scenario: Receive The Goods
    Given login for Receiving The Goods
    And Receive The Goods
    Then close the Goods Requisition window for receiving goods