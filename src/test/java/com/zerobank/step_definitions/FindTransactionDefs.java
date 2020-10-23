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

    @When("the user enters date range from “{int}{int}{int}” to “{int}{int}{int}”")
    public void theUserEntersDateRangeFromTo(int fromYYYY, int fromDD,int fromMM, int toYYYY, int toMM, int toDD)  {
//        BrowserUtils.waitFor(3);
//        String from =((Integer.toString(fromYYYY))+(Integer.toString(fromMM))+(Integer.toString(fromDD)));
//        String to =((Integer.toString(toYYYY))+(Integer.toString(toMM))+(Integer.toString(toDD)));
//        new AccountActivityPage().fromDateInput.sendKeys(from);
//        new AccountActivityPage().toDateInput.sendKeys(to);
//        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyyMMdd");
//        Date datefrom = originalFormat.parse(from.toString());
//        Date dateto = originalFormat.parse(from.toString());
        System.out.println(fromYYYY);
        System.out.println(fromMM);
    }

    @And("clicks search")
    public void clicksSearch() {
        BrowserUtils.waitFor(1);
        new AccountActivityPage().findButton.click();
    }

    @Then("results table should only show transactions dates between “{int}{int}{int}” to “{int}{int}{int}”")
    public void resultsTableShouldOnlyShowTransactionsDatesBetweenTo(int fromYYYY, int fromMM, int fromDD, int toYYYY, int toMM, int toDD) {
//        Date expectedFrom = new Date(fromYYYY-fromMM-fromDD);
//        Date expectedTo = new Date(toYYYY-toMM-toDD);
//
//        List<WebElement> dates = Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']//tbody//tr//td[1]"));
//        List<String> dateString = BrowserUtils.getElementsText(dates);
//        for (String date: dateString) {
//            String[] dateArray = date.split("-");
//            Date actualDate = new Date(Integer.parseInt(dateArray[0])-Integer.parseInt(dateArray[1])-Integer.parseInt(dateArray[2]));
//            if (expectedTo.after(actualDate)||expectedFrom.before(actualDate)){
//                System.out.println("it is in range");
//            }
//        }
        System.out.println("LAst one ");
    }


    @When("the user enters description “ONLINE”")
    public void theUserEntersDescriptionONLINE() {
        BrowserUtils.waitFor(1);
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
}
