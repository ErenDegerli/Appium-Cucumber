package com.getir.core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Base {

    protected AppiumDriver<MobileElement> driver;
    protected WebDriverWait wait;

    public Base(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public MobileElement waitUntilVisible(MobileElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public MobileElement waitUntilClickable(MobileElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }
}