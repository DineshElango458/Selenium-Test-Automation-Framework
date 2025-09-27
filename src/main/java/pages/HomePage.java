package pages;

import constant.Browsers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.BaseUtils;

public class HomePage extends BaseUtils {

    private static final By SIGN_IN = By.xpath("//div[normalize-space()='Sign in']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage(Browsers browsers, boolean isHeadless) {
        super(BaseUtils.setBrowser(browsers, isHeadless));
    }

    public LoginPage clickSignIn() {
        click(SIGN_IN);
        return new LoginPage(getDriver());
    }
}
