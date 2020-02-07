package com.ZERO.ReadyTests;


import com.ZERO.Tools.Driver;
import com.ZERO.Tools.TestBase;
import com.ZERO.pages.AccauntSummaryPage;
import com.ZERO.pages.LoginPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccountSummary extends TestBase {

    /*
    Account summary page should have the title
    Zero – Account summary. Account summary page should have to following account types:
    Cash Accounts, Investment Accounts, Credit Accounts, Loan Accounts.
    Credit Accounts table must have columns Account, Credit Card and Balance.

     */


    LoginPage loginPage;
    AccauntSummaryPage accauntSummaryPage;

    @BeforeMethod
    public void setUp() {
        System.out.println("logStart");
        loginPage = new LoginPage();

        accauntSummaryPage = new AccauntSummaryPage();

        loginPage.LoginField.sendKeys("username");

        loginPage.PasswordField.sendKeys("password");

        loginPage.Submit.click();
        System.out.println("logend");

    }


    @Test
    public void checkTitle() {
        extentLogger = reports.createTest("Check Titile");
        extentLogger.info("checking");
        Assert.assertEquals(Driver.get().getTitle(), "Zero - Account Summary");
        extentLogger.pass("Done");
        System.out.println("Done1");
    }


    @Test
    public void CheckAccountTypes() {
        System.out.println("done2");
        extentLogger = reports.createTest("Check Account Types");
        extentLogger.info("step 1");
        int count = 0;
        extentLogger.info("step 1");
        List<String> list = new ArrayList<>(Arrays.asList(
                "Cash Accounts", "Investment Accounts", "Credit Accounts", "Loan Accounts"));
        extentLogger.info("step 1");
        List<WebElement> listW = new ArrayList<>(accauntSummaryPage.listOfAccountsTypes);
        extentLogger.info("step 1");
        for (WebElement eachW : listW) {
            for (String eachS : list) {
                extentLogger.info("step 1");
                if (eachW.getText().equals(eachS)) {
                    Assert.assertEquals(eachW.getText(), eachS);
                    System.out.println(eachS);
                    System.out.println(eachW.getText());
                    count++;
                }
            }
        }
        extentLogger.info("step 1");
        Assert.assertEquals(count, listW.size());
        extentLogger.pass("DOne!");
    }

    @Test
    public void CheckCreditCardColumns(){
        extentLogger = reports.createTest("CCCC");
        extentLogger.info("step 1");
         int count=0;
        extentLogger.info("step 1");
        List<String> listS = new ArrayList<>(Arrays.asList("Account","Credit Card","Balance"));
        extentLogger.info("step 1");
        ArrayList<WebElement> listW =new ArrayList<>(accauntSummaryPage.CreditAccountsListColumns);
        extentLogger.info("step 1");
        for (WebElement eachW : listW){
            for (String eachS : listS){
                if(eachS.equals(eachW.getText())){
                    extentLogger.info("step 1");
                    Assert.assertEquals(eachW.getText(),eachS);
                    count++;
                    System.out.println(eachS);
                    System.out.println(eachW.getText());
                }
            }
        }
        extentLogger.info("step 1");
        Assert.assertEquals(count,listS.size());
        extentLogger.pass("doone");
    }
}
