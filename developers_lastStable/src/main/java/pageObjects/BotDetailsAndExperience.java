/*
	 * @Author : Anil kumar
	 * Module : Bot Detils and Experience PageObjects
	 * Date   : 11 Jan 2023
	 */

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BotDetailsAndExperience {
	
	public WebDriver driver;

	public BotDetailsAndExperience(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath="//button[@class='status-red']")
	WebElement EditDetails;
	
	public WebElement editDetails() {
		return EditDetails;
		
	}
	
	@FindBy(xpath="//button[@class='status-red']")
	WebElement CancelDetails;
	
	public WebElement cancelDetails() {
		return CancelDetails;
		
	}
	
	@FindBy(xpath="(//span[@class='font-weight-normal font-size-16'])[1]")
	WebElement Transactional;
	
	public WebElement transactional() {
		return Transactional;
	}
	
//	@FindBy(xpath="(//span[@class='font-weight-normal font-size-16'])[2]")
	@FindBy(id="2")
	WebElement PromotionalCheckBox;
	
	public WebElement promotionalCheckBox() {
		return PromotionalCheckBox;
	}
	
	@FindBy(xpath="(//span[@class='font-weight-normal font-size-16'])[2]")
	WebElement Promotional;
	
	public WebElement promotional() {
		return Promotional;
	}
	
	@FindBy(xpath="(//span[@class='font-weight-normal font-size-16'])[3]")
	WebElement OTP;
	
	public WebElement otp() {
		return OTP;
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
	
	
	
	@FindBy(xpath="(//span[@class='text-red cursor-pointer'])[1]")
	WebElement UploadBotLogo;
	
	public WebElement uploadBotLogo() {
		return UploadBotLogo;
		
	}
	
	@FindBy(xpath="(//span[@class='text-red cursor-pointer'])[2]")
	WebElement RemoveBotLogo;
	
	public WebElement RemoveBotLogo() {
		return RemoveBotLogo;
		
	}
	
	@FindBy(xpath="(//span[@class='text-red cursor-pointer'])[3]")
	WebElement UploadBannerImage;
	
	public WebElement uploadBannerImage() {
		return UploadBannerImage;
		
	}
	
	@FindBy(xpath="(//span[@class='text-red cursor-pointer'])[4]")
	WebElement RemoveBannerImage;
	
	public WebElement removeBannerImage() {
		return RemoveBannerImage;
		
	}
	
	@FindBy(xpath="(//p[@class='text-red '])[2]")
	WebElement ErrorMessage;
	
	public WebElement errorMessage() {
		return ErrorMessage;
		
	}
	@FindBy(name="myFile")
	WebElement UploadImage;
	
	public WebElement uploadImage() {
		return UploadImage;
		
	}
	
	@FindBy(xpath="(//button[@class='btn btn-red-round'])[2]")
	WebElement Select;
	
	public WebElement select() {
		return Select;
		
	}
	
	@FindBy(name="short_desc")
	WebElement ShortDesc;
	
	public WebElement shortDesc() {
		return ShortDesc;
		
	}
	
	@FindBy(name="color1")
	WebElement Color;
	
	public WebElement color() {
		return Color;
		
	}
	
	@FindBy(name="phone_numberCountry")
	WebElement CountryCode;
	
	public WebElement countryCode() {
		return CountryCode;
		
	}
	
	@FindBy(name="phone_number")
	WebElement PhoneNumber;
	
	public WebElement phoneNumber() {
		return PhoneNumber;
		
	}
	
	@FindBy(name="phone_list.0.label")
	WebElement PhoneNumberLabel;
	
	public WebElement phoneNumberLabel() {
		return PhoneNumberLabel;
		
	}
	
	@FindBy(name="email_list.0.value")
	WebElement PrimaryEmailID;
	
	public WebElement primaryEmailID() {
		return PrimaryEmailID;
		
	}
	
	@FindBy(name="email_list.0.label")
	WebElement PrimaryEmailIDLabel;
	
	public WebElement primaryEmailIDLabel() {
		return PrimaryEmailIDLabel;
		
	}
	
	@FindBy(name="website_list.0.value")
	WebElement PrimaryWebsite;
	
	public WebElement primaryWebsite() {
		return PrimaryWebsite;
		
	}
	
	@FindBy(name="website_list.0.label")
	WebElement PrimaryWebsiteLabel;
	
	public WebElement primaryWebsiteLabel() {
		return PrimaryWebsiteLabel;
		
	}
	
	@FindBy(name="terms_of_url")
	WebElement TermsOfURL;
	
	public WebElement termsOfURL() {
		return TermsOfURL;
		
	}
	
	@FindBy(name="privacy_policy")
	WebElement PrivacyPolicy;
	
	public WebElement privacyPolicy() {
		return PrivacyPolicy;
		
	}
	
	@FindBy(name="development_platform")
	WebElement RcsApi;
	
	public WebElement rcsApi() {
		return RcsApi;
		
	}
	
	@FindBy(name="chatbot_webhook_url")
	WebElement ChatbotWebhook;
	
	public WebElement chatbotWebhook() {
		return ChatbotWebhook;
		
	}
	
	
	@FindBy(name="languages_supported")
	WebElement LanguagesSupported;
	
	public WebElement languagesSupported() {
		return LanguagesSupported;
		
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-round-bdr pull-right']")
	WebElement ChangeSelection;
	
	public WebElement changeSelection() {
		return ChangeSelection;
		
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-round-bdr']")
	WebElement BackToBotDashboard;
	
	public WebElement backToBotDashboard() {
		return BackToBotDashboard;
		
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-round']")
	WebElement SaveChanges;
	
	public WebElement SaveChanges() {
		return SaveChanges;
		
	}
	

	@FindBy(xpath="(//button[@class='btn btn-link auto-fill-rcs-bot'])[1]")
	WebElement BrandNameAutoFill;
	
	public WebElement brandNameAutoFill() {
		return BrandNameAutoFill;
		
	}
	
	@FindBy(xpath="(//ul[@class='brand-menu blist']/li)[2]")
	WebElement BrandNameAutoFillSecondOption;
	
	public WebElement brandNameAutoFillSecondOption() {
		return BrandNameAutoFillSecondOption;
		
	}
	
}
