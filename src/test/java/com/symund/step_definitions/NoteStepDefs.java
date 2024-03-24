package com.symund.step_definitions;

import com.symund.pages.FilesPage;
import com.symund.pages.NotesPage;
import com.symund.utilities.BrowserUtils;
import com.symund.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class NoteStepDefs {

    NotesPage notesPage = new NotesPage();

    @Given("user is on the Notes Module page")
    public void user_is_on_the_notes_module_page() {
        notesPage.navigateToPage("notes");
    }


    @When("user clicks on new note button")
    public void user_clicks_on_new_note_button() {
        notesPage.newNoteBtn.click();
    }

    Actions actions = new Actions(Driver.getDriver());

    @And("user writes {string} inside the new note")
    public void user_writes_inside_the_new_note(String string) {
        BrowserUtils.waitFor(2);
        actions.sendKeys(notesPage.inputText, string).perform();

    }

    @Then("the new notes title should be matches with first words of {string}")
    public void theNewNotesTitleShouldBeMatchesWithFirstWordsOf(String string) {

      Assert.assertTrue(notesPage.isTitleMatchWithNoteName(string));
    }

    @When("user add {string} note to the favorites")
    public void userAddNoteToTheFavorites(String noteName) {
        notesPage.addToFavourites(noteName);
    }


@Then("user can see {string} the file newly added to favorites under Favorites tab inside Files module")
public void userCanSeeTheFileNewlyAddedToFavoritesUnderFavoritesTabInsideFilesModule(String noteName) {

    notesPage.navigateToPage("files");
    notesPage.favoritesLink.click();
    BrowserUtils.waitFor(3);

    Assert.assertTrue(notesPage.isFavoriteNoteAdded(noteName));

    BrowserUtils.waitFor(3);

}


    @When("user clicks on the note {string} to view details")
    public void userClicksOnTheNoteToViewDetails(String noteName) {

        notesPage.checkDetailOfNote(noteName);
    }
    @Then("user can see the number of letters and words that the note includes under the {string} title")
    public void userCanSeeTheNumberOfLettersAndWordsThatTheNoteIncludesUnderTheTitle(String noteName) {
        Assert.assertTrue(notesPage.isNoteDetailsContainWordAndCharacter(noteName));
    }

    @When("user deletes the {string} note")
    public void whenUserDeletesTheNote(String noteName) {
        notesPage.deleteNote(noteName);
    }


    @Then("user should see deletion message")
    public void userShouldSeeDeletionMessage() {
        String deleteMsg = notesPage.deleteMessage.getText();
        Assert.assertTrue(deleteMsg.contains("Deleted"));

    }
}

