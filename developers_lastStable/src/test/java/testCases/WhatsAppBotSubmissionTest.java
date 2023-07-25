/*
	 * @Author : Anil kumar
	 * Module : Create New RCS BOT functionality
	 * Date   : 19 Oct 2022
	 */
	
package testCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
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

import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.WhatsappBotDetails;
import pageObjects.WhatsappPreview;
import resources.Base;
import resources.Log;

public class WhatsAppBotSubmissionTest extends Base {
	
	@Parameters("value")
	@BeforeTest
	public void invokeBrowser(String value) throws IOException {
		driver =  driverInitialize(value);
		driver.get(readProperties("BaseURL"));
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginApplication(readProperties("CreateNewBotEmail"),readProperties("CreateNewBotPassword"));
	}
	
	
	@Test
	public void createWhatsAppBotButton() throws IOException {
		driver.get(readProperties("DashboardURL"));
		Log.info("Entering Dashboard Page");
		JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
		//scrollPage.executeScript("window.scrollBy(0,2000)", "");
		//scrollPage.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		DashboardPage dashboard = new DashboardPage(driver);
		scrollPage.executeScript("arguments[0].scrollIntoView();", dashboard.whatsAppBotCreateLink());
		Log.info("scrolled Down");
		dashboard.whatsAppBotCreateLink().click();
		Log.info("clicked on Click Here Button");
		Assert.assertEquals(driver.getCurrentUrl(), readProperties("WhatsappBotDetailsPage"));
		Log.info("------Successfully Redirected to WhatsAppBotDetail Page-------");
		Listeners.test.log(Status.INFO,"-----Successfully Redirected to WhatsAppBotDetail Page------");
		
		
	}
	
	@Test
	public void whatsappPreviewPage() throws IOException, InterruptedException {
		createWhatsAppBotButton();
		WhatsappBotDetails whatsappBotDetails = new WhatsappBotDetails(driver);
		whatsappBotDetails.botName().sendKeys(readProperties("WhatsappBotName"));
		Log.info("Enter the BOt Name");
		whatsappBotDetails.brandName().sendKeys(readProperties("WhatsappBotBrandName"));
		Log.info("Enter the Brand Name");
		whatsappBotDetails.botWebsiteUrl().sendKeys(readProperties("WhatsappBotBrandWebsite"));
		Log.info("Enter the WhatsappBotBrandWebsite URL");
		whatsappBotDetails.uploadBotLogo().click();
		Log.info("Clicked on UPload BOT logo");
		whatsappBotDetails.uploadBotImage().sendKeys(Base.localDir+"//utils/VI.jpg");
		Log.info("Added Image for the Bot LOGO");
		Actions crop = new Actions(driver);
		crop.clickAndHold(whatsappBotDetails.cropHandle()).moveByOffset(223, 223).release().build().perform(); //Cropped the Image to 224px * 224px
		Log.info("Cropped Image to the 224 pixels Wide x 224 pixels Tall");
		whatsappBotDetails.select().click();
		Log.info("Clicked on select Button");
		whatsappBotDetails.uploadScreenshots().sendKeys(Base.localDir+"//utils/VI_back.png");
		Log.info("Uploaded Screeshot");
		Thread.sleep(2000);
		whatsappBotDetails.shortDescription().sendKeys(readProperties("WhatsappBotShortDesc"));
		Log.info("Entered Short Description");
		whatsappBotDetails.longDescription().sendKeys(readProperties("WhatsappBotLongDesc"));
		Log.info("Entered Long Description");
		whatsappBotDetails.botWebsiteUrl().sendKeys(readProperties("WhatsappBotWebsiteURL"));
		Log.info("Entered WhatsappBotWEbsite URL");
		whatsappBotDetails.developedBy().sendKeys(readProperties("WhatsappBotDevelopedBy"));
		Log.info("Entered the WhatsappBot Developed BY");
		whatsappBotDetails.supportEmail().sendKeys(readProperties("WhatsappBotSupportEmail"));
		Log.info("Entered WhatsappBot Support Email");
		Select whatsappcountry = new Select(whatsappBotDetails.whatsappNumberCountry());
		whatsappcountry.selectByVisibleText("India");
		Log.info("Selected country code as India");
		whatsappBotDetails.whatsappNumber().sendKeys(readProperties("WhatsappBotPhNumber"));
		Log.info("Entered Whatsapp Phone NUmber");
		whatsappBotDetails.launchDate().sendKeys(readProperties("WhatsappBotlaunchDate"));
		Log.info("Entered WhatsappBOt lanuch Date");
		whatsappBotDetails.termsOfUse().sendKeys(readProperties("WhatsappBotTermsofURL"));
		Log.info("Entered Whatsapp Terms of URL");
		whatsappBotDetails.privacyPolicy().sendKeys(readProperties("WhatsappBotPrivacypolicy"));
		Log.info("Entered privacy policy");
		whatsappBotDetails.next().click();
		Log.info("Clicked on Next Button");
		WhatsappPreview whatsappPreview = new WhatsappPreview(driver);
		//Thread.sleep(1000);
		WebDriverWait wait = explicitWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(whatsappPreview.previewText()));
		Assert.assertEquals(whatsappPreview.previewText().getText(), "Preview");
		Log.info("-----Sucessfully Entered the PREVIEW PAGE--------");
		Listeners.test.log(Status.INFO,"------Sucessfully Entered the PREVIEW PAGE----------");
		
		
		
	}
	
	@Test
	public void clickOnSubmitforListing() throws IOException, InterruptedException {
		whatsappPreviewPage();
		JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
		WhatsappPreview whatsappPreview = new WhatsappPreview(driver);
		scrollPage.executeScript("arguments[0].scrollIntoView();",whatsappPreview.submitForListing());
		Log.info("Scrolling the Page to Down till the BUtton is visible");
		whatsappPreview.submitForListing().click();
		Log.info("Clicked on Submit Button");
		WebDriverWait wait = explicitWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(whatsappPreview.popUpMessage()));
		Assert.assertEquals(whatsappPreview.popUpMessage().getText(), "Please confirm your submission");
		Log.info("----Successfully Confirm PopUP is Displayed-------");
		Listeners.test.log(Status.INFO,"----Successfully Confirm PopUP is Displayed-------");
		
	}
	
	@Test
	public void clickonConfirmButton() throws IOException, InterruptedException {
		clickOnSubmitforListing();
		WhatsappPreview whatsappPreview = new WhatsappPreview(driver);
		whatsappPreview.popUpConfirm().click();
		Log.info("Clicked on Confirm Button");
		//Assert.assertEquals(whatsappPreview.popUpText().getText(), "Please confirm your submission");
		Log.info("---Successfully PopUP is displayed with Dashboard Button in it-------");
		Listeners.test.log(Status.INFO,"------Successfully PopUP is displayed with Dashboard Button in it---------");
		whatsappPreview.gotoDashboard().click();
		Log.info("Clicked on Dashboard Button");
		Assert.assertEquals(driver.getCurrentUrl(), readProperties("DashboardURL"));
		Log.info("Successfully Redirected to Dashboard Page");
		DashboardPage dashboard = new DashboardPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(dashboard.whatsAppBotListedName()));
		Assert.assertEquals(dashboard.whatsAppBotListedName().getText(), readProperties("WhatsappBotName"));
		Assert.assertEquals(dashboard.WhatsAppBotStatus().getText(), "Submitted");
		Log.info("-----Successfully " + readProperties("WhatsappBotName")+ " BOT Status is "+ dashboard.WhatsAppBotStatus().getText()+"-------");
		Listeners.test.log(Status.INFO,"-----Successfully " +readProperties("WhatsappBotName")+ " BOT Status is "+ dashboard.WhatsAppBotStatus().getText()+"-------");
		
		
		
	}

	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
