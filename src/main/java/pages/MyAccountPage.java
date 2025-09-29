package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.BaseUtils;

public class MyAccountPage extends BaseUtils {

    private static final By TEXT_NAME = By.xpath("//a[@class='account']/span");
    private static final By SEARCH_ITEM = By.id("search_query_top");
    private static final By SEARCH_BUTTON = By.name("submit_search");
    private static final By ADD_NEW_ADDRESS_LINK = By.xpath("//a[@title='Add my first address']");

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public String  validateTextName() {
        return getText(TEXT_NAME);
    }

    public SearchProductPage searchProduct(String productName) {
        enterText(productName, SEARCH_ITEM);
        click(SEARCH_BUTTON);
        return new SearchProductPage(getDriver());
    }

    public AddressPage goToAddressPage() {
        click(ADD_NEW_ADDRESS_LINK);
        return new AddressPage(getDriver());
    }
}
