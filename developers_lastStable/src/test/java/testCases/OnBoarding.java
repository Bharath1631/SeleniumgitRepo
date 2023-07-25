/*
	 * @Author : Anil kumar
	 * Module : OnBoarding cases
	 * Date   : 14 Oct 2022
	 * updated : 18 Nov 2022
	 */
package testCases;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObjects.AccountTypePage;
import pageObjects.DashboardPage;
import pageObjects.SignUpPage;
import pageObjects.LoginPage;
import pageObjects.Review_details;
import pageObjects.SetPassword;
import pageObjects.SetupUser;
import pageObjects.SignUpOkVerify;
import resources.Base;
import resources.Log;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OnBoarding extends Base {
	
	public String aplha = "abcdefghijklmnopqrstuvwxyz1234567890";
	public String randString ;
	public static String Email;
	
	@Parameters("value")
	@BeforeTest
	public void invokeBrowser(String value) throws IOException {
		driver =  driverInitialize(value);
		driver.get(readProperties("BaseURL"));
	}
	
	
	@Test (priority = -1)
	public void openDevelopersPortal() throws IOException, InterruptedException {
		
		SignUpPage signupemail=new SignUpPage(driver);
		Log.info("Text is"+signupemail.thankYouText().getText());
		Assert.assertEquals(signupemail.thankYouText().getText(), "Thank you for your interest in\nDotgo Developer Portal");
		Log.info("ThankYou for Your Interest Text is displayed");
		Assert.assertEquals(signupemail.viewListOfCarriersAndCarriers().getText(), "View list of countries and carriers.");
		Log.info("View List of countries and carriers link is displayed");
		Assert.assertTrue(signupemail.trmsAndConditionsCheckBox().isSelected());
		Log.info("Terms and conditions Check Box is Checked by Default");
		Assert.assertTrue(signupemail.clickReset().isEnabled());
		Assert.assertTrue(signupemail.clickSignUp().isEnabled());
		Assert.assertTrue(signupemail.signIN().isEnabled());
		Log.info("---------Successfully Reset, Singup, SignIN Buttons are displayed and Enabled---------------");
		
	}
	
	@Test (priority = -1)
	public void viewListOfCountryCarriers() throws IOException, InterruptedException {
		
		SignUpPage signupemail=new SignUpPage(driver);
		signupemail.viewListOfCarriersAndCarriers().click();
		Log.info("Clicked on View Carriers and Country link");
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	   // Thread.sleep(2000);
	    WebDriverWait wait = explicitWait(driver,30);
		wait.until(ExpectedConditions.urlContains(readProperties("CountryandCarrierPageURL")));
	    Assert.assertEquals(driver.getCurrentUrl(),readProperties("CountryandCarrierPageURL"));
	    driver.close();
	    driver.switchTo().window(tabs.get(0));
		Log.info("-------Successfully Redirected to the page COUNTRY and CARRIER PAGE-----------");
	
		
		
	}
	
	
	@Test (priority = -1)
	public void signInButton() throws IOException, InterruptedException {
		
		SignUpPage signupemail=new SignUpPage(driver);
		signupemail.signIN().click();
		Log.info("Clicked on SignIn Button");
		Assert.assertEquals(driver.getCurrentUrl(), readProperties("LoginURL"));
		Log.info("-------Successfully Redirected to SignIn Page-----------");
		driver.navigate().back();
		
		
		
	}

	@Test(priority = 0)
	public void newSignUpEmailVerify() throws Exception {
		
		//Listeners.test.assignCategory("regression");
		randString = getSaltString(18,aplha);
		WebDriverWait wait = explicitWait(driver,30);
		int ID = 0;
	    driver.get(readProperties("BaseURL"));
		SignUpPage signupemail=new SignUpPage(driver);
		signupemail.enterSignUpEmail().sendKeys("Auto"+randString+"@gmial.com");
		Email="Auto"+randString+"@gmial.com";
		Log.info("Auto"+randString+"@gmial.com");
		signupemail.clickSignUp().click();
		//Thread.sleep(3000);
		wait.until(ExpectedConditions.urlContains(readProperties("emailverify")));
		Assert.assertEquals(driver.getCurrentUrl(), readProperties("emailverify"));
		Log.info("------SUccessfully Redirected to Email Verify confirm Page---------");
		Listeners.test.log(Status.INFO,"------SUccessfully Redirected to Email Verify confirm Page---------");
		SignUpOkVerify ok=new SignUpOkVerify(driver);
		//Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(ok.clickOK()));
		ok.clickOK().click();
		Log.info("Clicked On OK BUtton");
		
		Connection DB = getDBconnection(readProperties("url"), readProperties("user"), readProperties("password"));
		Listeners.test.log(Status.INFO,"---------Database Connection opened Sucessfully-------");
    	PreparedStatement pstmt = DB.prepareStatement("select * from partners_profile where email=?;");
    	pstmt.setString(1, "Auto"+randString+"@gmial.com");
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			ID= rs.getInt("id");
			Log.info("ID is" +ID);
		}
		
		DB.close();
    	Log.info("--------Database connection closed successfully----------");
    	Listeners.test.log(Status.INFO,"---------Database connection closed successfully--------------");
    	Log.info("ID is "+ ID);
		//String token = getToken(ID);
		driver.get("https://partner-staging.dotgo.com/set-password?token="+getToken(ID));
		Log.info("----Successfully Redirected to SetPassword Page----");
		Listeners.test.log(Status.INFO,"----Successfully Redirected to SetPassword Page----");
		
	}
	
	
	
	@Test(priority = 1)
	public void setPassword() throws InterruptedException, IOException {
		SetPassword setPassword = new SetPassword(driver);
		setPassword.setPassword().sendKeys(readProperties("newpassword"));
		setPassword.confirmPassword().sendKeys(readProperties("confirmpassword"));
		setPassword.clickConfirm().click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		LoginPage loginPage = new LoginPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(loginPage.email()));
		Assert.assertEquals(driver.getCurrentUrl(), readProperties("LoginURL"));
		Log.info("-------Successfully Password has been set and Redirected to the Login Page------------");
		Listeners.test.log(Status.INFO,"--------Successfully Password has been set and Redirected to the Login Page------------");
		
		
	}
	
	
	@Test(priority = 2)
	public void setupPageRedirect() throws IOException, InterruptedException {
		
		//Listeners.test.assignCategory("regression");
		driver.get(readProperties("LoginURL"));
		LoginPage loginPage = new LoginPage(driver);
		loginPage.email().sendKeys("Auto"+randString+"@gmial.com");
		loginPage.password().sendKeys(readProperties("confirmpassword"));
		loginPage.submit().click();
		Log.info("Entered EMAIL, PASSWORD and clicked on Submit");
		SetupUser newuser=new SetupUser(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(newuser.firstNameEnter()));
		Assert.assertEquals(driver.getCurrentUrl(), readProperties("SetupUserURL"));
		Log.info("--------Successfully Redirected to the Setup USER page----------");
		Listeners.test.log(Status.INFO,"--------Successfully Redirected to the Setup USER page----------");
		
	}
	
	
	
	@Test(priority = 3)
	public void sendOTP() throws IOException{
		//Listeners.test.assignCategory("sanity");
		
		SetupUser newuser=new SetupUser(driver);
		newuser.firstNameEnter().sendKeys(readProperties("firstname"));
		newuser.lastNameEnter().sendKeys(readProperties("lastname"));
		Select countrydropdown=new Select(newuser.phoneCountry());
		countrydropdown.selectByVisibleText("India");
		newuser.phoneNumberEnter().sendKeys(readProperties("phonenumber"));
		newuser.verify().click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(newuser.otpPopUp()));
        Assert.assertTrue(newuser.otpPopUp().getText().contains("OTP successfully sent to"));
    	newuser.gotIt().click();
    	Log.info("-----Successfully OTP sent-------");
    	Listeners.test.log(Status.INFO,"-----Successfully OTP sent-------");
    	
		
	}
	
	@Test(priority = 4)
	public void resendOTP() throws IOException{
		//Listeners.test.assignCategory("sanity");
		
		SetupUser newuser=new SetupUser(driver);
		newuser.resendOTP().click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(newuser.otpPopUp()));
		Assert.assertTrue(newuser.otpPopUp().getText().contains("OTP successfully sent to"));
    	newuser.gotIt().click();
    	Log.info("-----Successfully OTP resent-------");
    	Listeners.test.log(Status.INFO,"-----Successfully OTP resent-------");
    	
		
	}
		
		
	@Test(priority = 5)
	public void enterValidOTPandConfirm() throws InterruptedException, InstantiationException, IllegalAccessException, IOException, SQLException {
		
    	SetupUser newuser=new SetupUser(driver);
    	int OTP=0;
		newuser.resendOTP().click();
    	Log.info("Successfully OTP sent Again");
		
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(newuser.otpPopUp()));
		Assert.assertTrue(newuser.otpPopUp().getText().contains("OTP successfully sent to"));
		
    	newuser.gotIt().click();
    	Connection DB = getDBconnection(readProperties("url"), readProperties("user"), readProperties("password"));
		Listeners.test.log(Status.INFO,"---------Database Connection opened Sucessfully-------");
    	PreparedStatement pstmt = DB.prepareStatement("select * from bot_user_otp  join partners_profile on partners_profile.id=bot_user_otp.partners_profile_id where email=?;");
    	pstmt.setString(1, "Auto"+randString+"@gmial.com");
    	Log.info("Email is "+"Auto"+randString+"@gmial.com");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			OTP = rs.getInt("otp");
			Log.info("otp is" +OTP);
		}
		
		DB.close();
    	Log.info("--------Database connection closed successfully----------");
    	Listeners.test.log(Status.INFO,"--------Database connection closed successfully----------");
    	Log.info("otp is "+ OTP);
    	//newuser.enterOTP().sendKeys(""+OTP);
    	if(OTP<=999)
    		newuser.enterOTP().sendKeys("0"+OTP);
    	else
    		newuser.enterOTP().sendKeys(String.valueOf(OTP));
    	newuser.verify().click();
		wait.until(ExpectedConditions.visibilityOf(newuser.otpPopUp()));
    	Assert.assertEquals(newuser.otpPopUp().getText(), "Mobile number verified");
    	newuser.gotIt().click();
	}
	
	
	@Test(priority = 6)
	public void defaultAccountType() throws IOException {
    	
		SetupUser newuser=new SetupUser(driver);
		newuser.companyNmaeEnter().sendKeys(readProperties("CompanyName"));
		newuser.jobTitleenter().sendKeys(readProperties("JobTitle"));
		newuser.companyWebsiteEnter().sendKeys(readProperties("CompanyWebsite"));
		newuser.addressOneEnter().sendKeys(readProperties("AddressLine1"));
		newuser.addressTwoEnter().sendKeys(readProperties("AddressLine2"));
		newuser.enterCity().sendKeys(readProperties("City"));
		newuser.enterState().sendKeys(readProperties("State/Province/Region"));
		JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
		scrollPage.executeScript("window.scrollBy(0,2000)", "");
		Actions keyDown = new Actions(driver); 
		//keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
		newuser.selectCountry().click();
		keyDown.sendKeys(readProperties("Country")).sendKeys(Keys.ENTER).perform();
		newuser.enterZipCode().sendKeys(readProperties("ZIP/PostalCode"));
		Select timezone =  new Select(newuser.enterTimeZone());
		timezone.selectByValue("Asia/Kolkata");
//		Select document = new Select(newuser.selectdocument());
//		document.selectByValue("Aadhar card");
//		newuser.browseDoc().sendKeys(Base.localDir+"/utils/VI.jpg");
//		Select businessDoc = new Select(newuser.selectBusinessDocument());
//		businessDoc.selectByValue("Aadhar card");
//		newuser.browseDoc().sendKeys(Base.localDir+"/utils/VI_back(1).png");
		newuser.clickNext().click();
		AccountTypePage accountType = new AccountTypePage(driver);
		Assert.assertEquals(driver.getCurrentUrl(),readProperties("AccountTypePageURL"));
		Assert.assertEquals(accountType.text().getText(),"Please select one of the options below:");
		Log.info("------Successfully Redirected to Account Type page and displayed the string as "+accountType.text().getText()+"--------");
		Listeners.test.log(Status.INFO,"-------Successfully Redirected to Account Type page and displayed the string as "+accountType.text().getText()+"-------");
		Assert.assertTrue(accountType.verifyradioButton1().isEnabled());
		Assert.assertTrue(accountType.verifyradioButton2().isEnabled());
		Log.info("Both the Radio Buttons are enabled and Displayed");
		Assert.assertTrue(accountType.verifyradioButton1().isSelected());
		Assert.assertFalse(accountType.verifyradioButton2().isSelected());
		Log.info("-------Dotgo RBM Hub Radio Button is Selected By Default---------");
		Listeners.test.log(Status.INFO,"-------Dotgo RBM Hub Radio Button is Selected By Default---------");
			
		
	}
	
	@Test(priority= 7)
	public void selectDirectRbmAccount()  {
		
		AccountTypePage accountType = new AccountTypePage(driver);
		accountType.radioButton2().click();
		Assert.assertTrue(accountType.verifyradioButton2().isSelected());
		Log.info("------Selected Direct RBM account--------");
		Listeners.test.log(Status.INFO,"------Selected Direct RBM account--------");
		Assert.assertEquals(accountType.directRBMText().getText(), "Carrier Selection for Direct RBM Termination");
		Assert.assertTrue(accountType.searchBox().isDisplayed());
		Log.info("Search Bar is displayed");
		Assert.assertTrue(accountType.selectAllCheckBox().isDisplayed());
		Log.info("Select All Check Box is Displayed");
		Assert.assertTrue(accountType.clickBackButton().isDisplayed());
		Assert.assertTrue(accountType.clickNextButton().isDisplayed());
		Log.info("Back and Next Buttons Displayed");
		Log.info("Carriers Displayed in the list is "+accountType.carrierList().getText());
		Listeners.test.log(Status.INFO,"SearchBar, SelectALL CheckBOx, Back and Next Button is displayed");
		
		
	}
			
	@Test(priority= 8)
	public void reviewYourDetails() throws IOException {
		
		AccountTypePage accountType = new AccountTypePage(driver);
		accountType.selectFirstCarrier().click();
		accountType.docomoJapanCarrier().click();
		Log.info("Selected First Carrier in the Carrier List");
		accountType.clickNextButton().click();
		Log.info("Clicked on Next Button");
		Assert.assertEquals(driver.getCurrentUrl(),readProperties("reviewDetails"));
		Log.info("------Successfully Redirected to the ReviewDetails Page------");
		Listeners.test.log(Status.INFO,"-----Successfully Redirected to the ReviewDetails Page-----");
	}
	
	
	@Test(priority= 9)
	public void backButton() throws IOException {
		
		Review_details reviewPage = new Review_details(driver);
		AccountTypePage accountType = new AccountTypePage(driver);
		reviewPage.backButton().click();
		Log.info("Clicked on Back Button");
		Assert.assertEquals(driver.getCurrentUrl(), readProperties("AccountTypePageURL"));
		Assert.assertTrue(accountType.verifyradioButton2().isSelected());
		Log.info("------Successfully Came back to AccountType Seclection Page and selected Account type is Selected----------");
		
		
	}

	
	@Test(priority = 10)
	public void clickOnViewCountryAndCarrier() throws IOException, InterruptedException {
		
		driver.get(readProperties("AccountTypePageURL"));
		AccountTypePage accountType = new AccountTypePage(driver);
		accountType.clickLink().click();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    //Thread.sleep(2000);
	    WebDriverWait wait = explicitWait(driver,30);
		wait.until(ExpectedConditions.urlContains(readProperties("CountryandCarrierPageURL")));
	    Assert.assertEquals(driver.getCurrentUrl(), readProperties("CountryandCarrierPageURL"));
	    driver.close();
	    driver.switchTo().window(tabs.get(0));
		Log.info("------Sucessfully Redirected to the Country and Carrier Page on the New Tab-------");
		Listeners.test.log(Status.INFO,"-----Sucessfully Redirected to the Country and Carrier Page on the New Tab-------");
	}
	
	
	
	@Test(priority=11, groups={"OnBoarding.DirectRBMAccount"})
	public void submitDirectRbmAccount() throws IOException, InterruptedException {
		
		WebDriverWait wait = explicitWait(driver,20);
		AccountTypePage accountType = new AccountTypePage(driver);
		SetupUser newuser=new SetupUser(driver);
		wait.until(ExpectedConditions.elementToBeClickable(accountType.selectFirstCarrier()));
		JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
		scrollPage.executeScript("window.scrollBy(0,2000)", "");
		newuser.clickNext().click();
		wait.until(ExpectedConditions.urlContains("https://partner-staging.dotgo.com/developer/review-details"));
		newuser.clickNext().click();
		//Thread.sleep(6000);		
		wait.until(ExpectedConditions.urlContains(readProperties("DashboardURL")));
		Assert.assertEquals(driver.getCurrentUrl(), readProperties("DashboardURL"));
		Log.info("-------Successfully Direct RBM account selected and Redirected to the Dashboard Page------------");
		Listeners.test.log(Status.INFO,"-------Successfully Direct RBM account selected and Redirected to the Dashboard Page-----------");
		
	}

	
//	@Test(priority=6)
//	public void selectDotgoRbmAccount() throws IOException, InterruptedException {
//		
//		AccountTypePage accountType = new AccountTypePage(driver);
//		accountType.radioButton1().click();
//		SetupUser newuser=new SetupUser(driver);
//		newuser.clickNext().click();
//		newuser.clickNext().click();
//		Thread.sleep(2000);
//		Assert.assertEquals(driver.getCurrentUrl(), readProperties("DashboardURL"));
//		Log.info("-------Successfully Dotgo RBM account selected and Redirected to the Dashboard Page------------");
//		Listeners.test.log(Status.INFO,"-------Successfully Dotgo RBM account selected and Redirected to the Dashboard Page-----------");
//		
//	}
//
//	
	
	@Test(priority = 12) 
	public void signupWithExistingEmail() throws IOException, InterruptedException {
		DashboardPage dashboard = new DashboardPage(driver);
		dashboard.dropdown().click();
		dashboard.logout().click();
		Log.info("Logged Out to the Signin page");
		//Thread.sleep(2000);
		WebDriverWait wait = explicitWait(driver,30);
		wait.until(ExpectedConditions.urlContains(readProperties("BaseURL")));
		//driver.get(readProperties("BaseURL"));
		SignUpPage signupemail=new SignUpPage(driver);
		signupemail.enterSignUpEmail().sendKeys("Auto"+randString+"@gmial.com");
		Log.info("Entered the Existing Email ID");
		signupemail.clickSignUp().click();
		SignUpPage signup = new SignUpPage(driver);
		Assert.assertEquals(signup.errorMessage().getText(), "Email address already registered!");
		Log.info("------Successfully Error message Displayed--------");
		Listeners.test.log(Status.INFO,"------Successfully Error message Displayed--------");
		
	}

	
	
	@Test(priority = 13, groups={"OnBoarding.createDeveloperAccount"})
	public void createDeveloperAccount() throws Exception {
		driver.get(readProperties("BaseURL"));
		SetupUser newuser=new SetupUser(driver);
		newSignUpEmailVerify();
		setPassword();
		setupPageRedirect();
		sendOTP();
		resendOTP();
		enterValidOTPandConfirm();
		defaultAccountType();
		newuser.clickNext().click();
		newuser.clickNext().click();
		WebDriverWait wait = explicitWait(driver,20);
		wait.until(ExpectedConditions.urlContains(readProperties("DashboardURL")));
		Assert.assertEquals(driver.getCurrentUrl(), readProperties("DashboardURL"));
		Log.info("-------Successfully Dotgo RBM HUB account selected and Redirected to the Dashboard Page------------");
		Listeners.test.log(Status.INFO,"-------Successfully Dotgo RBM HUB account selected and Redirected to the Dashboard Page-----------");
	}
	
	
	
	
	
//	//@Test(priority=5)
//	public void selectDirectRbmAccount() throws InterruptedException, IOException, InstantiationException, IllegalAccessException, SQLException {
//		
//		int ID = 0;
//		EnterSignUpEmail signupemail=new EnterSignUpEmail(driver);
//		signupemail.enterSignUpEmail().sendKeys(readProperties("signupemailid2"));
//		signupemail.clickSignUp().click();
//		Thread.sleep(3000);
//		Assert.assertEquals(driver.getCurrentUrl(), readProperties("emailverify"));
//		Log.info("------SUccessfully Redirected to Email Verify confirm Page---------");
//		Listeners.test.log(Status.INFO,"------SUccessfully Redirected to Email Verify confirm Page---------");
//		SignUpOkVerify ok=new SignUpOkVerify(driver);
//		Thread.sleep(5000);
//		ok.clickOK();
//		Log.info("Clicked On OK BUtton");
//		
//		Connection DB = getDBconnection(readProperties("url"), readProperties("user"), readProperties("password"));
//		Listeners.test.log(Status.INFO,"---------Database Connection opened Sucessfully-------");
//    	PreparedStatement pstmt = DB.prepareStatement("select * from partners_profile where email=?;");
//    	pstmt.setString(1, readProperties("signupemailid2"));
//		ResultSet rs = pstmt.executeQuery();
//		
//		while (rs.next()) {
//			ID= rs.getInt("id");
//			Log.info("ID is" +ID);
//		}
//		
//		DB.close();
//    	Log.info("--------Database connection closed successfully----------");
//    	Listeners.test.log(Status.INFO,"---------Database connection closed successfully--------------");
//    	Log.info("ID is "+ ID);
//		//String token = getToken(ID);
//		driver.get("https://partner-staging.dotgo.com/set-password?token="+getToken(ID));
//		setPassword();
//		driver.get(readProperties("LoginURL"));
//		LoginPage loginPage = new LoginPage(driver);
//		loginPage.email().sendKeys(readProperties("signupemailid2"));
//		loginPage.password().sendKeys(readProperties("confirmpassword"));
//		loginPage.submit().click();
//		Log.info("Entered EMAIL, PASSWORD and clicked on Submit");
//		Thread.sleep(3000);
//		Assert.assertEquals(driver.getCurrentUrl(), readProperties("SetupUserURL"));
//		Log.info("--------Successfully Redirected to the Setup USER page----------");
//		Listeners.test.log(Status.INFO,"--------Successfully Redirected to the Setup USER page----------");
//		int OTP=0;
//		SetupUser newuser=new SetupUser(driver);
//		newuser.firstNameEnter().sendKeys(readProperties("firstname"));
//		newuser.lastNameEnter().sendKeys(readProperties("lastname"));
//		Select countrydropdown=new Select(newuser.phoneCountry());
//		countrydropdown.selectByVisibleText("India");
//		newuser.phoneNumberEnter().sendKeys(readProperties("phonenumber"));
//		newuser.verify().click();
//		Thread.sleep(2000);
//		DB = getDBconnection(readProperties("url"), readProperties("user"), readProperties("password"));
//		Listeners.test.log(Status.INFO,"---------Database Connection opened Sucessfully-------");
//    	pstmt = DB.prepareStatement("select * from bot_user_otp  join partners_profile on partners_profile.id=bot_user_otp.partners_profile_id where email=?;");
//    	pstmt.setString(1, readProperties("signupemailid2"));
//		rs = pstmt.executeQuery();
//		while (rs.next()) {
//			OTP = rs.getInt("otp");
//			Log.info("otp is" +OTP);
//		}
//		
//		DB.close();
//    	Log.info("--------Database connection closed successfully----------");
//    	Listeners.test.log(Status.INFO,"--------Database connection closed successfully----------");
//    	Log.info("otp is "+ OTP);
//    	Thread.sleep(3000);
//    	Assert.assertEquals(newuser.otpPopUp().getText(), "OTP sent successfully");
//		
//    	newuser.gotIt().click();
//    	//newuser.enterOTP().sendKeys(""+OTP);
//    	if(OTP<=999)
//    		newuser.enterOTP().sendKeys("0"+OTP);
//    	else
//    		newuser.enterOTP().sendKeys(String.valueOf(OTP));
//    	newuser.verify().click();
//    	Thread.sleep(3000);
//    	Assert.assertEquals(newuser.otpPopUp().getText(), "OTP Validated successfully");
//    	
//    	newuser.gotIt().click();
//		newuser.companyNmaeEnter().sendKeys(readProperties("CompanyName"));
//		newuser.jobTitleenter().sendKeys(readProperties("JobTitle"));
//		newuser.companyWebsiteEnter().sendKeys(readProperties("CompanyWebsite"));
//		newuser.addressOneEnter().sendKeys(readProperties("AddressLine1"));
//		newuser.addressTwoEnter().sendKeys(readProperties("AddressLine2"));
//		newuser.enterCity().sendKeys(readProperties("City"));
//		newuser.enterState().sendKeys(readProperties("State/Province/Region"));
//		JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
//		scrollPage.executeScript("window.scrollBy(0,2000)", "");
//		Actions keyDown = new Actions(driver); 
//		//keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
//		newuser.selectCountry().click();
//		keyDown.sendKeys(readProperties("Country")).sendKeys(Keys.ENTER).perform();
//		newuser.enterZipCode().sendKeys(readProperties("ZIP/PostalCode"));
//		Select timezone =  new Select(newuser.enterTimeZone());
//		timezone.selectByValue("Asia/Kolkata");
//		newuser.clickNext().click();
//		AccountTypePage accountType = new AccountTypePage(driver);
//		Assert.assertEquals(driver.getCurrentUrl(),readProperties("AccountTypePageURL"));
//		Assert.assertEquals(accountType.text().getText(),"Please select one of the options below:");
//		Log.info("------Successfully Redirected to Account Type page and displayed the string as "+accountType.text().getText()+"--------");
//		Listeners.test.log(Status.INFO,"-------Successfully Redirected to Account Type page and displayed the string as "+accountType.text().getText()+"-------");
//		Assert.assertTrue(accountType.radioButton1().isEnabled());
//		Assert.assertTrue(accountType.radioButton2().isEnabled());
//		Log.info("Both the Radio Buttons are enabled and Displayed");
//		Assert.assertTrue(accountType.verifyradioButton1().isSelected());
//		Assert.assertFalse(accountType.verifyradioButton2().isSelected());
//		Log.info("Dotgo RBM Hub Radio Button is Selected By Default");
//		accountType.radioButton2().click();
//		Thread.sleep(2000);
//		Assert.assertTrue(accountType.verifyradioButton2().isSelected());
//		Log.info("------Selected Direct RBM account--------");
//		Listeners.test.log(Status.INFO,"------Selected Direct RBM account--------");
//		Assert.assertEquals(accountType.directRBMText().getText(), "Carrier Selection for Direct RBM Termination");
//		Assert.assertTrue(accountType.searchBox().isDisplayed());
//		Log.info("Search Bar is displayed");
//		Assert.assertTrue(accountType.selectAllCheckBox().isDisplayed());
//		Log.info("Select All Check Box is Displayed");
//		Assert.assertTrue(accountType.clickBackButton().isDisplayed());
//		Assert.assertTrue(accountType.clickNextButton().isDisplayed());
//		Log.info("Back and Next Buttons Displayed");
//		Log.info("Carriers Displayed in the list is "+accountType.carrierList().getText());
//		Listeners.test.log(Status.INFO,"1.SearchBar \n 2.SelectAllCheck Box \n 3.Back and Next Button and \n 4.Carriers are Displayed \n carrier list Displayed is \n" +accountType.carrierList().getText());
//		
//		
//	}
	
	
	
	
	
	
		@AfterTest
		public void tearDown() {
			driver.quit();
		}
		
	
}
