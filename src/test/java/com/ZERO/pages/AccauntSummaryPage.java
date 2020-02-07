package com.ZERO.pages;

import com.ZERO.Tools.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccauntSummaryPage extends BasePage {

    public AccauntSummaryPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//h2[.=\"Cash Accounts\"]")
    public WebElement CashAccountsTitle;

    @FindBy(xpath = "//h2[.='Investment Accounts']")
    public WebElement  InvestmentAccountsTitle;

    @FindBy(xpath = "//h2[.='Credit Accounts']")
    public WebElement  CreditAccountsTitle;

    @FindBy(xpath = "//h2[.='Loan']")
    public WebElement  LoanTitle;

    @FindBy(xpath = "//h2[@class='board-header']")
    public List <WebElement> listOfAccountsTypes;

    @FindBy(xpath ="//h2[.='Credit Accounts']/following-sibling::div[1]//th")
    public List<WebElement> CreditAccountsListColumns;



}
