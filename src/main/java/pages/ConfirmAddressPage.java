package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.BaseUtils;

public class ConfirmAddressPage  extends BaseUtils {
private static final By PROCEED_TO_CHECKOUT_ADDRESS_BUTTON = By.xpath("//button[@type='submit' and @name='processAddress']");

    protected ConfirmAddressPage(WebDriver driver) {
        super(driver);
    }

    public Shippingpage addressProceedToCheckout () {
        clickOn(PROCEED_TO_CHECKOUT_ADDRESS_BUTTON);
       return new Shippingpage(getDriver());
    }


}
