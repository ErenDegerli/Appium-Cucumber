package com.getir.pages;

import com.getir.core.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Base {

    @FindBy(id = "usernameEditText")
    private MobileElement emailInputField;

    @FindBy(id = "passwordEditText")
    private MobileElement passwordInputField;

    @FindBy(id = "loginButton")
    private MobileElement submitBtn;


    public LoginPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public void login(String username, String password) {
        waitUntilVisible(emailInputField).sendKeys(username);
        passwordInputField.sendKeys(password);
        submitBtn.click();
    }
}