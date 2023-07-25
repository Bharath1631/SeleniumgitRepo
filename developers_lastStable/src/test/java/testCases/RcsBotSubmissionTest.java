package testCases;

import java.io.File;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObjects.AdminDashBoard;
import pageObjects.BotConsolePage;
import pageObjects.Bot_Listing;
import pageObjects.AdminBotsPage;
import pageObjects.Brand_Details;
import pageObjects.Buisness_Name_Verification;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.RcsBotDetailsPage;
import pageObjects.SelectCarriers;
import resources.Base;
import resources.Log;

public class RcsBotSubmissionTest extends Base {

	/*
	 * @Author : Anil kumar
	 * Module : Create New RCS BOT functionality
	 * Date   : 12 Oct 2022
	 */

	int BotID;
	String alpha ="1234567890";
	String randInt = getSaltString(8,alpha);
	String UserEmail;
	String UserPassword;
	String AdminEmail;
	String AdminPassword;
	File UploadedDoc;
	
	
	@Parameters("value")
	@BeforeTest
	public void invokeBrowser(String value) throws IOException {
		driver =  driverInitialize(value);
		driver.get(readProperties("BaseURL"));
		LoginPage loginPage = new LoginPage(driver);
		UserEmail=readProperties("CreateNewBotEmail");
		UserPassword=readProperties("CreateNewBotPassword");
		 AdminEmail = readProperties("AdminEmailID");
		 AdminPassword =readProperties("AdminPassword");
		loginPage.loginApplication(UserEmail,UserPassword);
	}
	
	
	@Test(priority=-1)
	public void verifyCreateNewRcsBotButton() throws IOException, InterruptedException {
		DashboardPage dashboard = new DashboardPage(driver);
		//driver.get(readProperties("DashboardURL")); 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(dashboard.createNewRcsBot()));
		dashboard.createNewRcsBot().click();
		//RcsBotDetailsPage rcsBotDetail = dashboard.createNewRcsBot();
		Log.info("Clicked on Create New RCS BOT button");
		Assert.assertEquals(driver.getCurrentUrl(),readProperties("RcsBotDetailsURL"));
		Log.info("-----------Successfully Entered RCS BOT DETAILs page--------");
		Listeners.test.log(Status.INFO,"-----------Successfully Entered RCS BOT DETAILs page--------");
		RcsBotDetailsPage rcsBotDetail = new RcsBotDetailsPage(driver);
		//Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(rcsBotDetail.transactional()));
		String radio;
		radio = readProperties("CreateNewBotMessageType");
		
		switch (radio.toLowerCase()) {
		case "transactional":
			rcsBotDetail.transactional().click();
			Log.info("Selected Transactional Radio Button");
			break;
		case "promotional":
			rcsBotDetail.promotional().click();
			Log.info("Selected Promotional Radio Button");
			break;
		case "otp":
			rcsBotDetail.otp().click();
			Log.info("Selected OTP Radio Button");
			break;
		default:
			Log.info("Invalid Radio Button Name and going with default Selection");
		}
		

	}
	
	@Test
	public void verifyPrivacyPolicyPage() throws IOException, InterruptedException {
		
		driver.get(readProperties("DashboardURL")); 
		verifyCreateNewRcsBotButton();
		JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
		scrollPage.executeScript("window.scrollBy(0,2000)", "");
		RcsBotDetailsPage rcsBotDetail = new RcsBotDetailsPage(driver);
		rcsBotDetail.privacyPolicy().click();
		//driver.switch_to.window(.driver.window_handles[1]);
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    WebDriverWait wait = explicitWait(driver,10);
		wait.until(ExpectedConditions.urlContains(readProperties("PrivacyPolicyURL")));
	    Assert.assertEquals(driver.getCurrentUrl(), readProperties("PrivacyPolicyURL"));
	    driver.close();
	    driver.switchTo().window(tabs.get(0));
		Log.info("----------Sucessfully Redirected to the Page Privacy policy-----------");
		Listeners.test.log(Status.INFO,"----------Sucessfully Redirected to the Page Privacy policy----------");
	}
	

	
	@Test
	public void verifyTermsofServicePage() throws IOException, InterruptedException {
		
		driver.get(readProperties("DashboardURL")); 
		verifyCreateNewRcsBotButton();
		JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
		scrollPage.executeScript("window.scrollBy(0,2000)", "");
		RcsBotDetailsPage rcsBotDetail = new RcsBotDetailsPage(driver);
		rcsBotDetail.termsofService().click();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    WebDriverWait wait = explicitWait(driver,10);
		wait.until(ExpectedConditions.urlContains(readProperties("TermsofService")));
	    Assert.assertEquals(driver.getCurrentUrl(), readProperties("TermsofService"));
	    driver.close();
	    driver.switchTo().window(tabs.get(0));
		Log.info("--------Sucessfully Redirected to the Terms of Service policy---------");
		Listeners.test.log(Status.INFO,"-------Sucessfully Redirected to the Terms of Service policy--------");
	}
	
	@Test
	public void verifyRBMTermsPage() throws IOException, InterruptedException {
		
		driver.get(readProperties("DashboardURL")); 
		verifyCreateNewRcsBotButton();
		JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
		scrollPage.executeScript("window.scrollBy(0,2000)", "");
		RcsBotDetailsPage rcsBotDetail = new RcsBotDetailsPage(driver);
		rcsBotDetail.rbmTerms().click();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    WebDriverWait wait = explicitWait(driver,10);
		wait.until(ExpectedConditions.urlContains(readProperties("RBMTerms")));
	    Assert.assertEquals(driver.getCurrentUrl(), readProperties("RBMTerms"));
	    driver.close();
	    driver.switchTo().window(tabs.get(0));
		Log.info("------Sucessfully Redirected to the RBM Terms policy-------");
		Listeners.test.log(Status.INFO,"------Sucessfully Redirected to the RBM Terms policy-------");
	}
	
	@Test
	public void verifyRBMTPoliciesPage() throws IOException, InterruptedException {
		
		driver.get(readProperties("DashboardURL")); 
		verifyCreateNewRcsBotButton();
		JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
		scrollPage.executeScript("window.scrollBy(0,2000)", "");
		RcsBotDetailsPage rcsBotDetail = new RcsBotDetailsPage(driver);
		rcsBotDetail.rbmPolicies().click();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    WebDriverWait wait = explicitWait(driver,10);
		wait.until(ExpectedConditions.urlContains(readProperties("RBMPolicies")));
	    Assert.assertEquals(driver.getCurrentUrl(), readProperties("RBMPolicies"));
	    driver.close();
	    driver.switchTo().window(tabs.get(0));
		Log.info("-------Sucessfully Redirected to the RBMPolices page-------");
		Listeners.test.log(Status.INFO,"--------Sucessfully Redirected to the RBMPolices page------");
	}
	
	@Test(priority=1)
	public void createNewBot() throws IOException, InterruptedException, SQLException, InstantiationException, IllegalAccessException  {
		
		JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
		driver.get(readProperties("DashboardURL")); 
		verifyCreateNewRcsBotButton();
		RcsBotDetailsPage rcsBotDetail =new RcsBotDetailsPage(driver);
		rcsBotDetail .botName().sendKeys(readProperties("CreateNewBotName")+randInt);
		Log.info("Bot Name is: "+ readProperties("CreateNewBotName")+randInt);
		Log.info("Entered the BotName");
		rcsBotDetail.brandName().sendKeys(readProperties("CreateNewBotBrandName"));
		Log.info("Entered Brand Name");
		scrollPage.executeScript("window.scrollBy(0,350)", "");
		//Actions actions = new Actions(driver);
		// actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		//scrollPage(0,350);
		rcsBotDetail.uploadBotLogo().click();
		Log.info("Clicked on upload BOT logo");
		rcsBotDetail.selectBotLogo().sendKeys(Base.localDir+"//utils/VI.png");
		Actions crop = new Actions(driver);
		crop.clickAndHold(rcsBotDetail.cropHandle()).moveByOffset(223, 223).release().build().perform(); //Cropped the Image to 224px * 224px
		Log.info("Cropped Image to the 224 pixels Wide x 224 pixels Tall");
		rcsBotDetail.select().click();
		Log.info("Uploaded Bot Logo from local Utils");
		WebDriverWait wait = explicitWait(driver,10);
		Thread.sleep(2000);
		rcsBotDetail.uploadBannerImage().click();
		Log.info("Clicked on upload Banner Image");
		//Thread.sleep(1000);
		rcsBotDetail.selectBotLogo().sendKeys(Base.localDir+"/utils/VI_back(1).png");
		crop.clickAndHold(rcsBotDetail.cropHandle()).moveByOffset(550, 170).release().build().perform(); //Cropped the Image to 1440px * 448px
		Log.info("Cropped Image to the 550 pixels Wide x 170 pixels Tall");
		rcsBotDetail.select().click();
		Log.info("Uploaded Banner Image from local Utils");
		//wait.until(ExpectedConditions.visibilityOf(rcsBotDetail.shortDescription()));
		//wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(rcsBotDetail.opacity())));
		Thread.sleep(2000);
		//scrollPage.executeScript("window.scrollBy(0,350)", "");
		rcsBotDetail.shortDescription().sendKeys(readProperties("CreateNewBotShortDescription"));
		Log.info("Entered Short Description");
		rcsBotDetail.primaryPhoneNumber().sendKeys(readProperties("CreateNewBotPrimaryPhone"));
		Log.info("Entered Primary Phone Number");
		rcsBotDetail.primaryPhoneNumberLabel().sendKeys(readProperties("CreateNewBotprimaryPhoneLabel"));
		Log.info("Entered Primary phone Label");
		rcsBotDetail.primaryEmailId().sendKeys(readProperties("CreateNewBotPrimaryEMail"));
		Log.info("Entered Primary EMAIL ID");
		rcsBotDetail.primaryEmailIdLabel().sendKeys(readProperties("CreateNewBotPrimaryEmailLabel"));
		Log.info("Entered Primary Email Label");
		rcsBotDetail.primaryWebsite().sendKeys(readProperties("CreateNewBotPrimaryWebsite"));
		Log.info("Entered Primary Website URL");
		rcsBotDetail.primaryWebsiteLabel().sendKeys(readProperties("CreateNewBotPrimaryWebsiteLabel"));
		Log.info("Entered Primary Website URL LABEL");
		rcsBotDetail.termsOfUseUrl().sendKeys(readProperties("CreateNewBotTermsofUseURL"));
		Log.info("Entered Terms of Use URL");
		rcsBotDetail.privacyPolicyUrl().sendKeys(readProperties("CreateNewBotPrivacyPolicyURL"));
		Log.info("Entered Privacy policy URL");
		Select rcsAPI = new Select(rcsBotDetail.rcsApi());
		Log.info("clicked on RCSAPI Dropdown");
		rcsAPI.selectByVisibleText(readProperties("CreateNewBotRCSAPI"));
		Log.info("Selected RCSAPI Platform as: "+readProperties("CreateNewBotRCSAPI") );
		rcsBotDetail.chatBotWebhook().sendKeys(readProperties("CreateNewBotChatbotWebhook"));
		Log.info("Entered Webhook URL");
		rcsBotDetail.languagesSupported().sendKeys(readProperties("CreateNewBotLanguagesSupported"));
		Log.info("Entered Supported Languages");
		SelectCarriers carrier = rcsBotDetail.next();
		Log.info("Clicked on Next button");
		
		Assert.assertEquals(driver.getCurrentUrl(), readProperties("SelectCarrierURL"));
		wait.until(ExpectedConditions.elementToBeClickable(carrier.firstCarrierSelect()));
		carrier.firstCarrierSelect().click();
		Log.info("Selected First carrier which is: "+ carrier.firstCarrierName().getText() +"is the country");
		carrier.submit().click();
		Log.info("---------Submitted the New RCS BOT------------");
		Listeners.test.log(Status.INFO,"---------Submitted the New RCS BOT------------");
		wait.until(ExpectedConditions.visibilityOf(carrier.getPopupText()));
		
		Assert.assertEquals(carrier.getPopupText().getText(),readProperties("CreateNewBotSucessPopup1"));
		Log.info(carrier.getPopupText().getText());
		
		Assert.assertEquals(carrier.getNextPopupText().getText(),readProperties("CreateNewBotSucessPopup2"));
		Log.info(carrier.getNextPopupText().getText());
		carrier.gotoDashboard().click();
		
		Assert.assertEquals(driver.getCurrentUrl(),readProperties("DashboardURL"));
		DashboardPage dashboard = new DashboardPage(driver);
		
		wait.until(ExpectedConditions.visibilityOfAllElements(dashboard.recentBotName()));
		Log.info(dashboard.recentBotName().getText());
		
		Assert.assertEquals(dashboard.recentBotStatus().getText(),readProperties("CreateNewBotStatus"));
		Log.info(dashboard.recentBotStatus().getText());
		Listeners.test.log(Status.INFO,"------Entered Dashboard and the Bot status is: "+dashboard.recentBotStatus().getText()+"-------");
		Connection DB = getDBconnection(readProperties("url"), readProperties("user"), readProperties("password"));
		Listeners.test.log(Status.INFO,"---------Database Connection opened Sucessfully-------");
    	PreparedStatement pstmt = DB.prepareStatement("select * from bot where partners_profile_id =399 order by 1 desc limit 1;");
    	//pstmt.setString(1, "Auto"+randString+"@gmial.com");
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			BotID= rs.getInt("id");
			Log.info("BotID is" +BotID);
		}
		
		DB.close();
		Listeners.test.log(Status.INFO,"---------Database Connection Closed Sucessfully-------");
		Log.info("---------Database closed successfully-------");
		
	}
	
	  @Test(priority=2)
	  public void unselectingAndSelectingNewCarriers() throws Exception {
		  
		   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		   
		   DashboardPage dashboard=new DashboardPage(driver);
		   dashboard.dropdown().click();
		   dashboard.logout().click();
		   Log.info("BOt Submitted from the User portal and logged out");
		   LoginPage loginPage = new LoginPage(driver);
		   AdminEmail = readProperties("AdminEmailID");
		   AdminPassword =readProperties("AdminPassword");
		   loginPage.loginApplication(AdminEmail,AdminPassword);
		   Log.info("Logged in to the Admin Portal");
		   AdminDashBoard admindashboard=new AdminDashBoard(driver);
		   Log.info("Logged in to the AdminDashboard");
		   admindashboard.bots().click();
		   Log.info("Clicked on Bots Tab");
		   AdminBotsPage adminCreateBot=new AdminBotsPage(driver);
		   //createbot.clickSubmittedDate().click();
		   driver.get("https://partner-staging.dotgo.com/dotgo-admin/verification-details/"+encryptID(BotID)+"/creation");
		   Log.info("BotID is"+encryptID(BotID));
		   Thread.sleep(1000);
		   driver.navigate().refresh();
		   adminCreateBot.clickApprove().click();	
		   Thread.sleep(2000);
		   driver.navigate().back();
		   adminCreateBot.clickApprove().click();
		   Log.info("Clicked on Approve from Admin portal");
		   wait.until(ExpectedConditions.visibilityOf(adminCreateBot.selectMaapAgent()));
		   //Thread.sleep(2000);
	       adminCreateBot.selectMaapAgent().click();
	       Actions key = new Actions(driver); 
		   key.sendKeys(Keys.DOWN, Keys.DOWN, Keys.ENTER).perform();
		   Log.info("Selected MaapAgent as Google");
		   adminCreateBot.clickBrowse().sendKeys(Base.localDir+"/utils/rbm-fedex-awqgeqs-c8816fea04fa.json");
		   Thread.sleep(2000);
		   adminCreateBot.upload().click();
		   Log.info("uploaded JSON");
		   adminCreateBot.maapAssignedID().sendKeys(readProperties("MaapassignedID")+encryptID(BotID));
		   Log.info("Entered MaapAssigned ID");
		   adminCreateBot.extraInfo().sendKeys(readProperties("ExtrajsonInfo"));
		   Log.info("Entered Extra JSON");
		   adminCreateBot.submitAgent().click();
		   JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
		   scrollPage.executeScript("window.scrollBy(0,100)", "");
		   wait.until(ExpectedConditions.visibilityOf(adminCreateBot.status()));
		   adminCreateBot.confirmApprove().click();
		   adminCreateBot.clickYes().click();
		   Log.info("Submitted Agent");
		   adminCreateBot.enterActionReason().sendKeys(readProperties("createactionreason"));
		   adminCreateBot.actionReasonApprove().click();
		   Log.info("Approved the Bot with the Reason");
		   Thread.sleep(2000);
		   adminCreateBot.clickOK().click();
		   dashboard.dropdown().click();
		   dashboard.logout().click();
		   Log.info("Logged out from Admin portal");
		   loginPage.loginApplication(UserEmail,UserPassword);
		   Log.info("Logged in to the User Portal");
		   wait.until(ExpectedConditions.elementToBeClickable(dashboard.viewDetails()));
		   dashboard.viewDetails().click();
		   //driver.get("https://partner-staging.dotgo.com/developer/bot-console/"+BotID);
		   //Thread.sleep(3000);
		   wait.until(ExpectedConditions.urlContains("https://partner-staging.dotgo.com/developer/bot-console/"));
		   Log.info("Clicked on View Details and Entered BOT Console page");
		   BotConsolePage botConsole=new BotConsolePage(driver);
		   //JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
		  
		   scrollPage.executeScript("window.scrollBy(0,100)", "");
		   Log.info("Scrolldown the Page");
		   wait.until(ExpectedConditions.visibilityOf(botConsole.verificationStatus()));
		   botConsole.clickVerificationandLaunch().click();
		   Log.info("Clicked on Verification and Launch Button");
		   botConsole.editOrAddCarriers().click();
		   Log.info("Clicked on ADD or Edit Carrier Button");
		   botConsole.selectSecondCarrier().click();
		   Log.info("Selected second carrier from the available List");
		   scrollPage.executeScript("window.scrollBy(0,2000)", "");
		   botConsole.submit().click();
		   Log.info("Clicked on Submit");
		   botConsole.yes().click();
		   Log.info("clicked Yes on the POP UP");
		   botConsole.clickNext().click();
		   Log.info("Clicked on Next Button");
		   Assert.assertEquals(botConsole.botDetailsandExperiencePageText().getText(), "Bot Details & Experience");
		   Log.info("------Successfully Redirected to the Bot Detail and Experinece Page---------");
		   Listeners.test.log(Status.INFO,"------Successfully Redirected to the Bot Detail and Experinece Page---------");
		   
	  }
	
	  @Test(priority=3)
	  public void submitAfterBrandDetailsPage() throws IOException, InterruptedException {
		  
		   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		   wait.until(ExpectedConditions.elementToBeClickable(createbot.clickOK()));
		   BotConsolePage botConsole=new BotConsolePage(driver);
		  // wait.until(ExpectedConditions.visibilityOf(botConsole.clickUploadImages()));
		   botConsole.clickUploadImages().sendKeys(Base.localDir+"/utils/screeshot.jpg");
		   botConsole.ChatbotWWebhook().sendKeys(readProperties("GSMAChatbotWebhook"));
		   botConsole.enterVideoUrl().sendKeys(readProperties("VideoURLs"));
		   botConsole.eneterMessage().sendKeys(("opted-in"));
		   botConsole.triggerActions().sendKeys(readProperties("triggermessages"));
		   botConsole.enterInteractionType().sendKeys(readProperties("botinteraction"));
		   botConsole.enterOptOutMessage().sendKeys(readProperties("optout"));
		   botConsole.enterinstructions().sendKeys(readProperties("accessinstructions"));
		   JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
		   scrollPage.executeScript("window.scrollBy(0,200)", "");
		   //wait.until(ExpectedConditions.elementToBeClickable(botConsole.clickNextVerificationPage()));
		   Thread.sleep(1000);
		   botConsole.clickNextVerificationPage().click();
		   Log.info("Entered all the Details and clicked on Next");
		   wait.until(ExpectedConditions.urlMatches(readProperties("BrandDetails")));
		   scrollPage.executeScript("window.scrollBy(0,2000)", "");
		   Brand_Details branddetails=new Brand_Details(driver);
		   wait.until(ExpectedConditions.elementToBeClickable(branddetails.clickNext()));
		   branddetails.clickNext().click();
		   Buisness_Name_Verification businessverification=new Buisness_Name_Verification(driver); 
		   wait.until(ExpectedConditions.visibilityOf(businessverification.bussinessVerificationPageText()));
		   Assert.assertEquals(businessverification.bussinessVerificationPageText().getText(), "Business Verification");
		   Log.info("-------Successfully Entered Business Verification Page----------");
		   Listeners.test.log(Status.INFO,"------Successfully Entered Business Verification Page---------");
	   
	  }
	  
	  @Test(priority=4)
	  public void verifyLegalBusinessName() throws IOException, InterruptedException {
		  
		   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		   wait.until(ExpectedConditions.elementToBeClickable(createbot.clickOK()));
		   Buisness_Name_Verification businessverification=new Buisness_Name_Verification(driver); 
		   wait.until(ExpectedConditions.elementToBeClickable(businessverification.selectDocumentType()));
		   Select document =  new Select(businessverification.selectDocumentType());
		   document.selectByValue("Aadhar card");
		   businessverification.selectFile().sendKeys(Base.localDir+"/utils/screeshot.jpg");
		   wait.until(ExpectedConditions.elementToBeClickable(businessverification.downloadIcon1()));
		   Log.info("Uploaded Documentation of your business’s legal name.");
		   Assert.assertTrue(businessverification.downloadIcon1().isEnabled());
		   Assert.assertTrue(businessverification.deleteIcon1().isEnabled());
		   Log.info("------Successfully Document Uploaded, Download and Delete Buttons are Dispalyed---------");
		   Listeners.test.log(Status.INFO,"-------Successfully Document Uploaded, Download and Delete Buttons are Dispalyed---------");
		   
		  
	  }
	  
	  @Test(priority=5)
	  public void verifyLegalBusinessAddress() throws IOException, InterruptedException {
		  
		   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		   wait.until(ExpectedConditions.elementToBeClickable(createbot.clickOK()));
		   Buisness_Name_Verification businessverification=new Buisness_Name_Verification(driver); 
		   wait.until(ExpectedConditions.elementToBeClickable(businessverification.BuisnessselectDocumentType()));
		   Select buisnessdocument =  new Select(businessverification.BuisnessselectDocumentType());
		   buisnessdocument.selectByValue("Aadhar card");
		   businessverification.selectFile().sendKeys(Base.localDir+"/utils/screeshot.jpg");
		   wait.until(ExpectedConditions.elementToBeClickable(businessverification.downloadIcon2()));
		   Log.info("Uploaded Documentation of your business’s legal Address.");
		   Assert.assertTrue(businessverification.downloadIcon2().isEnabled());
		   Assert.assertTrue(businessverification.deleteIcon2().isEnabled());
		   Log.info("------Successfully Document Uploaded, Download and Delete Buttons are Dispalyed---------");
		   Listeners.test.log(Status.INFO,"-------Successfully Document Uploaded, Download and Delete Buttons are Dispalyed----------");
		  
	  }
	  
	  @Test(priority=6)
	  public void downloadAfterUploadingDocument() throws IOException, InterruptedException {
		  
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		   wait.until(ExpectedConditions.elementToBeClickable(createbot.clickOK()));
		  Buisness_Name_Verification businessverification=new Buisness_Name_Verification(driver); 
		  wait.until(ExpectedConditions.elementToBeClickable(businessverification.downloadIcon2()));
		  businessverification.downloadIcon2().click();
		  wait.until(ExpectedConditions.visibilityOf(businessverification.businessAddressDocName()));
		  UploadedDoc = new File(Base.DownloadsPath+"/"+businessverification.businessAddressDocName().getText());
		  Thread.sleep(2000);
		  Assert.assertTrue(UploadedDoc.exists(), "Failed to download Expected document");  
		  Log.info("Document Path is: "+UploadedDoc);
		  Log.info("-----------SUccessfully Document file Downloaded----------");
		  Listeners.test.log(Status.INFO,"-----------SUccessfully Document file Downloaded in the path: "+UploadedDoc+"----------");
		  Log.info("Downloaded File will be Deleted in the TearDown");
		  Listeners.test.log(Status.INFO,"----Downloaded File will be Deleted in the TearDown------");
		  
	  }
	  
	  @Test(priority=7)
	  public void RedirectToPaymentPage() throws IOException, InterruptedException {
		  
		  Buisness_Name_Verification businessverification=new Buisness_Name_Verification(driver);
		  businessverification.clickNext().click(); 
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  wait.until(ExpectedConditions.visibilityOf(businessverification.errorWithOutCheckBox()));
		  Assert.assertEquals(businessverification.errorWithOutCheckBox().getText(), "Please accept the terms to proceed.");
		  Log.info("CheckBox Not Selected so Getting the Error Message as 'Please accept the terms to proceed.'");
		  Listeners.test.log(Status.INFO,"--------CheckBox Not Selected so Getting the Error Message as 'Please accept the terms to proceed.'----");
		  businessverification.acceptMessage().click();
		  Log.info("Selected CheckBox");
     	  businessverification.clickNext().click();
		  Log.info("Clicked on Next Button");
		  Assert.assertEquals(businessverification.summaryPageText().getText(), "Payment Details");
		  Log.info("-------Successfully Redirected To the Payment Page----------");
		  Listeners.test.log(Status.INFO,"-------Successfully Redirected To the Payment Page---------");
		  Assert.assertEquals(businessverification.launchFeesText().getText(), "One Time Fee");
		  Assert.assertEquals(businessverification.maintainanceFeesText().getText(), "Recurring Fee (charged after 12 Months)");
		  Log.info("---------Successfully Launch Fees and MaintainanceFees is Dispalying---------------");
		  Listeners.test.log(Status.INFO,"---------Successfully Launch Fees and MaintainanceFees is Dispalying---------------");
		  
		  
	  }
	  
	  @Test(priority=8)
	  public void SubmitBusinessVerificationDocs() throws IOException, InterruptedException {
		  
		  JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
		  scrollPage.executeScript("window.scrollBy(0,700)", "");
		  Buisness_Name_Verification businessverification=new Buisness_Name_Verification(driver);
		  businessverification.paymentSubmit().click();
		  Log.info("Clicked on Payment submit Button");
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  wait.until(ExpectedConditions.elementToBeClickable(businessverification.goToDashBoard()));
		  Assert.assertTrue( businessverification.goToDashBoard().isEnabled());
		  Log.info("------Sucessfully PopUP is displayed Successfully------------");
		  businessverification.goToDashBoard().click();
		  Log.info("CLicked on GOTO dahsboard");
		  Listeners.test.log(Status.INFO,"------Sucessfully PopUP is displayed Successfully and GOTO Dashboard Button is provided------------");
		  
	  }
	  
	  @Test(priority=9)
	  public void viewLaunchDetails() throws Exception {
		  
		   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		   wait.until(ExpectedConditions.elementToBeClickable(createbot.clickOK()));
		   DashboardPage dashboard=new DashboardPage(driver);
		   BotConsolePage botConsole=new BotConsolePage(driver);
		   AdminBotsPage adminCreateBot=new AdminBotsPage(driver);
		   LoginPage loginPage = new LoginPage(driver);
		   AdminDashBoard admindashboard=new AdminDashBoard(driver);
		   dashboard.dropdown().click();
		   dashboard.logout().click();
		   Log.info("Logged out from Userportal");
		   loginPage.loginApplication(AdminEmail,AdminPassword);
		   Log.info("Logged in to Admin Portal");
		   admindashboard.bots().click();
		   driver.get("https://partner-staging.dotgo.com/dotgo-admin/verification-details/"+encryptID(BotID)+"/verification");
		   Log.info("Entered BOT Verification Page"); 
		   wait.until(ExpectedConditions.elementToBeClickable(adminCreateBot.clickApprove()));
		   adminCreateBot.clickApprove().click();
		   adminCreateBot.clickYes().click();
		   adminCreateBot.enterActionReason().sendKeys(readProperties("adminbotapprovereason"));
		   adminCreateBot.actionReasonApprove().click();
		   Log.info("Verified the Bot with reason");
		   wait.until(ExpectedConditions.elementToBeClickable(adminCreateBot.oK()));
		   Thread.sleep(2000);
		   adminCreateBot.oK().click();
		   wait.until(ExpectedConditions.elementToBeClickable(dashboard.dropdown()));
		   dashboard.dropdown().click();
		   dashboard.logout().click();
		   Log.info("logged out from Admin Portal");
		   loginPage.loginApplication(UserEmail,UserPassword);
		   Log.info("Logged in to the  USER POrtal");
		   wait.until(ExpectedConditions.elementToBeClickable(dashboard.viewDetails()));
		   driver.get("https://partner-staging.dotgo.com/developer/bot-console/"+encryptID(BotID));
		   Thread.sleep(3000);
//		   JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
//		   scrollPage.executeScript("window.scrollBy(0,1500)", "");
//		   scrollPage.executeScript("window.scrollBy(0,300)", "");
		   //scrollPage.executeScript("arguments[0].scrollIntoView(true);", botConsole.viewLaunchDetails()); 
//		   Actions actions = new Actions(driver);
//		   actions.moveToElement(botConsole.viewLaunchDetails()).click().perform();
//		   wait.until(ExpectedConditions.elementToBeClickable(botConsole.viewLaunchDetails()));
		  // botConsole.viewLaunchDetails().click();
		   driver.get("https://partner-staging.dotgo.com/developer/launch-details/"+encryptID(BotID)+"/1/console");
		   Log.info("Clicked on View Launch Details");
		   wait.until(ExpectedConditions.visibilityOf(botConsole.launchDetailsTablecolumn1()));
		   Assert.assertEquals(botConsole.launchDetailsTablecolumn1().getText(), "Carrier");
		   Assert.assertEquals(botConsole.launchDetailsTablecolumn2().getText(), "Country");
		   Assert.assertEquals(botConsole.launchDetailsTablecolumn3().getText(), "Status");
		   Assert.assertEquals(botConsole.launchDetailsTablecolumn4().getText(), "Last Update");
		   Log.info("------Sucessfully Launch Details Displayed with columns 1.Carrier, 2.country, 3.Status, 4.Last Update-----------");
		   Listeners.test.log(Status.INFO,"-----Sucessfully Launch Details Displayed with columns 1.Carrier, 2.country, 3.Status, 4.Last Update-----------");
		   
		  
	  }
	  
	  @Test(priority=10)
	   public void selectCarrier() throws IOException {
		  
		  BotConsolePage botConsole = new BotConsolePage(driver);
		  botConsole.clickHere().click();
		  Log.info("clicked on 'Click here' to launch the bots in other carriers");
          SelectCarriers selectcarrier=new SelectCarriers(driver);
          JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
		  scrollPage.executeScript("window.scrollBy(0,100)", "");
		  WebDriverWait wait = explicitWait(driver,10);
		  wait.until(ExpectedConditions.elementToBeClickable( selectcarrier.globacomNigeria()));
		  selectcarrier.globacomNigeria().click();
		  Log.info("Selected NIgeria carrier");
		  scrollPage.executeScript("window.scrollBy(0,2000)", "");
//	      selectcarrier.mtnMigeris().click();
//	      selectcarrier.relienceJio().click();
	      selectcarrier.submit().click();
	      Log.info("Clicked on Submit");
	      Assert.assertTrue(selectcarrier.clickYes().isEnabled());
	      Log.info("-----Successfully POP UP displayed with Yes or NO--------");
	      selectcarrier.clickYes().click();
	      Log.info("Clicked on Yes and Request for the selected carrier will be Submitted");
	      selectcarrier.clickOK().click();
	      Listeners.test.log(Status.INFO,"------Successfully POP UP displayed with Yes or NO--------");
	   
	  } 
	  
	  @Test(priority=11)
	   public void previewListing() throws Exception {

		  DashboardPage dashboard=new DashboardPage(driver);
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       	  wait.until(ExpectedConditions.elementToBeClickable(dashboard.viewDetails()));
		  driver.get("https://partner-staging.dotgo.com/developer/bot-console/"+encryptID(BotID));
		  JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
		  scrollPage.executeScript("window.scrollBy(0,700)", "");
		  BotConsolePage botConsole = new BotConsolePage(driver);
		  wait.until(ExpectedConditions.elementToBeClickable(botConsole.clickHereToList()));
		  botConsole.clickHereToList().click();
		  Bot_Listing botList=new Bot_Listing(driver);
		  botList.addDescription().sendKeys(readProperties("description"));
		  botList.addcategory().click();
		  //Thread.sleep(3000);
		  Actions key = new Actions(driver);
		  key.sendKeys(Keys.DOWN, Keys.ENTER).perform();
		  botList.adddevelopedby().sendKeys(readProperties("developedby"));
		  botList.previewListing().click();
		  //Thread.sleep(2000);
		  wait.until(ExpectedConditions.urlContains("https://partner-staging.dotgo.com/developer/listing/"));
		  Assert.assertEquals(driver.getCurrentUrl(), "https://partner-staging.dotgo.com/developer/listing/"+encryptID(BotID));
		  Log.info("----Successfully Redirected to Preview Page-----");
		  scrollPage.executeScript("window.scrollBy(0,2000)", "");
		  Assert.assertTrue(botList.submitForListing().isEnabled());
		  Assert.assertTrue(botList.backToEdit().isEnabled());
		  Log.info("Back to Edit and Submit for listing Buttons are Displayed");
		  Listeners.test.log(Status.INFO,"-----Successfully Redirected to Preview Page----");
		  
		  
	  }
	
	  @Test(priority=12)
	   public void submitForListing() throws IOException, InterruptedException {
		  
		  
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		   wait.until(ExpectedConditions.elementToBeClickable(createbot.clickOK()));
		  Bot_Listing botList=new Bot_Listing(driver); wait.until(ExpectedConditions.elementToBeClickable(botList.submitForListing()));
		  botList.submitForListing().click();
		  wait.until(ExpectedConditions.elementToBeClickable(botList.clickConfirm()));
		  Assert.assertTrue(botList.clickConfirm().isEnabled());
		  Assert.assertTrue(botList.cancel().isEnabled());
		  Log.info("Successfully POP UP displayed with the cancel and cofirm Buttons");
		  botList.clickConfirm().click();
		  wait.until(ExpectedConditions.elementToBeClickable(botList.successPOPUP()));
		  Log.info("clicked on confirm Button");
		  //Thread.sleep(2000);
		  wait.until(ExpectedConditions.visibilityOf(botList.successPOPUP()));
		  Assert.assertEquals(botList.successPOPUP().getText(), "Submission was successful!");
		  Log.info("--------Success message POP UP displayed with the GOTO dashboard button-----------");
		  botList.goToDashboard().click();
		  Log.info("clicked on GOTO Dashboard Button");
		  Assert.assertEquals(driver.getCurrentUrl(), readProperties("DashboardURL"));
		  Log.info("---------Successfully Redirected to Dashboard Page------------");
		  Listeners.test.log(Status.INFO,"---------Successfully Redirected to Dashboard Page------------");
		  
	  }
		  
	  
	  
	 

	  
	@AfterTest
	public void tearDown() {
	    Log.info("Document File which is Downloaded in this path "+UploadedDoc +" will be Deleted");
		UploadedDoc.delete();
		Log.info("Deleted the Downloaded document file from the Downloads Path");
		driver.quit();
	}
	
	
	
}
