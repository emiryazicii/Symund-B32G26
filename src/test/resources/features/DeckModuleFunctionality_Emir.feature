Feature: Deck Management

  User Story :

  As a user, I should be able to manage my works by creating a new board/list/card and modifying them under Deck Module.

  Background:
    Given the user logged in successfully
    And the user navigates to the Deck Module page

  @createAndVerifyNewBoard
  Scenario: User can create a new board
    When the user creates a new board
    Then the new board should be visible in the list of boards






