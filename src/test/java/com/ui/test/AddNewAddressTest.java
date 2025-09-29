package com.ui.test;

import com.github.javafaker.Faker;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddressPage;
import pages.MyAccountPage;
import pojo.AddressPojo;
import utility.FakerUtils;

import static org.testng.Assert.assertEquals;

public class AddNewAddressTest extends BaseTest {
MyAccountPage   myAccountPage;
AddressPage addressPage;
    AddressPojo addressPojo;

    @BeforeMethod
    private void setUpSearch() {
        myAccountPage = homePage.clickSignIn().loginToApp("sogole8183@cspaus.com", "password");
        addressPojo = FakerUtils.generateFakerData();

    }

    @Test(description = "Verifying user can able to add new address in the application", groups = {"smoke", "e2e"})
    private void addNewAddress() {
        String s = myAccountPage.goToAddressPage().saveAddress(addressPojo);
        assertEquals(s, addressPojo.getAddressalias().toUpperCase());
    }
}
