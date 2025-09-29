package com.ui.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MyAccountPage;
import pages.SearchProductPage;

import java.util.List;

import static org.testng.Assert.*;

public class SearchProductTest extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(SearchProductTest.class);
    MyAccountPage myAccountPage;
    SearchProductPage searchProductPage;

    @BeforeMethod
    private void setUpSearch() {
        myAccountPage = homePage.clickSignIn().loginToApp("sogole8183@cspaus.com", "password");
    }

    @Test(priority = 0, description = "Verifying the users able to search the product in the application", groups = {"smoke", "e2e"})
    private void searchProduct() {
        String productName = "PRINTED SUMMER DRESS";
        searchProductPage = myAccountPage.searchProduct(productName);
        String name = searchProductPage.getProductName();
        assertNotNull(name);
        assertFalse(name.isEmpty(), "Product Name is Empty");
        assertTrue(name.contains(productName));
        System.out.println("name = " + name);
    }

    @Test(  priority = 1, description = "Verifying the users able to get list of products in the application", groups = {"smoke", "e2e"})
    private void getListOfProducts() {
        String productName = "PRINTED SUMMER DRESS";
        boolean listOfProducts = myAccountPage.searchProduct(productName).getListOfProducts(productName);
        assertEquals(listOfProducts, true);

    }
}