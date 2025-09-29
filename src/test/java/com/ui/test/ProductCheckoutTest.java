package com.ui.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SearchProductPage;

public class ProductCheckoutTest extends BaseTest {
    private SearchProductPage searchProductPage;
    private static final String PRODUCT_NAME = "PRINTED SUMMER DRESS";

    @BeforeMethod
    private void setUpSearch() {
        searchProductPage = homePage.clickSignIn().loginToApp("sogole8183@cspaus.com", "password")
                .searchProduct(PRODUCT_NAME);
    }

    @Test(description = "Verifying user can able to checkout the product in the application", groups = {"smoke", "e2e"})
    public void checkoutProductTest() {
        String confirmText = searchProductPage.clickFirstProduct()
                .selectingProductSizeAndColour().addingProductToCart()
                .proceedToCheckout().summaryProceedToCheckout().addressProceedToCheckout()
                .agreeToTermsAndProceedToCheckout().selectPayByBankWire();
        System.out.println("confirmText = " + confirmText);
        Assert.assertEquals(confirmText, "Your order on My Shop is complete.");
    }
}
