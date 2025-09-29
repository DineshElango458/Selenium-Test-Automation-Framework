package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.BaseUtils;

public class CartSummaryPage extends BaseUtils {
private static final By CART_SUMMARY_PROCEED_TO_CHECKOUT_BUTTON = By.xpath("//p[@class='cart_navigation clearfix']/a[@title='Proceed to checkout']");

    protected CartSummaryPage(WebDriver driver) {
        super(driver);
    }

    public ConfirmAddressPage summaryProceedToCheckout () {
        clickOn(CART_SUMMARY_PROCEED_TO_CHECKOUT_BUTTON);
        return new ConfirmAddressPage(getDriver());
    }
}
