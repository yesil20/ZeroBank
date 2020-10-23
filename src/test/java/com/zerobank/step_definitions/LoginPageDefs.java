package com.zerobank.step_definitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginPageDefs {
    @When("the user on main page")
    public void theUserOnMainPage() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @And("click on sign in button on top")
    public void clickOnSignInButtonOnTop() {
        new LoginPage().signInBtn.click();
    }

    @And("enter valid credentials")
    public void enterValidCredentials() {
        BrowserUtils.waitFor(1);
        new LoginPage().username.sendKeys(ConfigurationReader.get("username"));
        new LoginPage().password.sendKeys(ConfigurationReader.get("password"));
    }

    @Then("click sign in button and the user should able to logged in")
    public void clickSignInButtonAndTheUserShouldAbleToLoggedIn() {
        new LoginPage().loginBtn.click();
    }

    @And("enter unvalid credentials")
    public void enterUnvalidCredentials() {
        new LoginPage().username.sendKeys("123123");
        new LoginPage().password.sendKeys("234112");
    }

    @And("click sign in button")
    public void clickSignInButton() {
        new LoginPage().loginBtn.click();
    }

    @Then("the user should not login and should see error message")
    public void theUserShouldNotLoginAndShouldSeeErrorMessage() {
        Assert.assertTrue(new LoginPage().errorMessage.isDisplayed());
    }
}
