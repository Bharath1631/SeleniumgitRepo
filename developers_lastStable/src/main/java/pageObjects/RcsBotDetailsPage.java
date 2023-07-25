/*
	 * @Author : Anil kumar
	 * Module : Create New RCS BOT functionality
	 * Date   : 12-Oct-2022
	 */
package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RcsBotDetailsPage {

	private WebDriver driver;


	public RcsBotDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//input[@name='bot_name']")
	WebElement BotName;
	
	@FindBy(css="input[name='brand_name']")
	WebElement BrandName;
	
	@FindBy(xpath="(//a/span)[3]")
	//@FindBy(xpath="//span[@class='text-red cursor-pointer']")
	WebElement UploadBotLogo;
	
	
	//@FindBy(css="input[class*='file-input1']")
	@FindBy(name="myFile")
	WebElement SelectBotLogo;
	
	
	
	@FindBy(xpath="(//a/span[@class='text-red cursor-pointer'])[3]")
	WebElement UploadBannerImage;
	
	@FindBy(css="textarea[name='bot_short_desc']")
	WebElement ShortDescription;
	
	@FindBy(css="input[name='color1']")
	WebElement Color;
	
	@FindBy(css="input[type='tel']")
	WebElement PrimaryPhoneNumber;
	
	@FindBy(css="input[name*='phone_list']")
	WebElement PrimaryPhoneNumberLabel;
	
	@FindBy(css="input[type='email']")
	WebElement PrimaryEmailId;
	
	@FindBy(css="input[name*='email_list.0.label']")
	WebElement PrimaryEmailIdLabel;
	
	@FindBy(name="tos_url")
	WebElement TermsOfUseUrl;
	
	@FindBy(name="pp_url")
	WebElement PrivacyPolicyUrl;
	
	@FindBy(name="development_platform")
	WebElement RcsApi;
	
	@FindBy(name="gsma_chatbot")
	WebElement ChatBotWebhook;
	
	@FindBy(name="languages_supported")
    WebElement LanguagesSupported;	
	
	@FindBy(css="button[class*='btn-round-red-bdr']")
	WebElement Back;
	
	@FindBy(css="button[class*='btn-red-round']")
	WebElement Next;
	
	
	//@FindBy(css="(button[class*='btn btn-red'])[1]")
	@FindBy(xpath="(//button[@class='btn btn-red-round'])[2]")
	WebElement Select;
	
	
	@FindBy(xpath="//input[class='drop-zone__input custom-file-input1']")
	WebElement SelectBannerImage;
	
	
	@FindBy(name="website_list.0.value")
	WebElement PrimaryWebsite;
	
	@FindBy(name="website_list.0.label")
	WebElement PrimaryWebsiteLabel;
	
	
	
	public WebElement botName() {
		return BotName; 
	}
	
	public WebElement brandName() {
		return BrandName; 
	}
	
	public WebElement uploadBotLogo() {
		return UploadBotLogo; 
	}
	
	public WebElement uploadBannerImage() {
		return UploadBannerImage; 
	}
	
	public WebElement shortDescription() {
		return ShortDescription; 
	}
	
	public WebElement color() {
		return Color; 
	}
	
	public WebElement primaryPhoneNumber() {
		return PrimaryPhoneNumber; 
	}
	
	public WebElement primaryPhoneNumberLabel() {
		return PrimaryPhoneNumberLabel; 
	}
	
	public WebElement primaryEmailId() {
		return PrimaryEmailId; 
	}
	
	public WebElement primaryEmailIdLabel() {
		return PrimaryEmailIdLabel; 
	}
	
	public WebElement termsOfUseUrl() {
		return TermsOfUseUrl; 
	}
	
	public WebElement privacyPolicyUrl() {
		return PrivacyPolicyUrl; 
	}
	
	public WebElement rcsApi() {
		return RcsApi; 
	}
	
	public WebElement chatBotWebhook() {
		return ChatBotWebhook; 
	}
	
	public WebElement languagesSupported() {
		return LanguagesSupported; 
	}
	
	public WebElement back() {
		return Back; 
	}
	
	public SelectCarriers next() {
		Next.click();
		SelectCarriers carrier = new SelectCarriers(driver); 
		return carrier; 
	}
	
	public WebElement selectBotLogo() {
		return SelectBotLogo; 
	}
	
	public WebElement select() {
		return Select;
	}
	
	
	public WebElement selectBannerImage() {
		return SelectBannerImage;
	
		}
	
	public WebElement primaryWebsite() {
		return PrimaryWebsite;
	}
	
	public WebElement primaryWebsiteLabel() {
		return PrimaryWebsiteLabel;
	}
	
	@FindBy(xpath="//div[@data-ord='se']")
	WebElement CropHandle;
	
	public WebElement cropHandle() {
		return CropHandle;
	}
	
	@FindBy(xpath="//a[@href='/developer-pp']")
	WebElement PrivacyPolicy;
	
	public WebElement privacyPolicy() {
		return PrivacyPolicy;
	}
	
	@FindBy(xpath="//a[@href='/developer-tos']")
	WebElement TermsofService;
	
	public WebElement termsofService() {
		return TermsofService;
	}
	
	@FindBy(xpath="//a[@href='/rbm-terms']")
	WebElement RbmTerms;
	
	public WebElement rbmTerms() {
		return RbmTerms;
	}
	
	@FindBy(xpath="//a[@href='/rbm-policies']")
	WebElement RbmPolicies;
	
	public WebElement rbmPolicies() {
		return RbmPolicies;
	}
	
	
	@FindBy(xpath="//div[@role='none presentation']")
	WebElement Opacity;
	
	public WebElement opacity() {
		return Opacity;
	}
	
	@FindBy(xpath="(//span[@class='font-weight-normal font-size-16'])[1]")
	WebElement Transactional;
	
	public WebElement transactional() {
		return Transactional;
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
	
	@FindBy(xpath="//a/span[@class='text-red cursor-pointer']")
	WebElement Remove;
	
	public WebElement remove() {
		return Remove;
	}
}
