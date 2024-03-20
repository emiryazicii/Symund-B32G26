package com.symund.step_definitions;

import com.symund.pages.LoginPage;
import com.symund.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefs {

    LoginPage loginPage = new LoginPage();

    @When("the user logs in with username {string} and password {string}")
    public void the_user_logs_in_with_username_and_password(String username, String password) {
        loginPage.login(username,password);
    }

    @Then("the user should be directed to the dashboard")
    public void the_user_should_be_directed_to_the_dashboard() {
        BrowserUtils.verifyTitleContains("Dashboard");
    }
}
