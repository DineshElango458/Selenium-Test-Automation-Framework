package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.BaseUtils;

public class MyAccountPage extends BaseUtils {

    private static final By TEXT_NAME = By.xpath("//a[@class='account']/span");
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public String  validateTextName() {
        return getText(TEXT_NAME);
    }

}
