package com.symund.pages;

import com.symund.utilities.BrowserUtils;
import com.symund.utilities.ConfigurationReader;
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
    private List<WebElement> boardElements;

    public void createNewBoard(String boardName) {

        appNavigationToggle.click();
        addBoardModule.click();
        inputBoardName.sendKeys(boardName);
        confirmIcon.click();

    }

    public boolean isBoardVisibleInList(String boardName) {

        BrowserUtils.waitForPresenceOfElement(By.cssSelector("span[title='"+boardName+"']"),10);

        for (WebElement boardElement : boardElements) {
            if (boardElement.getText().equals(boardName)) {
                return true;
            }
        }
        return false;
    }
}
