package com.ui.test;

import constant.Browsers;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.HomePage;
import utility.JSONUtils;
import utility.LambdaUtils;

import java.net.MalformedURLException;

public class BaseTest {
    HomePage homePage;
    private boolean isLambdaTest;
    private boolean isHeadless;

    @Parameters({"isLambdaTest", "isHeadless", "browser"})
    @BeforeMethod(description = "Launching Browser and application")
    void setUp(
            @Optional("false") boolean isLambdaTest,
            @Optional("false") boolean isHeadless,
            @Optional("firefox") String browser, ITestResult result) throws MalformedURLException {

        this.isLambdaTest = isLambdaTest;
        this.isHeadless = isHeadless;
        if (isLambdaTest) {
            WebDriver lambdadriver;
            lambdadriver = LambdaUtils.initializeLambdaTestSession(result.getMethod().getMethodName(), browser);
            homePage = new HomePage(lambdadriver);
            homePage.goToWebsite(JSONUtils.readJSON().getUrl());
        } else {
            homePage = new HomePage(Browsers.valueOf(browser.toUpperCase()), isHeadless);
            homePage.goToWebsite(JSONUtils.readJSON().getUrl());
        }
    }

    public HomePage getHomePage() {
        return homePage;
    }

    @AfterMethod(description = "Closing the browser")
    public void quitDriver() {
        if (isLambdaTest) {
            LambdaUtils.quitDriver(); //quit lambda driver
        } else {
            homePage.quitBrowser(); // quit local driver
        }
    }
}
