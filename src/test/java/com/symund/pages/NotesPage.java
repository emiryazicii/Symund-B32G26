package com.symund.pages;

import com.symund.utilities.BrowserUtils;
import com.symund.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NotesPage extends BasePage {

    Actions actions = new Actions(Driver.getDriver());

    public NotesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "button[id='notes_new_note']")
    public WebElement newNoteBtn;

    @FindBy(xpath = "//div[@id='note-container']")
    public WebElement inputText;

    public boolean isTitleMatchWithNoteName(String noteName) {

        WebElement note = Driver.getDriver().findElement(By.xpath("//span[@title='" + noteName + "']"));

        BrowserUtils.waitFor(3);
        return note.getAttribute("title").equals(noteName);
    }

    public void addToFavourites(String noteName) {


        WebElement dynamicAddFavouritesBtn = Driver.getDriver().findElement(By.xpath("//li//span[@title='" + noteName + "']/../..//button"));
        actions.click(dynamicAddFavouritesBtn).perform();

        WebElement addToFavouritesOption = Driver.getDriver().findElement(By.xpath("//button//span[.='Add to favourites']"));
        actions.click(addToFavouritesOption).perform();

    }

    @FindBy(xpath = "//li[@data-id='favorites']")
    public WebElement favoritesLink;

    @FindBy(xpath = "//tbody/tr/td[@class='filename']")
    public List<WebElement> favoriteList;

    public boolean isFavoriteNoteAdded(String expectedInNote) {


        for (WebElement eachNote : favoriteList) {

            if (eachNote.getText().contains(expectedInNote)) {
                return true;
            }
        }
        return false;
    }

    public void checkDetailOfNote(String noteName) {
        WebElement givenNote = Driver.getDriver().findElement(By.xpath("//li//span[@title='" + noteName + "']"));
        BrowserUtils.waitFor(3);
        actions.click(givenNote).perform();

        WebElement threeDotsBtn = Driver.getDriver().findElement(By.xpath("//span[@class='action-buttons']"));
        BrowserUtils.waitFor(3);
        actions.click(threeDotsBtn).perform();
        BrowserUtils.waitFor(3);

        WebElement detailsBtn = Driver.getDriver().findElement(By.xpath("//li[@class='action active']"));
        actions.click(detailsBtn).perform();
        BrowserUtils.waitFor(3);
    }

    @FindBy(css = "p.app-sidebar-header__subtitle")
    public WebElement detailsOfNote;

    public boolean isNoteDetailsContainWordAndCharacter(String noteName){
        if(detailsOfNote.getText().contains("words") && detailsOfNote.getText().contains("characters")){
            return true;
        }
        return false;
    }

    public void deleteNote(String noteName) {

        WebElement threeDotBtn = Driver.getDriver().findElement(By.xpath("//a/span[@title='" + noteName + "']/../..//button"));

        BrowserUtils.waitFor(3);
        actions.click(threeDotBtn).perform();

        WebElement deleteBtn = Driver.getDriver().findElement(By.xpath("//button//span[text()='Delete note']"));
        actions.click(deleteBtn).perform();
    }

    @FindBy(xpath = "//span[@class='deletedLabel']")
    public WebElement deleteMessage;


}



















