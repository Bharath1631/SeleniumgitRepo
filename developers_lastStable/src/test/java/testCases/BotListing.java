package testCases;

import org.openqa.selenium.JavascriptExecutor;
import java.io.IOException;

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
import pageObjects.AddTemplatePage;
import pageObjects.TestDevice;
import resources.Base;
import resources.Log;
import pageObjects.LoginPage;
import pageObjects.BotListingObjectsSanity;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;

import pageObjects.LoginPage;

public class BotListing extends Base{
	
	@Parameters("value")
	@BeforeTest
	public void invokeBrowser(String value) throws IOException {
		driver = driverInitialize(value);
		driver.get(readProperties("BaseURL"));
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginApplication(readProperties("botlistingemail"),
				readProperties("botlistingpassword"));
	}
//	@Test
//	public void clickUploadImage() throws InterruptedException {
//		BotListingObjectsSanity clickscreenshot=new BotListingObjectsSanity(driver);
//		clickscreenshot.clickBotViewDetail().click();
//		JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
//	 	scrollPage.executeScript("window.scrollBy(0,1500)", "");
//	 	Thread.sleep(2000);
//	 	clickscreenshot.clickHereToList().click();
//	    Log.info("------clickheretolost button clicked successfully and URL navigated to listing page-------");
//	    Thread.sleep(4000);
//	 	Assert.assertEquals(clickscreenshot.botListingTextverify().getText(), "Bot Store Listing");
//	 	
//		}
	
//	@Test
//	public void selectImage() throws IOException, InterruptedException {
//		BotListingObjectsSanity selectimage=new BotListingObjectsSanity(driver);
//		driver.get(readProperties("DashboardURL"));
//		clickUploadImage();
//	    Log.info("------clickheretolost button clicked successfully and URL navigated to listing page-------");
//	 	Assert.assertEquals(selectimage.botListingTextverify().getText(), "Bot Store Listing");
//	 	selectimage.clickUploadImage().sendKeys(Base.localDir+"/utils/screeshot.jpg");
//	 	
//	 	
//		}

	@Test
	public void selectMoreThanEightImages() throws IOException, InterruptedException {
		BotListingObjectsSanity selecteightimages=new BotListingObjectsSanity(driver);	
		driver.get(readProperties("DashboardURL"));
		selecteightimages.clickBotViewDetail().click();
		
	}
}
