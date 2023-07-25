package testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

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
import pageObjects.LoginPage;
import pageObjects.AddTemplatePage;
import resources.Base;
import resources.Log;

public class RichMessageTemplatesTestCases extends Base{
	
	String RCSMessageTemplate;
	File JsonFile;
	Actions actions;
	
	@Parameters("value")
	@BeforeTest
	public void invokeBrowser(String value) throws IOException {
		driver =  driverInitialize(value);
		driver.get(readProperties("BaseURL"));
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginApplication(readProperties("richmessagetemplatesemail"),readProperties("richmessagetemplatesoassword"));
		
	}
	
	public void hamburgerOptions() throws InterruptedException, IOException {
		
		driver.get(readProperties("DashboardURL"));
		Log.info("Entered Dashboard Page");
		AddTemplatePage templates=new AddTemplatePage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	 	wait.until(ExpectedConditions.elementToBeClickable(templates.clickBotButton()));
		templates.clickBotButton().click();
		Log.info("Clicked on Bot");
		driver.navigate().refresh();
		Log.info("Refreshed the Page");
		JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
		scrollPage.executeScript("window.scrollBy(0,2000)", "");
		Log.info("Scrolling the page Down");
		wait.until(ExpectedConditions.visibilityOf(templates.richFirstTemplateName()));
		RCSMessageTemplate = templates.richFirstTemplateName().getText();
		Log.info("First Template Name is: "+RCSMessageTemplate);
		actions = new Actions(driver);
		actions.moveToElement(templates.clickDropDown()).perform();
		Log.info("Clicked on Hamburger Options");
		
	}
	
	
	@Test
	public void downloadTemplate() throws InterruptedException, IOException {
		
		hamburgerOptions();
		AddTemplatePage templates=new AddTemplatePage(driver);
		actions.moveToElement(templates.downloadTemplate()).click().perform();
		Log.info("Clicked on Download JSON file");
		Thread.sleep(3000);
		JsonFile = new File(Base.DownloadsPath+"/"+RCSMessageTemplate+".json");
		Assert.assertTrue(JsonFile.exists(), "Failed to download Expected document");
		Log.info("Json Downloaded in the Path: "+JsonFile);
		Log.info("-----------Successfully JSON file Downloaded----------");
		Listeners.test.log(Status.INFO,"-----------Successfully JSON file Downloaded in the path: "+JsonFile+"----------");
		JsonFile.delete();
		
	}
	
	
	@Test
	public void previewTemplate() throws IOException, InterruptedException {
		
		hamburgerOptions();
		AddTemplatePage templates=new AddTemplatePage(driver);
		actions.moveToElement(templates.previewTemplate()).click().perform();
		Log.info("Clicked on Preview Template");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 	wait.until(ExpectedConditions.visibilityOf(templates.previewText()));
	 	Assert.assertTrue(templates.deleteFromPreview().isDisplayed());
	 	Assert.assertTrue(templates.editFromPreview().isDisplayed());
	 	Assert.assertTrue(templates.downloadFromPreview().isDisplayed());
		Log.info("-----------Preview Template page opened successfully with Edit, Delete and Download Options----------");
	
	}
	
	@Test
	public void downloadTemplateFromPerview() throws InterruptedException, IOException {
		
		previewTemplate();
		AddTemplatePage templates=new AddTemplatePage(driver);
		templates.downloadFromPreview().click();
		Log.info("Clicked on Download Template in Preview Page");
		Thread.sleep(2000);
		JsonFile = new File(Base.DownloadsPath+"/"+RCSMessageTemplate+".json");
		Assert.assertTrue(JsonFile.exists(), "Failed to download Expected document");
		Log.info("Downloaded Json is in the Path: "+JsonFile);
		Log.info("-----------Successfully JSON file Downloaded----------");
		Listeners.test.log(Status.INFO,"-----------Successfully JSON file Downloaded in the path: "+JsonFile+"----------");
		JsonFile.delete();
		
	}
	
	@Test
	public void editTemplateFromPerview() throws InterruptedException, IOException {
		
		previewTemplate();
		AddTemplatePage templates=new AddTemplatePage(driver);
		templates.editFromPreview().click();
		Log.info("Clicked on Edit Template from Preview Page");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 	wait.until(ExpectedConditions.elementToBeClickable(templates.cancelEdit()));
		Assert.assertTrue(templates.cancelEdit().isEnabled());
		Log.info("----------Edit Template Page opened Successfully from Preview Page----------");
		
	}
	
	
	@Test 
	public void cancelDeleteTemplateFromPerview() throws InterruptedException, IOException {
		
		previewTemplate();
		AddTemplatePage templates=new AddTemplatePage(driver);
		actions.moveToElement(templates.previewTemplate()).click().perform();
		templates.deleteFromPreview().click();
		Log.info("Clicked on Delete from Preview Page");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 	wait.until(ExpectedConditions.elementToBeClickable(templates.deletePreviewCancel()));
		templates.deletePreviewCancel().click();
		Log.info("Clicked on Cancel in Delete Confirmation Options");
		Log.info("---------Successfully Clicked on Cancel button----------");
		
	}
	
	@Test (dependsOnGroups={"CreatedTemplates"})
	public void deleteTemplateFromPerview() throws InterruptedException, IOException {
		
		previewTemplate();
		AddTemplatePage templates=new AddTemplatePage(driver);
	    templates.deleteFromPreview().click();
	    Log.info("Clicked on Delete Icon");
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 	wait.until(ExpectedConditions.elementToBeClickable(templates.deletePreviewYes()));
	    templates.deletePreviewYes().click();
	    Log.info("Clicked on Yes");
		Log.info("--------Successfully Template Got Deleted-----------");
		
	}
	
	
	@Test (dependsOnGroups={"CreatedTemplates"})
	public void deleteTemplateOKFromPerview() throws InterruptedException, IOException {
		
		previewTemplate();
		AddTemplatePage templates=new AddTemplatePage(driver);
		templates.deleteFromPreview().click();
		Log.info("Clicked on Delete Icon");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(templates.deletePreviewYes()));
		templates.deletePreviewYes().click();
		Log.info("Clicked on Yes");
		wait.until(ExpectedConditions.elementToBeClickable(templates.deletePreviewOk()));
		templates.deletePreviewOk().click();
		Log.info("Clicked on OK");
		Log.info("----------Template deleted successfully----------");
		
	}
	
	@Test
	public void editTemplateFromHamburger() throws InterruptedException, IOException {
		
		hamburgerOptions();
		AddTemplatePage templates=new AddTemplatePage(driver);
		actions.moveToElement(templates.EditTemplate()).click().perform();
		Log.info("Clicked on Edit Template");
		Thread.sleep(2000);
		Assert.assertTrue(driver.getCurrentUrl().contains("https://partner-staging.dotgo.com/developer/view-template-details"));
		Log.info("----------Successfully Edit Page Opened----------");
		
	}
	
	
	@Test (dependsOnGroups={"CreatedTemplates"})
	public void deleteTemplatePopupFromhamburger() throws InterruptedException, IOException {
		
		hamburgerOptions();
		AddTemplatePage templates=new AddTemplatePage(driver);
		actions.moveToElement(templates.deleteTemplate()).click().perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 	wait.until(ExpectedConditions.elementToBeClickable(templates.deleteHamburgeryes()));
	 	Assert.assertTrue(templates.deleteHamburgeryes().isEnabled());
		Log.info("----------Successfully Delete Popup Displayed----------");
		
	}
	
	@Test
	public void cancelDeleteTemplateFromHemburger() throws InterruptedException, IOException {
		
		hamburgerOptions();
		AddTemplatePage templates=new AddTemplatePage(driver);
		actions.moveToElement(templates.deleteTemplate()).click().perform();
		Log.info("Clicked on Delete Template");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 	wait.until(ExpectedConditions.elementToBeClickable(templates.deletehamburgerCancel()));
		templates.deletehamburgerCancel().click();
		Log.info("----------Successfully Clicked on Cancel Button----------");
		
	}
	
	@Test (dependsOnGroups={"CreatedTemplates"})
	public void deleteTemplateFromHamburger() throws InterruptedException, IOException {
		
		hamburgerOptions();
		AddTemplatePage templates=new AddTemplatePage(driver);
		actions.moveToElement(templates.deleteTemplate()).click().perform();
		Log.info("Clicked on Delete Option");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 	wait.until(ExpectedConditions.elementToBeClickable(templates.deleteHamburgeryes()));
		templates.deleteHamburgeryes().click();
		Log.info("Clicked on Yes");
		wait.until(ExpectedConditions.elementToBeClickable(templates.deletePreviewOk()));
		templates.deletePreviewOk().click();
		Log.info("Clicked on OK");
		Log.info("----------Successfully Template got Deleted----------");
		
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
}
