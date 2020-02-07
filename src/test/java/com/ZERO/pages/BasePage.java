package com.ZERO.pages;

import com.ZERO.Tools.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


abstract public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "account_summary_tab")
    public WebElement AccountSummary;

    @FindBy(id = "account_activity_tab")
    public WebElement AccountActivity;

    @FindBy(id = "transfer_funds_tab")
    public WebElement TransferFunds;

    @FindBy(id = "pay_bills_tab")
    public WebElement PayBills;

    @FindBy(id = "money_map_tab")
    public WebElement MoneyMap;

    @FindBy(id = "online_statements_tab")
    public WebElement Statements;

    @FindBy(xpath= "//i[@class=\"icon-user\"]")
    public WebElement UserDropDown;



}
