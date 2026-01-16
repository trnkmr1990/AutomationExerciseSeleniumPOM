package utils;

import com.aventstack.extentreports.*;
import org.testng.*;

public class TestListener implements ITestListener {

    private ExtentReports extent = ExtentManager.getExtentReport();
    private ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().fail(result.getThrowable());

        String screenshotPath = ScreenshotUtil.captureScreenshot(result.getName());
        extentTest.get().addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
