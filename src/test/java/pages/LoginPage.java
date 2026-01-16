package pages;

import org.openqa.selenium.*;
import utils.WaitUtil;

public class LoginPage {

    private WebDriver driver;
    private WaitUtil wait;
    //locators
    private By loginHeader = By.xpath("//h2[contains(text(),'Login to your account')]");
    private By emailInput = By.cssSelector("input[data-qa='login-email']");
    private By passwordInput = By.cssSelector("input[data-qa='login-password']");
    private By loginButton = By.cssSelector("button[data-qa='login-button']");
    private By loggedInText = By.xpath("//*[contains(text(),'Logged in as')]");
    private By errorMessage = By.xpath("//p[contains(text(),'Your email or password is incorrect!')]");
    //constructor
    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WaitUtil(driver);
    }

    public boolean isLoginPageLoaded(){
        return wait.waitForElementVisible(loginHeader).isDisplayed();
    }

    public void login(String email, String password){
        wait.waitForElementVisible(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public boolean isUserLoggedIn(){
        return wait.waitForElementVisible(loggedInText).isDisplayed();
    }
    
    public boolean isLoginErrorVisible() {
        try {
            return wait.waitForElementVisible(errorMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}
