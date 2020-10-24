package com.zerobank.step_definitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;

public class PayBillDefs {
    @And("User should able to make a payment")
    public void userShouldAbleToMakeAPayment() {
        BrowserUtils.waitFor(1);
        new PayBillsPage().payBillsTab.click();
        BrowserUtils.waitFor(1);
        new PayBillsPage().sp_Amount.sendKeys("100");
        new PayBillsPage().sp_Date.sendKeys("20200101");
        new PayBillsPage().sp_PayBtn.click();
    }

    @Then("After payments user should able to see The payment was succesfully submitted message")
    public void afterPaymentsUserShouldAbleToSeeThePaymentWasSuccesfullySubmittedMessage() {
        BrowserUtils.waitFor(1);
        Assert.assertTrue(new PayBillsPage().paymentSuccesfullMessage.isDisplayed());
    }

    @When("user tries to make a payment without netering amount or date")
    public void userTriesToMakeAPaymentWithoutNeteringAmountOrDate() {
        BrowserUtils.waitFor(1);
        new PayBillsPage().payBillsTab.click();
        BrowserUtils.waitFor(1);
        new PayBillsPage().sp_Date.sendKeys("20200101");
        new PayBillsPage().sp_PayBtn.click();
    }

    @Then("user should receive Please fill out this field message")
    public void userShouldReceivePleaseFillOutThisFieldMessage() {
        BrowserUtils.waitFor(1);
        String message = new PayBillsPage().sp_Amount.getAttribute("validationMessage");
        Assert.assertEquals("Please fill out this field.",message);
    }

    @And("Amount fields should not accept alphabetical and special characters")
    public void amountFieldsShouldNotAcceptAlphabeticalAndSpecialCharacters() {
        BrowserUtils.waitFor(1);
        new PayBillsPage().payBillsTab.click();
        BrowserUtils.waitFor(1);
        new PayBillsPage().sp_Amount.sendKeys("damsdn----");
        //Assert.assertFalse(new PayBillsPage().paymentSuccesfullMessage.isDisplayed());
    }

    @And("Date field should not accept alphabetical")
    public void dateFieldShouldNotAcceptAlphabetical() {
        BrowserUtils.waitFor(1);
        new PayBillsPage().payBillsTab.click();
        BrowserUtils.waitFor(1);
        new PayBillsPage().sp_Date.sendKeys("asdasda");
        String spdate = new PayBillsPage().sp_Date.getText();
        Assert.assertTrue(spdate.isEmpty());
    }
}
