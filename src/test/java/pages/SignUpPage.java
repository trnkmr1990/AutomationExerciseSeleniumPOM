package pages;

import org.openqa.selenium.*;
import utils.WaitUtil;

public class SignUpPage {

    private WebDriver driver;
    private WaitUtil wait;

    private By signupHeader = By.xpath("//h2[contains(text(),'New User Signup!')]");
    private By nameInput = By.name("name");
    private By emailInput = By.cssSelector("input[data-qa='signup-email']");
    private By signupButton = By.cssSelector("button[data-qa='signup-button']");
    private By accountCreatedText = By.xpath("//h2[contains(text(),'Account Created!')]");

    public SignUpPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WaitUtil(driver);
    }

    public boolean isSignUpPageLoaded(){
        return wait.waitForElementVisible(signupHeader).isDisplayed();
    }

    public void signUp(String name , String email) {
    	wait.waitForElementVisible(nameInput);
    	driver.findElement(nameInput).sendKeys(name);
    	driver.findElement(emailInput).sendKeys(email);
    	driver.findElement(signupButton).click();
    }
    
    public boolean isAccountCreated() {
    	 return wait.waitForElementVisible(accountCreatedText).isDisplayed();
    }
}
