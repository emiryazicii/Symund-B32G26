@DeckPage
Feature: Deck Management

  As a user, I should be able to manage my works by creating a new board/list/card and modifying them under Deck Module.

  Background:
    Given the user logs in with username "Employee80" and password "Employee123"
    Given the user navigates to the Deck page

  @createNewBoard
  Scenario: User can create a new board
    When the user creates a new board with name "Board 1"
    Then the new board "Board 1" should be visible in the list of boards

  @createNewList
  Scenario: User can create a new list of card under any board
    When the user creates a new list under board "Board 1" with name "List 1"
    Then the new list "List 1" should be visible under the selected board

  @addNewCard
  Scenario: User can add a new card on any list on the current board
    When the user creates a new list under board "Board 1" with name "List 2"
    And the user adds a new card "Card 1" to list "List 2"
    Then the new card "Card 1" should be visible in list "List 2"


