package com.getir.steps;

import com.getir.pages.CategoryDetailPage;
import com.getir.pages.CartPage;
import com.getir.pages.DashboardPage;
import com.getir.pages.LoginPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import java.io.IOException;
import static com.getir.driver.Driver.setDriver;
import static org.junit.jupiter.api.Assertions.*;

public class Steps {

    public Logger logger;
    public AndroidDriver<MobileElement> driver;
    public LoginPage loginPage;
    public DashboardPage dashboardPage;
    public CartPage cartPage;
    public CategoryDetailPage categoryDetailPage;

    public Steps() throws IOException {
        driver = setDriver();
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        cartPage = new CartPage(driver);
        categoryDetailPage = new CategoryDetailPage(driver);
        logger = Logger.getLogger(Steps.class);
    }

    @When("^User signs in with \"([^\"]*)\" username and \"([^\"]*)\" password$")
    public void user_signs_in_with_username_and_password(String username, String password) {
        logger.info("Test user can login with valid username and password");
        loginPage.login(username,password);
    }

    @Then("^User is navigated to dashboard$")
    public void user_is_navigated_to_dashboard() {
        logger.info("Test whether the user is landed on dashboard after entering valid credentials");
        assertTrue(dashboardPage.checkGetirLogoExisting());
    }

    @Then("^User navigates to the cart$")
    public void user_navigates_to_the_cart() throws InterruptedException {
        logger.info("Test user can click on cart button and navigate to the related page");
        dashboardPage.goToCart();
        assertTrue(cartPage.isBasketTextExisting());
    }

    @Then("^User sees \"([^\"]*)\" message$")
    public void user_sees_message(String message) throws InterruptedException {
        logger.info("Test 'There is no result' message is displayed as default ");
        assertEquals(message, cartPage.getNoResultText());
    }

    @When("^User selects \"([^\"]*)\" category$")
    public void user_selects_category(String categoryName) throws InterruptedException {
        logger.info("Test user can click on a category from the list");
        dashboardPage.selectCategory(categoryName);
    }

    @When("^User adds (\\d+) number of the (\\d+) 'th product to the cart$")
    public void user_adds_number_of_the_st_product_to_the_cart(int productNumber, int productIndex) {
        logger.info("Test user can add products to the cart");
        categoryDetailPage.addANumberOfProductsToCart(productNumber, productIndex);
        assertEquals(productNumber, categoryDetailPage.getNumberOfProductsAddedOnTheDetailPage(productIndex));
    }

    @When("^User removes all (\\d+) products from the cart$")
    public void user_removes_products_from_the_cart(int totalProductNumber) throws InterruptedException {
        logger.info("Test user can decrease or remove the products");
        cartPage.removeProducts(totalProductNumber);
    }

    @When("^User navigates back to the dashboard$")
    public void user_navigates_back_to_the_dashboard() {
        logger.info("Test user can navigate back by clicking on the back arrow");
        categoryDetailPage.navigateBackToDashboard();
        assertTrue(dashboardPage.checkGetirLogoExisting());
    }

    @Then("^User sees the number of categories$")
    public void user_sees_the_number_of_categories() {
        logger.info("Test user sees various categories on the dashboard and the number of the categories is: "
        + dashboardPage.getNumberOfCategories());
    }

    @When("^User increase all products in the chart by (\\d+)$")
    public void user_increase_all_products_in_the_chart_by(int increaseNumber) throws InterruptedException {
        logger.info("Test user can increase number of products on the cart");
        dashboardPage.goToCart();
        cartPage.increaseNumberOfAllProductsBy(increaseNumber);
    }

    @Then("^User sees the number of products (\\d+) for (\\d+)'th product$")
    public void user_sees_the_number_of_products_for_th_product(int productNumber, int productIndex) {
        logger.info("Test user sees the increased numbers for each product added");
        assertEquals(productNumber, cartPage.getNumberOfProductAdded(productIndex));
    }
}
