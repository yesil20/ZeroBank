package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.lang.reflect.Array;
import java.util.Date;
import java.util.List;

public class AccountActivityPage extends BasePage {
    public AccountActivityPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//select[@id='aa_accountId']")
    public WebElement accountDropdown;
    //==================Find Transactions=========
    @FindBy(xpath = "//a[contains(text(),'Find Transactions')]")
    public WebElement findTransactionsTab;
    @FindBy (xpath = "//input[@id='aa_fromDate']")
    public WebElement fromDateInput;
    @FindBy (xpath = "//input[@id='aa_toDate']")
    public WebElement toDateInput;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement findButton;
    @FindBy (xpath = "//div[@id='filtered_transactions_for_account']//tbody//tr//td[1]")
    public WebElement dateColumnOffilteredTable;// All of them





    public String verifyFirstSelection(){
        return new Select(accountDropdown).getFirstSelectedOption().getText();
    }
    public void isWithinRange (int fromYYYY, int fromMM, int fromDD, int toYYYY, int toMM, int toDD) {

        Date expectedFrom = new Date(fromYYYY-fromMM-fromDD);
        Date expectedTo = new Date(toYYYY-toMM-toDD);

        List<WebElement> dates = Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']//tbody//tr//td[1]"));
        List<String> dateString =BrowserUtils.getElementsText(dates);
        for (String date: dateString) {
            String[] dateArray = date.split("-");
            Date actualDate = new Date(Integer.parseInt(dateArray[0])-Integer.parseInt(dateArray[1])-Integer.parseInt(dateArray[2]));
            if (expectedTo.after(actualDate)||expectedFrom.before(actualDate)){
                System.out.println("it is in range");
            }
        }

//        String[] dateArrayFirst = BrowserUtils.getElementsText(dates).get(0).split("-");
//        int fromDate = Integer.parseInt(dateArrayFirst[0]+dateArrayFirst[1]+dateArrayFirst[2]);
//        int fYYYY = Integer.parseInt(dateArrayFirst[0]);
//        int fMM =Integer.parseInt(dateArrayFirst[1]);
//        int fDD =Integer.parseInt(dateArrayFirst[2]);
//        String [] dateArrayLast = BrowserUtils.getElementsText(dates).get(-1).split("-");
//        int toDate = Integer.parseInt(dateArrayLast[0]+dateArrayLast[1]+dateArrayLast[2]);
//        int tYYYY = Integer.parseInt(dateArrayLast[0]);
//        int tMM =Integer.parseInt(dateArrayLast[1]);
//        int tDD =Integer.parseInt(dateArrayLast[2]);
    }
}
