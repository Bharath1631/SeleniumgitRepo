package testCases;

import java.io.File;
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

import com.aventstack.extentreports.Status;

import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.AddTemplatePage;
import pageObjects.TestDevice;
import pageObjects.ViewAllTemplatesObjects;
import resources.Base;
import resources.Log;
import pageObjects.LoginPage;

import pageObjects.LoginPage;

public class ViewAllTemplates extends Base{
	
	String TemplateName;
	File JsonFile;
	
	@Parameters("value")
	@BeforeTest
	public void invokeBrowser(String value) throws IOException {
		driver = driverInitialize(value);
		driver.get(readProperties("BaseURL"));
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginApplication(readProperties("richmessagetemplatesemail"),
				readProperties("richmessagetemplatesoassword"));
	}
	@Test(priority = 1)
	public void clickOnViewTemplates() {
		
		ViewAllTemplatesObjects viewtemplate=new ViewAllTemplatesObjects(driver);
		viewtemplate.clickBotButton().click();
		JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
	 	scrollPage.executeScript("window.scrollBy(0,2000)", "");
	 	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 	wait.until(ExpectedConditions.visibilityOf(viewtemplate.viewAllTemplates()));
	 	viewtemplate.viewAllTemplates().click();
	 	Assert.assertEquals(viewtemplate.verifyViewAndAddTemplate().getText(), "View and Add Templates");
	 	Log.info("All the templates (Rich corousel and Rich Card stand alone) will be displayed");
		
	}
	
	@Test(priority = 2)
	public void clickDownloadTemplate() throws InterruptedException, IOException {
		driver.get(readProperties("DashboardURL"));
		ViewAllTemplatesObjects downloadtemplate=new ViewAllTemplatesObjects(driver);
//		downloadtemplate.clickBotButton().click();
//		JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
//	 	scrollPage.executeScript("window.scrollBy(0,2000)", "");
//	 	downloadtemplate.viewAllTemplates().click();
		clickOnViewTemplates();
		TemplateName=downloadtemplate.firstTemplateName().getText();
		Log.info("First Template Name is: "+TemplateName);
		Actions actions = new Actions(driver);
		actions.moveToElement(downloadtemplate.clickDropDown()).perform();            
		actions.moveToElement(downloadtemplate.clickDownloadTemplate()).click().perform(); 
		Log.info("Clicked on Download JSON file");
		Thread.sleep(3000);
		JsonFile = new File(Base.DownloadsPath+"/"+TemplateName+".json");
		Assert.assertTrue(JsonFile.exists(), "Failed to download Expected document");  
		Log.info("Json Path is: "+JsonFile);
		Log.info("-----------SUccessfully JSON file Downloaded----------");
		Listeners.test.log(Status.INFO,"-----------SUccessfully JSON file Downloaded in the path: "+JsonFile+"----------");
		Log.info("Downloaded File will be Deleted in the TearDown");
		
	}
	
	@Test(priority = 3)
	public void clickPreviewTemplate() throws InterruptedException, IOException {
		driver.get(readProperties("DashboardURL"));
		ViewAllTemplatesObjects previewtemplate=new ViewAllTemplatesObjects(driver);
		clickOnViewTemplates();
		TemplateName=previewtemplate.firstTemplateName().getText();
		Log.info("First Template Name is: "+TemplateName);
		Actions actions = new Actions(driver);
		actions.moveToElement(previewtemplate.clickDropDown()).perform();            
		actions.moveToElement(previewtemplate.clickPreviewTemplate()).click().perform(); 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 	wait.until(ExpectedConditions.visibilityOf(previewtemplate.verifyPreview()));
		Assert.assertEquals(previewtemplate.verifyPreview().getText(), TemplateName);
		Log.info("-----------Delete edit and download options are displayed----------");
		
		
	}
	
	@Test(priority = 4)
	public void downloadFromPreview() throws InterruptedException, IOException {
		driver.get(readProperties("DashboardURL"));
		ViewAllTemplatesObjects downloadpreview=new ViewAllTemplatesObjects(driver);
		clickOnViewTemplates();
	 	TemplateName=downloadpreview.firstTemplateName().getText();
		Log.info("First Template Name is: "+TemplateName);
		Actions actions = new Actions(driver);
		actions.moveToElement(downloadpreview.clickDropDown()).perform();            
		actions.moveToElement(downloadpreview.clickPreviewTemplate()).click().perform(); 
		downloadpreview.downloadPreviewObject().click();
		Log.info("Clicked on Download JSON file");
		Thread.sleep(3000);
		JsonFile = new File(Base.DownloadsPath+"/"+TemplateName+".json");
		Assert.assertTrue(JsonFile.exists(), "Failed to download Expected document");  
		Log.info("Json Path is: "+JsonFile);
		Log.info("-----------SUccessfully JSON file Downloaded----------");
		Listeners.test.log(Status.INFO,"-----------SUccessfully JSON file Downloaded in the path: "+JsonFile+"----------");
		Log.info("Downloaded File will be Deleted in the TearDown");
		
		
	}
	
	@Test(priority = 5)
	public void editTemplateFromPreview() throws InterruptedException, IOException {
		driver.get(readProperties("DashboardURL"));
		ViewAllTemplatesObjects editpreviewtemplate=new ViewAllTemplatesObjects(driver);
		clickOnViewTemplates();
	 	TemplateName=editpreviewtemplate.firstTemplateName().getText();
		Log.info("First Template Name is: "+TemplateName);
		Actions actions = new Actions(driver);
		actions.moveToElement(editpreviewtemplate.clickDropDown()).perform();            
		actions.moveToElement(editpreviewtemplate.clickPreviewTemplate()).click().perform(); 
		editpreviewtemplate.editPreviewTemplateObject().click();
		Log.info("Page is navigated to edit template page");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 	wait.until(ExpectedConditions.visibilityOf(editpreviewtemplate.verifyEditPage()));
		Assert.assertEquals(editpreviewtemplate.verifyEditPage().getText(), "Cancel edit");  
		Log.info("Edit page is opened successfully");
		}
	
	@Test(priority = 6)
	public void deleteTemplateFromPreview() throws InterruptedException, IOException {
		driver.get(readProperties("DashboardURL"));
		ViewAllTemplatesObjects deletepreviewtemplate=new ViewAllTemplatesObjects(driver);
		clickOnViewTemplates();
	 	TemplateName=deletepreviewtemplate.firstTemplateName().getText();
		Actions actions = new Actions(driver);
		actions.moveToElement(deletepreviewtemplate.clickDropDown()).perform();            
		actions.moveToElement(deletepreviewtemplate.clickPreviewTemplate()).click().perform();
		Thread.sleep(2000);
		deletepreviewtemplate.deletePreviewPOPUP().click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 	wait.until(ExpectedConditions.visibilityOf(deletepreviewtemplate.deletePreviewPOPUPText()));
		Assert.assertEquals(deletepreviewtemplate.deletePreviewPOPUPText().getText(), "Are you sure you want to delete "+TemplateName+" template?");  
		Log.info("popup displayed after clicking delete icon");
		}
	
	@Test(priority = 7)
	public void deleteTemplateFromPreviewOk() throws InterruptedException, IOException {
		driver.get(readProperties("DashboardURL"));
		ViewAllTemplatesObjects deletepreviewtemplateok=new ViewAllTemplatesObjects(driver);
		clickOnViewTemplates();
	 	TemplateName=deletepreviewtemplateok.firstTemplateName().getText();
	 	Actions actions = new Actions(driver);
		actions.moveToElement(deletepreviewtemplateok.clickDropDown()).perform();            
		actions.moveToElement(deletepreviewtemplateok.clickPreviewTemplate()).click().perform();
		deletepreviewtemplateok.deletePreviewPOPUP().click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(deletepreviewtemplateok.deleteConfirmation()));
		deletepreviewtemplateok.deletePreviewPOPUPYes().click();
		Thread.sleep(2000);
		Assert.assertEquals(deletepreviewtemplateok.deleteConfirmation().getText(), "Template "+TemplateName+" has been deleted successfully!");  
		deletepreviewtemplateok.clickFinalDeleteOk().click();
		Assert.assertEquals(deletepreviewtemplateok.viewAllTemplateText().getText(), "View and Add Templates");
		Log.info("Templated is deleted from template page");
		
		}
	
	@Test(priority = 8)
	public void deleteTemplateFromPreviewCancel() throws InterruptedException, IOException {
	driver.get(readProperties("DashboardURL"));
		ViewAllTemplatesObjects deletepreviewtemplatecancel=new ViewAllTemplatesObjects(driver);
		clickOnViewTemplates();
	 	TemplateName=deletepreviewtemplatecancel.firstTemplateName().getText();
		Actions actions = new Actions(driver);
		actions.moveToElement(deletepreviewtemplatecancel.clickDropDown()).perform();            
		actions.moveToElement(deletepreviewtemplatecancel.clickPreviewTemplate()).click().perform();
		Thread.sleep(2000);
		deletepreviewtemplatecancel.deletePreviewPOPUP().click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(deletepreviewtemplatecancel.deletePreviewPOPUPText()));
		Assert.assertEquals(deletepreviewtemplatecancel.deletePreviewPOPUPText().getText(), "Are you sure you want to delete "+TemplateName+" template?");
		deletepreviewtemplatecancel.deleteCancel().click();
		Thread.sleep(2000);
		Assert.assertEquals(deletepreviewtemplatecancel.viewAllTemplateText().getText(), "View and Add Templates");
		Log.info("Templated will not be deleted");
		}
	
	@Test(priority = 9)
	public void editTemplateFromHemburger() throws InterruptedException, IOException {
	driver.get(readProperties("DashboardURL"));
		ViewAllTemplatesObjects edithemburger=new ViewAllTemplatesObjects(driver);
		clickOnViewTemplates();
	 	TemplateName=edithemburger.firstTemplateName().getText();
		Actions actions = new Actions(driver);
		actions.moveToElement(edithemburger.clickDropDown()).perform();            
		actions.moveToElement(edithemburger.hemburgerEDit()).click().perform();
		Assert.assertEquals(edithemburger.verifyEditPage().getText(), "Cancel edit"); 
		Log.info("Successfully navigated to edit Template page");
	}
	
	@Test(priority = 10)
	public void templateDeleteFromHemburger() throws InterruptedException, IOException {
	driver.get(readProperties("DashboardURL"));
		ViewAllTemplatesObjects deletethemburger=new ViewAllTemplatesObjects(driver);
		clickOnViewTemplates();
	 	TemplateName=deletethemburger.firstTemplateName().getText();
		Actions actions = new Actions(driver);
		actions.moveToElement(deletethemburger.clickDropDown()).perform();            
		actions.moveToElement(deletethemburger.hemburgerDelete()).click().perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 	wait.until(ExpectedConditions.visibilityOf(deletethemburger.deletePreviewPOPUPText()));
		Assert.assertEquals(deletethemburger.deletePreviewPOPUPText().getText(), "Are you sure you want to delete "+TemplateName+" template?");  
		Log.info("popup displayed after clicking delete icon");
		
	}
	
	@Test(priority = 11)
	public void templateDeleteFromHemburgerCancel() throws InterruptedException, IOException {
	driver.get(readProperties("DashboardURL"));
		ViewAllTemplatesObjects deletethemburgercancel=new ViewAllTemplatesObjects(driver);
		clickOnViewTemplates();
	 	TemplateName=deletethemburgercancel.firstTemplateName().getText();
		Actions actions = new Actions(driver);
		actions.moveToElement(deletethemburgercancel.clickDropDown()).perform();            
		actions.moveToElement(deletethemburgercancel.hemburgerDelete()).click().perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 	wait.until(ExpectedConditions.visibilityOf(deletethemburgercancel.deletePreviewPOPUPText()));
		Assert.assertEquals(deletethemburgercancel.deletePreviewPOPUPText().getText(), "Are you sure you want to delete "+TemplateName+" template?");  
		Log.info("popup displayed after clicking delete icon");
		deletethemburgercancel.deleteCancel().click();
		Thread.sleep(2000);
		Assert.assertEquals(deletethemburgercancel.viewAllTemplateText().getText(), "View and Add Templates");
		Log.info("Templated will not be deleted");
		
		
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
