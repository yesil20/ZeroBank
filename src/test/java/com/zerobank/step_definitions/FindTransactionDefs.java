package com.zerobank.step_definitions;

import com.google.errorprone.annotations.FormatMethod;
import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.*;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FindTransactionDefs<toMM> {
    @Given("the user accesses the Find Transactions tab")
    public void theUserAccessesTheFindTransactionsTab() {
        new AccountSummaryPage().accountActivityTab.click();
        new AccountActivityPage().findTransactionsTab.click();
    }
    @And("clicks search")
    public void clicksSearch() {
        BrowserUtils.waitForClickablility(new AccountActivityPage().findButton,5);
        new AccountActivityPage().findButton.click();
    }
    @When("the user enters description “ONLINE”")
    public void theUserEntersDescriptionONLINE() {
        BrowserUtils.waitForClickablility(new AccountActivityPage().descriptionInput,5);
        new AccountActivityPage().descriptionInput.sendKeys("ONLINE");
    }
    @Then("results table should only show descriptions containing “ONLINE”")
    public void resultsTableShouldOnlyShowDescriptionsContainingONLINE() {
        BrowserUtils.waitFor(1);
        List<WebElement> results = Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']//tbody//tr//td[2]"));
        for (WebElement result: results) {
            Assert.assertTrue(result.getText().contains("ONLINE"));
        }
    }
    @When("the user enters description “OFFICE”")
    public void theUserEntersDescriptionOFFICE() {
        BrowserUtils.waitFor(1);
        new AccountActivityPage().descriptionInput.clear();
        BrowserUtils.waitFor(1);
        new AccountActivityPage().descriptionInput.sendKeys("OFFICE");
    }
    @Then("results table should only show descriptions containing “OFFICE”")
    public void resultsTableShouldOnlyShowDescriptionsContainingOFFICE() {
        BrowserUtils.waitFor(1);
        List<WebElement> results = Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']//tbody//tr//td[2]"));
        for (WebElement result: results) {
            Assert.assertTrue(result.getText().contains("OFFICE"));
        }
    }
    @But("results table should not show descriptions containing “ONLINE”")
    public void resultsTableShouldNotShowDescriptionsContainingONLINE() {
        BrowserUtils.waitFor(2);
        List<WebElement> results = Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']//tbody//tr//td[2]"));
        for (WebElement result: results) {
            Assert.assertFalse(result.getText().contains("ONLINE"));
        }
    }
    @Then("results table should show at least one result under Deposit")
    public void resultsTableShouldShowAtLeastOneResultUnderDeposit() {
        BrowserUtils.waitFor(1);
        List<WebElement> results = Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']//tbody//tr//td[3]"));
        Assert.assertTrue(results.size()>1);
    }

    @Then("results table should show at least one result under Withdrawal")
    public void resultsTableShouldShowAtLeastOneResultUnderWithdrawal() {
        BrowserUtils.waitFor(1);
        List<WebElement> results = Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']//tbody//tr//td[4]"));
        Assert.assertTrue(results.size()>=1);
    }
    @When("user selects type “Deposit”")
    public void userSelectsTypeDeposit() {
        BrowserUtils.waitFor(1);
        new Select(new AccountActivityPage().typeFindTranscationDropdown).selectByVisibleText("Deposit");
    }
    @But("results table should show no result under Withdrawal")
    public void resultsTableShouldShowNoResultUnderWithdrawal() {
        BrowserUtils.waitFor(1);
        List<WebElement> results = Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']//tbody//tr//td[4]"));
        for (WebElement ele:results) {
            Assert.assertTrue(ele.getText().isEmpty());
        }
    }
    @When("user selects type “Withdrawal”")
    public void userSelectsTypeWithdrawal() {
        BrowserUtils.waitFor(1);
        new Select(new AccountActivityPage().typeFindTranscationDropdown).selectByVisibleText("Withdrawal");
    }
    @But("results table should show no result under Deposit")
    public void resultsTableShouldShowNoResultUnderDeposit() {
        BrowserUtils.waitFor(1);
        List<WebElement> results = Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']//tbody//tr//td[3]"));
        for (WebElement ele:results) {
            Assert.assertTrue(ele.getText().isEmpty());
        }
    }
    @When("the user enters date range from {string} to {string}")
    public void theUserEntersDateRangeFromTo(String arg0, String arg1) {
        BrowserUtils.waitFor(1);
        new AccountActivityPage().fromDateInput.clear();
        new AccountActivityPage().toDateInput.clear();
        new AccountActivityPage().fromDateInput.sendKeys(arg0);
        new AccountActivityPage().toDateInput.sendKeys(arg1);
        new AccountActivityPage().toDateInput.sendKeys(Keys.ENTER);
    }
    @Then("results table should only show transactions dates between {string} to {string}")
    public void resultsTableShouldOnlyShowTransactionsDatesBetweenTo(String arg0, String arg1) throws ParseException {
        BrowserUtils.waitFor(1);
        List <String> listdate = BrowserUtils.getElementsText(Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']//tbody//tr//td[1]")));
        SimpleDateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd");
        Date Cdate1= dateFormat.parse(arg0);
        Date Cdate2= dateFormat.parse(arg1);
        for (String dates :listdate) {
            Date date = dateFormat.parse(dates);
            Assert.assertTrue(Cdate2.equals(dateFormat.parse(dates))||
                    Cdate1.before(dateFormat.parse(dates))||
                    Cdate1.equals(dateFormat.parse(dates))||
                    Cdate2.after(dateFormat.parse(dates)));
        }
    }
    @And("the results should be sorted by most recent date")
    public void theResultsShouldBeSortedByMostRecentDate() throws ParseException {
        List<String> listdate = BrowserUtils.getElementsText(Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']//tbody//tr//td[1]")));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
       Date mostrecent = dateFormat.parse(listdate.get(0));
        for (int i = 1; i < listdate.size(); i++) {
            if (mostrecent.before(dateFormat.parse(listdate.get(i)))) {
                mostrecent=dateFormat.parse(listdate.get(i));
            }
        }
        Assert.assertEquals(listdate.get(0),dateFormat.format(mostrecent));
    }

    @And("the results table should only not contain transactions dated {string}")
    public void theResultsTableShouldOnlyNotContainTransactionsDated(String arg0) throws ParseException {
        BrowserUtils.waitFor(1);
        List <String> listdate = BrowserUtils.getElementsText(Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']//tbody//tr//td[1]")));
        for (String dates :listdate) {
            Assert.assertNotEquals("2012-09-01",dates);
        }
    }
}
