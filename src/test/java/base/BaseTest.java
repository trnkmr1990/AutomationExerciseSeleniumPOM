package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import factory.DriverFactory;
import utils.Config;

public class BaseTest {
	
	protected WebDriver driver;
	
	@BeforeMethod
	@Parameters("browser")
	public void setup(@Optional String browser) {
		// If browser passed from testng.xml use it
        // Else read from config.properties
        String browserName = (browser != null) ? browser : Config.get("browser");

		DriverFactory.initDriver(browserName);
		driver = DriverFactory.getDriver();
		driver.get(Config.get("baseUrl"));
	}
	
	@AfterMethod
    public void tearDown(){
        DriverFactory.quitDriver();
    }

	
}
