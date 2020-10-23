package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSummaryPage extends BasePage {
    public AccountSummaryPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//a[contains(text(),'Savings')]")
    public WebElement savingsLink;
    @FindBy(xpath = "//a[contains(text(),'Brokerage')]")
    public WebElement brokerageLink;
    @FindBy(xpath = "//a[contains(text(),'Checking')]")
    public WebElement checkingLink;
    @FindBy(xpath = "//a[contains(text(),'Credit Card')]")
    public WebElement creditCardLink;
    @FindBy(xpath = "//a[contains(text(),'Loan')]")
    public WebElement loanLink;
    @FindBy(xpath = "//a[contains(text(),'Account Activity')]")
    public WebElement accountActivityTab;




}
