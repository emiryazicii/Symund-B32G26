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

    public void clickOnBoard(String boardName) {

        WebElement board = Driver.getDriver().findElement(
                By.xpath("//span[@title='" + boardName + "']/.."));

        BrowserUtils.waitForClickable(board,10);
        board.click();
    }

    public void clickAddCardButtonByListName(String listName) {

        WebElement addButton = Driver.getDriver().findElement(
                By.xpath("//h3[contains(text(),'"+listName+"')]/../button"));

        BrowserUtils.waitForClickable(addButton,10);
        addButton.click();
    }

    public boolean isListVisibleUnderBoard(String listName) {

        WebElement list = Driver.getDriver().findElement(
                By.xpath("//div[@class='stack__header']//h3[contains(text(),'" + listName + "')]"));

        BrowserUtils.waitForVisibility(list,10);
        return list.isDisplayed();
    }

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

    public boolean isCardVisibleUnderList(String cardName, String listName) {

        String xpathExpression = "//h3[contains(text(),'" + listName + "')]" +
                "/../following-sibling::div//span[contains(text(),'" + cardName + "')]";

        WebElement card = Driver.getDriver().findElement(By.xpath(xpathExpression));

        BrowserUtils.waitForVisibility(card, 10);
        return card.isDisplayed();
    }



    public void createNewList(String boardName, String listName) {

        clickAppNavigationToggle();
        clickOnBoard(boardName);
        addListButton.click();
        listNameInputBox.sendKeys(listName);
        listNameSubmitArrow.click();
    }

    public void createNewBoard(String boardName) {

        clickAppNavigationToggle();
        addBoardModule.click();
        inputBoardName.sendKeys(boardName);
        confirmIcon.click();
    }

    public void createNewCard(String cardName, String listName) {

        clickAddCardButtonByListName(listName);
        cardNameInputBox.sendKeys(cardName);
        cardNameSubmitArrow.click();
    }

    public void clickAppNavigationToggle() {
        appNavigationToggle.click();
    }
}
