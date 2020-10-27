package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.lang.reflect.Array;
import java.util.Date;
import java.util.List;

public class AccountActivityPage extends BasePage {
    public AccountActivityPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//select[@id='aa_accountId']")
    public WebElement accountDropdown;
    //==================Find Transactions=========
    @FindBy(xpath = "//a[contains(text(),'Find Transactions')]")
    public WebElement findTransactionsTab;
    @FindBy(xpath = "//input[@id='aa_fromDate']")
    public WebElement fromDateInput;
    @FindBy(xpath = "//input[@id='aa_toDate']")
    public WebElement toDateInput;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement findButton;
    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody//tr//td[1]")
    public WebElement dateColumnOffilteredTable;// All of them
    @FindBy(xpath = "//div[@class='board']//input[@id='aa_description']")
    public WebElement descriptionInput;
    @FindBy(xpath = "//select[@id='aa_type']")
    public WebElement typeFindTranscationDropdown;
    @FindBy(xpath = "//div//thead//tr//th")
    public WebElement transactionsTbaleHeaders;
    @FindBy(xpath = "//a[contains(text(),'Account Activity')]")
    public WebElement accountActivityTab;


    public String verifyFirstSelection() {
        return new Select(accountDropdown).getFirstSelectedOption().getText();
    }

    public boolean checkoptions(String expected) {
        Select select = new Select(new AccountActivityPage().accountDropdown);
        List<String> list = BrowserUtils.getElementsText(select.getOptions());
        for (String opt : list) {
            if (opt.equals(expected)) {
                return true;
            }
        }
        return false;
    }
    public void checkoptionsList(List<String> expected,List<String> actual) {
        for (String opt : expected) {
            Assert.assertTrue(actual.contains(opt));
        }
    }








}
