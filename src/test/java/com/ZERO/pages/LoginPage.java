package com.ZERO.pages;

import com.ZERO.Tools.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginPage{

    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "user_login")
    public WebElement LoginField;

    @FindBy(id = "user_password")
    public WebElement PasswordField;

    @FindBy(name = "submit")
    public WebElement Submit;

    @FindBy(xpath = "//div[contains(text(),\"Login and/or password are wrong\")]")
    public WebElement ErrorLogin;


}
