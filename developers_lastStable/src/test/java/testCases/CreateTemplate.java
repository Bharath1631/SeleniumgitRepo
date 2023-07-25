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

import pageObjects.LoginPage;
import pageObjects.AddTemplatePage;
import pageObjects.DashboardPage;
import resources.Base;
import resources.Log;

public class CreateTemplate extends Base{
	
	public String salt1=getSaltString(5,"1234567890abceefghijklmnopqrstuvwxyz@#$");
	public String salt2=getSaltString(5,"1234567890abceefghijklmnopqrstuvwxyz@#$");
	public String salt3=getSaltString(5,"1234567890abceefghijklmnopqrstuvwxyz@#$");
	public String salt4=getSaltString(5,"1234567890abceefghijklmnopqrstuvwxyz@#$");
	
	@Parameters("value")
	@BeforeTest
	public void invokeBrowser(String value) throws IOException {
		driver =  driverInitialize(value);
		driver.get(readProperties("BaseURL"));
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginApplication(readProperties("richmessagetemplatesemail"),readProperties("richmessagetemplatesoassword"));
	}
	
	
	@Test
	public void addTemplateButton() throws IOException {
		
		driver.get(readProperties("DashboardURL"));
		DashboardPage dashboard = new DashboardPage(driver);
		AddTemplatePage botConsole=new AddTemplatePage(driver);
		WebDriverWait wait = explicitWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(dashboard.viewDetails()));
		dashboard.viewDetails().click();
		Log.info("Clicked on submitted Bot View Details and Redirected to BotConsole Page");
		JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
	 	scrollPage.executeScript("window.scrollBy(0,2000)", "");
	 	Log.info("Scrolled Down to the Page to check if 'Add Template' Button is enabled");
	 	Assert.assertTrue(botConsole.addTemplate().isEnabled());
	    Log.info("------Add Template button is Enabled and Able to Click-------");
	
	}
	
	
	@Test
	public void clickAddTemplateButton() throws IOException {
		
		driver.get(readProperties("DashboardURL"));
		addTemplateButton();
		AddTemplatePage clickaddtemplatebutton=new AddTemplatePage(driver);
	 	clickaddtemplatebutton.addTemplate().click();
	 	Log.info("Clicked on Add Template link");
	 	Assert.assertEquals(driver.getCurrentUrl(), readProperties("addtemplatepageurl")); 
	 	Log.info("------Sucessfully clicked on add template button and Redirected to Add Template Page-------");
	}
	
	
	
	@Test
	public void selectCarouselCard() throws IOException {
		
		driver.get(readProperties("DashboardURL"));
		addTemplateButton();
		AddTemplatePage template=new AddTemplatePage(driver);
	 	template.addTemplate().click();
	 	Assert.assertEquals(driver.getCurrentUrl(), readProperties("addtemplatepageurl"));
	 	Log.info("Navigated to Add Template Page");
	 	Select templateType = new Select(template.templatetype());
	 	templateType.selectByVisibleText("Rich Card Carousel");
	 	Log.info("Rich Card Carousel is selected");
	 	template.plusSymbol().click();
	 	Log.info("clicked on Plus symbol to add 3rd Card");
	 	Assert.assertEquals(template.newCard3().getText(), "Card 3");
	 	Log.info("------Selected Carousel Card and Added 3rd Card successfully-------");
	}
	
	@Test
	public void addSuggestions() throws IOException, InterruptedException {
		
		driver.get(readProperties("DashboardURL"));
		addTemplateButton();
		AddTemplatePage template=new AddTemplatePage(driver);
		template.addTemplate().click();
		Log.info("Clicked on Add Template Link");
	 	Assert.assertEquals(driver.getCurrentUrl(), readProperties("addtemplatepageurl"));
	 	Log.info("Navigated to Add Template Page");
	 	JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
	 	scrollPage.executeScript("window.scrollBy(0,2000)", "");
	 	template.addSuggestion().click();
	 	Assert.assertEquals(template.typeOfActionText().getText(), "Type of Action");
	 	Select typeOfAction = new Select(template.typeOfAction());
	 	Assert.assertEquals(typeOfAction.getFirstSelectedOption().getText(),"Reply");
	 	Log.info("------Suggestion Options Displayed with Type of Action as Reply by Default-------");
	    
	}
	
	@Test(priority=2)
	public void ImageUploadOrientation() throws InterruptedException, IOException {
		
		driver.get(readProperties("DashboardURL"));
		AddTemplatePage template=new AddTemplatePage(driver);
		addTemplateButton();
	 	template.addTemplate().click();
	 	WebDriverWait wait = explicitWait(driver,10);
		wait.until(ExpectedConditions.urlContains(readProperties("addtemplatepageurlFraction")));
	 	template.clickUploadButton().click();
	 	template.clickSelectImage().sendKeys(Base.localDir+"/utils/screeshot.jpg");
	 	Thread.sleep(1000);
	 	template.clickSelectButton().click();
	 	Thread.sleep(2000);
	 	Log.info("Image uploaded successfully");
	 	Select select = new Select(template.cardOrientation());
     	select.selectByVisibleText("HORIZONTAL");
     	Log.info("Changed Image Orientaion to Horizontal");
     	wait.until(ExpectedConditions.visibilityOf(template.tosterMessage()));
     	Assert.assertEquals(template.tosterMessage().getText(), "Since you have changed the orientation, please check whether your image meets the desired aspect ratio.");
     	Log.info("------Image Orientation Changed from vertical to horizontal-------");
	}
	
	
	
	@Test
	public void businessInfo() throws InterruptedException, IOException {
		
		driver.get(readProperties("DashboardURL"));
		addTemplateButton();
		AddTemplatePage template=new AddTemplatePage(driver);
		template.addTemplate().click();
		Log.info("Clicked on Add Template Link");
	 	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 	wait.until(ExpectedConditions.urlContains(readProperties("addtemplatepageurlFraction")));
	 	Assert.assertEquals(driver.getCurrentUrl(), readProperties("addtemplatepageurl"));
	 	Log.info("Navigated to Add Template Page");
	 	template.buisnessInfo().click();
	 	Assert.assertEquals(template.phoneBuisenessInfo().getText(), "Home1");
	 	Assert.assertEquals(template.urlBuisenessInfo().getText(), "url");
	 	Assert.assertEquals(template.emailIDBuisenessInfo().getText(), "emailid");
	 	Log.info("------Phone number, EmailID and URL is displayed after clicking on Buisness Info Option-------");
	 	
    }
	
	
	@Test
	public void optionsInBuisnessInfo() throws InterruptedException, IOException {
		
		driver.get(readProperties("DashboardURL"));
		addTemplateButton();
		AddTemplatePage template=new AddTemplatePage(driver);
	 	template.addTemplate().click();
	 	Log.info("Clicked on Add Template Link");
	 	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 	wait.until(ExpectedConditions.urlContains(readProperties("addtemplatepageurlFraction")));
	 	Log.info("Navigated to Add Template Page");
	 	template.buisnessInfo().click();
	 	Log.info("Clicked on BusinessInfo");
	 	template.optionsBuisnessInfo().click();
	 	Log.info("Clicked on Options");
	 	Assert.assertEquals(template.optionsNotificationBuisnessInfo().getText(), "Notification");
	 	Assert.assertEquals(template.learnMoreText().getText(), "Learn more");
	 	Assert.assertEquals(template.blockAndReportSpamText().getText(), "Block & report spam");
	 	Log.info("Notification, Block & report spam and Learn More Text is displayed in the Preview");
	 	template.optionsPrivacyPolicy().click();
	 	ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	 	wait.until(ExpectedConditions.urlContains(readProperties("privacypolicyurl")));
	    Assert.assertEquals(driver.getCurrentUrl(), readProperties("privacypolicyurl"));
	    Log.info("------Privacy and Policy link is clickable and opened the page by clicking on link.-------");
	    driver.close();
	    Log.info("Closed the New Tab opened");
	    driver.switchTo().window(tabs.get(0));
	    template.optionstermsOfServices().click();
	    Log.info("Clicked on Terms of service link");
	    ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
	 	//options.optionstermsOfServices().click();
	    driver.switchTo().window(tabs1.get(1));
	    wait.until(ExpectedConditions.urlContains(readProperties("termsofservicesurl")));
	    Assert.assertEquals(driver.getCurrentUrl(), readProperties("termsofservicesurl"));
	    driver.close();
	    driver.switchTo().window(tabs1.get(0));
	    Log.info("------Terms of services link is able to click and page opened successfully by clicking on link.-------");
	 	
    }
	
	
	@Test
	public void addURLAction() throws IOException, InterruptedException {
		
		driver.get(readProperties("DashboardURL"));
		addTemplateButton();
		AddTemplatePage template=new AddTemplatePage(driver);
	 	template.addTemplate().click();
	 	Log.info("Clicked on Add template Link");
	 	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 	wait.until(ExpectedConditions.urlContains(readProperties("addtemplatepageurlFraction")));
	 	Log.info("Navigated to Add template Page");
	 	JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
	 	scrollPage.executeScript("window.scrollBy(0,2000)", "");
	 	Log.info("Scrolled down to the page");
	 	template.addSuggestion().click();
	 	Log.info("Clicked on Add suggestion");
	 	Select select = new Select(template.selectUrlAction());
     	select.selectByVisibleText("URL Action");
     	Log.info("selected URL action in the DropDown");
     	template.suggestionText().sendKeys(readProperties("suggestiontext00"));
     	template.suggestionPostback().sendKeys(readProperties("suggestionPostback00"));
     	template.urlSuggestionfirstfield().sendKeys(readProperties("suggestionurl1"));
     	scrollPage.executeScript("window.scrollBy(0,-2000)", "");
     	wait.until(ExpectedConditions.visibilityOf(template.youtubeImageDisplayed()));
     	Assert.assertTrue(template.youtubeImageDisplayed().isDisplayed(), "Youtube Icon is displayed");
     	Log.info("------Successfully youtube icon is visible in the Template Preview-------");
     	
     	
	}
	
	@Test
	public void changeSuggestionUrlToReply() throws IOException, InterruptedException {
		
		driver.get(readProperties("DashboardURL"));
		addTemplateButton();
		AddTemplatePage template=new AddTemplatePage(driver);
	 	template.addTemplate().click();
	 	Log.info("Clicked on Add template Link");
	 	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 	wait.until(ExpectedConditions.urlContains(readProperties("addtemplatepageurlFraction")));
	 	Log.info("Navigated to Add template Page");
	 	JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
	 	scrollPage.executeScript("window.scrollBy(0,2000)", "");
	 	template.addSuggestion().click();
	 	Select typeOfAction = new Select(template.selectUrlAction());
     	typeOfAction.selectByVisibleText("URL Action");
     	template.suggestionText().sendKeys(readProperties("suggestiontext00"));
     	template.suggestionPostback().sendKeys(readProperties("suggestionPostback00"));
     	template.urlSuggestionfirstfield().sendKeys(readProperties("suggestionurl1"));
     	//Thread.sleep(3000);
     	typeOfAction.selectByVisibleText("Reply");
    	
     	Log.info("------Successfully Type of Action Changed to Reply-------");
     	
    }
	
	@Test(groups= {"CreatedTemplates"})
	public void createTemplateWithReplySuggestion() throws IOException, InterruptedException {
		  
		driver.get(readProperties("DashboardURL"));
		addTemplateButton();
		AddTemplatePage template=new AddTemplatePage(driver);
	 	template.addTemplate().click();
	 	Log.info("Clicked on Add template Link");
	 	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 	wait.until(ExpectedConditions.urlContains(readProperties("addtemplatepageurlFraction")));
	 	Log.info("Navigated to Add template Page");
	 	template.enterTemplateName().sendKeys(readProperties("templatename")+salt1);
	 	template.clickUploadButton().click();
	 	template.clickSelectImage().sendKeys(Base.localDir+"/utils/screeshot.jpg");
	 	Thread.sleep(1000);
	 	template.clickSelectButton().click();
	 	Thread.sleep(2000);
	 	JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
	 	scrollPage.executeScript("window.scrollBy(0,2000)", "");
	 	template.cardTitle().sendKeys(readProperties("cardtitle"));
	 	Log.info("Image and Card Title Added");
	 	template.cardDescription().sendKeys(readProperties("carddescription"));
	 	Log.info("Entered Card Description");
	 	template.addSuggestion().click();
	 	Log.info("Clicked on Add suggestion");
	 	template.suggestionText().sendKeys(readProperties("suggestiontext00reply"));
	 	template.suggestionPostback().sendKeys(readProperties("suggestionPostback00reply"));
	 	Log.info("By Default Reply Type of Action is used");
	 	scrollPage.executeScript("window.scrollBy(0,500)", "");
	 	template.clickSubmitButton().click();
	 	Log.info("Clicked on Submit Button");
	 	wait.until(ExpectedConditions.visibilityOf(template.submitPop()));
	 	Assert.assertEquals(template.submitPop().getText(), "Are you sure you want to submit this template?");
	 	Log.info("Confirm pop-up Displayed with Yes or No");
	 	template.yesTemplate().click();
	 	Log.info("Clicked on Yes");
	 	wait.until(ExpectedConditions.visibilityOf(template.templateSubmittedSucessfully()));
	 	Assert.assertEquals(template.templateSubmittedSucessfully().getText(), "Template has been submitted successfully!");
	 	template.templateSubmittedSucessfullyOK().click();
	 	Log.info("------Successfully Template Submitted-------");
    }
	  
	
	  @Test(groups= {"CreatedTemplates"})
	  public void createTemplateWithURLSuggestion() throws IOException, InterruptedException {
		  
		    driver.get(readProperties("DashboardURL"));
			addTemplateButton();
			AddTemplatePage template=new AddTemplatePage(driver);
		 	template.addTemplate().click();
		 	Log.info("Clicked on Add template Link");
		 	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 	wait.until(ExpectedConditions.urlContains(readProperties("addtemplatepageurlFraction")));
		 	Log.info("Navigated to Add template Page");
		 	template.enterTemplateName().sendKeys(readProperties("templatename")+salt2);
		 	template.clickUploadButton().click();
		 	template.clickSelectImage().sendKeys(Base.localDir+"/utils/screeshot.jpg");
		 	Thread.sleep(1000);
		 	template.clickSelectButton().click();
		 	Thread.sleep(2000);
		 	JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
		 	scrollPage.executeScript("window.scrollBy(0,2000)", "");
		 	template.cardTitle().sendKeys(readProperties("cardtitle"));
		 	Log.info("Image and Card Title Added");
		 	template.cardDescription().sendKeys(readProperties("carddescription"));
		 	Log.info("Entered Card Description");
		 	template.addSuggestion().click();
		 	Select select = new Select(template.selectUrlAction());
	     	select.selectByVisibleText("URL Action");
	     	Log.info("Selected URL Action");
	     	template.suggestionText().sendKeys(readProperties("suggestiontext00reply"));
	     	template.suggestionPostback().sendKeys(readProperties("suggestionPostback00reply"));
	     	template.urlSuggestionfirstfield().sendKeys(readProperties("suggestionurl1"));
	     	Log.info("All the Fields are Filled with proper data");
	     	scrollPage.executeScript("window.scrollBy(0,500)", "");
	     	template.clickSubmitButton().click();
	     	Log.info("Clicked on Submit Button");
		 	wait.until(ExpectedConditions.visibilityOf(template.submitPop()));
		 	Assert.assertEquals(template.submitPop().getText(), "Are you sure you want to submit this template?");
		 	Log.info("Confirm pop-up displayed with yes or no");
		 	template.yesTemplate().click();
		 	Log.info("clicked on yes");
		 	wait.until(ExpectedConditions.visibilityOf(template.templateSubmittedSucessfully()));
		 	Assert.assertEquals(template.templateSubmittedSucessfully().getText(), "Template has been submitted successfully!");
		 	template.templateSubmittedSucessfullyOK().click();
		 	Log.info("------Successfully Template created with URL Action.-------");
	    }
	  
	  @Test(groups= {"CreatedTemplates"})
	  public void createTemplateWithDialerActionSuggestion() throws IOException, InterruptedException {
		  
		    driver.get(readProperties("DashboardURL"));
			addTemplateButton();
			AddTemplatePage template=new AddTemplatePage(driver);
		 	template.addTemplate().click();
		 	Log.info("Clicked on Add template Link");
		 	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 	wait.until(ExpectedConditions.urlContains(readProperties("addtemplatepageurlFraction")));
		 	Log.info("Navigated to Add template Page");
		 	template.enterTemplateName().sendKeys(readProperties("templatename")+salt3);
		 	template.clickUploadButton().click();
		 	template.clickSelectImage().sendKeys(Base.localDir+"/utils/screeshot.jpg");
		 	Thread.sleep(1000);
		 	template.clickSelectButton().click();
		 	Thread.sleep(2000);
		 	JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
		 	scrollPage.executeScript("window.scrollBy(0,2000)", "");
		 	template.cardTitle().sendKeys(readProperties("cardtitle"));
		 	Log.info("Image and Card Title Added");
		 	template.cardDescription().sendKeys(readProperties("carddescription"));
		 	Log.info("Entered Card Description");
		 	template.addSuggestion().click();
		 	Select select = new Select(template.selectUrlAction());
	     	select.selectByVisibleText("Dialer Action");
	     	Log.info("Selected Dailer Action");
	     	template.suggestionText().sendKeys(readProperties("suggestiontext00reply"));
	     	template.suggestionPostback().sendKeys(readProperties("suggestionPostback00reply"));
	     	template.suggestionPhoneNo1().sendKeys(readProperties("phonenumbertodial"));
	     	Log.info("All the Details filled with Proper Values");
	     	scrollPage.executeScript("window.scrollBy(0,500)", "");
	     	template.clickSubmitButton().click();
	     	Log.info("Clicked on submit Button");
		 	wait.until(ExpectedConditions.visibilityOf(template.clickDialerPopMessage()));
		 	Assert.assertEquals(template.clickDialerPopMessage().getText(), "Are you sure you want to submit this template?");
		 	Log.info("Confirm pop-up displayed with yes or no");
		 	template.yesTemplate().click();
		 	Log.info("clicked on yes");
		 	wait.until(ExpectedConditions.visibilityOf(template.templateSubmittedSucessfully()));
		 	Assert.assertEquals(template.templateSubmittedSucessfully().getText(), "Template has been submitted successfully!");
		 	template.templateSubmittedSucessfullyOK().click();
		 	Log.info("------Successfully Template Created with Dailer Action-------");
	 }
  
	  
	  @Test
	  public void cancelSubmittingTemplate() throws IOException, InterruptedException {
		  
		    driver.get(readProperties("DashboardURL"));
			addTemplateButton();
			AddTemplatePage template=new AddTemplatePage(driver);
		 	template.addTemplate().click();
		 	Log.info("Clicked on Add template Link");
		 	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 	wait.until(ExpectedConditions.urlContains(readProperties("addtemplatepageurlFraction")));
		 	Log.info("Navigated to Add template Page");
		 	template.enterTemplateName().sendKeys(readProperties("templatename")+salt4);
		 	template.clickUploadButton().click();
		 	template.clickSelectImage().sendKeys(Base.localDir+"/utils/screeshot.jpg");
		 	Thread.sleep(1000);
		 	template.clickSelectButton().click();
		 	Thread.sleep(2000);
		 	JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
		 	scrollPage.executeScript("window.scrollBy(0,2000)", "");
		 	template.cardTitle().sendKeys(readProperties("cardtitle"));
		 	Log.info("Image and Card Title Added");
		 	template.cardDescription().sendKeys(readProperties("carddescription"));
		 	Log.info("Entered Card Description");
		 	template.addSuggestion().click();
		 	template.suggestionText().sendKeys(readProperties("suggestiontext00reply"));
		 	template.suggestionPostback().sendKeys(readProperties("suggestionPostback00reply"));
		 	scrollPage.executeScript("window.scrollBy(0,400)", "");
		 	template.clickSubmitButton().click();
		 	Log.info("Clicked on Submit Button");
		 	Assert.assertEquals(template.submitPop().getText(), "Are you sure you want to submit this template?");
		 	Log.info("Confirm pop-up with yes or no displayed");
		 	template.clickSubmitNo().click();
		 	Log.info("Clicked on No");
		 	Assert.assertEquals(template.clickSubmitButton().getText(), "Submit");
		 	Log.info("------Sucessfully pop-up disappeared on clicking on NO----------");
		 	
	  }
	  
	  
	  @AfterTest
	  public void tearDown() {
			
		driver.close();
		
	  }
	  
	  
}
