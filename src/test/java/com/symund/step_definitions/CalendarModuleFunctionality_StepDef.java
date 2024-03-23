package com.symund.step_definitions;

import com.symund.pages.CalendarPage;
import com.symund.pages.LoginPage;
import com.symund.utilities.BrowserUtils;
import com.symund.utilities.ConfigurationReader;
import com.symund.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CalendarModuleFunctionality_StepDef {
    CalendarPage calendarPage = new CalendarPage();

    @When("user navigates to the Calendar module page")
    public void user_navigates_to_the_calendar_module_page() {
        calendarPage.navigateToPage("calendar");
    }
    @Given("user navigates to the dropdown option")
    public void user_navigates_to_the_dropdown_option() {

        calendarPage.dropdownBtn.click();
    }
    @When("user clicks to the Daily calendar")
    public void user_clicks_to_the_daily_calendar() {

        BrowserUtils.waitFor(2);
        calendarPage.dailyCalendar.click();
    }
    @Then("Daily Calendar should be visible on the page")
    public void daily_calendar_should_be_visible_on_the_page() {

        BrowserUtils.waitFor(2);
        String dailyCalendarURL = Driver.getDriver().getCurrentUrl();
        String expectedInDailyURL = "timeGridDay";
        Assert.assertTrue(dailyCalendarURL.contains(expectedInDailyURL));
    }
    @When("user clicks to the Weekly calendar")
    public void user_clicks_to_the_weekly_calendar() {

        BrowserUtils.waitFor(2);
        calendarPage.weeklyCalendar.click();
    }
    @Then("Weekly Calendar should be visible on the page")
    public void weekly_calendar_should_be_visible_on_the_page() {

        BrowserUtils.waitFor(2);
        String weeklyCalendarURL = Driver.getDriver().getCurrentUrl();
        String expectedInWeeklyURL = "timeGridWeek";
        Assert.assertTrue(weeklyCalendarURL.contains(expectedInWeeklyURL));
    }
    @When("user clicks to the Monthly calendar")
    public void user_clicks_to_the_monthly_calendar() {

        calendarPage.monthlyCalendar.click();
    }
    @Then("Monthly Calendar should be visible on the page")
    public void monthly_calendar_should_be_visible_on_the_page() {

        String monthlyCalendarURL = Driver.getDriver().getCurrentUrl();
        String expectedInMonthlyURL = "dayGridMonth";
        Assert.assertTrue(monthlyCalendarURL.contains(expectedInMonthlyURL));
    }

    @When("user enters event name {string},")
    public void userEntersEventName(String eventName) {
        calendarPage.enterEventName(eventName);
    }

    @And("user enters starting date {string}, {string},{string}")
    public void userEntersStartingDate(String date, String time, String amPm) {
        calendarPage.chooseFromDate(date, time, amPm);
    }

    @And("user enters ending date {string}, {string},{string} and save it")
    public void userEntersEndingDateAndSaveIt(String date, String time, String amPm) {
        calendarPage.chooseToDate(date, time, amPm);
    }

    @Then("user should see the new event with given {string} and {string} through the Monthly Calendar view")
    public void userShouldSeeTheNewEventWithGivenAndThroughTheMonthlyCalendarView(String date, String time) {

        Assert.assertTrue(calendarPage.isEventVisible(date, time));
    }




}





