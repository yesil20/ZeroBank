package com.zerobank.step_definitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import javax.sql.rowset.BaseRowSet;
import java.util.List;

public class PurcahseForeignCurrencyDefs {
    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() {
        new AccountSummaryPage().payBillsTab.click();
        new PayBillsPage().purchaseForeignCurrency.click();
    }
    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> currencyOptions) {
        BrowserUtils.waitFor(1);
        List<String> actualOptions = BrowserUtils.getElementsText(new Select(new PayBillsPage().optionsForeignCurrency).getOptions());
        for (String options:currencyOptions) {
            Assert.assertTrue(actualOptions.contains(options));
        }
    }
    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        BrowserUtils.waitFor(1);
        new PayBillsPage().amountOfCurrency.sendKeys("1212");
        new PayBillsPage().calculateCosts.click();
    }
    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        //Alert alert = Driver.get().switchTo().alert();
        Assert.assertFalse(ExpectedConditions.alertIsPresent()==null);
    }
    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        BrowserUtils.waitFor(1);
        new Select(new PayBillsPage().optionsForeignCurrency).selectByVisibleText("China (yuan)");
        new PayBillsPage().calculateCosts.click();
    }
}
