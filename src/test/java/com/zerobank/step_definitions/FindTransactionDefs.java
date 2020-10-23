package com.zerobank.step_definitions;

import com.google.errorprone.annotations.FormatMethod;
import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FindTransactionDefs {
    @Given("the user accesses the Find Transactions tab")
    public void theUserAccessesTheFindTransactionsTab() {
        new AccountSummaryPage().accountActivityTab.click();
        new AccountActivityPage().findTransactionsTab.click();
    }

    @When("the user enters date range from “{int}{int}{int}” to “{int}{int}{int}”")
    public void theUserEntersDateRangeFromTo(int fromYYYY, int toYYYY) throws ParseException {
//        BrowserUtils.waitFor(3);
//        String from =((Integer.toString(fromYYYY))+(Integer.toString(fromMM))+(Integer.toString(fromDD)));
//        String to =((Integer.toString(toYYYY))+(Integer.toString(toMM))+(Integer.toString(toDD)));
//        new AccountActivityPage().fromDateInput.sendKeys(from);
//        new AccountActivityPage().toDateInput.sendKeys(to);
//        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyyMMdd");
//        Date datefrom = originalFormat.parse(from.toString());
//        Date dateto = originalFormat.parse(from.toString());
    }

    @And("clicks search")
    public void clicksSearch() {
        new AccountActivityPage().findButton.click();
    }

    @Then("results table should only show transactions dates between “{int}{int}{int}” to “{int}{int}{int}”")
    public void resultsTableShouldOnlyShowTransactionsDatesBetweenTo(int fromYYYY, int fromMM, int fromDD, int toYYYY, int toMM, int toDD) {
        Date expectedFrom = new Date(fromYYYY-fromMM-fromDD);
        Date expectedTo = new Date(toYYYY-toMM-toDD);

        List<WebElement> dates = Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']//tbody//tr//td[1]"));
        List<String> dateString = BrowserUtils.getElementsText(dates);
        for (String date: dateString) {
            String[] dateArray = date.split("-");
            Date actualDate = new Date(Integer.parseInt(dateArray[0])-Integer.parseInt(dateArray[1])-Integer.parseInt(dateArray[2]));
            if (expectedTo.after(actualDate)||expectedFrom.before(actualDate)){
                System.out.println("it is in range");
            }
        }

    }


}
