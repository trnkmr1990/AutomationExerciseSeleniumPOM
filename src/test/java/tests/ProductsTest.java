package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class ProductsTest extends BaseTest {

    @Test
    public void verifyProductSearch(){

        HomePage home = new HomePage(driver);
        Assert.assertTrue(home.isHomePageLoaded());

        ProductsPage products = home.clickProducts();
        Assert.assertTrue(products.isProductsPageLoaded());

        products.searchProduct("Top");
        Assert.assertTrue(products.isSearchResultDisplayed());
    }
}
