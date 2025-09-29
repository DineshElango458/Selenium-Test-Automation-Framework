package com.ui.test;

import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.testng.Assert.*;

public class InvalidLoginCredTest extends BaseTest {
    private static final String INVALID_EMAIL = "abc@gmail.com";
    private static final String INVALID_PASSWORD = "abc@123";

    @Test(description = "Verifying the users able to login to the application", groups = {"smoke", "e2e"})
    void InvalidLoginTest(Method method) {
        System.out.println("Thread Count" + Thread.currentThread().getName() + method.getName());
        String textName = homePage.clickSignIn().LoginWithInvalidCredentials(INVALID_EMAIL, INVALID_PASSWORD)
                .getErrorMessage();
        assertNotNull(textName);
        assertFalse(textName.isEmpty(), "Error Message is Empty");
        assertEquals(textName, "Authentication failed.");
    }

}
