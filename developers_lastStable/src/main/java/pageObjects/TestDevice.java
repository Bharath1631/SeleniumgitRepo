package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestDevice {
	
	public WebDriver driver;
	public TestDevice(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath="//a[normalize-space()='Puma_bot']")
	WebElement botclick;
	
	public WebElement clickBotButton() {
		return botclick;
	}
	@FindBy(xpath="//strong[normalize-space()='+ Add a Test Device']")
	WebElement testdevice;
	
	public WebElement clickAddTestDevice() {
		return testdevice;
	}
	
	@FindBy(xpath="//h3[normalize-space()='Add Test Devices']")
	WebElement textaddtestdevice;
	
	public WebElement addTestDeviceText() {
		return textaddtestdevice;
	}
	
	@FindBy(name="mobile_number")
	WebElement mobilenumber;
	
	public WebElement enterMobileNumber() {
		return mobilenumber;
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-test-device']")
	WebElement addbutton;
	
	public WebElement clickAddButton() {
		return addbutton;
	}
	@FindBy(xpath="//button[@class='btn btn-red-round']")
	WebElement addbuttonok;
	
	public WebElement clickAddButtonOK() {
		return addbuttonok;
	}
	
	@FindBy(name="mobile_numberCountry")
	WebElement countryname;
	
	public WebElement clickCountryName() {
		return countryname;
	}
	
	@FindBy(xpath="//p[@class='text-red position-abs']")
	WebElement invalidnumbertext;
	
	public WebElement invalidNumberText() {
		return invalidnumbertext;
	}
	@FindBy(xpath="//h2[@class='MuiTypography-root MuiTypography-h6']")
	WebElement notrcsnumberpop;
	
	public WebElement rcsDisbaledPOPUP() {
		return notrcsnumberpop;
	}
	
	@FindBy(xpath="//div[@class='status-black']")
	WebElement failed;
	
	public WebElement failedStatus() {
		return failed;
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-round']")
	WebElement back;
	
	public WebElement rcsDisabledBackPOpUp() {
		return back;
	}
	@FindBy(name="mobile_number")
	WebElement countrycode;
	
	public WebElement countryCode() {
		return countrycode;
	}
	
	@FindBy(xpath="//div[@class='status-black']")
	WebElement pending;
	
	public WebElement pendingStatus() {
		return pending;
	}
	
	@FindBy(xpath="//h2[@class='MuiTypography-root MuiTypography-h6']")
	WebElement alreadyexist;
	
	public WebElement alreadyExistDevice() {
		return alreadyexist;
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-round']")
	WebElement alreadyexistback;
	
	public WebElement alreadyExistDeviceBackButton() {
		return alreadyexistback;
	}
	
	@FindBy(xpath="//img[@class='margin-left-10 ']")
	WebElement refresh;
	
	public WebElement clickRefresh() {
		return refresh;
	}
	
	@FindBy(xpath="//img[@src='images/icon_delete.svg']")
	WebElement trash;
	
	public WebElement clickTrash() {
		return trash;
	}
	
	
	@FindBy(xpath="//button[@class='btn btn-white-round']")
	WebElement clicktrashcancel;
	
	public WebElement clickOnTrashCancel() {
		return clicktrashcancel;
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-round']")
	WebElement clicktrashyes;
	
	public WebElement clickOnTrashYes() {
		return clicktrashyes;
	}
	
	@FindBy(xpath="//h5")
	WebElement popupmessage;
	
	public WebElement popUPMessageDelete() {
		return popupmessage;
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-round margin-top-15']")
	WebElement deletemessageok;
	
	public WebElement deleteMessageOK() {
		return deletemessageok;
	}
	
	@FindBy(xpath="//div[@class='modal-body text-center']")
	WebElement confirmdeletepopup;
	
	public WebElement confirmDeletePopup() {
		return confirmdeletepopup;
	}
	
	@FindBy(xpath="//p[normalize-space()='No Test devices']")
	WebElement notestdevice;
	
	public WebElement noTestDevice() {
		return notestdevice;
	}
	
	@FindBy(xpath="//a[normalize-space()='Send test message']")
	WebElement sendtestmessage;
	
	public WebElement clickSendTestMessage() {
		return sendtestmessage;
	}
	
	@FindBy(xpath="//button[@class='btn btn-round-red-bdr']")
	WebElement sendtestmessagecancel;
	
	public WebElement clickSendTestMessageCancel() {
		return sendtestmessagecancel;
	}
	
	@FindBy(xpath="//a[@class='rounded-left']")
	WebElement sendtextmessage;
	
	public WebElement clickSendTextMessage() {
		return sendtextmessage;
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-round']")
	WebElement clicksendbutton;
	
	public WebElement clickSendButton() {
		return clicksendbutton;
	}
	
	@FindBy(xpath="(//button[@class='btn btn-red-round'])[2]")
	WebElement sendmessageok;
	
	public WebElement sendMessageOk() {
		return sendmessageok;
	}
	
	@FindBy(xpath="//a[normalize-space()='This is a rich card']")
	WebElement clickrichcard;
	
	public WebElement clickRichCard() {
		return clickrichcard;
	}

	@FindBy(xpath="//span[@class='link-red pull-left font-size-16']")
	WebElement gobackbutton;
	
	public WebElement goBackButton() {
		return gobackbutton;
	}
	
	@FindBy(xpath="//a[normalize-space()='URCS_2']")
	WebElement sendmessagebot;
	
	public WebElement sendMessageBot() {
		return sendmessagebot;
	}
	
	@FindBy(xpath="(//h3)[4]")
	WebElement sendmessageassertText;
	
	public WebElement sendMessageAssertText() {
		return sendmessageassertText;
	}
	@FindBy(xpath="//a[@class='rounded-right']")
	WebElement suggestionreply;
	
	public WebElement suggestionReply() {
		return suggestionreply;
	}
	
	@FindBy(xpath="(//td)[1]")
	WebElement fetchingphonenumber;
	
	public WebElement fetchingPhoneNumber() {
		return fetchingphonenumber;
	}
	
	@FindBy(xpath="(//h3)[3]")
	WebElement popmessagercsnotenabled;
	
	public WebElement popMessageRCSNotEnabled() {
		return popmessagercsnotenabled;
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-round']")
	WebElement backpopup;
	
	public WebElement clickBack() {
		return backpopup;
	}
	
	@FindBy(xpath="//div[@class='MuiDialogContent-root common__modal']")
	WebElement checkingpopup;
	
	public WebElement checkingPOPUP() {
		return checkingpopup;
	}
	
	@FindBy(xpath="(//h3)[3]")
	WebElement testdeviceadded;
	
	public WebElement testDeviceAdded() {
		return testdeviceadded;
	}
}
