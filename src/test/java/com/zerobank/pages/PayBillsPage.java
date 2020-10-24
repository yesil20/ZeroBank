package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayBillsPage extends BasePage{
    public PayBillsPage(){
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(xpath = "//a[contains(text(),'Add New Payee')]")
    public WebElement addNewPayeeTab;
    @FindBy(xpath = "//input[@id='np_new_payee_name']")
    public WebElement payeeName;
    @FindBy(xpath = "//textarea[@id='np_new_payee_address']")
    public WebElement payeeAddress;
    @FindBy(xpath = "//input[@id='np_new_payee_account']")
    public WebElement account;
    @FindBy(xpath = "//input[@id='np_new_payee_details']")
    public WebElement payeeDetails;
    @FindBy(xpath = "//input[@id='add_new_payee']")
    public WebElement addBtn;
    @FindBy(xpath = "//div[@id='alert_content']")
    public WebElement addPayeeMessage;
    //============================
    @FindBy(xpath = "//a[contains(text(),'Purchase Foreign')]")
    public WebElement purchaseForeignCurrency;
    @FindBy(xpath = "//select[@id='pc_currency']")
    public WebElement optionsForeignCurrency;
    @FindBy(xpath = "//input[@id='pc_amount']")
    public WebElement amountOfCurrency;
    @FindBy(xpath = "//input[@id='pc_calculate_costs']")
    public WebElement calculateCosts;
    @FindBy (xpath = "//span[contains(text(),'The payment was successfully submitted.')]")
    public WebElement paymentSuccesfullMessage;
    @FindBy(xpath = "//input[@id='sp_amount']")
    public WebElement sp_Amount;
    @FindBy(xpath = "//input[@id='sp_date']")
    public WebElement sp_Date;
    @FindBy(xpath = "//input[@id='pay_saved_payees']")
    public WebElement sp_PayBtn;







}
