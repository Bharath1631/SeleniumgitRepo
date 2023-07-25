/*
	 * @Author : Anil kumar
	 * Module : Edit RCS BOT
	 * Date   : 14 Oct 2022
	 */
package testCases;

import java.io.IOException;
import java.time.Duration;

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

import pageObjects.BotConsolePage;
import pageObjects.BotDetailsAndExperience;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.RcsBotDetailsPage;
import resources.Base;
import resources.Log;

public class EditRcsBot extends Base{
	
	String alpha ="1234567890";
	String randInt = getSaltString(5,alpha);
	Boolean flag = false;
	
	@Parameters("value")
	@BeforeTest
	public void invokeBrowser(String value) throws IOException {
		
		driver =  driverInitialize(value);
		driver.get(readProperties("BaseURL"));
		LoginPage login = new LoginPage(driver);
		login.loginApplication(readProperties("CreateNewBotEmail"), readProperties("CreateNewBotPassword"));
	}
	
	public BotConsolePage editBot() throws IOException, InterruptedException {
		driver.get(readProperties("DashboardURL"));
		Log.info("Entered Dashboard Page");
		DashboardPage dashboard = new DashboardPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(dashboard.viewDetails()));
		dashboard.viewDetails().click();
		Log.info("Clicked on ViewDetails");
		BotConsolePage edit = new BotConsolePage(driver);
//		wait.until(ExpectedConditions.visibilityOf(edit.viewBotDetails()));
//		JavascriptExecutor executor = (JavascriptExecutor) driver;
//		executor.executeScript("arguments[0].click();", edit.viewBotDetails());
//		//edit.viewBotDetails().click();
		Log.info("Clicked on View Bot Details in Bot console Page");
		Thread.sleep(1000);
		driver.get("https://partner-staging.dotgo.com/developer/bot-console/view-rcs-details/hnpctqH-95qUt22TaFcqoA==");
//		driver.navigate().back();
//		wait.until(ExpectedConditions.elementToBeClickable(edit.ViewSubmittedBotDetails()));
//		edit.ViewSubmittedBotDetails().click();
		//Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(edit.editDetails()));
		edit.editDetails().click();
		Log.info("Cliked on Edit Details Link");
		return edit;
		
	}
	
	@Test
	public void editBotName() throws IOException, InterruptedException {
		DashboardPage dashboard = new DashboardPage(driver);
		BotConsolePage edit = editBot();
		edit.botName().clear();
		edit.botName().sendKeys(readProperties("editBotName")+randInt);
		Log.info("Edited the Bot Name");
		JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
		scrollPage.executeScript("window.scrollBy(0,2000)", "");
		Log.info("Scrolling the page Down");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(edit.saveChanges()));
		edit.saveChanges().click();
		Log.info("Cliked on SaveChanges button");
		wait.until(ExpectedConditions.textToBePresentInElement(edit.popupMessage(),"Bot details has been updated successfully"));
		Assert.assertEquals(edit.popupMessage().getText(), "Bot details has been updated successfully");
		Log.info("------Succesfully popup message with Dashboard Button Displayed--------");
		edit.gotoDashboard().click();
		Assert.assertEquals(driver.getCurrentUrl(), readProperties("DashboardURL"));
		Log.info("------Successfully Redirected to the Dashboard Page on Clicking gotoDashboard Button------------");
		Listeners.test.log(Status.INFO,"------Successfully Redirected to the Dashboard Page on Clicking gotoDashboard Button------------");
		wait.until(ExpectedConditions.visibilityOf(dashboard.recentBotName()));
//		String recentBotName = dashboard.recentBotName().getText();
//		String[] BotName = recentBotName.split("\\r?\\n");
		//Assert.assertEquals(BotName[0], readProperties("editBotName"));
		driver.get("https://partner-staging.dotgo.com/developer/bot-console/hnpctqH-95qUt22TaFcqoA==");
		wait.until(ExpectedConditions.textToBePresentInElement(edit.consoleBotName(),readProperties("editBotName")+randInt));
		//Thread.sleep(3000);
		Log.info("name is "+edit.consoleBotName().getText());
		Assert.assertEquals(edit.consoleBotName().getText(), readProperties("editBotName")+randInt);
		Log.info("-----Successfully Changes are Reflecting in the Dashboard bot List-------");
		Listeners.test.log(Status.INFO,"-------Successfully Changes are reflecting in the Dashboard Bot list------");
	
	}
	
	@Test
	public void editBrandName() throws IOException, InterruptedException {
		DashboardPage dashboard = new DashboardPage(driver);
		BotConsolePage edit = editBot();
		edit.brandName().clear();
		edit.brandName().sendKeys(readProperties("editBrandName")+randInt);
		Log.info("Edited the Brand Name");
		JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
		scrollPage.executeScript("window.scrollBy(0,2000)", "");
		Log.info("Scrolled the page Down");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(edit.saveChanges()));
		edit.saveChanges().click();
		Log.info("clicked on SaveChanges Button");
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElement(edit.popupMessage(),"Bot details has been updated successfully"));
		Assert.assertEquals(edit.popupMessage().getText(), "Bot details has been updated successfully");
		Log.info("-----------Successfully PopUP Displayed-------");
		edit.gotoDashboard().click();
		Assert.assertEquals(driver.getCurrentUrl(), readProperties("DashboardURL"));
		Log.info("-------Successfully Redirected to Dashboard page on Clicking gotoDashboard Button-----------");
		Listeners.test.log(Status.INFO,"-------Successfully Redirected to Dashboard page on Clicking gotoDashboard Button-----------");
		wait.until(ExpectedConditions.visibilityOf(dashboard.recentBrandName()));
		//Assert.assertEquals(dashboard.recentBrandName().getText(), readProperties("editBrandName"));
		driver.get("https://partner-staging.dotgo.com/developer/bot-console/hnpctqH-95qUt22TaFcqoA==");
		wait.until(ExpectedConditions.textToBePresentInElement(edit.ConsoleBrandName(),readProperties("editBrandName")+randInt));
		//Thread.sleep(2000);
		String brandName = edit.ConsoleBrandName().getText();
		Log.info("name is "+brandName);
		String[] BotName = brandName.split(":");
		Assert.assertEquals(BotName[1].trim(), readProperties("editBrandName")+randInt);
		Log.info("-----------Successfully Changes are reflecting in the Dashboard Bot list--------");
		Listeners.test.log(Status.INFO,"-------Successfully Changes are reflecting in the Dashboard Bot list------");
		
	}
	
	@Test
	public void changeBotLogo() throws IOException, InterruptedException {
		
		BotConsolePage edit = editBot();
		RcsBotDetailsPage editBot = new RcsBotDetailsPage(driver);
		editBot.uploadBotLogo().click();
		Log.info("Clicked on upload BOT logo");
		editBot.selectBotLogo().sendKeys(Base.localDir+"//utils/Apple.png");
		Actions crop = new Actions(driver);
		crop.clickAndHold(editBot.cropHandle()).moveByOffset(223, 223).release().build().perform(); //Cropped the Image to 224px * 224px
		Log.info("Cropped Image to the 224 pixels Wide x 224 pixels Tall");
		editBot.select().click();
		Log.info("Uploaded Bot Logo from local Utils");
		Thread.sleep(2000);
		JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
		scrollPage.executeScript("window.scrollBy(0,2000)", "");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(edit.saveChanges()));
		edit.saveChanges().click();
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElement(edit.popupMessage(),"Bot details has been updated successfully"));
		Assert.assertEquals(edit.popupMessage().getText(), "Bot details has been updated successfully");
		Log.info("-----------Successfully Bot details has been updated successfully-------");
		edit.cancel().click();
		
	}
	
	@Test
	public void changeBannerImage() throws IOException, InterruptedException {
		
		BotConsolePage edit = editBot();
		RcsBotDetailsPage editBot = new RcsBotDetailsPage(driver);
		editBot.uploadBannerImage().click();
		Log.info("Clicked on upload Banner Image");
		editBot.selectBotLogo().sendKeys(Base.localDir+"//utils/VI_white.png");
		Actions crop = new Actions(driver);
		crop.clickAndHold(editBot.cropHandle()).moveByOffset(550, 170).release().build().perform(); //Cropped the Image to 1440px * 448px
		Log.info("Cropped Image to the 550 pixels Wide x 170 pixels Tall");
		editBot.select().click();
		Log.info("Uploaded Banner Image from local Utils");
		Thread.sleep(2000);
		JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
		scrollPage.executeScript("window.scrollBy(0,2000)", "");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(edit.saveChanges()));
		edit.saveChanges().click();
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElement(edit.popupMessage(),"Bot details has been updated successfully"));
		Assert.assertEquals(edit.popupMessage().getText(), "Bot details has been updated successfully");
		Log.info("-----------Successfully Bot details has been updated successfully-------");
		edit.cancel().click();
		
	}
	
	
	@Test
	public void editShortDesc() throws IOException, InterruptedException {
		
		BotConsolePage edit = editBot();
		BotDetailsAndExperience editBot = new BotDetailsAndExperience(driver);
		JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
		scrollPage.executeScript("window.scrollBy(0,200)", "");
		editBot.shortDesc().clear();
		editBot.shortDesc().sendKeys(readProperties("editShortDesc")+randInt);
		Log.info("Edited Short Description with slated string Followed by.");
		scrollPage.executeScript("window.scrollBy(0,2000)", "");
		Log.info("Scrolled the page Down");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(edit.saveChanges()));
		edit.saveChanges().click();
		Log.info("clicked on SaveChanges Button");
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElement(edit.popupMessage(),"Bot details has been updated successfully"));
		Assert.assertEquals(edit.popupMessage().getText(), "Bot details has been updated successfully");
		Log.info("-----------Successfully Bot details has been updated successfully-------");
		edit.cancel().click();
	}
	
	@Test
	public void editTermsOfURL() throws IOException, InterruptedException {
		
		BotConsolePage edit = editBot();
		BotDetailsAndExperience editBot = new BotDetailsAndExperience(driver);
		JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
		scrollPage.executeScript("window.scrollBy(0,1000)", "");
		editBot.termsOfURL().clear();
		editBot.termsOfURL().sendKeys(readProperties("TermsofService")+randInt);
		Log.info("Edited Terms of URL with salted string Followed by.");
		scrollPage.executeScript("window.scrollBy(0,2000)", "");
		Log.info("Scrolled the page Down");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(edit.saveChanges()));
		edit.saveChanges().click();
		Log.info("clicked on SaveChanges Button");
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElement(edit.popupMessage(),"Bot details has been updated successfully"));
		Assert.assertEquals(edit.popupMessage().getText(), "Bot details has been updated successfully");
		Log.info("-----------Successfully Bot details has been updated successfully-------");
		edit.cancel().click();
	}

	@Test
	public void editPrivacyPolicyURL() throws IOException, InterruptedException {
		
		BotConsolePage edit = editBot();
		BotDetailsAndExperience editBot = new BotDetailsAndExperience(driver);
		JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
		scrollPage.executeScript("window.scrollBy(0,1000)", "");
		editBot.privacyPolicy().clear();
		editBot.privacyPolicy().sendKeys(readProperties("PrivacyPolicyURL")+randInt);
		Log.info("Edited Privacy Policy URL with salted string Followed by.");
		scrollPage.executeScript("window.scrollBy(0,2000)", "");
		Log.info("Scrolled the page Down");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(edit.saveChanges()));
		edit.saveChanges().click();
		Log.info("clicked on SaveChanges Button");
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElement(edit.popupMessage(),"Bot details has been updated successfully"));
		Assert.assertEquals(edit.popupMessage().getText(), "Bot details has been updated successfully");
		Log.info("-----------Successfully Bot details has been updated successfully-------");
		edit.cancel().click();
		
	}
	
	@Test(priority=-1)
	public void editBotMessageType() throws IOException, InterruptedException {
		
		BotConsolePage edit = editBot();
		BotDetailsAndExperience editBot = new BotDetailsAndExperience(driver);
		JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
	    flag = editBot.promotionalCheckBox().isSelected();
	    Log.info("flag is "+flag);
		if(flag) {
			
			editBot.otp().click();
			Log.info("Changed Bot Message type to OTP");
			
		}
		
		else {
			
			editBot.promotional().click();
			Log.info("Changed Bot Message type to Promtional");
			
		}
		Log.info("Edited Bot Message Type");
		scrollPage.executeScript("window.scrollBy(0,2000)", "");
		Log.info("Scrolled the page Down");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(edit.saveChanges()));
		edit.saveChanges().click();
		Log.info("clicked on SaveChanges Button");
		wait.until(ExpectedConditions.textToBePresentInElement(edit.popupMessage(),"Bot details has been updated successfully"));
		Assert.assertEquals(edit.popupMessage().getText(), "Bot details has been updated successfully");
		Log.info("-----------Successfully Bot details has been updated successfully-------");
		edit.cancel().click();
		
	}
	
	@Test(priority=3)
	public void removeBannerImage() throws IOException, InterruptedException {
		
		BotConsolePage edit = editBot();
		BotDetailsAndExperience editBot = new BotDetailsAndExperience(driver);
		JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
		editBot.removeBannerImage().click();
		Thread.sleep(1000);
		Log.info("Removed Banner Image");
		scrollPage.executeScript("window.scrollBy(0,2000)", "");
		Log.info("Scrolled the page Down");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(edit.saveChanges()));
		edit.saveChanges().click();
		Log.info("clicked on SaveChanges Button");
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElement(editBot.errorMessage(),"Please enter all the details properly"));
		Assert.assertEquals(editBot.errorMessage().getText(), "Please enter all the details properly");
		Log.info("-----------Successfully Error Message Displayed as 'Please enter all the details properly'-------");
		
	}
	
	@Test
	public void editPrimaryPhoneNumber() throws IOException, InterruptedException {
		
		BotConsolePage edit = editBot();
		BotDetailsAndExperience editBot = new BotDetailsAndExperience(driver);
		JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
		scrollPage.executeScript("window.scrollBy(0,800)", "");
		editBot.phoneNumber().clear();
		editBot.phoneNumber().sendKeys(81475+randInt);
		Log.info("Edited Primary Phone Number");
		scrollPage.executeScript("window.scrollBy(0,2000)", "");
		Log.info("Scrolled the page Down");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(edit.saveChanges()));
		edit.saveChanges().click();
		Log.info("clicked on SaveChanges Button");
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElement(edit.popupMessage(),"Bot details has been updated successfully"));
		Assert.assertEquals(edit.popupMessage().getText(), "Bot details has been updated successfully");
		Log.info("-----------Successfully Bot details has been updated successfully-------");
		edit.cancel().click();
		
	}
	
	@Test
	public void editPrimaryPhoneNumberLabel() throws IOException, InterruptedException {
		
		BotConsolePage edit = editBot();
		BotDetailsAndExperience editBot = new BotDetailsAndExperience(driver);
		JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
		scrollPage.executeScript("window.scrollBy(0,800)", "");
		editBot.phoneNumberLabel().clear();
		editBot.phoneNumberLabel().sendKeys("Phone"+randInt);
		Log.info("Edited Primary Phone Number Label");
		scrollPage.executeScript("window.scrollBy(0,2000)", "");
		Log.info("Scrolled the page Down");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(edit.saveChanges()));
		edit.saveChanges().click();
		Log.info("clicked on SaveChanges Button");
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElement(edit.popupMessage(),"Bot details has been updated successfully"));
		Assert.assertEquals(edit.popupMessage().getText(), "Bot details has been updated successfully");
		Log.info("-----------Successfully Bot details has been updated successfully-------");
		edit.cancel().click();
		
	}
	
	@Test
	public void editLanguageSupported() throws IOException, InterruptedException {
		
		BotConsolePage edit = editBot();
		BotDetailsAndExperience editBot = new BotDetailsAndExperience(driver);
		JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
		scrollPage.executeScript("window.scrollBy(0,1500)", "");
		editBot.languagesSupported().clear();
		editBot.languagesSupported().sendKeys("English"+randInt);
		Log.info("Edited Language supported");
		scrollPage.executeScript("window.scrollBy(0,2000)", "");
		Log.info("Scrolled the page Down");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(edit.saveChanges()));
		edit.saveChanges().click();
		Log.info("clicked on SaveChanges Button");
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElement(edit.popupMessage(),"Bot details has been updated successfully"));
		Assert.assertEquals(edit.popupMessage().getText(), "Bot details has been updated successfully");
		Log.info("-----------Successfully Bot details has been updated successfully-------");
		edit.cancel().click();
		
	}
	
	
	
	@Test
	public void changeColor() throws IOException, InterruptedException {
		
		BotConsolePage edit = editBot();
		BotDetailsAndExperience editBot = new BotDetailsAndExperience(driver);
		JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
		scrollPage.executeScript("window.scrollBy(0,200)", "");
		String Value = editBot.color().getAttribute("value");
		
		if(Value.equals("#000000")) {
			Log.info("Color value is '#000000' i.e Black");
			editBot.color().clear();
			Log.info("Color Value is Cleared");
			editBot.color().sendKeys("#3465a4");
			Log.info("Changed the color to '#3465a4' i.e Parrot Green");
			
		}
		
		else {
			editBot.color().clear();
			Log.info("Color Value is Cleared");
			editBot.color().sendKeys("#000000");
			Log.info("Changed the color to '#000000' i.e Black");
		}
		
		scrollPage.executeScript("window.scrollBy(0,2000)", "");
		Log.info("Scrolled the page Down");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(edit.saveChanges()));
		edit.saveChanges().click();
		Log.info("clicked on SaveChanges Button");
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElement(edit.popupMessage(),"Bot details has been updated successfully"));
		Assert.assertEquals(edit.popupMessage().getText(), "Bot details has been updated successfully");
		Log.info("-----------Successfully Bot details has been updated successfully-------");
		edit.cancel().click();
		
	}
	
	
	
	@Test
	public void editBrandNamewithAutoFill() throws IOException, InterruptedException {
		
		BotConsolePage edit = editBot();
		BotDetailsAndExperience editBot = new BotDetailsAndExperience(driver);
		editBot.brandNameAutoFill().click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(editBot.brandNameAutoFillSecondOption()));
		editBot.brandNameAutoFillSecondOption().click();
		Log.info("Edited the Brand Name");
		JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
		scrollPage.executeScript("window.scrollBy(0,2000)", "");
		Log.info("Scrolled the page Down");
		wait.until(ExpectedConditions.elementToBeClickable(edit.saveChanges()));
		edit.saveChanges().click();
		Log.info("clicked on SaveChanges Button");
		wait.until(ExpectedConditions.textToBePresentInElement(edit.popupMessage(),"Bot details has been updated successfully"));
		Assert.assertEquals(edit.popupMessage().getText(), "Bot details has been updated successfully");
		Log.info("-----------Successfully Bot details has been updated successfully------");
		edit.cancel().click();
		
	}
	
	@Test
	public void editRCSAPI() throws IOException, InterruptedException {
		
		BotConsolePage edit = editBot();
		BotDetailsAndExperience editBot = new BotDetailsAndExperience(driver);
		JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
		scrollPage.executeScript("window.scrollBy(0,1500)", "");
		String rcsPlatform = editBot.rcsApi().getAttribute("value");
		
		if(rcsPlatform.equals("GSMA API")) {
			editBot.rcsApi().click();
			Select rcs = new Select(editBot.rcsApi());
			rcs.selectByValue("Google API");
			Log.info("Changed to Google API");
			
		}
		else {
			editBot.rcsApi().click();
			Select rcs = new Select(editBot.rcsApi());
			rcs.selectByValue("GSMA API");
			Log.info("Changed to GSMA API");
		}
		
		scrollPage.executeScript("window.scrollBy(0,2000)", "");
		Log.info("Scrolled the page Down");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(edit.saveChanges()));
		edit.saveChanges().click();
		Log.info("clicked on SaveChanges Button");
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElement(edit.popupMessage(),"Bot details has been updated successfully"));
		Assert.assertEquals(edit.popupMessage().getText(), "Bot details has been updated successfully");
		Log.info("-----------Successfully Bot details has been updated successfully-------");
		edit.cancel().click();
		
	}
	

	@Test
	public void editPrimaryEmailID() throws IOException, InterruptedException {
		
		BotConsolePage edit = editBot();
		BotDetailsAndExperience editBot = new BotDetailsAndExperience(driver);
		JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
		scrollPage.executeScript("window.scrollBy(0,800)", "");
		editBot.primaryEmailID().clear();
		editBot.primaryEmailID().sendKeys("Test"+randInt+"@gmail.com");
		Log.info("Edited Primary Email ID");
		scrollPage.executeScript("window.scrollBy(0,2000)", "");
		Log.info("Scrolled the page Down");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(edit.saveChanges()));
		edit.saveChanges().click();
		Log.info("clicked on SaveChanges Button");
		wait.until(ExpectedConditions.textToBePresentInElement(edit.popupMessage(),"Bot details has been updated successfully"));
		Assert.assertEquals(edit.popupMessage().getText(), "Bot details has been updated successfully");
		Log.info("-----------Successfully Bot details has been updated successfully-------");
		edit.cancel().click();
		
	}
	
	@Test
	public void editPrimaryEmailIDLabel() throws IOException, InterruptedException {
		
		BotConsolePage edit = editBot();
		BotDetailsAndExperience editBot = new BotDetailsAndExperience(driver);
		JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
		scrollPage.executeScript("window.scrollBy(0,800)", "");
		editBot.primaryEmailIDLabel().clear();
		editBot.primaryEmailIDLabel().sendKeys("TestEmail"+randInt);
		Log.info("Edited Primary Email ID Label");
		scrollPage.executeScript("window.scrollBy(0,2000)", "");
		Log.info("Scrolled the page Down");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(edit.saveChanges()));
		edit.saveChanges().click();
		Log.info("clicked on SaveChanges Button");
		wait.until(ExpectedConditions.textToBePresentInElement(edit.popupMessage(),"Bot details has been updated successfully"));
		Assert.assertEquals(edit.popupMessage().getText(), "Bot details has been updated successfully");
		Log.info("-----------Successfully Bot details has been updated successfully-------");
		edit.cancel().click();
		
	}
	
	@Test
	public void saveEditedChanges() throws IOException, InterruptedException {
		
		BotConsolePage edit = editBot();
		BotDetailsAndExperience editBot = new BotDetailsAndExperience(driver);
		JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
		scrollPage.executeScript("window.scrollBy(0,800)", "");
		editBot.primaryEmailIDLabel().clear();
		editBot.primaryEmailIDLabel().sendKeys("TestEmail1"+randInt);
		Log.info("Edited Primary Email ID Label");
		scrollPage.executeScript("window.scrollBy(0,2000)", "");
		Log.info("Scrolled the page Down");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(edit.saveChanges()));
		edit.saveChanges().click();
		Log.info("clicked on SaveChanges Button");
		wait.until(ExpectedConditions.textToBePresentInElement(edit.popupMessage(),"Bot details has been updated successfully"));
		Assert.assertEquals(edit.popupMessage().getText(), "Bot details has been updated successfully");
		Log.info("-----------Successfully Bot details has been updated successfully-------");
		edit.cancel().click();
		
	}
	
	@AfterTest
	public void tearDown() {
		
		driver.close();
	}
	

}
