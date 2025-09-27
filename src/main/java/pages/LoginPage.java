package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.BaseUtils;

public class LoginPage extends BaseUtils {

    private static final By LOGIN_SIGN_IN = By.xpath("//span[normalize-space()='Sign in']");
    private static final By USERNAME = By.xpath("//input[@id='email']");
    private static final By PASSWORD =  By.xpath("//input[@id='passwd']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MyAccountPage loginToApp(String email, String password) {
        enterText(email, USERNAME);
        enterText(password, PASSWORD);
        click(LOGIN_SIGN_IN);
        return new MyAccountPage(getDriver());
    }
}
