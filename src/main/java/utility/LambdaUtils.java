package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class LambdaUtils {
    private static final String HUB_URL = "https://hub.lambdatest.com/wd/hub";
    private static  ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    private static ThreadLocal<DesiredCapabilities> capabilitiesThreadLocal = new ThreadLocal<>();

    public static WebDriver initializeLambdaTestSession (String testname, String browser) throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browser);
        capabilities.setCapability("browserVersion", "127");
        Map<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("user", "dineshelango23");
        ltOptions.put("accessKey", "LT_urLsbXKFtviPo6WOLHPjB5Ey5ZDV4dGYVLTSySSnow9PQuX");
        ltOptions.put("build", "Selenium 4");
        ltOptions.put("name", testname);
        ltOptions.put("platformName", "Windows 10");
        ltOptions.put("seCdp", true);
        ltOptions.put("selenium_version", "4.23.0");
        capabilities.setCapability("LT:Options", ltOptions);
        capabilitiesThreadLocal.set(capabilities);
WebDriver driver = new RemoteWebDriver(new URL(HUB_URL), capabilitiesThreadLocal.get());
        driverThreadLocal.set(driver);

        return driverThreadLocal.get();
    }


    public static void quitDriver() {
        if (driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();
        }
    }
}
