/*
	 * @Author : Anil kumar
	 * Module : WhatsappBOTDetails Webelements
	 * Date   : 19-oct-2022
	 */
package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WhatsappBotDetails {

	@SuppressWarnings("unused")
	private WebDriver driver;

	public WhatsappBotDetails(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
	
	
	@FindBy(name="bot_name")
	WebElement BotName;
	
	public WebElement botName() {
		return BotName;
		
	}
	
	
	@FindBy(name="brand_name")
	WebElement BrandName;
	
	public WebElement brandName() {
		return BrandName;
		
	}
	
	
	@FindBy(name="brand_website")
	WebElement BrandWebsite;
	
	public WebElement brandWebsite() {
		return BrandWebsite;
		
	}
	
	
	@FindBy(linkText="Upload")
	WebElement UploadBotLogo;
	
	public WebElement uploadBotLogo() {
		return UploadBotLogo;
		
	}
	
	
	@FindBy(xpath="//input[@name='myFile']")
	WebElement UploadBotImage;
	
	public WebElement uploadBotImage() {
		return UploadBotImage;
		
	}
	
	@FindBy(xpath="(//button[@class='btn btn-red-round'])[2]")
	WebElement Select;
	
	public WebElement select() {
		return Select;
		
	}
	
	@FindBy(id="files")
	WebElement UploadScreenshots;
	
	public WebElement uploadScreenshots() {
		return UploadScreenshots;
		
	}
	
	@FindBy(name="short_desc")
	WebElement ShortDescription;
	
	public WebElement shortDescription() {
		return ShortDescription;
		
	}
	
	@FindBy(name="long_desc")
	WebElement LongDescription;
	
	public WebElement longDescription() {
		return LongDescription;
		
	}
	
	@FindBy(name="bot_website_url")
	WebElement BotWebsiteUrl;
	
	public WebElement botWebsiteUrl() {
		return BotWebsiteUrl;
		
	}
	
	@FindBy(name="developed_by")
	WebElement DevelopedBy;
	
	public WebElement developedBy() {
		return DevelopedBy;
		
	}
	
	@FindBy(name="support_email")
	WebElement SupportEmail;
	
	public WebElement supportEmail() {
		return SupportEmail;
		
	}
	
	@FindBy(name="whatsapp_numberCountry")
	WebElement WhatsappNumberCountry;
	
	public WebElement whatsappNumberCountry() {
		return WhatsappNumberCountry;
		
	}
	
	@FindBy(name="whatsapp_number")
	WebElement WhatsappNumber;
	
	public WebElement whatsappNumber() {
		return WhatsappNumber;
		
	}
	
	
	@FindBy(name="launch_date")
	WebElement LaunchDate;
	
	public WebElement launchDate() {
		return LaunchDate;
		
	}
	
	@FindBy(name="terms_of_use")
	WebElement TermsOfUse;
	
	public WebElement termsOfUse() {
		return TermsOfUse;
		
	}
	
	@FindBy(name="privacy_policy")
	WebElement PrivacyPolicy;
	
	public WebElement privacyPolicy() {
		return PrivacyPolicy;
		
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-round']")
	WebElement Next;
	
	public WebElement next() {
		return Next;
		
	}
	

	@FindBy(xpath="//div[@data-ord='se']")
	WebElement CropHandle;
	
	public WebElement cropHandle() {
		return CropHandle;
	}
	
	
}
