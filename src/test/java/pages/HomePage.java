package pages;

import org.openqa.selenium.*;
import utils.WaitUtil;

public class HomePage {

    private WebDriver driver;
    private WaitUtil wait;

    private By signUpLoginBtn = By.cssSelector("a[href='/login']");
    private By productsBtn = By.cssSelector("a[href='/products']");
    private By homeSlider = By.id("slider-carousel");

    public HomePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WaitUtil(driver);
    }

    public boolean isHomePageLoaded(){
        return wait.waitForElementVisible(homeSlider).isDisplayed();
    }

    public LoginPage clickSignUpLogin(){
        wait.waitForElementClickable(signUpLoginBtn).click();
        return new LoginPage(driver);
    }

    public ProductsPage clickProducts(){
        wait.waitForElementClickable(productsBtn).click();
        return new ProductsPage(driver);
    }
    
    public SignUpPage clickSignUp() {
    	wait.waitForElementClickable(signUpLoginBtn).click();
    	return new SignUpPage(driver);
    }
}
