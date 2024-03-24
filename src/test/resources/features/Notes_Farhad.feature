@B32G26-139
Feature: Notes Module Functionality

  User Story:

  As a user, I should be able to create/delete any note and see the details of the note.

  Background:
    Given the user logs in with username "Employee60" and password "Employee123"
    And user is on the Notes Module page

  Scenario Outline: User can create a new note

    When user clicks on new note button
    And user writes "<notes>" inside the new note
    Then the new notes title should be matches with first words of "<notes>"
    Examples:
      | notes       |
      | Hello World |
      | How are you |


  Scenario Outline: User can adds any note to the favorites

    When user add "<notes>" note to the favorites
    Then user can see "<notes>" the file newly added to favorites under Favorites tab inside Files module
    Examples:
      | notes       |
      | Hello World |
      | How are you |

@wip
  Scenario Outline: User can check details of the note

    When user clicks on the note "<notes>" to view details
    Then user can see the number of letters and words that the note includes under the "<notes>" title
  Examples:
    | notes       |
    | Hello World |
    | How are you |

    Scenario Outline: User deletes a note

      When user deletes the "<notes>" note
      Then user should see deletion message
      Examples:
        | notes       |
        | Hello World |
        | How are you |






