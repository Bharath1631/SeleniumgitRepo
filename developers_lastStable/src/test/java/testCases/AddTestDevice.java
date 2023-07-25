package testCases;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.AddTemplatePage;
import pageObjects.TestDevice;
import resources.Base;
import resources.Log;
import pageObjects.LoginPage;

public class AddTestDevice extends Base {
	
			
	@Parameters("value")
	@BeforeTest
	public void invokeBrowser(String value) throws IOException {
		driver = driverInitialize(value);
		driver.get(readProperties("BaseURL"));
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginApplication(readProperties("richmessagetemplatesemail"),
				readProperties("richmessagetemplatesoassword"));
	}
	@Test
	public void clickAddTestDevice() {
		TestDevice testdeviceclick=new TestDevice(driver);
		testdeviceclick.clickBotButton().click();
		JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
	 	scrollPage.executeScript("window.scrollBy(0,2000)", "");
	 	testdeviceclick.clickAddTestDevice().click();
	    Log.info("------AddTestDevice button clicked successfully and URL navigated to addtest device page-------");
	 	Assert.assertEquals(testdeviceclick.addTestDeviceText().getText(), "Add Test Devices");
		
		}
	@Test
    public void enterMobileNumber() throws IOException {
    	driver.get(readProperties("DashboardURL"));
   	    TestDevice mobilenumber=new TestDevice(driver);
    	clickAddTestDevice();
  	    mobilenumber.enterMobileNumber().sendKeys(readProperties("MobileNumber"));
  	    mobilenumber.clickAddButton().click();
  	     Assert.assertTrue(mobilenumber.checkingPOPUP().isDisplayed());
	}
	
	@Test
	  public void deleteTestDevice() throws IOException {
	  	driver.get(readProperties("DashboardURL"));
	  	TestDevice deletetestdevice=new TestDevice(driver);
	  	clickAddTestDevice();
		    String phonenumber=deletetestdevice.fetchingPhoneNumber().getText();
		    deletetestdevice.clickTrash().click();
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 	wait.until(ExpectedConditions.visibilityOf(deletetestdevice.popUPMessageDelete()));
		    Log.info("------Pop message is displayed successfully.  .-------");
		    Assert.assertEquals(deletetestdevice.popUPMessageDelete().getText(), "Are you sure you want to delete "+phonenumber+" Test Device?");
		    deletetestdevice.clickOnTrashCancel().click();
		    deletetestdevice.clickTrash().click();
		    deletetestdevice.clickOnTrashYes().click();
		    wait.until(ExpectedConditions.visibilityOf(deletetestdevice.confirmDeletePopup()));
		    deletetestdevice.deleteMessageOK().click();
		    Assert.assertEquals(deletetestdevice.noTestDevice().getText(), "No Test devices");
	}
	
	
	
	@Test
    public void selectCountryFlag() throws IOException, InterruptedException {
  	  driver.get(readProperties("DashboardURL"));
  	  TestDevice countryselection=new TestDevice(driver);
  	  clickAddTestDevice();
	  Select select = new Select(countryselection.clickCountryName());
	  select.selectByValue(readProperties("countryValue"));
	  Log.info(countryselection.countryCode().getAttribute("value")+ "this is identifying attribute value ");
	  Assert.assertEquals(countryselection.countryCode().getAttribute("value"), readProperties("countrycode"));
	 	 }

	@Test
    public void addingInvalidNumber() throws IOException {
  	  driver.get(readProperties("DashboardURL"));
  	  TestDevice invalidnumber=new TestDevice(driver);
  	  clickAddTestDevice();
	  invalidnumber.enterMobileNumber().sendKeys(readProperties("invalidnumber"));
      invalidnumber.clickAddButton().click();
      Log.info("------Error message is displayed. please enter valid number-------");
	  Assert.assertEquals(invalidnumber.invalidNumberText().getText(), "Please enter valid mobile number");
	 	 }

	@Test
    public void addingNotRCSEnabledNumberr() throws IOException {
  	  driver.get(readProperties("DashboardURL"));
  	  TestDevice notrcsenabled=new TestDevice(driver);
  	  clickAddTestDevice();
	  notrcsenabled.enterMobileNumber().sendKeys(readProperties("notrcsenabled"));
	  notrcsenabled.clickAddButton().click();
      Log.info("------POPup is displayed.-------");
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	 	wait.until(ExpectedConditions.visibilityOf(notrcsenabled.rcsDisbaledPOPUP()));
	 	Assert.assertEquals(notrcsenabled.rcsDisbaledPOPUP().getText(), "Tester Invite Request failed since the test device is not RCS enabled.");
	 	notrcsenabled.rcsDisabledBackPOpUp().click();
	 	wait.until(ExpectedConditions.visibilityOf(notrcsenabled.failedStatus()));
	 	Assert.assertEquals(notrcsenabled.failedStatus().getText(), "Failed");
	 	Log.info("------Number added with failed status..-------");
	
	 	 }
	
	@Test
	  public void deleteNotRCSEnabledNumber() throws IOException {
	  	driver.get(readProperties("DashboardURL"));
	  	TestDevice deletetestdevice=new TestDevice(driver);
	  	clickAddTestDevice();
		    String phonenumber=deletetestdevice.fetchingPhoneNumber().getText();
		    deletetestdevice.clickTrash().click();
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 	wait.until(ExpectedConditions.visibilityOf(deletetestdevice.popUPMessageDelete()));
		    Log.info("------Pop message is displayed successfully.  .-------");
		    Assert.assertEquals(deletetestdevice.popUPMessageDelete().getText(), "Are you sure you want to delete "+phonenumber+" Test Device?");
		    deletetestdevice.clickOnTrashCancel().click();
		    deletetestdevice.clickTrash().click();
		    deletetestdevice.clickOnTrashYes().click();
		    wait.until(ExpectedConditions.visibilityOf(deletetestdevice.confirmDeletePopup()));
		    deletetestdevice.deleteMessageOK().click();
		    Assert.assertEquals(deletetestdevice.noTestDevice().getText(), "No Test devices");
	}
	
	@Test
	  public void AddtestDevicepageNumber() throws IOException {
	  	driver.get(readProperties("DashboardURL"));
	  	TestDevice addtestdevice=new TestDevice(driver);
	  	clickAddTestDevice();
		    addtestdevice.enterMobileNumber().sendKeys(readProperties("MobileNumber1"));
		    addtestdevice.clickAddButton().click();
		   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	 	wait.until(ExpectedConditions.visibilityOf(addtestdevice.testDeviceAdded()));
	 	Assert.assertEquals(addtestdevice.testDeviceAdded().getText(), "Test Device added successfully");
		    
		    addtestdevice.clickAddButtonOK().click();
		    Log.info("------Test device added with pending status.  .-------");
		    Assert.assertEquals(addtestdevice.pendingStatus().getText(), "Pending");
	}
	@Test
	  public void clickRefreshButton() throws IOException {
	  	driver.get(readProperties("DashboardURL"));
	  	TestDevice clickrefreshbutton=new TestDevice(driver);
	  	clickAddTestDevice();
		    clickrefreshbutton.clickRefresh().click();
		    Log.info("------test device refreshed without status changed.  .-------");
		    Assert.assertEquals(clickrefreshbutton.pendingStatus().getText(), "Failed");
	}
	
	
	@Test
  public void againgAddingSameRCSMobileNumber() throws IOException {
  	driver.get(readProperties("DashboardURL"));
  	TestDevice samemobilenumber=new TestDevice(driver);
  	clickAddTestDevice();
	    samemobilenumber.enterMobileNumber().sendKeys(readProperties("MobileNumber1"));
	    samemobilenumber.clickAddButton().click();
	    Log.info("------Pop is dispalyed with Test Device already exist with this number message.-------");
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	 	wait.until(ExpectedConditions.visibilityOf(samemobilenumber.alreadyExistDevice()));
	 	Assert.assertEquals(samemobilenumber.alreadyExistDevice().getText(), "Test Device already exist with this number");
	 	samemobilenumber.alreadyExistDeviceBackButton().click();
	 	Assert.assertEquals(samemobilenumber.pendingStatus().getText(), "Pending");
	}


	@Test
	  public void deletePageTestDeviceNumber() throws IOException {
	  	driver.get(readProperties("DashboardURL"));
	  	TestDevice deletetestdevice=new TestDevice(driver);
	  	clickAddTestDevice();
		    String phonenumber=deletetestdevice.fetchingPhoneNumber().getText();
		    deletetestdevice.clickTrash().click();
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 	wait.until(ExpectedConditions.visibilityOf(deletetestdevice.popUPMessageDelete()));
		    Log.info("------Pop message is displayed successfully.  .-------");
		    Assert.assertEquals(deletetestdevice.popUPMessageDelete().getText(), "Are you sure you want to delete "+phonenumber+" Test Device?");
		    deletetestdevice.clickOnTrashCancel().click();
		    deletetestdevice.clickTrash().click();
		    deletetestdevice.clickOnTrashYes().click();
		    wait.until(ExpectedConditions.visibilityOf(deletetestdevice.confirmDeletePopup()));
		    deletetestdevice.deleteMessageOK().click();
		    Assert.assertEquals(deletetestdevice.noTestDevice().getText(), "No Test devices");
	}
	@Test
	  public void emptyMobileField() throws IOException {
	  	driver.get(readProperties("DashboardURL"));
	  	TestDevice nomobilenumber=new TestDevice(driver);
	  	clickAddTestDevice();
		    nomobilenumber.clickAddButton().click();
		    Log.info("------Error message displays Please enter valid mobile number  .-------");
		    Assert.assertEquals(nomobilenumber.invalidNumberText().getText(), "Please enter valid mobile number");
		}


	@Test(priority = 1)
	public void cancelSendMessage() throws IOException {
		DashboardPage dashboard=new DashboardPage(driver);
		dashboard.dropdown().click();
		dashboard.logout().click();
		 Log.info("Logged out from Userportal");
		//driver.get(readProperties("DashboardURL"));
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginApplication(readProperties("senmessagename"), readProperties("sendmessagepassword"));
		 Log.info("Logged in to different account");
		TestDevice cancelsendmessage = new TestDevice(driver);
		cancelsendmessage.sendMessageBot().click();
		JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
		scrollPage.executeScript("window.scrollBy(0,2000)", "");
		cancelsendmessage.clickAddTestDevice().click();
		cancelsendmessage.clickSendTestMessage().click();
		Log.info("------Page is navigated to send message page  .-------");
		cancelsendmessage.clickSendTestMessageCancel().click();
		Assert.assertEquals(cancelsendmessage.clickSendTestMessage().getText(), "Send test message");
	}

	@Test(priority = 2)
	public void sendTextMessagePageDisplayed() throws IOException {
		TestDevice sendtestmessagepage = new TestDevice(driver);
		sendtestmessagepage.clickSendTestMessage().click();
		Log.info("------Page is navigated to send message page  .-------");
		Assert.assertEquals(sendtestmessagepage.goBackButton().getText(), "Go back to Test Devices");
		Log.info("Send text message page is displayed");
	}

	@Test(priority = 3)
	public void sendTextMessage() throws IOException, InterruptedException {
		TestDevice sendtestmessage = new TestDevice(driver);
		sendtestmessage.clickSendButton().click();
		Log.info("Pop should be displayed with message sent successfully");
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 wait.until(ExpectedConditions.elementToBeClickable(sendtestmessage.sendMessageAssertText()));
		 Assert.assertEquals(sendtestmessage.sendMessageAssertText().getText(), "Message sent to test device successfully");
		 Log.info("Message is send successfully");
		 sendtestmessage.sendMessageOk().click();
		 
	}

	@Test(priority = 4)
	public void richCard() throws IOException, InterruptedException {
		TestDevice richcard = new TestDevice(driver);
		richcard.clickRichCard().click();
		richcard.clickSendButton().click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 wait.until(ExpectedConditions.elementToBeClickable(richcard.sendMessageAssertText()));
		 Assert.assertEquals(richcard.sendMessageAssertText().getText(), "Message sent to test device successfully");
		 Log.info("rich card sent successfully");
		 richcard.sendMessageOk().click();
	}

	@Test(priority = 5)
	public void suggestedReply() throws IOException, InterruptedException {
		TestDevice suggestedreply = new TestDevice(driver);
		suggestedreply.suggestionReply().click();
		suggestedreply.clickSendButton().click();;
		//suggestedreply.sendMessageOk().click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 wait.until(ExpectedConditions.elementToBeClickable(suggestedreply.sendMessageAssertText()));
		 Assert.assertEquals(suggestedreply.sendMessageAssertText().getText(), "Message sent to test device successfully");
		 Log.info("suggestedReply send successfully");
		 suggestedreply.sendMessageOk().click();
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
