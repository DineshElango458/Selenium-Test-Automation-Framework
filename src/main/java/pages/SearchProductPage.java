package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.BaseUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class SearchProductPage extends BaseUtils {
    private static final By PRODUCT_NAME = By.xpath("//span[@class='lighter']");
    private static final By LIST_OF_PRODUCTS = By.xpath("//h5[@itemprop='name']/a");
    private static final By CLICK_FIRST_PRODUCT = By.xpath("(//a[@title='View']/span)[1]");
   // private static final String SEARCH_ITEM = "PRINTED SUMMER DRESS";


    protected SearchProductPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return getText(PRODUCT_NAME);
    }

    public boolean getListOfProducts(String searchItem) {
        List<String> keywordlist = Arrays.asList(searchItem.toLowerCase().split(" "));
        List<String> listOfElements = getListOfElements(LIST_OF_PRODUCTS);
        boolean result = listOfElements.stream()
                .anyMatch(name -> (keywordlist.stream().anyMatch(name.toLowerCase()::contains)));
        return result;
    }

    public ProductCheckoutPage clickFirstProduct() {
        clickOn(CLICK_FIRST_PRODUCT);
        return new ProductCheckoutPage(getDriver());
    }
}
