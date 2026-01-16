package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.Config;

import java.time.Duration;

public class DriverFactory {

    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public static void initDriver(String browser) {
        //String browser = Config.get("browser");

        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver());
        } else if(browser.equalsIgnoreCase("fireFox")){
        	WebDriverManager.firefoxdriver().setup();
        	tlDriver.set(new FirefoxDriver());
        } else if(browser.equalsIgnoreCase("edge")) {
        	WebDriverManager.edgedriver().setup();
        	tlDriver.set(new EdgeDriver());
        } else {
            throw new RuntimeException("Browser not supported: " + browser);
        }

        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
    }

    public static WebDriver getDriver(){
        return tlDriver.get();
    }

    public static void quitDriver(){
        getDriver().quit();
        tlDriver.remove();
    }
}
