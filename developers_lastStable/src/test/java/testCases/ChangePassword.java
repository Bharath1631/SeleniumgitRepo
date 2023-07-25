/*
	 * @Author : Anil kumar
	 * Module : ChangePassword Testcases
	 * Date   : Nov 9th 2022
	 */
package testCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObjects.ChangePasswordPage;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import resources.Base;
import resources.Log;

public class ChangePassword extends Base {
	
	
	@Parameters("value")
	@BeforeTest
	public void invokeBrowser(String value) throws IOException {
		
		driver =  driverInitialize(value);
		driver.get(readProperties("BaseURL"));
		LoginPage login = new LoginPage(driver);
		login.loginApplication(readProperties("oldEmail"), readProperties("oldPassword"));
	}

	@Test(priority=-1)
	public void changePasswordPageRedirect() throws IOException {
		
	
		DashboardPage dashboard = new DashboardPage(driver);
		dashboard.dropdown().click();
		Log.info("Clicked on DropDown");
		dashboard.changePassword().click();
		Log.info("Clicked on ChangePassword");
		Assert.assertEquals(driver.getCurrentUrl(), readProperties("ChangePasswordPage"));
		Log.info("------Successfully Redirected to ChangePassword Page-------");
		Listeners.test.log(Status.INFO,"--------Successfully Redirected to ChangePassword Page-------");
		
	

	}
	
	@Test
	public void enterDetailsAndclickCancel() throws IOException {
		
		driver.get(readProperties("DashboardURL"));
		changePasswordPageRedirect();
		ChangePasswordPage changepwd = new ChangePasswordPage(driver);
		changepwd.oldPassword().sendKeys(readProperties("oldPassword"));
		Log.info("Entered OldPassword");
		changepwd.newPassword().sendKeys(readProperties("newPasswordChange"));
		Log.info("Entered New Password");
		changepwd.confirmPassword().sendKeys(readProperties("confirmPasswordChange"));
		Log.info("Entered Confirm New password");
		changepwd.cancel().click();
		Assert.assertEquals(driver.getCurrentUrl(), readProperties("DashboardURL"));
		Log.info("------Successfully Canceled and Redirected to the Dashboard Page----------");
		Listeners.test.log(Status.INFO,"-----Successfully Canceled and Redirected to the Dashboard Page----------");
		
	}
	
	@Test
	public void clickSubmitWithoutDetails() throws IOException {
		
		driver.get(readProperties("DashboardURL"));
		changePasswordPageRedirect();
		ChangePasswordPage changepwd = new ChangePasswordPage(driver);
		changepwd.confirmSetPassword().click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(changepwd.fieldErrorMessage()));
		Assert.assertEquals(changepwd.fieldErrorMessage().getText(),"Field cannot be empty");
		Log.info("------SUccessfully Error message Displayed as "+changepwd.fieldErrorMessage().getText() +"---------");
		Listeners.test.log(Status.INFO,"------SUccessfully Error message Displayed as "+changepwd.fieldErrorMessage().getText() +"----------");
	}
	
	@Test
	public void enterOnlyOldPasswordAndSubmit() throws IOException {
		
		driver.get(readProperties("DashboardURL"));
		changePasswordPageRedirect();
		ChangePasswordPage changepwd = new ChangePasswordPage(driver);
		changepwd.oldPassword().sendKeys(readProperties("oldPassword"));
		Log.info("Entered OldPassword");
		changepwd.confirmSetPassword().click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(changepwd.fieldErrorMessage()));
		Assert.assertEquals(changepwd.fieldErrorMessage().getText(),"Field cannot be empty");
		Log.info("------SUccessfully Error message Displayed as "+changepwd.fieldErrorMessage().getText() +"---------");
		Listeners.test.log(Status.INFO,"------SUccessfully Error message Displayed as "+changepwd.fieldErrorMessage().getText() +"----------");
	}
	
	@Test
	public void enterWrongOldPasswordAndSubmit() throws IOException {
		
		driver.get(readProperties("DashboardURL"));
		changePasswordPageRedirect();
		ChangePasswordPage changepwd = new ChangePasswordPage(driver);
		changepwd.oldPassword().sendKeys(readProperties("wrongOldPassword"));
		Log.info("Entered Wrong OldPassword");
		changepwd.newPassword().sendKeys(readProperties("newPasswordChange"));
		Log.info("Entered valid New Password");
		changepwd.confirmPassword().sendKeys(readProperties("newPasswordChange"));
		Log.info("Entered valid Confirm New password");
		changepwd.confirmSetPassword().click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(changepwd.mainErrorMessage()));
		Assert.assertEquals(changepwd.mainErrorMessage().getText(),"old password entered is incorrect");
		Log.info("------SUccessfully Error message Displayed as "+changepwd.mainErrorMessage().getText() +"---------");
		Listeners.test.log(Status.INFO,"------SUccessfully Error message Displayed as "+changepwd.mainErrorMessage().getText() +"----------");
	}
	
	@Test
	public void CheckProfileIsClickable() throws IOException {
		
		driver.get(readProperties("DashboardURL"));
		changePasswordPageRedirect();
		ChangePasswordPage changepwd = new ChangePasswordPage(driver);
		Assert.assertTrue(changepwd.profilePicture().isDisplayed());
	    Assert.assertTrue(changepwd.FirstAndLastName().isDisplayed());
		Assert.assertTrue(changepwd.emailID().isDisplayed());
		Assert.assertTrue(changepwd.countryName().isDisplayed());
		Log.info("------Profile Picture, First and Last Name, EmailID, country is Displayed and not able to click--------");
	}
	
	
	@Test
	public void enterInvalidPassword() throws IOException, InterruptedException {
		
		driver.get(readProperties("DashboardURL"));
		changePasswordPageRedirect();
		ChangePasswordPage changepwd = new ChangePasswordPage(driver);
		changepwd.oldPassword().sendKeys(readProperties("oldPassword"));
		Log.info("Entered Valid OldPassword");
		changepwd.newPassword().sendKeys(readProperties("invalidPasswordChange"));
		Log.info("Entered Invalid New Password");
		changepwd.confirmPassword().sendKeys(readProperties("invalidPasswordChange"));
		Log.info("Entered Invalid Confirm New password");
		changepwd.confirmSetPassword().click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(changepwd.fieldErrorMessage()));
		Assert.assertEquals(changepwd.fieldErrorMessage().getText(),"⚠ Password length should be minimum 8 characters and should contain atleast one uppercase alphabet, special character [ . $ @ ! % * ? & # ^ < > ( ) ~ ` + _ - ] and digit");
		Log.info("------SUccessfully Error message Displayed as "+changepwd.fieldErrorMessage().getText() +"---------");
		Listeners.test.log(Status.INFO,"------SUccessfully Error message Displayed as "+changepwd.fieldErrorMessage().getText() +"----------");
	}
	
	@Test
	public void passwordDontMatch() throws IOException, InterruptedException {
		
		driver.get(readProperties("DashboardURL"));
		changePasswordPageRedirect();
		ChangePasswordPage changepwd = new ChangePasswordPage(driver);
		changepwd.oldPassword().sendKeys(readProperties("oldPassword"));
		Log.info("Entered Valid OldPassword");
		changepwd.newPassword().sendKeys(readProperties("newPasswordChange"));
		Log.info("Entered valid New Password");
		changepwd.confirmPassword().sendKeys(readProperties("invalidPasswordChange"));
		Log.info("Entered Different Confirm New password");
		changepwd.confirmSetPassword().click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(changepwd.mainErrorMessage()));
		Assert.assertEquals(changepwd.mainErrorMessage().getText(),"New and confirm password don't match");
		Log.info("---------Successfully Password not matched Message displayed----------");
		Listeners.test.log(Status.INFO,"---------Successfully Password not matched Message displayed----------");
		
		
	}
	
	@Test
	public void sameOldAndNewPassword() throws IOException, InterruptedException {
		
		driver.get(readProperties("DashboardURL"));
		changePasswordPageRedirect();
		ChangePasswordPage changepwd = new ChangePasswordPage(driver);
		changepwd.oldPassword().sendKeys(readProperties("oldPassword"));
		Log.info("Entered OldPassword");
		changepwd.newPassword().sendKeys(readProperties("oldPassword"));
		Log.info("Entered New Password");
		changepwd.confirmPassword().sendKeys(readProperties("oldPassword"));
		Log.info("Entered Confirm New password");
		changepwd.confirmSetPassword().click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(changepwd.mainErrorMessage()));
		Assert.assertEquals(changepwd.mainErrorMessage().getText(),"New and Old password cannot be same.");
		Log.info("-----SUccessfully Error Message displayed as "+changepwd.mainErrorMessage().getText()+ "----------");
		Listeners.test.log(Status.INFO,"------SUccessfully Error Message displayed as "+changepwd.mainErrorMessage().getText()+"----------");
	
		
	}
	
	
	@Test(priority=1)
	public void changePassword() throws IOException, InterruptedException {
		
		driver.get(readProperties("DashboardURL"));
		changePasswordPageRedirect();
		ChangePasswordPage changepwd = new ChangePasswordPage(driver);
		changepwd.oldPassword().sendKeys(readProperties("oldPassword"));
		Log.info("Entered OldPassword");
		changepwd.newPassword().sendKeys(readProperties("newPasswordChange"));
		Log.info("Entered New Password");
		changepwd.confirmPassword().sendKeys(readProperties("confirmPasswordChange"));
		Log.info("Entered Confirm New password");
		changepwd.confirmSetPassword().click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(changepwd.passwordUpdatePopup()));
		Assert.assertEquals(changepwd.passwordUpdatePopup().getText(),"Your password is updated successfully.");
		Log.info("--------Sucessfully Password Changed PopUP Displayed--------");
		Listeners.test.log(Status.INFO,"-------Sucessfully Password Changed PopUP Displayed--------");
		
	}
	
	@Test(priority=2)
	public void gotoDashboard() throws IOException {
	
		ChangePasswordPage changepwd = new ChangePasswordPage(driver);
		changepwd.gotoDashboard().click();
		Assert.assertEquals(driver.getCurrentUrl(), readProperties("DashboardURL"));
		Log.info("--------SUcessfully Password Changed and Redirected to Dashboard Page----------");
		Listeners.test.log(Status.INFO,"--------SUcessfully Password Changed and Redirected to Dashboard Page-----------");
		
	
		
	}
	
	
	
	@AfterTest
	public void tearDown() throws IOException, InterruptedException {
		
		driver.get(readProperties("DashboardURL"));
		changePasswordPageRedirect();
		ChangePasswordPage changepwd = new ChangePasswordPage(driver);
		changepwd.oldPassword().sendKeys(readProperties("newPasswordChange"));
		changepwd.newPassword().sendKeys(readProperties("oldPassword"));
		changepwd.confirmPassword().sendKeys(readProperties("oldPassword"));
		changepwd.confirmSetPassword().click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(changepwd.passwordUpdatePopup()));
		driver.close();
	}
	
}
