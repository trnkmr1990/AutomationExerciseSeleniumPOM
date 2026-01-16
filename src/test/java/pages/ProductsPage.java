package pages;

import org.openqa.selenium.*;
import utils.WaitUtil;

public class ProductsPage {

    private WebDriver driver;
    private WaitUtil wait;

    private By productsHeader = By.xpath("//h2[contains(text(),'All Products')]");
    private By searchInput = By.id("search_product");
    private By searchBtn = By.id("submit_search");
    private By searchedHeader = By.xpath("//h2[contains(text(),'Searched Products')]");

    public ProductsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WaitUtil(driver);
    }

    public boolean isProductsPageLoaded(){
        return wait.waitForElementVisible(productsHeader).isDisplayed();
    }

    public void searchProduct(String product){
        wait.waitForElementVisible(searchInput).sendKeys(product);
        driver.findElement(searchBtn).click();
    }

    public boolean isSearchResultDisplayed(){
        return wait.waitForElementVisible(searchedHeader).isDisplayed();
    }
}
