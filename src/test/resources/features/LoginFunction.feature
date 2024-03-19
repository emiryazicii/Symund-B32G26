Feature: Login function

  @login
  Scenario: User can log in with valid credentials
    Given the user logged in successfully
    Then the user is on the dashboard
