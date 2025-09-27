package utility;

import constant.Browsers;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseUtils {
    private static  ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public WebDriver getDriver() {
        return driver.get();
    }


    protected BaseUtils(WebDriver driver) {
        this.driver.set(driver);

    }

    public static WebDriver setBrowser(Browsers browser) {
        if (browser != null && browser == Browsers.CHROME) {
            return new ChromeDriver();
        } else if (browser == Browsers.FIREFOX) {
            return new FirefoxDriver();
        } else if (browser != null && browser == Browsers.EDGE) {
            return new EdgeDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }
    public static WebDriver setBrowser(Browsers browser, boolean isheadless) {
        if (browser == Browsers.CHROME) {
            if (isheadless) {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("-window-size=1920,1080");
                driver.set(new ChromeDriver(chromeOptions));
            } else {
                driver.set(new ChromeDriver());
            }
        } else if (browser == Browsers.FIREFOX) {
            if (isheadless) {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless");
                firefoxOptions.addArguments("-window-size=1920,1080");
                driver.set(new FirefoxDriver(firefoxOptions));
            } else {
                driver.set(new FirefoxDriver());
            }
        } else if (browser == Browsers.EDGE) {
            if (isheadless) {
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--headless");
                edgeOptions.addArguments("-window-size=1920,1080");
                driver.set(new EdgeDriver(edgeOptions));
            } else {
                driver.set(new EdgeDriver());
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
        String relativePath = "/ScreenShot/"+ name + " - " + format + ".png";
        String absolutePath = System.getProperty("user.dir") + relativePath;
        File f = new File(absolutePath);
        try {
            FileUtils.copyFile(screenshotAs, f);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return relativePath;
    }
}

