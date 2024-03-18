package com.symund.step_definitions;

import com.symund.pages.LoginPage;
import com.symund.utilities.BrowserUtils;
import com.symund.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginFunctionStepDefs {

    LoginPage loginPage = new LoginPage();

    @Given("the user logged in successfully")
    public void the_user_logged_in_successfully() {

        loginPage.login(ConfigurationReader.getProperty("username.emir"),ConfigurationReader.getProperty("password"));

    }

    @Then("the user is on the dashboard")
    public void the_user_is_on_the_dashboard() {

        BrowserUtils.verifyTitleContains(ConfigurationReader.getProperty("expected.title.part.dashboard"));
    }

}
