package com.getir.pages;

import com.getir.core.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class CategoryDetailPage extends Base {

    @FindBy(id = "btnAdd")
    private List<MobileElement> addBtnList;

    @FindBy(id = "tvCount")
    private List<MobileElement> numberOfProductsAdded;

    @FindBy(id = "ga_toolbar_leftIconImageView")
    private MobileElement backBtn;

    public CategoryDetailPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public void addANumberOfProductsToCart(int numberOfProductToBeAdded, int productIndex) {
        for(int i = 0; i<numberOfProductToBeAdded; i++) {
            waitUntilClickable(addBtnList.get(productIndex-1)).click();
        }
    }

    public int getNumberOfProductsAddedOnTheDetailPage(int productIndex) {
        return Integer.parseInt(waitUntilVisible(numberOfProductsAdded.get(productIndex-1)).getText());
    }

    public void navigateBackToDashboard() {
        backBtn.click();
    }
}