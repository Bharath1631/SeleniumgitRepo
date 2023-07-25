/*
 * @Author : Anil kumar
	 * Module : Campaign Management TestCases
	 * Date   : 07 March 2023
	 */
package testCases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.AddNewCampaign;
import pageObjects.CampaignScheduleManagement;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.MyCampaigns;
import resources.Base;
import resources.Log;

public class CampaignManagement extends Base{
	
	public String rand = getSaltString(3,"Abcd1234");
	
	
	@Parameters("value")
	@BeforeTest
	public void invokeBrowser(String value) throws IOException {
		driver =  driverInitialize(value);
		driver.get(readProperties("BaseURL"));
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginApplication(readProperties("CreateNewBotEmail"),readProperties("CreateNewBotPassword"));
	}
	
	
	public void newCampaign() throws IOException, InterruptedException {
		
		driver.get(readProperties("DashboardURL"));
		DashboardPage dashboard = new DashboardPage(driver);
		WebDriverWait wait = explicitWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(dashboard.myCampaigns()));
		dashboard.myCampaigns().click();
		Log.info("Clicked on MyCampagins Tab in Dashboard");
		AddNewCampaign campaign = new AddNewCampaign(driver);
		campaign.addNewCampaign().click();
		Thread.sleep(2000);
		Log.info("Clicked on New Campaign Button");
		campaign.selectBot().click();
		Log.info("Clicked on select BOT DropDown");
		campaign.firstBot().click();
		Log.info("Selected First BOT");
		campaign.SelectTemplate().click();
		Log.info("Clicked on Select Template DropDown");
		campaign.firstTemplate().click();
		Log.info("Selected First Template");
		campaign.scheduleCampaign().click();
		Log.info("Clicked on Schedule Campaign");
		CampaignScheduleManagement campaignSchedule = new CampaignScheduleManagement(driver);
		campaignSchedule.campaignName().sendKeys("AutomationCamp"+rand);
		Log.info("Given the CampaignName as "+"AutomationCamp"+rand);
		

	}
	
	@Test
	public void uploadFileError() throws IOException, InterruptedException {
		
		newCampaign();
		CampaignScheduleManagement campaignSchedule = new CampaignScheduleManagement(driver);
		campaignSchedule.UploadFile().sendKeys(Base.localDir+"/utils/Visual_Graphs.png");
		Log.info("Uploaded the file with the extension PNG");
		WebDriverWait wait = explicitWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(campaignSchedule.errorAlert()));
		Assert.assertEquals(campaignSchedule.errorAlert().getText(), "Please provide file with extension (txt, csv, xlsx, xls)");
		Log.info("-----Successfully Error Message displayed and File did not Uploaded----------");
		
	}
	
	
	@Test(priority=1)
	public void uploadProperFile() throws IOException, InterruptedException {
		
		newCampaign();
		CampaignScheduleManagement campaignSchedule = new CampaignScheduleManagement(driver);
		campaignSchedule.UploadFile().sendKeys(Base.localDir+"/utils/2_rcs.txt");
		Log.info("Uploaded Text File");
		WebDriverWait wait = explicitWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(campaignSchedule.fileUploadSuccessText()));
		Assert.assertEquals(campaignSchedule.fileUploadSuccessText().getText(), "Document uploaded successfully");
		Log.info("----------Successfully Document Uploaded Successfully--------");
		
	}
	
	@Test(priority=2)
	public void clickOnDeleteFile() throws IOException, InterruptedException {
		
		uploadProperFile();
		CampaignScheduleManagement campaignSchedule = new CampaignScheduleManagement(driver);
		WebDriverWait wait = explicitWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(campaignSchedule.delete()));
		campaignSchedule.delete().click();
		Log.info("Dispalyed the alert message as "+campaignSchedule.removeFileAlert().getText());
		Assert.assertTrue(campaignSchedule.removeFileAlertYes().isEnabled());
		Assert.assertTrue(campaignSchedule.removeFileAlertNo().isEnabled());
		Log.info("---------Successfully Alert Message is displayed with Yes and No Button------------");
		
	}
	
	@Test(priority=10)
	public void clickOnRunNow() throws IOException, InterruptedException {
		uploadProperFile();
		CampaignScheduleManagement campaignSchedule = new CampaignScheduleManagement(driver);
		//campaignSchedule.removeFileAlertNo().click();
		JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
		scrollPage.executeScript("window.scrollBy(0,500)", "");
		campaignSchedule.runNow().click();
		Log.info("Clicked on Run Now option");
		campaignSchedule.submit().click();
		Log.info("Clicked on Submit Button");
		campaignSchedule.submitCampaignYes().click();
		Log.info("Clicked on Yes in the Confirm Alert");
		WebDriverWait wait = explicitWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(campaignSchedule.submitSuccessAlert()));
		Assert.assertEquals(campaignSchedule.submitSuccessAlert().getText(), "Campaign has started successfully!");
		Log.info("-------Successfully Campaing Got Created--------");
	}

	@Test(priority=4)
	public void runLater() throws IOException, InterruptedException {
		
	
		uploadProperFile();
		CampaignScheduleManagement campaignSchedule = new CampaignScheduleManagement(driver);
		JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
		scrollPage.executeScript("window.scrollBy(0,500)", "");
		campaignSchedule.RunLater().click();
		Log.info("clicked on Run Later");
		Thread.sleep(2000);
		scrollPage.executeScript("window.scrollBy(0,500)", "");
		//campaignSchedule.date().sendKeys(Base.date+Base.month+Base.year);
		WebDriverWait wait = explicitWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(campaignSchedule.date()));
		campaignSchedule.date().click();
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.UP).perform();
		actions.sendKeys(Keys.ARROW_RIGHT).perform();
		actions.sendKeys(Keys.UP).perform();
		actions.sendKeys(Keys.ARROW_RIGHT).perform();
		actions.sendKeys(Keys.UP).perform();
		actions.sendKeys(Keys.DOWN).perform();
//		campaignSchedule.date().sendKeys(123213+"");
//		Log.info(Base.date+"/"+Base.month+"/"+Base.year);
		Select hour = new Select(campaignSchedule.hours());
		hour.selectByValue("10");
		Select minute = new Select(campaignSchedule.minutes());
		minute.selectByValue(Base.minute);
		Select seconds = new Select(campaignSchedule.Seconds());
		seconds.selectByValue("10");
		Select amORpm = new Select(campaignSchedule.amORpm());
		amORpm.selectByValue("PM");
		campaignSchedule.submit().click();
		campaignSchedule.submitCampaignYes().click();
		wait.until(ExpectedConditions.elementToBeClickable(campaignSchedule.submitSuccessAlert()));
		Assert.assertEquals(campaignSchedule.submitSuccessAlert().getText(), "Campaign scheduled successfully!");
		campaignSchedule.submitSuccessAlertMyCampaigns().click();


		
	}
	
	
	@Test(priority=5)
	public void clickOnEdit() throws IOException {
		
		driver.get(readProperties("DashboardURL"));
		DashboardPage dashboard = new DashboardPage(driver);
		dashboard.myCampaigns().click();
		//CampaignScheduleManagement campaignSchedule = new CampaignScheduleManagement(driver);
		//campaignSchedule.submitSuccessAlertMyCampaigns().click();
		MyCampaigns campaign = new MyCampaigns(driver);
		WebDriverWait wait = explicitWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(campaign.recentCampaign()));
		campaign.recentCampaign().click();
		Assert.assertTrue(driver.getCurrentUrl().contains(readProperties("CampaignDetailsURL")));
		wait.until(ExpectedConditions.elementToBeClickable(campaign.viewCampaignEdit()));
		campaign.viewCampaignEdit().click();
		Assert.assertTrue(driver.getCurrentUrl().contains(readProperties("CampaignEditURL")));
		
		
	}
	
	@Test(priority=6)
	public void cancelCampaign() throws IOException, InterruptedException {
		
		driver.get(readProperties("MyCampaignsURL"));
		MyCampaigns campaign = new MyCampaigns(driver);
		WebDriverWait wait = explicitWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(campaign.cancel()));
		campaign.cancel().click();
		campaign.CancelCampaignYes().click();
		wait.until(ExpectedConditions.elementToBeClickable(campaign.reason()));
		campaign.reason().click();
		campaign.reason().sendKeys("AutomationCamp");
		campaign.cancelCampaignSubmit().click();
		Thread.sleep(2000);
		Assert.assertEquals(campaign.canceledCampaignAlertText().getText(), "Campaign canceled successfully.");
	}
	
	
}
