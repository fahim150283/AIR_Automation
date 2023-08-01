Feature: Login Test

#  Background:
#    Given Launch login Page

  @regression @practice
  Scenario Outline: Complete login for https://practicetestautomation.com/practice-test-login

    Given Launch login Page
#    Given User enters <username> and <password>
    When  User enters <username> and <password>
#    When input credentials
    Then click the signin button
    And quit
    Examples:
      | username             | password |
      | kignufardi@gufum.com | @Test123 |
      | kignufardi@gufum.com | @Test123 |


  @regression @google
  Scenario: Go to google
    Given launch google page

