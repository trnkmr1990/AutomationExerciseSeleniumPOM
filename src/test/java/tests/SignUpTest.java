package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.SignUpPage;

public class SignUpTest extends BaseTest{
  @Test
  public void verifyNewUserSignup() {
	  
	  HomePage homepage = new HomePage(driver);
	  Assert.assertTrue(homepage.isHomePageLoaded());
	  
	  SignUpPage signup = homepage.clickSignUp();
	  Assert.assertTrue(signup.isSignUpPageLoaded());
	  
	  signup.signUp("Tarun", "tarun" + System.currentTimeMillis() + "@mail.com");
      Assert.assertTrue(signup.isAccountCreated());
	  
  }
}
