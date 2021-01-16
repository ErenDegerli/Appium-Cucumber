package com.getir.pages;

import com.getir.core.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends Base {

    @FindBy(id = "tvTitle")
    private MobileElement noResultText;

    @FindBy(id = "tvCount")
    private List<MobileElement> addedProductsNumber;

    @FindBy(id = "btnAdd")
    private List<MobileElement> addProductButtons;

    @FindBy(id = "cardChildView")
    private List<MobileElement> product;

    @FindBy(id = "btnRemove")
    private MobileElement removeProductBtn;

    @FindBy(id = "ga_toolbar_getir10TitleTextView")
    private MobileElement basketText;

    public CartPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public boolean isBasketTextExisting() throws InterruptedException {
        Thread.sleep(1000);
        return waitUntilVisible(basketText).isDisplayed();
    }

    public String getNoResultText() throws InterruptedException {
        Thread.sleep(1500);
        return waitUntilVisible(noResultText).getAttribute("text");
    }

    public void removeProducts(int totalProductNumber) throws InterruptedException {
        Thread.sleep(2000);
        for(int i = 0; i<totalProductNumber; i++) {
            waitUntilClickable(removeProductBtn).click();
        }
    }

    public void increaseNumberOfAllProductsBy(int increaseNumber) throws InterruptedException {
        Thread.sleep(2000);
        List<MobileElement> elementList = driver.findElements(By.id("btnAdd"));
        for (int i=0; i< addProductButtons.size();i++){
            for(int j = 0; j < increaseNumber; j++) {
                waitUntilClickable(addProductButtons.get(i)).click();
            }
        }
    }

    public int getNumberOfProductAdded(int productIndex) {
        return Integer.parseInt(waitUntilVisible(addedProductsNumber.get(productIndex - 1)).getText());
    }
}