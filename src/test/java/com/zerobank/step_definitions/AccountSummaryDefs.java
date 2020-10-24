package com.zerobank.step_definitions;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

import javax.sql.rowset.BaseRowSet;
import java.util.List;

public class AccountSummaryDefs {

    @Then("Account Summary page should have following options")
    public void accountSummaryPageShouldHaveFollowingOptions(List<String> list) {
        BrowserUtils.waitFor(1);
      List<String> list1 = BrowserUtils.getElementsText(Driver.get().findElements(By.xpath("//h2[@class='board-header']")));
        Assert.assertEquals(list,list1);
    }

    @And("Credit Account table should contains specified column")
    public void creditAccountTableShouldContainsSpecifiedColumn(List<String> list) {
        BrowserUtils.waitFor(1);
        List<String> list1 = BrowserUtils.getElementsText(Driver.get().findElements(By.xpath("//div[@class='board'][3]//thead//th")));
        Assert.assertEquals(list,list1);
    }
}
