package com.ZERO.ReadyTests;
import com.ZERO.Tools.Driver;
import com.ZERO.Tools.TestBase;
import com.ZERO.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;


public class Login extends TestBase {

/*
Only authorized users should be able to login to the application.
When user logs in with valid credentials,
Account summary page should be displayed.
Users with wrong username or wrong password should not be able to login.
Users with blank username or password should also not be able to login.
When user tries to login with invalid information, error message Login and/or
password are wrong. should be displayed.

 */
   LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
      loginPage = new LoginPage();

    }


    @Test
    public void ValidLogin(){
        extentLogger = reports.createTest("Login test");
        extentLogger.info("step 1");
        loginPage.LoginField.sendKeys("username");
        extentLogger.info("step 2");
        loginPage.PasswordField.sendKeys("password");
        extentLogger.info("step 3");
        loginPage.Submit.click();
        extentLogger.info("step 4");
        Assert.assertTrue(Driver.get().getTitle().contains("Account Summary"));
        extentLogger.pass("done");
    }

    @Test
    public void WrongUserAndPassword(){
        extentLogger = reports.createTest("WrongPassword");
        extentLogger.info("1");
        loginPage.LoginField.sendKeys("user");
        loginPage.PasswordField.sendKeys("password");
        loginPage.Submit.click();
        Assert.assertTrue(loginPage.ErrorLogin.isDisplayed());
        loginPage.LoginField.sendKeys("username");
        loginPage.PasswordField.sendKeys("passwor");
        Assert.assertTrue(loginPage.ErrorLogin.isDisplayed());
        extentLogger.pass("done");
    }
    @Test
    public void BlankUserNameOrPassword(){
        extentLogger = reports.createTest("Check the blikn fields");

        extentLogger.info("step 1");
        loginPage.LoginField.sendKeys("username");
        extentLogger.info("step 2");
        loginPage.PasswordField.clear();
        extentLogger.info("step 3");
        loginPage.Submit.click();
        Assert.assertTrue(loginPage.ErrorLogin.isDisplayed());

        loginPage.PasswordField.sendKeys("password");
        loginPage.LoginField.clear();
        loginPage.Submit.click();
        Assert.assertTrue(loginPage.ErrorLogin.isDisplayed());
        extentLogger.pass("Test passed");

    }




}
