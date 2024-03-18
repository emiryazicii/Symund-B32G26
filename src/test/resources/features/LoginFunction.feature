Feature: Login function

  @login
  Scenario: the user logged in with valid credentials
    Given the user logged in successfully
    Then the user is on the dashboard