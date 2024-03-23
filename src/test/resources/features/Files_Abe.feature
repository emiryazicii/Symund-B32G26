Feature: Add File To Favorites Rename Add Comment
  As a user, I should be able to add a file to favorites,
  rename any file and give some comments on any file.




  Background:
    Given the user logs in with username "Employee140" and password "Employee123"
    And   user navigates to File page




  Scenario:
    When user clicks three dots for file Hello World
    And  user clicks to Add to favorites
    Then file Hello World should be under Favorite page





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
