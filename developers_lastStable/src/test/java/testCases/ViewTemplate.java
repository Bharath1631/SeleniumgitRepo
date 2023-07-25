/*
	 * @Author : Anil kumar
	 * Module : View Template Page
	 * Date   : 8 Dec 2022
	 */
package testCases;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObjects.BotConsolePage;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import resources.Base;
import resources.Log;

public class ViewTemplate extends Base{
	
	
	String TemplateName;
	File JsonFile;
	
	@Parameters("value")
	@BeforeTest
	public void invokeBrowser(String value) throws IOException {
		driver =  driverInitialize(value);
		driver.get(readProperties("BaseURL"));
		LoginPage login = new LoginPage(driver);
		login.loginApplication(readProperties("CreateNewBotEmail"), readProperties("CreateNewBotPassword"));
	}
	
	@Test
	public void downloadTemplate() throws IOException, InterruptedException {
		
		BotConsolePage botConsole = new BotConsolePage(driver);
		DashboardPage dashboard = new DashboardPage(driver);
		WebDriverWait wait = explicitWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(dashboard.viewDetails()));
		driver.get(readProperties("ViewTemplatePage"));
		JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
		scrollPage.executeScript("window.scrollBy(0,2000)", "");
		TemplateName = botConsole.firstTemplateName().getText();
		Log.info("First Template Name is: "+TemplateName);
		Actions actions = new Actions(driver);
		actions.moveToElement(botConsole.templateOptions()).perform();             //Hovering on Template option
		actions.moveToElement(botConsole.downloadTemplate()).click().perform();    //build()- used to compile all the actions into a single step
		Log.info("Clicked on Download JSON file");
		Thread.sleep(2000);
		JsonFile = new File(Base.DownloadsPath+"/"+TemplateName+".json");
		Assert.assertTrue(JsonFile.exists(), "Failed to download Expected document");  
		Log.info("Json Path is: "+JsonFile);
		Log.info("-----------SUccessfully JSON file Downloaded----------");
		Listeners.test.log(Status.INFO,"-----------SUccessfully JSON file Downloaded in the path: "+JsonFile+"----------");
		Log.info("Downloaded File will be Deleted in the TearDown");
	}
	
	@AfterTest
	public void teardown() {
		
		//File JsonFile = new File(Base.DownloadsPath+"/"+TemplateName+".json");
		Log.info("Json File which is Downloaded in this path "+JsonFile +" will be Deleted");
		JsonFile.delete();
		Log.info("Deleted the Downloaded JSON file from the Downloads Path");
		driver.close();
	}
	
	
}
