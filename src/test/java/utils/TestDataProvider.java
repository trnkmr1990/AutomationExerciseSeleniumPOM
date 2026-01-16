package utils;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
	
	@DataProvider(name ="loginData")
	public Object[][] getLoginData(){
		return new Object[][] {
			 {"testautomation@mail.com", "Test@123", true},   // valid
             {"wronguser@mail.com", "Test@123", false},       // invalid email
             {"testautomation@mail.com", "wrongpass", false}  // invalid password
			
		};
	}

}
