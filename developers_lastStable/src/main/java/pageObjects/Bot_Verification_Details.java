package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Bot_Verification_Details {
	
	public WebDriver driver;


	public Bot_Verification_Details(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath="//button[@class='btn btn-green-round']")
	WebElement approve;
	
	public WebElement approveBot() {
		return approve;
		
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-round2']")
	WebElement reject;
	
	public WebElement rejectBot() {
		return reject;
		
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-round2']")
	WebElement viewhistory;
	
	public WebElement viewHistory() {
		return viewhistory;
		
	}
	
	@FindBy(xpath="//button[@class='btn btn-blue-round margin-left-10']")
	WebElement createrbm;
	
	public WebElement createRBM() {
		return createrbm;
		
	}
	@FindBy(xpath="//button[@class='btn btn-red-round']")
	WebElement goback;
	
	public WebElement goBack() {
		return goback;
		
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-round margin-left-20']")
	WebElement yes;
	
	public WebElement clickYes() {
		return yes;
	}
	
	@FindBy(xpath="//div[@class=' css-1hwfws3']")
	WebElement rightclick;
	
	public WebElement selectAgent() {
		return rightclick;
	}
	
	@FindBy(xpath="//input[@class='file-input-field__uploader']")
	WebElement browse;
	
	public WebElement clickBrowse() {
		return browse;
	}
	
	@FindBy(name="maap_assigned_id")
	WebElement assignedID;
	
	public WebElement assignedID() {
		return assignedID;
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-round']")
	WebElement submitagent;
	
	public WebElement submitAgent() {
		return submitagent;
	}
	
	@FindBy(name="extra_info")
	WebElement extrajson;
	
	public WebElement extraJson() {
		return extrajson;
	}
	@FindBy(xpath="//button[@class='ml-md btn btn-red-round']")
	WebElement upload;
	
	public WebElement uploadRBMJson() {
		return upload;
	}
	@FindBy(xpath="//button[@class='btn btn-red-round']")
	WebElement confirmapprove;
	
	public WebElement confirmApprove() {
		return confirmapprove;
	}
	
	
	@FindBy(xpath="//button[@class='btn btn-red-round']")
	WebElement popupyes;
	
	public WebElement clickPopYes() {
		return popupyes;
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-round']")
	WebElement actionreason;
	
	public WebElement enterActionReason() {
		return actionreason;
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-round']")
	WebElement actionreasonapprove;
	
	public WebElement actionReasonApprove() {
		return actionreasonapprove;
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-round']")
	WebElement clickok;
	
	public WebElement clickOK() {
		return clickok;
	}
	
}
