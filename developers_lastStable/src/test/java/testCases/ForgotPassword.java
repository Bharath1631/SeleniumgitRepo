package testCases;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObjects.LoginPage;
import pageObjects.ForgotPasswordPage;
import resources.Base;
import resources.Log;

public class ForgotPassword extends Base{
	
	
	
	@Parameters("value")
	@BeforeTest
	public void invokeBrowser(String value) throws IOException {
		driver =  driverInitialize(value);
		driver.get(readProperties("BaseURL"));
	}
	
	public void enterOTP() throws IOException, InstantiationException, IllegalAccessException, SQLException, InterruptedException {
		
		int ssoOTP=0;
//		LoginPage login=new LoginPage(driver);
		ForgotPasswordPage forgotPassword=new ForgotPasswordPage(driver);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        login.signin().click();
//        wait.until(ExpectedConditions.elementToBeClickable(login.email()));
//        login.email().sendKeys(readProperties("forgotEmailID"));
//		forgotPassword.forgetPasswrd().click();
//		Log.info("Clicked on Forgot Password");
		//forgotpass.eneterResendOtp().click();
		Connection DB = getDBconnection(readProperties("ssourl"), readProperties("ssouser"), readProperties("ssopassword"));
		Listeners.test.log(Status.INFO,"---------Database Connection opened Sucessfully-------");
    	PreparedStatement pstmt = DB.prepareStatement("select * from user_otp where user_id=?");
    	pstmt.setString(1, readProperties("forgotEmailID"));
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			ssoOTP = rs.getInt("otp_generated");
			Log.info("OTP is " +ssoOTP);
		}
		
		DB.close();
		Listeners.test.log(Status.INFO,"---------Database Connection Closed Sucessfully-------");
		Log.info("----------Database conection closed successfull----------");
		//forgotPassword.enterOtp().sendKeys(""+ssoOTP);
		if(ssoOTP<=99999) {
		    forgotPassword.enterOtp().sendKeys("0"+ssoOTP);
			Log.info("Entered OTP is 0"+ssoOTP);
		}
    	else {
    		forgotPassword.enterOtp().sendKeys(""+ssoOTP);
			Log.info("Entered OTP is "+ssoOTP);
    	}
		
		
	}
	
	@Test
	public void clickOnForgotPassword() throws IOException {
		
		driver.get(readProperties("BaseURL"));
		LoginPage login=new LoginPage(driver);
		ForgotPasswordPage forgotPassword=new ForgotPasswordPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        login.signin().click();
        wait.until(ExpectedConditions.elementToBeClickable(login.email()));
        login.email().sendKeys(readProperties("forgotEmailID"));
		forgotPassword.forgetPasswrd().click();
		Assert.assertEquals(forgotPassword.setPasswordText().getText(), "Set Password");
		Log.info("------Successfully Clicked on Forgot Password and Redirected to Set Password Page---------");
		Listeners.test.log(Status.INFO,"------Successfully Clicked on Forgot Password and Redirected to Set Password Page--------");
		
	}
	
	@Test
	public void OTPinBullets() throws IOException, InstantiationException, IllegalAccessException, SQLException, InterruptedException {
		
		clickOnForgotPassword();
		enterOTP();
		ForgotPasswordPage forgotPassword=new ForgotPasswordPage(driver);
		Assert.assertEquals(forgotPassword.enterOtp().getAttribute("type"), "password");
		Log.info("--------------Entered OTP is in Bullets and it is Masked Successfully--------------");
		Listeners.test.log(Status.INFO,"--------Entered OTP is in Bullets and it is Masked Successfully-------------");
		
		
	}
	
	@Test
	public void resendOTP() throws IOException, InstantiationException, IllegalAccessException, SQLException, InterruptedException {
		
		clickOnForgotPassword();
		ForgotPasswordPage forgotPassword=new ForgotPasswordPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(forgotPassword.okOTP()));
		forgotPassword.okOTP().click();
		Thread.sleep(1000);
		forgotPassword.eneterResendOtp().click();
		wait.until(ExpectedConditions.elementToBeClickable(forgotPassword.okOTP()));
		forgotPassword.okOTP().click();
		enterOTP();
		Log.info("-----------Successfully Clicked on Resend OTP-----");
		Listeners.test.log(Status.INFO,"----------Successfully Clicked on Resend OTP------");
	}
	
	
	@Test
	public void invalidPassword() throws IOException, InterruptedException, InstantiationException, IllegalAccessException, SQLException {
		
		clickOnForgotPassword();
		ForgotPasswordPage forgotpass=new ForgotPasswordPage(driver);
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(forgotpass.okOTP()));
	    forgotpass.okOTP().click();
		enterOTP();
		forgotpass.enterNewPassword().sendKeys(readProperties("invalidPassword"));
		Log.info("Entered New Password :"+readProperties("invalidPassword"));
		forgotpass.enterConfirmPassword().sendKeys(readProperties("invalidPassword"));
		Log.info("Entered New Password :"+readProperties("invalidPassword"));
		forgotpass.submitBtn().click();
		Log.info("Clicked on Submit Button");
		wait.until(ExpectedConditions.visibilityOf(forgotpass.errorVisible()));
		Assert.assertEquals(forgotpass.invalidPasswordText().getText(),"Your password needs to be at least 8 characters long including at least 1 digit, 1 special character like .$@!%*?&#^<>()~`+_- and 1 upper case and lower case letter.");
		Log.info("------Invalid Password Error message Displayed-------------");
		Listeners.test.log(Status.INFO,"-----Invalid Password Error message Displayed------");
		
	}
	
	
	@Test
	public void invalidOTP() throws IOException, InterruptedException, InstantiationException, IllegalAccessException, SQLException {
		
		clickOnForgotPassword();
		ForgotPasswordPage forgotpass=new ForgotPasswordPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(forgotpass.okOTP()));
	    forgotpass.okOTP().click();
		forgotpass.enterOtp().sendKeys(""+1234);
		forgotpass.enterNewPassword().sendKeys(readProperties("forgotnewpassword"));
		Log.info("Entered New Password :"+readProperties("forgotnewpassword"));
		forgotpass.enterConfirmPassword().sendKeys(readProperties("forgotnewpassword"));
		Log.info("Entered New Password :"+readProperties("forgotnewpassword"));
		Thread.sleep(1000);
		forgotpass.submitBtn().click();
		Log.info("Clicked on Submit Button");
		wait.until(ExpectedConditions.visibilityOf(forgotpass.errorVisible()));
		Thread.sleep(1000);
		Assert.assertEquals(forgotpass.invalidOTPError().getText(),"Invalid OTP.");
		Log.info("------Invalid OTP Error message Displayed-------------");
		Listeners.test.log(Status.INFO,"------Invalid OTP Error message Displayed-------------");
		
	}
	
	@Test(priority = 1)
	public void passwordNotMatched() throws IOException, InterruptedException, InstantiationException, IllegalAccessException, SQLException {
		
		clickOnForgotPassword();
		ForgotPasswordPage forgotpass=new ForgotPasswordPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(forgotpass.okOTP()));
	    forgotpass.okOTP().click();
		enterOTP();
		forgotpass.enterNewPassword().sendKeys(readProperties("forgotnewpassword"));
		Log.info("Entered New Password :"+readProperties("forgotnewpassword"));
		forgotpass.enterConfirmPassword().sendKeys(readProperties("forgotconfirmpassword"));
		Log.info("Entered New Password :"+readProperties("forgotconfirmpassword"));
		forgotpass.submitBtn().click();
		Log.info("Clicked on Submit Button");
		wait.until(ExpectedConditions.visibilityOf(forgotpass.errorVisible()));
		Assert.assertEquals(forgotpass.pwdNotMatch().getText(),"The new password and confirmation password do not match.");
		Log.info("------'The new password and confirmation password do not match.' Error message Displayed-------------");
		Listeners.test.log(Status.INFO,"------'The new password and confirmation password do not match.' Error message Displayed-------------");
		
	}
	
	@Test(priority = 2)
	public void setNewValidPassword() throws IOException, InterruptedException, InstantiationException, IllegalAccessException, SQLException {
		
		clickOnForgotPassword();
		ForgotPasswordPage forgotpass=new ForgotPasswordPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(forgotpass.okOTP()));
	    forgotpass.okOTP().click();
		enterOTP();
		forgotpass.enterNewPassword().sendKeys(readProperties("forgotnewpassword"));
		Log.info("Entered New Password :"+readProperties("forgotnewpassword"));
		forgotpass.enterConfirmPassword().sendKeys(readProperties("forgotnewpassword"));
		Thread.sleep(500);
		forgotpass.submitBtn().click();
		Log.info("Clicked on Submit Button");
		wait.until(ExpectedConditions.elementToBeClickable(forgotpass.clickOK()));
		//Thread.sleep(4000);
		Assert.assertEquals(forgotpass.popUpMessage().getText(),"Your new password is set successfully.");
		Log.info("------Successfully New Password as been set-------------");
		Listeners.test.log(Status.INFO,"----------Successfully New Password as been set-----------");
		forgotpass.clickOK().click();
		Assert.assertEquals(driver.getCurrentUrl(), readProperties("BaseURL"));
		Log.info("----------Sucessfully Redirected to LoginPage-----------");
		Listeners.test.log(Status.INFO,"----------Sucessfully Redirected to LoginPage-----------");
		
	}
	
	
	@Test(priority = 3)
	public void samePassword() throws IOException, InterruptedException, InstantiationException, IllegalAccessException, SQLException {
		
		clickOnForgotPassword();
		ForgotPasswordPage forgotpass=new ForgotPasswordPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(forgotpass.okOTP()));
	    forgotpass.okOTP().click();
		enterOTP();
		forgotpass.enterNewPassword().sendKeys(readProperties("forgotnewpassword"));
		Log.info("Entered New Password :"+readProperties("forgotnewpassword"));
		forgotpass.enterConfirmPassword().sendKeys(readProperties("forgotnewpassword"));
		forgotpass.submitBtn().click();
		Log.info("Clicked on Submit Button");
		wait.until(ExpectedConditions.visibilityOf(forgotpass.errorVisible()));
		Assert.assertEquals(forgotpass.samePWDError().getText(),"New and Old password cannot be same.");
		Log.info("-----'New and Old password cannot be same.' Error message printed-------------");
		Listeners.test.log(Status.INFO,"----'New and Old password cannot be same.' Error message printed--------------");
		
	}
	
	
	@AfterTest
	public void tearDown() throws InterruptedException, InstantiationException, IllegalAccessException, IOException, SQLException {
		
		
		clickOnForgotPassword();
		ForgotPasswordPage forgotpass=new ForgotPasswordPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(forgotpass.okOTP()));
	    forgotpass.okOTP().click();
		enterOTP();
		forgotpass.enterNewPassword().sendKeys(readProperties("forgotconfirmpassword"));
		forgotpass.enterConfirmPassword().sendKeys(readProperties("forgotconfirmpassword"));
		forgotpass.submitBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(forgotpass.clickOK()));
		driver.close();
	
	}


}
