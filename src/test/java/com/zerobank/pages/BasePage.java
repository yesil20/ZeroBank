package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class BasePage {
    @FindBy(xpath = "//button[@id='signin_button']")
    public WebElement signInBtn;
    @FindBy(xpath = "//a[contains(text(),'Pay Bills')]")
    public WebElement payBillsTab;

}
