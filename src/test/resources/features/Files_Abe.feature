
Feature: Add File To Favorites Rename Add Comment
  As a user, I should be able to add a file to favorites,
  rename any file and give some comments on any file.


  Background:
    Given the user logs in with username "Employee140" and password "Employee123"
    And   user navigates to File page


  Scenario Outline:
    When user choose Add to favorites for file "<fileName>"
    Then user should see "<fileName>" under Favorite Page
    Examples:
      | fileName    |
      | Talk        |
      | Hello World |
      | Readme      |


  Scenario Outline:
    When user choose Rename file name "<fileName>" to file name "<updatedFileName>"
    Then user should see updated file name "<updatedFileName>"


    Examples:
      | fileName    | updatedFileName |
      | Talk        | Grisha          |
      | Hello World | Salam World     |
      | Readme      | Hidden Jem      |


  Scenario Outline:
    When user choose Details on the file "<fileName>"
    And  user click on Comment button
    And  user ads comment "<comment>"
    Then user should see comment "<comment>" under the comment section

    Examples:
      | fileName    | comment                                           |
      | Grisha      | Very important comment                            |
      | Salam World | Please follow me on istagram                      |
      | Hidden Jem  | Wow, amazing photos, please DM for collaboration! |


  Scenario Outline:

    And all test passed file "<updatedFileName>" removes from favorite

    Examples:
      | updatedFileName |
      | Grisha          |
      | Salam World     |
      | Hidden Jem      |

  Scenario:
    And user should delete folder Grisha

  Scenario Outline:
    When user choose Rename file name "<fileName>" to file name "<updatedFileName>"

    Examples:
      | fileName    | updatedFileName |
      | Salam World | Hello World     |
      | Hidden Jem  | Readme          |


