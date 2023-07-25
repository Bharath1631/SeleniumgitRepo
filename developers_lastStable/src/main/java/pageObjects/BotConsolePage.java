/*
	 * @Author : Anil kumar
	 * Module : Bot console PageObjects
	 * Date   : 14 Oct 2022
	 */
package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BotConsolePage {
	
	
	public WebDriver driver;

	public BotConsolePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath="//a[@class='link-red']")
	WebElement ViewBotDetails;
	
	public WebElement viewBotDetails() {
		return ViewBotDetails;
		
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-btr-round']")
	WebElement editaddcarrier;
	
	public WebElement editAddCarrier() {
		return editaddcarrier;
		
	}
	
	
	@FindBy(xpath="//button[@class='status-red']")
	WebElement EditDetails;
	
	public WebElement editDetails() {
		return EditDetails;
		
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
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement SaveChanges;
	
	public WebElement saveChanges() {
		return SaveChanges;
		
	}
	
	@FindBy(xpath="//button[@class='btn btn-white-round']")
	WebElement Cancel;
	
	public WebElement cancel() {
		return Cancel;
		
	}
	
	
	@FindBy(xpath="(//button[@class='btn btn-red-round'])[2]")
	WebElement GotoDashboard;
	
	public WebElement gotoDashboard() {
		return GotoDashboard;
		
	}
	

	@FindBy(xpath="(//h3)[4]")
	WebElement PopupMessage;
	
	public WebElement popupMessage() {
		return PopupMessage;
		
	}

	@FindBy(linkText="Bot Details")
	WebElement BotDetailsLink;
	
	public WebElement botDetailsLink() {
		return BotDetailsLink;
		
	}
	
	@FindBy(xpath="(//img[@class='cursor-pointer'])[1]")
	WebElement TestTemplateIcon;
	
	public WebElement testTemplateIcon() {
		return TestTemplateIcon;
		
	}
	
	@FindBy(name="phoneNumber")
	WebElement TestPhoneNumber;
	
	public WebElement testPhoneNumber() {
		return TestPhoneNumber;
		
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-template']")
	WebElement AddButton;
	
	public WebElement addButton() {
		return AddButton;
		
	}
	
	@FindBy(xpath="(//h3)[2]")
	WebElement AlreadyExistPopUp;
	
	public WebElement alreadyExistPopUp() {
		return AlreadyExistPopUp;
		
	}
	
	@FindBy(xpath="(//button[@class='btn btn-red-round'])[2]")
	WebElement PopupBackButton;
	
	public WebElement popupBackButton() {
		return PopupBackButton;
		
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-round']")
	WebElement CountinueButton;
	
	public WebElement countinueButton() {
		return CountinueButton;
		
	}
	
	@FindBy(xpath="//p[@class='yesno-desc']")
	WebElement YesNoConfirmText;
	
	public WebElement yesNoConfirmText() {
		return YesNoConfirmText;
		
	}
	
	@FindBy(xpath="//button[@class='btn-pri-pop yesNo-btn-pad']")
	WebElement YesButton;
	
	public WebElement yesButton() {
		return YesButton;
		
	}
	
	@FindBy(xpath="(//h2)[2]")
	WebElement TestTemplateSuccessMessage;
	
	public WebElement testTemplateSuccessMessage() {
		return TestTemplateSuccessMessage;
		
	}


@FindBy(xpath="/html[1]/body[1]/div[1]/section[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[7]/div[1]/a[1]/img[1]']")
	WebElement viewdetails;
	
	public WebElement clickViewDetails() {
		return viewdetails;
		
	}
	
	@FindBy(xpath="//div[normalize-space()='Submit for Verification and Launch']")
	WebElement verificationandlaunch;
	
	public WebElement clickVerificationandLaunch() {
		return verificationandlaunch;
		
	}
	
	@FindBy(xpath="//div[@class='status-not-verified']")
	WebElement VerificationStatus;
	
	public WebElement verificationStatus() {
		return VerificationStatus;
		
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-round']")
	WebElement next;
	
	public WebElement clickNext() {
		return next;
		
	}
	@FindBy(id="select-screenshot")
	WebElement uploadimages;
	
	public WebElement clickUploadImages() {
		return uploadimages;
		
	}
	
	@FindBy(name="chat_bot_webhook")
	WebElement ChatbotWebhook;
	
	public WebElement ChatbotWWebhook() {
		return ChatbotWebhook;
		
	}
	
	@FindBy(name="bot_video_url")
	WebElement videourl;
	
	public WebElement enterVideoUrl() {
		return videourl;
		
	}
	
	@FindBy(name="opt_in_message")
	WebElement message;
	
	public WebElement eneterMessage() {
		return message;
		
	}
	
	@FindBy(name="trigger_actions")
	WebElement triggeractions;
	
	public WebElement triggerActions() {
		return triggeractions;
		
	}
	
	@FindBy(name="interaction_type")
	WebElement interactiontype;
	
	public WebElement enterInteractionType() {
		return interactiontype;
		
	}
	
	@FindBy(name="opt_out_message")
	WebElement optoutmessage;
	
	public WebElement enterOptOutMessage() {
		return optoutmessage;
		
	}
	
	@FindBy(name="access_instructions")
	WebElement instructions;
	
	public WebElement enterinstructions() {
		return instructions;
		
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-round']")
	WebElement nextverification;
	
	public WebElement clickNextVerificationPage() {
		return nextverification;
		
	}
	
	@FindBy(xpath="(//i[contains(@class,'fa-ellipsis-v')])[1]")
	WebElement TemplateOptions;
	
	public WebElement templateOptions() {
		return TemplateOptions;
		
	}
	
	@FindBy(id="downloadTemplate")
	WebElement DownloadTemplate;
	
	public WebElement downloadTemplate() {
		return DownloadTemplate;
		
	}
	
	@FindBy(xpath="(//a[@style='text-decoration: none;'])[1]")
	WebElement FirstTemplateName;
	
	public WebElement firstTemplateName() {
		return FirstTemplateName;
		
	}
	
	
	@FindBy(linkText="View Launch Details")
	WebElement ViewLaunchDetails;
	
	public WebElement viewLaunchDetails() {
		return ViewLaunchDetails;
		
	}
	
	@FindBy(xpath="(//tr/th)[1]")
	WebElement LaunchDetailsTablecolumn1;
	
	public WebElement launchDetailsTablecolumn1() {
		return LaunchDetailsTablecolumn1;
		
	}
	
	@FindBy(xpath="(//tr/th)[2]")
	WebElement LaunchDetailsTablecolumn2;
	
	public WebElement launchDetailsTablecolumn2() {
		return LaunchDetailsTablecolumn2;
		
	}
	
	@FindBy(xpath="(//tr/th)[3]")
	WebElement LaunchDetailsTablecolumn3;
	
	public WebElement launchDetailsTablecolumn3() {
		return LaunchDetailsTablecolumn3;
		
	}
	
	@FindBy(xpath="(//tr/th)[4]")
	WebElement LaunchDetailsTablecolumn4;
	
	public WebElement launchDetailsTablecolumn4() {
		return LaunchDetailsTablecolumn4;
		
	}
	
	@FindBy(linkText="Click Here")
	WebElement ClickHere;
	
	public WebElement clickHere() {
		return ClickHere;
		
	}
	
	
	@FindBy(xpath="//button[@class='btn btn-red-btr-round']")
	WebElement EditOrAddCarriers;
	
	public WebElement editOrAddCarriers() {
		return EditOrAddCarriers;
		
	}
	
	@FindBy(xpath="(//div[@class='carrier-rbm-box cursor-pointer'])[2]")
	WebElement SelectSecondCarrier;
	
	public WebElement selectSecondCarrier() {
		return SelectSecondCarrier;
		
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-round']")
	WebElement Submit;
	
	public WebElement submit() {
		return Submit;
		
	}
	
	@FindBy(xpath="//button[@class='btn  btn-red-bdr-round text-16']")
	WebElement Yes;
	
	public WebElement yes() {
		return Yes;
		
	}
	
	@FindBy(xpath="//h2")
	WebElement BotDetailsandExperiencePageText;
	
	public WebElement botDetailsandExperiencePageText() {
		return BotDetailsandExperiencePageText;
		
	}
	
	@FindBy(xpath="(//div[@class='footer'])[4]")
	WebElement ClickHereToList;
	
	public WebElement clickHereToList() {
		return ClickHereToList;
		
	}
	
	
	
	@FindBy(xpath="//p/strong")
	WebElement ConsoleBotName;
	
	public WebElement consoleBotName() {
		return ConsoleBotName;
		
	}
	
	@FindBy(xpath="//table[@class='font-size-15 margin-bottom-5 margin-top-5']")
	WebElement ConsoleBrandName;
	
	public WebElement ConsoleBrandName() {
		return ConsoleBrandName;
		
	}
	
	@FindBy(xpath="//div[@class='text-center link-red']")
	WebElement ViewSubmittedBotDetails;
	
	public WebElement ViewSubmittedBotDetails() {
		return ViewSubmittedBotDetails;
		
	}
}

