package com.zerobank.step_definitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class AddNewPayee {
    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String> addNewPayee) {
        BrowserUtils.waitFor(1);
        new PayBillsPage().payeeName.sendKeys(addNewPayee.get("Payee Name"));
        new PayBillsPage().payeeAddress.sendKeys(addNewPayee.get("Payee Address"));
        new PayBillsPage().account.sendKeys(addNewPayee.get("Account"));
        new PayBillsPage().payeeDetails.sendKeys(addNewPayee.get("Payee details"));
        new PayBillsPage().addBtn.click();
    }
    @Then("message The new payee The Law Offices of Hyde, Price & Scharks was successfully created. should be displayed")
    public void message_The_new_payee_The_Law_Offices_of_Hyde_Price_Scharks_was_successfully_created_should_be_displayed() {
        Assert.assertTrue(new PayBillsPage().addPayeeMessage.isDisplayed());
    }

    @Given("the user clicks on Pay Bills Tab")
    public void theUserClicksOnPayBillsTab() {
        new PayBillsPage().payBillsTab.click();
    }

    @And("clicks Add New Payee tab")
    public void clicksAddNewPayeeTab() {
        new PayBillsPage().addNewPayeeTab.click();
    }


}
