package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest{
	
	@Test(groups={"login"}, dataProvider = "loginData", dataProviderClass = utils.TestDataProvider.class)
  
	public void verifyLoginWithMultipleUsers(String email, String password, boolean expectedResult) {
	  HomePage homePage = new HomePage(driver);
	  Assert.assertTrue(homePage.isHomePageLoaded());
	  
	  LoginPage loginPage = homePage.clickSignUpLogin();
	  Assert.assertTrue(loginPage.isLoginPageLoaded());
	  
	  loginPage.login(email, password);
	  boolean result;

	  if(expectedResult){
	      result = loginPage.isUserLoggedIn();
	  } else {
	       result = loginPage.isLoginErrorVisible();
	  }

	  Assert.assertTrue(result);
	  
  }
}
