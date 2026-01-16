package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureTestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        AllureScreenshotUtil.captureScreenshot();
    }
}
