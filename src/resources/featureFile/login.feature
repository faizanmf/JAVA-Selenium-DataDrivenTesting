Feature: Login Functionality

  @login
  Scenario: Valid login
    Given User is on login page
    When User enters valid credentials
    Then User should be logged in
