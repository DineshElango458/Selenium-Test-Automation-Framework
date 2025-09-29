package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pojo.AddressPojo;
import utility.BaseUtils;

public class AddressPage  extends BaseUtils{
    private static final By COMPANY_TEXT_BOX_LOCATOR = By.id("company");
    private static final By ADDRESS1_TEXT_BOX_LOCATOR = By.id("address1");
    private static final By ADDRESS2_TEXT_BOX_LOCATOR = By.id("address2");
    private static final By CITY_TEXT_BOX_LOCATOR = By.id("city");
    private static final By STATE_DROPDOWN_LOCATOR = By.id("id_state");
    private static final By POSTAL_CODE_TEXT_BOX_LOCATOR = By.id("postcode");
    private static final By HOME_PHONE_TEXT_BOX_LOCATOR = By.id("phone");
    private static final By MOBILE_PHONE_TEXT_BOX_LOCATOR = By.id("phone_mobile");
    private static final By OTHER_INFO_LOCATOR = By.id("other");
    private static final By ADDRESS_TITLE_TEXT_BOX_LOCATOR = By.id("alias");
    private static final By SAVE_ADDRESS_LOCATOR = By.id("submitAddress");
    private static final By ADDRESS_HEADER = By.tagName("h3");

    protected AddressPage(WebDriver driver) {
        super(driver);
    }

    public String saveAddress (AddressPojo addressPojo) {
        enterText(addressPojo.getCompany(), COMPANY_TEXT_BOX_LOCATOR);
        enterText(addressPojo.getAddress1(), ADDRESS1_TEXT_BOX_LOCATOR);
        enterText(addressPojo.getAddress2(), ADDRESS2_TEXT_BOX_LOCATOR);
        enterText(addressPojo.getCity(), CITY_TEXT_BOX_LOCATOR);
        enterText(addressPojo.getPostalCode(),POSTAL_CODE_TEXT_BOX_LOCATOR);
        enterText(addressPojo.getHomePhone(), HOME_PHONE_TEXT_BOX_LOCATOR);
        enterText(addressPojo.getMobilePhone(), MOBILE_PHONE_TEXT_BOX_LOCATOR);
        enterText(addressPojo.getOtherInfo(), OTHER_INFO_LOCATOR);
        clearText(ADDRESS_TITLE_TEXT_BOX_LOCATOR);
        enterText(addressPojo.getAddressalias(), ADDRESS_TITLE_TEXT_BOX_LOCATOR);
        selectFromDropdown(STATE_DROPDOWN_LOCATOR, "California");
        click(SAVE_ADDRESS_LOCATOR);
        String text = getText(ADDRESS_HEADER);
        return text;
    }
}
