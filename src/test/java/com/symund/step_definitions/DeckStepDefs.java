package com.symund.step_definitions;

import com.symund.pages.DeckPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class DeckStepDefs {

    DeckPage deckPage = new DeckPage();

    @Given("the user navigates to the Deck page")
    public void the_user_navigates_to_the_deck_page() {
        deckPage.navigateToPage("deck");
    }

    @Given("the user clicks on app navigation toggle")
    public void the_user_clicks_on_app_navigation_toggle() {
        deckPage.clickAppNavigationToggle();
    }

    @When("the user creates a new board with name {string}")
    public void the_user_creates_a_new_board_with_name(String boardName) {
        deckPage.createNewBoard(boardName);
    }

    @Then("the new board {string} should be visible in the list of boards")
    public void the_new_board_should_be_visible_in_the_list_of_boards(String boardName) {
        Assert.assertTrue(deckPage.isBoardVisibleInListOfBoards(boardName));
    }

    @When("the user creates a new list under board {string} with name {string}")
    public void the_user_creates_a_new_list_under_board_with_name(String boardName, String listName) {
        deckPage.createNewList(boardName,listName);
    }

    @Then("the new list {string} should be visible under the selected board")
    public void the_new_list_should_be_visible_under_the_selected_board(String listName) {
        Assert.assertTrue(deckPage.isListVisibleUnderBoard(listName));
    }

    @And("the user adds a new card {string} to list {string}")
    public void the_user_adds_a_new_card_to_list(String cardName, String listName) {
        deckPage.createNewCard(cardName,listName);
    }

    @Then("the new card {string} should be visible in list {string}")
    public void the_new_card_task_should_be_visible_in_list(String cardName, String listName) {
        Assert.assertTrue(deckPage.isCardVisibleUnderList(cardName,listName));
    }

    @When("the user clicks on any board with name {string}")
    public void the_user_clicks_on_board_with_name(String boardName) {
        deckPage.clickOnBoard(boardName);
    }

    @When("the user clicks {string} button to assigns the card {string} to themselves on list {string}")
    public void the_user_clicks_button_to_assigns_the_card_to_themselves_on_list(String buttonName, String cardName,String listName) {
        deckPage.clickCardMenuButton(cardName,listName);
        deckPage.clickButtonFromCardMenu(buttonName);
    }

    @Then("the card {string} should be assigned to the current user")
    public void the_card_should_be_assigned_to_current_user(String cardName) {
        Assert.assertTrue(deckPage.isCardAssignToUser(cardName));
    }
}
