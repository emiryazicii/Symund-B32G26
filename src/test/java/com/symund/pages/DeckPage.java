package com.symund.pages;

import com.symund.utilities.BrowserUtils;
import com.symund.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class DeckPage extends BasePage {

    public DeckPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "span[title='Add board']")
    private WebElement addBoardModule;

    @FindBy(css = "input[placeholder='Board name']")
    private WebElement inputBoardName;

    @FindBy(css = "input[class='icon-confirm']")
    private WebElement confirmIcon;

    @FindBy(css = "a[class='app-navigation-toggle']")
    private WebElement appNavigationToggle;

    @FindBy(css = "ul.app-navigation-entry__children li")
    private List<WebElement> allBoardsInList;

    @FindBy(css = "div#stack-add")
    private WebElement addListButton;

    @FindBy(xpath = "(//input[@id='new-stack-input-main'])[1]")
    private WebElement listNameInputBox;

    @FindBy(xpath = "//div[@id='stack-add']//input[@type='submit']")
    private WebElement listNameSubmitArrow;

    @FindBy(css = "#new-stack-input-main")
    private WebElement cardNameInputBox;

    @FindBy(xpath = "//div[@class='stack__card-add']//input[@type='submit']")
    private WebElement cardNameSubmitArrow;

    @FindBy(xpath = "//aside[@id='app-sidebar-vue']/header/a")
    private WebElement closeSideBarButton;

    /**
     * Clicks on the three dots menu button for a specified card in a specified list.
     *
     * @param cardName The name of the card.
     * @param listName The name of the list containing the card.
     */
    public void clickCardMenuButton(String cardName,String listName){

        WebElement cardMenuButton = Driver.getDriver().findElement(
                By.xpath("//h3[contains(text(),'"+listName+"')]" +
                        "/../..//span[contains(text(),'"+cardName+"')]/../../..//button"));

        BrowserUtils.waitForClickable(cardMenuButton,10);
        cardMenuButton.click();
    }

    /**
     * Clicks on any button from the card menu by its name.
     *
     * @param buttonName The name of the button in the card menu.
     */
    public void clickButtonFromCardMenu(String buttonName){

        WebElement anyButtonFromCardMenu = Driver.getDriver().findElement(
                By.xpath("//span[contains(text(),'"+buttonName+"')]"));

        BrowserUtils.waitForClickable(anyButtonFromCardMenu,10);
        anyButtonFromCardMenu.click();
    }

    /**
     * Checks if a card is assigned to the current user.
     *
     * @param cardName The name of the card.
     * @return True if the card is assigned to the current user, false otherwise.
     */
    public boolean isCardAssignToUser(String cardName){

        WebElement userAvatarInCard = Driver.getDriver().findElement(
                By.xpath("//span[contains(text(),'"+cardName+"')]/../../..//img"));

        BrowserUtils.waitForVisibility(userAvatarInCard,10);
        return userAvatarInCard.isDisplayed();

    }

    /**
     * Clicks on a board with a specified name.
     *
     * @param boardName The name of the board to click.
     */
    public void clickOnBoard(String boardName) {

        WebElement board = Driver.getDriver().findElement(
                By.xpath("//span[@title='" + boardName + "']/.."));

        BrowserUtils.waitForClickable(board,10);
        board.click();
    }

    /**
     * Clicks the 'Add card' button for a specified list.
     *
     * @param listName The name of the list to add a card to.
     */
    public void clickAddCardButtonByListName(String listName) {

        WebElement addButton = Driver.getDriver().findElement(
                By.xpath("//h3[contains(text(),'"+listName+"')]/../button"));

        BrowserUtils.waitForClickable(addButton,10);
        addButton.click();
    }

    /**
     * Checks if a list is visible under a board.
     *
     * @param listName The name of the list to check for visibility.
     * @return True if the list is visible, false otherwise.
     */
    public boolean isListVisibleUnderBoard(String listName) {

        WebElement list = Driver.getDriver().findElement(
                By.xpath("//div[@class='stack__header']//h3[contains(text(),'" + listName + "')]"));

        BrowserUtils.waitForVisibility(list,10);
        return list.isDisplayed();
    }

    /**
     * Checks if a board is visible in the list of boards.
     *
     * @param boardName The name of the board to check for visibility.
     * @return True if the board is visible, false otherwise.
     */
    public boolean isBoardVisibleInListOfBoards(String boardName) {

        WebElement board = Driver.getDriver().findElement(
                By.xpath("//span[@title='" + boardName + "']"));

        BrowserUtils.waitForVisibility(board,10);

        for (WebElement eachBoard : allBoardsInList) {
            if (eachBoard.getText().equals(boardName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a card is visible under a list.
     *
     * @param cardName The name of the card to check for visibility.
     * @param listName The name of the list containing the card.
     * @return True if the card is visible, false otherwise.
     */
    public boolean isCardVisibleUnderList(String cardName, String listName) {

        String xpathExpression = "//h3[contains(text(),'" + listName + "')]" +
                "/../following-sibling::div//span[contains(text(),'" + cardName + "')]";

        WebElement card = Driver.getDriver().findElement(By.xpath(xpathExpression));

        BrowserUtils.waitForVisibility(card, 10);
        return card.isDisplayed();
    }

    /**
     * Creates a new list under a specified board.
     *
     * @param boardName The name of the board to create the list under.
     * @param listName The name of the new list to create.
     */
    public void createNewList(String boardName, String listName) {
        clickOnBoard(boardName);
        addListButton.click();
        listNameInputBox.sendKeys(listName);
        listNameSubmitArrow.click();
    }

    /**
     * Creates a new board with a specified name.
     *
     * @param boardName The name of the new board to create.
     */
    public void createNewBoard(String boardName) {
        addBoardModule.click();
        inputBoardName.sendKeys(boardName);
        confirmIcon.click();
    }

    /**
     * Creates a new card with a specified name under a specified list.
     *
     * @param cardName The name of the new card to create.
     * @param listName The name of the list to add the card to.
     */
    public void createNewCard(String cardName, String listName) {
        clickAddCardButtonByListName(listName);
        cardNameInputBox.sendKeys(cardName);
        cardNameSubmitArrow.click();
    }

    /**
     * Clicks the app navigation toggle button.
     */
    public void clickAppNavigationToggle() {
        appNavigationToggle.click();
    }

    /**
     * Clicks the close sidebar button.
     */
    public void clickCloseSideBarButton(){
        closeSideBarButton.click();
    }
}
