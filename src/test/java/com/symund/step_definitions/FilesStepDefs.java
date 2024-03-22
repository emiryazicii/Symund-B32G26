package com.symund.step_definitions;

import com.symund.pages.BasePage;
import com.symund.pages.FilesPage;
import com.symund.utilities.BrowserUtils;
import com.symund.utilities.ConfigurationReader;
import com.symund.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FilesStepDefs {

    FilesPage filesPage = new FilesPage();


    @And("the user navigates to the File Module page")
    public void theUserNavigatesToTheFileModulePage() {
        filesPage.navigateToPage("files");
    }

    @When("user clicks on plus button")
    public void userClicksOnPlusButton() {
        filesPage.plusDropdown.click();
    }

    @And("user clicks on upload file option, and choose {string} to upload and click open")
    public void userClicksOnUploadFileOptionAndChooseToUploadAndClickOpen(String filePath) {
        filesPage.uploadFileLink.sendKeys(filesPage.getFullPath());
    }

    @Then("user see file {string} he uploaded in first row of all files listed")
    public void userSeeFileHeUploadedInFirstRowOfAllFilesListed(String expectedName) {
        boolean isContainsFileName = filesPage.isExpectedNameInListOfFiles(filesPage.listOfAllFilesAndFolders, expectedName);
        Assert.assertTrue(isContainsFileName);
    }

    @And("user clicks on New Folder option")
    public void userClicksOnNewFolderOption() {
        filesPage.newFolderLink.click();
    }

    @And("user put {string} in the input box")
    public void userPutInTheInputBox(String folderName) {
        filesPage.inputNewFolderName.sendKeys(folderName);
    }

    @And("user clicks on arrow button")
    public void userClicksOnArrowButton() {
        filesPage.arrowButton.click();
    }

    @Then("user see new folder with given name {string} in the list of files and folders")
    public void userSeeNewFolderWithGivenNameInTheListOfFilesAndFolders(String folderName) {
        boolean isContainsFolderName = filesPage.isExpectedNameInListOfFiles(filesPage.listOfAllFilesAndFolders, folderName);
        Assert.assertTrue(isContainsFolderName);
    }

    @When("user clicks on three dots button near selected file-folder name {string}")
    public void userClicksOnThreeDotsButtonNearSelectedFileFolderName(String fileName) {
        filesPage.clickOnThreeDotsNearSelectedFileOrFolder(fileName);
    }

    @And("user clicks on delete folder-file button, from option list provided")
    public void userCliksOnDeleteFolderFileButtonFromOptionListProvided() {
        filesPage.deleteFolderOption.click();
    }

    @Then("user see selected folder-file name {string} is deleted")
    public void userSeeSelectedFolderFileNameIsDeleted(String folderName) {
        filesPage.deletedFilesFoldersLink.click();
        Assert.assertEquals(folderName, filesPage.fileFolderDeleted.getText());
    }

    @Given("user see total number of folders and files under the files and folders list")
    public void userSeeTotalNumberOfFoldersAndFilesUnderTheFilesAndFoldersList() {
        Assert.assertTrue(filesPage.isNumberOfFoldersAndFilesEqual());

    }
}



