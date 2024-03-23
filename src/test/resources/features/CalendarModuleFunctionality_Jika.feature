@B32G26-129
Feature: Calendar module functionality
  User Story :
  As a user, I should be able to see Daily-Weekly-Monthly calendar view
  and create a new event under the Calendar module US-005

  Background:
    Given the user logs in with username "Employee40" and password "Employee123"
    When user navigates to the Calendar module page

  Scenario: user can display daily calendar view
    Given user navigates to the dropdown option
    When user clicks to the Daily calendar
    Then Daily Calendar should be visible on the page

  Scenario: user can display weekly calendar view
    Given user navigates to the dropdown option
    When user clicks to the Weekly calendar
    Then Weekly Calendar should be visible on the page

  Scenario: user can display monthly calendar view
    Given user navigates to the dropdown option
    When user clicks to the Monthly calendar
    Then Monthly Calendar should be visible on the page


  Scenario: user can create a new event under the Calendar module
    When user enters event name "Meeting",
    And user enters starting date "03/27/2024", "8:00","PM"
    And user enters ending date "03/27/2024", "9:00","PM" and save it
    Then user should see the new event with given "2024-03-27" and "8:00 PM" through the Monthly Calendar view



