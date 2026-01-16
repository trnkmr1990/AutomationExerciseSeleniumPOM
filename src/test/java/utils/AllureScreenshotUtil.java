package utils;

import factory.DriverFactory;
import io.qameta.allure.Attachment;
import org.openqa.selenium.*;

public class AllureScreenshotUtil {

    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] captureScreenshot() {
        WebDriver driver = DriverFactory.getDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
