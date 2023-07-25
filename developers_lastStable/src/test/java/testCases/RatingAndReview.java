package testCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.DirectoryDashboard;
import pageObjects.DirectoryHomePage;
import pageObjects.LoginPage;

import resources.Base;
import resources.Log;

public class RatingAndReview extends Base {
	
	
	String ratings="0";
	String reviews="0";
	
	@Parameters("value")
	@BeforeTest
	public void invokeBrowser(String value) throws IOException {
		
		driver = driverInitialize(value);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5)); 
		driver.get(readProperties("BaseURL"));
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginApplication(readProperties("DevPortalBotUserID"),
		readProperties("DevPortalBOtUserPassword"));
//		DashboardPage dashboard = new DashboardPage(driver);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOf(dashboard.viewDetails()));
//		ratings = dashboard.secondBotRatings().getText();
//		Log.info("value of rating is: "+ratings);
//		reviews = dashboard.secondBotReviews().getText();
//		Log.info("Value of review is: "+reviews);
	}

	@Test
	public void withoutRating() throws IOException {
		
		driver.get(readProperties("DashboardURL"));
		DashboardPage dashboard = new DashboardPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 	wait.until(ExpectedConditions.visibilityOf(dashboard.viewDetails()));
	 	Assert.assertEquals(dashboard.firstBotRatings().getText(), "-");
	 	Log.info("---------Rating Count is not reflecting without Rating------------");
	 	
		
	}
	
	@Test
	public void withoutReviews() throws IOException {
		
		driver.get(readProperties("DashboardURL"));
		DashboardPage dashboard = new DashboardPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(dashboard.viewDetails()));
		Assert.assertEquals(dashboard.firstBotReviews().getText(), "-");
		Log.info("---------Reviews Count is not reflecting without any Reviews------------");
	}
	
	
	public void giveRatingfromDirectory() throws IOException, InterruptedException {
		
		
		 try
		    {
			 driver.get(readProperties("DirectoryURL")); //takes a long time here. More than 40 seconds to complete whole page
		    }
		    catch(WebDriverException e)
		    {
		        Log.info("Not loaded successfully");
		    }
		    finally
		    {
		        // It will perform your steps either if page loaded correctly during timeout set or after timeout expired
		        //here I don't want to wait too long
		        // <input type="text" id="tp-test-selenium" />
		    	JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
//				scrollPage.executeScript("window.stop()", "");
				DirectoryHomePage directoryhome = new DirectoryHomePage(driver);
				directoryhome.signIn().click();
				Log.info("clicked on SignIn button");
				LoginPage login = new LoginPage(driver);
				Thread.sleep(2000);
				login.email().sendKeys(readProperties("DirectoryUserID"));
				Log.info("Entered UserID with Phone Number");
				login.password().sendKeys(readProperties("DirectoryPassword"));
				Log.info("Entered Password");
				try {
				login.submit().click();
				Log.info("Clicked on Submit Button");
				}
				catch (Exception e){
					Log.info("Page not laoded Successfully");
					
				}
				finally {
					driver.get("https://portal-staging.dotgo.com/bot_details/bot1/rcs?id=2667");
					Log.info("opened Bot Reviews Page");
					scrollPage.executeScript("window.scrollBy(0,500)", "");
					Log.info("Scrolled the page little");
					DirectoryDashboard directoryDashboard = new DirectoryDashboard(driver);
					Thread.sleep(2000);
					directoryDashboard.myReview().click();
					Log.info("Clicked on My Review Button");
					Thread.sleep(1000);
					//directoryDashboard.rating3().click();
					directoryDashboard.review().sendKeys("This is Automated Review"); //I should be able to access this text input without waiting 40 seconds
			   
				}
			}
		
		
		
	}
	
	@Test(priority=1)
	public void giveRatingfromDirectoryAndCancel() throws IOException, InterruptedException {
		
		giveRatingfromDirectory();
		DirectoryDashboard directoryDashboard = new DirectoryDashboard(driver);
		directoryDashboard.Cancel().click();
		Log.info("------------Successfully Clicked on Cancel Button--------------");
		
	}
	
	@Test(priority=2)
	public void giveRatingfromDirectoryAndUpdate() throws IOException, InterruptedException {
		
		//giveRatingfromDirectory();
		DirectoryDashboard directoryDashboard = new DirectoryDashboard(driver);
		directoryDashboard.myReview().click();
		Thread.sleep(1000);
		directoryDashboard.rating3().click();
		Log.info("clicked on Rating 3 star");
		directoryDashboard.review().clear();
		Log.info("cleared the Review Text Area");
		directoryDashboard.review().sendKeys("This is Automated Review");
		Log.info("Entered the Reveiw");
		directoryDashboard.update().click();
		Log.info("Clicked on Update Button");
	    Assert.assertEquals(directoryDashboard.successfullToastMessage().getText(), "Review has been updated!");
	    Log.info("--------------Successfully Review has been Updated---------------");
		
	}
	
	
	@Test(priority=3)
	public void withRating() throws IOException {
		
		driver.get(readProperties("DashboardURL"));
		DashboardPage dashboard = new DashboardPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 	wait.until(ExpectedConditions.visibilityOf(dashboard.viewDetails()));
	 	if(ratings.equals(dashboard.secondBotRatings().getText())) {
	 		Assert.fail();
	 	}else {
	 		Log.info("--------Successfully Rating Added---------------");
	 	}
	  
		
	}
	
	@Test(priority=3)
	public void withReviews() throws IOException {
		
		driver.get(readProperties("DashboardURL"));
		DashboardPage dashboard = new DashboardPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(dashboard.viewDetails()));
		if(reviews.equals(dashboard.secondBotReviews().getText())) {
	 		Assert.fail();
	 	}else {
	 		Log.info("--------Successfully Review Added--------------");
	 	}
	}
	
	
	
}
