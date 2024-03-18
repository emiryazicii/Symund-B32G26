package com.symund.step_definitions;

import com.symund.pages.DeckPage;
import com.symund.pages.LoginPage;
import com.symund.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class DeckModuleFunctionalityStepDefs {

    LoginPage loginPage = new LoginPage();
    DeckPage deckPage = new DeckPage();

    @Given("the user is on the Deck Module page")
    public void the_user_is_on_the_deck_module_page() {

        loginPage.login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
        deckPage.navigateToPage("deck");

    }
    @When("the user creates a new board")
    public void the_user_creates_a_new_board() {

        deckPage.createNewBoard(ConfigurationReader.getProperty("board.name"));

    }
    @Then("the new board should be visible in the list of boards")
    public void the_new_board_should_be_visible_in_the_list_of_boards() {

        Assert.assertTrue(deckPage.isBoardVisibleInList(ConfigurationReader.getProperty("board.name")));

    }
}
