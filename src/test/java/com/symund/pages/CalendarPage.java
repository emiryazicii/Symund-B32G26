package com.symund.pages;

import com.symund.utilities.BrowserUtils;
import com.symund.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarPage extends BasePage {

    public CalendarPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    Actions actions = new Actions(Driver.getDriver());

    @FindBy(xpath = "(//button[@aria-label='Actions'])[1]")
    public WebElement dropdownBtn;

    @FindBy(xpath = "(//button[@class='action-button focusable'])[6]")
    public WebElement dailyCalendar;

    @FindBy(xpath = "(//button[@class='action-button focusable'])[7]")
    public WebElement weeklyCalendar;

    @FindBy(xpath = "(//button[@class='action-button focusable'])[8]")
    public WebElement monthlyCalendar;

    @FindBy(xpath = "(//button[contains(@class, 'primary')])[1]")
    public WebElement newEventBtn;

    @FindBy(xpath = "//input[@placeholder='Event title']")
    public WebElement eventTitle;

    @FindBy(xpath = "(//input[@name='date'])[2]")
    public WebElement fromDateTime;

    @FindBy(xpath = "(//input[@name='date'])[3]")
    public WebElement toDateTime;

    @FindBy(xpath = "(//button[contains(@class, 'primary')])[2]")
    public WebElement saveBtn;

    @FindBy(xpath = "//span[@title='Personal']")
    public WebElement personalBtn;

    public void enterEventName(String eventName) {

        BrowserUtils.waitFor(5);
        actions.click(newEventBtn).perform();
        BrowserUtils.waitFor(5);
        eventTitle.sendKeys(eventName);
    }

    public void chooseFromDate(String date, String time, String amPm) {
        BrowserUtils.waitFor(5);

        // Highlight the fromDate string
        BrowserUtils.executeJsCommand(fromDateTime, "arguments[0].select();");
     //   BrowserUtils.waitFor(1);

        // Delete the fromDate string
        fromDateTime.sendKeys(Keys.DELETE);
     //   BrowserUtils.waitFor(5);
        fromDateTime.sendKeys("from " + date + " at " + time + " " + amPm);
    }

    public void chooseToDate(String date, String time, String amPm) {

        actions.click(toDateTime).perform();

        // Highlight the toDate string
        BrowserUtils.executeJsCommand(toDateTime, "arguments[0].select();");

        actions.sendKeys(Keys.DELETE).perform();

        toDateTime.sendKeys("to " + date + " at " + time + " " + amPm);

        actions.click(saveBtn).perform();
    }
    public boolean isEventVisible(String date, String time) {

        WebElement event = Driver.getDriver().findElement(
                By.xpath("//td[@data-date='" + date + "']//div[.='" + time + "']/.."));

        BrowserUtils.waitFor(5);

        return event.isDisplayed();
    }
}
