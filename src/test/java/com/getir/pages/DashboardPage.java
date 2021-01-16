package com.getir.pages;

import com.getir.core.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class DashboardPage extends Base {

    @FindBy(id = "ga_toolbar_getirLogoImageView")
    private MobileElement getirLogo;

    @FindBy(id = "ga_toolbar_getir10GABasketButton")
    private MobileElement cartBtn;

    @FindBy(id = "tvTitle")
    private List<MobileElement> sections;

    public DashboardPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public boolean checkGetirLogoExisting() {
        return waitUntilVisible(getirLogo).isDisplayed();
    }

    public void goToCart() {
        cartBtn.click();
    }

    public void selectCategory(String categoryName) throws InterruptedException {
        Thread.sleep(2000);
        waitUntilVisible(driver.findElementByXPath("//android.widget.TextView[@text='" + categoryName + "']")).click();
    }

    public int getNumberOfCategories() {
        waitUntilVisible(sections.get(0));
        return sections.size();
    }
}