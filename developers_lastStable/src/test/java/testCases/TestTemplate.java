/*
	 * @Author : Anil kumar
	 * Module : Test Template Page
	 * Date   : 2 Dec 2022
	 */
package testCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.BotConsolePage;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import resources.Base;
import resources.Log;

public class TestTemplate  extends Base{
	
	@Parameters("value")
	@BeforeTest
	public void invokeBrowser(String value) throws IOException {
		driver =  driverInitialize(value);
		driver.get(readProperties("BaseURL"));
		LoginPage login = new LoginPage(driver);
		login.loginApplication(readProperties("CreateNewBotEmail"), readProperties("CreateNewBotPassword"));
	}
	
	@Test
	public void templateTestMethod() throws IOException, InterruptedException {
		DashboardPage dashboard = new DashboardPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(dashboard.viewDetails()));
		dashboard.viewDetails().click();
		Log.info("clicked on View Details Icon");
		BotConsolePage console = new BotConsolePage(driver);
		Assert.assertTrue(console.botDetailsLink().isEnabled());
		Log.info("------SUccessfully Redirected to BOT console Page---------");
		driver.get(readProperties("TestTemplatePage"));
		JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
		scrollPage.executeScript("window.scrollBy(0,2000)", "");
		wait.until(ExpectedConditions.elementToBeClickable(console.testTemplateIcon()));
		console.testTemplateIcon().click();
		Log.info("Clicked on Test Template Icon");
		console.testPhoneNumber().sendKeys(readProperties("TestPhoneNumber"));
		console.addButton().click();
		Log.info("Clicked on Add Button");
		wait.until(ExpectedConditions.textToBePresentInElement(console.alreadyExistPopUp(),"Test Device already exist with this number"));
		Assert.assertEquals(console.alreadyExistPopUp().getText(), "Test Device already exist with this number");
		Log.info("Already Test device Exist Message Displayed in the POPUP");
		console.popupBackButton().click();
		Log.info("Clicked on Back Button");
		console.countinueButton().click();
		Log.info("Clicked on Countinue BUtton");
		wait.until(ExpectedConditions.textToBePresentInElement(console.yesNoConfirmText(),"Please press YES to continue with the template test, press NO to go back and make changes."));
		Assert.assertEquals(console.yesNoConfirmText().getText(), "Please press YES to continue with the template test, press NO to go back and make changes.");
		Log.info("Yes or No Confirm POPUP displayed");
		console.yesButton().click();
		Log.info("Clicked on Yes");
		wait.until(ExpectedConditions.textToBePresentInElement(console.testTemplateSuccessMessage(),"Test message(s) sent successfully!"));
		Assert.assertEquals(console.testTemplateSuccessMessage().getText(), "Test message(s) sent successfully!");
		Log.info("----------Successfully Test Message has Sent to the Device----------");
		
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
}
