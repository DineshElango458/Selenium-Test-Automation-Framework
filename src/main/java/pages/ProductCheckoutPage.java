package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.BaseUtils;

public class ProductCheckoutPage extends BaseUtils {
private static final By SIZE_DROPDOWN_LOCATOR = By.xpath("//select[@id='group_1']");
private static final By SELECT_COLOUR_PRODUCT_LOCATOR = By.xpath("//ul/li/a[@name='Blue']");
private static final By ADD_TO_CART_BUTTON_LOCATOR = By.name("Submit");
private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By.xpath("//a[@title='Proceed to checkout']");


    protected ProductCheckoutPage(WebDriver driver) {
        super(driver);
    }

    public ProductCheckoutPage selectingProductSizeAndColour() {
        selectFromDropdown(SIZE_DROPDOWN_LOCATOR, "L");
        click(SELECT_COLOUR_PRODUCT_LOCATOR);
        return new ProductCheckoutPage(getDriver());
    }

    public ProductCheckoutPage addingProductToCart() {
        clickOn(ADD_TO_CART_BUTTON_LOCATOR);
        return new ProductCheckoutPage(getDriver());
    }
    public CartSummaryPage proceedToCheckout () {
        clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
        return new CartSummaryPage(getDriver());
    }
}
