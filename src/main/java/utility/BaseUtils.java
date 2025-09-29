package utility;

import constant.Browsers;
import org.apache.commons.io.FileUtils;
import org.awaitility.Awaitility;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseUtils {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    static WebDriverWait webDriverWait;

    public WebDriver getDriver() {
        return driver.get();
    }


    protected BaseUtils(WebDriver driver) {
        this.driver.set(driver);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public  static WebDriver setBrowser(Browsers browser, boolean isheadless) {
        if (browser == Browsers.CHROME) {
            if (isheadless) {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("-window-size=1920,1080");
                driver.set(new ChromeDriver(chromeOptions));
                webDriverWait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
            } else {
                driver.set(new ChromeDriver());
                webDriverWait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
            }
        } else if (browser == Browsers.FIREFOX) {
            if (isheadless) {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless");
                firefoxOptions.addArguments("-window-size=1920,1080");
                driver.set(new FirefoxDriver(firefoxOptions));
                webDriverWait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
            } else {
                driver.set(new FirefoxDriver());
                webDriverWait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
            }
        } else if (browser == Browsers.EDGE) {
            if (isheadless) {
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--headless");
                edgeOptions.addArguments("-window-size=1920,1080");
                driver.set(new EdgeDriver(edgeOptions));
                webDriverWait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
            } else {
                driver.set(new EdgeDriver());
                webDriverWait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
            }
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
        return driver.get();
    }


    public void goToWebsite(String url) {
        driver.get().get(url);
    }

    public void enterText(String text, By xpath) {
        WebElement element = driver.get().findElement(xpath);
        element.sendKeys(text);
    }

    public void click(By xpath) {
        WebElement element = driver.get().findElement(xpath);
        element.click();
    }

    public void clickOn(By xpath) {
        WebElement webElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        webElement.click();
    }

    public String getText(By xpath) {
        return driver.get().findElement(xpath).getText();
    }

    public void quitBrowser() {
        driver.get().quit();
    }

    public String takesScreenshot(String name) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver.get();
        File screenshotAs = takesScreenshot.getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH-mm-ss");
        String format = formatter.format(date);
        String relativePath = "./ScreenShot/" + name + " - " + format + ".png";
        String absolutePath = System.getProperty("user.dir") + relativePath;
        File f = new File(relativePath);
        try {
            FileUtils.copyFile(screenshotAs, f);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return relativePath;
    }

    public String getVisibleText(WebElement element) {
        return element.getText();
    }

    public List<String> getListOfElements(By xpath) {
        List<WebElement> elements = driver.get().findElements(xpath);
        List<String> visibleTextList = new ArrayList<>();
        for (WebElement ele : elements) {
            System.out.println(getVisibleText(ele));
            visibleTextList.add(getVisibleText(ele));
        }
        return visibleTextList;
    }

    public void selectFromDropdown(By dropdownLocator, String dropdownValue) {
        WebElement dropdown = driver.get().findElement(dropdownLocator);
        Select select = new Select(dropdown);
        select.selectByVisibleText(dropdownValue);
    }

    public void clearText(By xpath) {
        WebElement element = driver.get().findElement(xpath);
        element.clear();
    }

    public void awaitTillElementIsVisible(By xpath) {
        Awaitility
                .await()
                .pollInterval(2, TimeUnit.SECONDS)
                .atMost(10, TimeUnit.SECONDS)
                .until(() -> driver.get().findElement(xpath).isDisplayed());
    }
}

