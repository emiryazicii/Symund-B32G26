@B32G26-149
Feature: Deck Management

  As a user, I should be able to manage my works by creating a new board/list/card and modifying them under Deck Module.


  Background:
    Given the user logs in with username "Employee80" and password "Employee123"
    And the user navigates to the Deck page
    And the user clicks on app navigation toggle

  @B32G26-143
  Scenario Outline: User can create a new board
    When the user creates a new board with name "<boardName>"
    Then the new board "<boardName>" should be visible in the list of boards

    Examples:
      | boardName              |
      | Strategic Initiatives  |
      | Product Development    |
      | Marketing Campaigns    |
      | Financial Planning     |
      | Operational Excellence |

  @B32G26-146
  Scenario Outline: User can create a new list of card under any board
    When the user creates a new list under board "<boardName>" with name "<listName>"
    Then the new list "<listName>" should be visible under the selected board

    Examples:
      | boardName              | listName             |
      | Strategic Initiatives  | Milestones           |
      | Product Development    | Feature Backlog      |
      | Marketing Campaigns    | Content Calendar     |
      | Financial Planning     | Budget Breakdown     |
      | Operational Excellence | Process Improvements |

  @B32G26-147
  Scenario Outline: User can add a new card on any list on the current board
    When the user clicks on any board with name "<boardName>"
    And the user adds a new card "<cardName>" to list "<listName>"
    Then the new card "<cardName>" should be visible in list "<listName>"

    Examples:
      | boardName              | listName             | cardName          |
      | Strategic Initiatives  | Milestones           | Q1 Goals          |
      | Product Development    | Feature Backlog      | User Stories      |
      | Marketing Campaigns    | Content Calendar     | Social Media Plan |
      | Financial Planning     | Budget Breakdown     | Expense Tracking  |
      | Operational Excellence | Process Improvements | Lean Six Sigma    |

  @B32G26-148
  Scenario Outline: User can assign a card to themselves
    When the user clicks on any board with name "<boardName>"
    And the user clicks "Assign to me" button to assigns the card "<cardName>" to themselves on list "<listName>"
    Then the card "<cardName>" should be assigned to the current user

    Examples:
      | boardName              | listName             | cardName          |
      | Strategic Initiatives  | Milestones           | Q1 Goals          |
      | Product Development    | Feature Backlog      | User Stories      |
      | Marketing Campaigns    | Content Calendar     | Social Media Plan |
      | Financial Planning     | Budget Breakdown     | Expense Tracking  |
      | Operational Excellence | Process Improvements | Lean Six Sigma    |

  @deleteAllBoards
  Scenario: User can delete all boards
    Given user deletes all the boards
