package com.ui.test;

import constant.Browsers;
import dataprovider.LoginDataProvider;
import listeners.MyRetryAnalyser;
import listeners.TestListeners;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pojo.User;
import utility.JSONUtils;

import java.lang.reflect.Method;

import static org.testng.Assert.*;
@Listeners(TestListeners.class)
public class LoginTest extends BaseTest {


    @Test(description = "Verifying the users able to login to the application", groups = {"smoke", "e2e"},
            dataProviderClass = LoginDataProvider.class, dataProvider = "logindata")
    void loginTest(User user, Method method) {
        System.out.println("Thread Count" + Thread.currentThread().getName() + method.getName());
        String textName = homePage.clickSignIn().loginToApp(user.getEmail(), user.getPassword())
                .validateTextName();
        assertNotNull(textName);
        assertFalse(textName.isEmpty(), "User TextName is Empty");
        assertEquals(textName, "Dinesh D");
    }

    @Test(enabled = false, description = "Verifying the users able to login to the application", groups = {"smoke", "e2e"},
            dataProviderClass = LoginDataProvider.class, dataProvider = "LoginDataUsingCSV")
    void loginTestUsingCSV(User user, Method method) {
        System.out.println("Thread Count" + Thread.currentThread().getName() + method.getName());
        String textName = homePage.clickSignIn().loginToApp(user.getEmail(), user.getPassword())
                .validateTextName();
        assertNotNull(textName);
        assertFalse(textName.isEmpty(), "User TextName is Empty");
        assertEquals(textName, "Dinesh D");
    }

    @Test(enabled = false, description = "Verifying the users able to login to the application", groups = {"smoke", "e2e"},
            dataProviderClass = LoginDataProvider.class, dataProvider = "LoginDataUsingExcel",retryAnalyzer = MyRetryAnalyser.class)
    void loginTestUsingExcelReader(User user, Method method) {
        System.out.println("Thread Count" + Thread.currentThread().getName() + method.getName());
        String textName = homePage.clickSignIn().loginToApp(user.getEmail(), user.getPassword())
                .validateTextName();
        assertNotNull(textName);
        assertFalse(textName.isEmpty(), "User TextName is Empty");
        assertEquals(textName, "Dinesh D");
    }
}