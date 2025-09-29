package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.BaseUtils;

public class PaymentPage extends BaseUtils {

private static final By PAY_BY_BANK_WIRE_OPTION = By.xpath("//a[@title='Pay by bank wire']");
private static final By CONFIRM_ORDER_BUTTON = By.xpath("//p[@id='cart_navigation']/button/span");
private static final By ORDER_CONFIRMATION_TEXT = By.xpath("//p[@class='alert alert-success']");
    protected PaymentPage(WebDriver driver) {
        super(driver);
    }

    public String selectPayByBankWire() {
        clickOn(PAY_BY_BANK_WIRE_OPTION);
        clickOn(CONFIRM_ORDER_BUTTON);
        return getText(ORDER_CONFIRMATION_TEXT);
    }
}
