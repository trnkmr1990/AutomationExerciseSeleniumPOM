package utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.TakesScreenshot;
import factory.DriverFactory;

public class ScreenshotUtil {

	
	public static String captureScreenshot(String testName) {
		try {
			WebDriver driver = DriverFactory.getDriver();
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String path = "test-output/screenshots/"+ testName+".png";
			FileUtils.copyFile(src, new File(path));
			return path;
		}catch(Exception e) {
			return null;
		}
	}
}
