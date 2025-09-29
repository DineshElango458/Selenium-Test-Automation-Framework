package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.BaseUtils;

public class Shippingpage extends BaseUtils {
    private static final By TERMS_OF_SERVICE_CHECKBOX = By.id("uniform-cgv");
    private static final By PROCEED_TO_CHECKOUT_SHIPPING_BUTTON = By.name("processCarrier");

    protected Shippingpage(WebDriver driver) {
        super(driver);
    }

    public PaymentPage agreeToTermsAndProceedToCheckout() {
        clickOn(TERMS_OF_SERVICE_CHECKBOX);
        clickOn(PROCEED_TO_CHECKOUT_SHIPPING_BUTTON);
        return new PaymentPage(getDriver());
    }
}
