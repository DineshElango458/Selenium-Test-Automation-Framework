package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import utility.JSONUtils;

public class MyRetryAnalyser implements IRetryAnalyzer {
    private static final int MAX_ATTEMPT = Integer.parseInt(JSONUtils.readJSON().getMAX_ATTEMPT());
    private int CURRENT_ATTEMPT = Integer.parseInt(JSONUtils.readJSON().getCURRENT_ATTEMPT());

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (CURRENT_ATTEMPT <= MAX_ATTEMPT) {
            CURRENT_ATTEMPT++;
            return true;
        }
        return false;
    }
}
