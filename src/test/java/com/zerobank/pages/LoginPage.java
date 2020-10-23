package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(xpath = "//button[@id='signin_button']")
    public WebElement signInBtn;
    @FindBy(xpath="//input[@id='user_login']")
    public WebElement username;
    @FindBy(xpath="//input[@id='user_password']")
    public WebElement password;
    @FindBy(xpath = "//input[@name='submit']")
    public WebElement loginBtn;
    @FindBy (xpath = "//div[@class='alert alert-error']")
    public WebElement errorMessage;



    public void login(String userNameStr, String passwordStr) {
        Driver.get().get(ConfigurationReader.get("url"));
        signInBtn.click();
        BrowserUtils.waitFor(1);
        username.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        loginBtn.click();
    }




}
