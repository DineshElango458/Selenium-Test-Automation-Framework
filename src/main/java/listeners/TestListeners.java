package listeners;

import com.aventstack.extentreports.Status;
import io.reactivex.rxjava3.observers.BaseTestConsumer;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utility.BaseUtils;
import utility.ExtentReporterUtility;
import utility.LoggerUtils;

import java.util.Arrays;

public class TestListeners  implements ITestListener {
         Logger logger = LoggerUtils.getLogger(this.getClass());

    public void onTestStart(ITestResult result) {
        logger.info(result.getMethod().getMethodName());
        logger.info(result.getMethod().getDescription());
        logger.info(Arrays.toString(result.getMethod().getGroups()));
        ExtentReporterUtility.createExtentTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        logger.info(result.getMethod().getMethodName() + "PASSED");
        logger.info(result.getMethod().getDescription());
        ExtentReporterUtility.getTest().log(Status.PASS,result.getMethod().getMethodName() + "PASSED");
    }

    public void onTestFailure(ITestResult result) {
        logger.error(result.getMethod().getMethodName() + "FAILED");
        logger.error(result.getThrowable().getMessage());
        ExtentReporterUtility.getTest().log(Status.FAIL,result.getMethod().getMethodName() + "FAILED");
        ExtentReporterUtility.getTest().log(Status.FAIL, result.getThrowable().getMessage());

       /* Object testInstance = result.getInstance();
        if (testInstance instanceof BaseTest) {
            BaseTest baseTest = (BaseTest) testInstance;
            BaseUtils baseUtils = baseTest.getHomePage(); // HomePage extends BaseUtils
            String screenshotPath = baseUtils.takesScreenshot(result.getMethod().getMethodName());
            ExtentReporterUtility.getTest().addScreenCaptureFromPath(screenshotPath);
        }*/

        Object testInstance = result.getInstance();
        try {
            java.lang.reflect.Method method = testInstance.getClass().getMethod("getHomePage");
            Object pageObj = method.invoke(testInstance);
            if (pageObj instanceof BaseUtils) {
                BaseUtils baseUtils = (BaseUtils) pageObj;
                String screenshotPath = baseUtils.takesScreenshot(result.getMethod().getMethodName());
                ExtentReporterUtility.getTest().addScreenCaptureFromPath(screenshotPath);
            }
        } catch (Exception e) {
            // handle exception or log
        }
    }

    public void onTestSkipped(ITestResult result) {
        logger.warn(result.getMethod().getMethodName() + "SKIPPED");
        ExtentReporterUtility.getTest().log(Status.SKIP,result.getMethod().getMethodName() + "SKIPPED");
    }

    public void onStart(ITestContext context) {
        logger.info("Test Suite Started");
        ExtentReporterUtility.setUpSparkReporter();
    }

    public void onFinish(ITestContext context) {
        logger.info("Test Suite Completed");
        ExtentReporterUtility.flushReport();
    }
}
