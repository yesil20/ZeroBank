package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import javax.sql.rowset.BaseRowSet;
import java.util.*;

public class AccountActivityDefs {

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");
        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);
    }
    @When("the user clicks on Savings link on the Account Summary page")
    public void the_user_clicks_on_Savings_link_on_the_Account_Summary_page() {
        BrowserUtils.waitFor(1);
        new AccountSummaryPage().savingsLink.click();
    }
    @Then("Account drop down should have Savings selected")
    public void account_drop_down_should_have_Savings_selected() {
        Assert.assertEquals("Savings",new AccountActivityPage().verifyFirstSelection());
        //Assert.assertEquals("Savings",new Select(new AccountActivityPage().accountDropdown).getFirstSelectedOption().getText());
    }
    @When("the user clicks on Brokerage link on the Account Summary page")
    public void the_user_clicks_on_Brokerage_link_on_the_Account_Summary_page() {
        new AccountSummaryPage().brokerageLink.click();
    }
    @Then("Account drop down should have Brokerage selected")
    public void account_drop_down_should_have_Brokerage_selected() {
        Assert.assertEquals("Brokerage",new AccountActivityPage().verifyFirstSelection());
        //Assert.assertEquals("Brokerage",new Select(new AccountActivityPage().accountDropdown).getFirstSelectedOption().getText());
    }
    @When("the user clicks on Checking link on the Account Summary page")
    public void the_user_clicks_on_Checking_link_on_the_Account_Summary_page() {
        new AccountSummaryPage().checkingLink.click();
    }
    @Then("Account drop down should have Checking selected")
    public void account_drop_down_should_have_Checking_selected() {
        Assert.assertEquals("Checking",new AccountActivityPage().verifyFirstSelection());
    }
    @When("the user clicks on Credit card link on the Account Summary page")
    public void the_user_clicks_on_Credit_card_link_on_the_Account_Summary_page() {
        new AccountSummaryPage().creditCardLink.click();
    }
    @Then("Account drop down should have Credit Card selected")
    public void account_drop_down_should_have_Credit_Card_selected() {
        Assert.assertEquals("Credit Card",new AccountActivityPage().verifyFirstSelection());
    }
    @When("the user clicks on Loan link on the Account Summary page")
    public void the_user_clicks_on_Loan_link_on_the_Account_Summary_page() {
        BrowserUtils.waitFor(1);
        new AccountSummaryPage().loanLink.click();
    }
    @Then("the Account Activity page should be displayed")
    public void the_Account_Activity_page_should_be_displayed() {
        BrowserUtils.waitFor(1);
       Assert.assertTrue(Driver.get().findElement(By.xpath("//li[@class='active'][@id='account_activity_tab']")).isDisplayed());
    }
    @Then("Account drop down should have Loan selected")
    public void account_drop_down_should_have_Loan_selected() {
        BrowserUtils.waitFor(1);
        Assert.assertEquals("Loan",new AccountActivityPage().verifyFirstSelection());
    }

    @When("on the Account summary page Zerobank should be displayed as a title")
    public void onTheAccountSummaryPageZerobankShouldBeDisplayedAsATitle() {
        BrowserUtils.waitFor(1);
        Assert.assertTrue(new AccountSummaryPage().pageTitle.isDisplayed());
    }

    @Then("Default option of Account dropdown should be Savings")
    public void defaultOptionOfAccountDropdownShouldBeSavings() {
        BrowserUtils.waitFor(2);
        Assert.assertEquals("Savings",new Select(new AccountActivityPage().accountDropdown).getFirstSelectedOption().getText());
    }

    @Then("Dropdown sholud have following options")
    public void dropdownSholudHaveFollowingOptions(List<String> accountdropdown) {
        BrowserUtils.waitFor(1);
        Select select =new Select(new AccountActivityPage().accountDropdown);
        Set<String> set = new LinkedHashSet<>(BrowserUtils.getElementsText(select.getOptions()));
        List<String>list =new ArrayList<>(set);
        Assert.assertEquals(accountdropdown,list);
    }

    @Then("Transcations table must have following options")
    public void transcationsTableMustHaveFollowingOptions(List<String> TransactionTable) {
        BrowserUtils.waitFor(1);
        Assert.assertEquals(TransactionTable, BrowserUtils.getElementsText(Driver.get().findElements(By.xpath("//div//thead//tr//th"))));
    }

    @When("And clicks Account Activity Tab")
    public void andClicksAccountActivityTab() {
        BrowserUtils.waitFor(1);
        new AccountActivityPage().accountActivityTab.click();
    }
}
