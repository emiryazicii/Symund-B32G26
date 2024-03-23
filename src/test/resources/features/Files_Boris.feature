@B32G26-126
Feature: US-002 - Upload/Edit/Delete File Module Functionality
  Agile story : As a user, I should be able to upload a file, move or delete any selected file under the Files module


  Background:
    Given the user logs in with username "Employee10" and password "Employee123"
    And the user navigates to the File Module page


  Scenario: User can upload a file
    When user clicks on plus button
    And user clicks on upload file option, and choose "Cydeo" to upload and click open
    Then user see file "Cydeo" he uploaded in first row of all files listed


  Scenario: User can create a new folder
    When user clicks on plus button
    And user clicks on New Folder option
    And user put "Boris" in the input box
    And user clicks on arrow button
    Then user see new folder with given name "Boris" in the list of files and folders


  Scenario: User can delete any selected item from its three dots menu
    When user clicks on three dots button near selected file-folder name "Boris"
    And user clicks on delete folder-file button, from option list provided
    Then user see selected folder-file name "Boris" is deleted


  Scenario: User can see the total number of files and folders under the files list table
    Given user see total number of folders and files under the files and folders list