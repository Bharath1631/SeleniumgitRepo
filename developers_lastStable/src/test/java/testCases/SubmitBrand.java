/*
	 * @Author : Anil kumar
	 * Module : Submit Brand Test Cases
	 * Date   : Feb 21st 2023
	 */
package testCases;

import java.io.IOException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import resources.Base;

public class SubmitBrand extends Base {
	
	
	@Parameters("value")
	@BeforeTest
	public void invokeBrowser(String value) throws IOException {
		
		driver =  driverInitialize(value);
		driver.get(readProperties("BaseURL"));
		LoginPage login = new LoginPage(driver);
		login.loginApplication(readProperties("CreateNewBotEmail"), readProperties("CreateNewBotPassword"));
	}
	
	@Test
	public void clickOnViewDetails() {
		
		
	}
	
	
}
