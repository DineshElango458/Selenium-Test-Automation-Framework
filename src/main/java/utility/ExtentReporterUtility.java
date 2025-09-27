package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterUtility {
private static ExtentReports extentReports;
private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public static void setUpSparkReporter() {
        ExtentSparkReporter extentSparkReporter = new
                ExtentSparkReporter(System.getProperty("user.dir") + "/report.html");
        extentReports = new ExtentReports();
extentReports.attachReporter(extentSparkReporter);
    }

    public static void createExtentTest(String Testname) {
        ExtentTest test = extentReports.createTest(Testname);
        extentTest.set(test);
    }

    public static ExtentTest getTest() {
        return extentTest.get();
    }

    public static void flushReport() {
        extentReports.flush();
    }
}

