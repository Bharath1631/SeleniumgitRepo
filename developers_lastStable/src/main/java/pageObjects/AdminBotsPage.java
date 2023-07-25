package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminBotsPage {
	
	public WebDriver driver;


	public AdminBotsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath="//th[normalize-space()='Submitted Date']")
    WebElement submitdate;
	
	public WebElement clickSubmittedDate() {
		return submitdate;
		}
	
	@FindBy(xpath="(//a[@class='purple-link'])[1]")
    WebElement create;
	
	public WebElement clickCreate() {
		return create;
		}
	
	@FindBy(xpath="//tbody/tr[1]/td[7]/div[1]/div[1]/a[1]/a[1]")
    WebElement approvereject;
	
	public WebElement clickApprovereject() {
		return approvereject;
		}
      
	@FindBy(xpath="//button[@class='btn btn-green-round']")
    WebElement approve;
	
	public WebElement clickApprove() {
		return approve;
		}
	
	@FindBy(xpath="//div[@class=' css-ql68v7-control']")
    WebElement selectmaapagent;
	
	public WebElement selectMaapAgent() {
		return selectmaapagent;
		}
	
	@FindBy(xpath="//div[@class='css-1d67vx3']")
    WebElement google;
	
	public WebElement selectGoogle() {
		return google;
		}
	
	@FindBy(xpath="//input[@class='file-input-field__uploader']")
    WebElement browse;
	
	public WebElement clickBrowse() {
		return browse;
		}
	

	@FindBy(xpath="//button[@class='ml-md btn btn-red-round']")
    WebElement Upload;
	
	public WebElement upload() {
		return Upload;
		}
	
	@FindBy(name="maap_credentials")
    WebElement maapcredentials;
	
	public WebElement maapCredentials() {
		return maapcredentials;
		}
	
	@FindBy(name="maap_assigned_id")
    WebElement maapassignedid;
	
	public WebElement maapAssignedID() {
		return maapassignedid;
		}
	
	@FindBy(name="extra_info")
    WebElement extrainfo;
	
	public WebElement extraInfo() {
		return extrainfo;
		}
	
	@FindBy(xpath="//button[@class='btn btn-red-round']")
    WebElement SubmitAgent;
	
	public WebElement submitAgent() {
		return SubmitAgent;
		}
	
	@FindBy(xpath="//button[@class='btn btn-red-round']")
    WebElement confirmapprove;
	
	public WebElement confirmApprove() {
		return confirmapprove;
		}
	
	@FindBy(xpath="//div[@class='status-verified ml-1']")
    WebElement Status;
	
	public WebElement status() {
		return Status;
		}
	
	
	@FindBy(xpath="(//button[@class='btn btn-red-round'])[2]")
    WebElement yes;
	
	public WebElement clickYes() {
		return yes;
		}
	
	@FindBy(name="action_reason")
    WebElement actionreason;
	
	public WebElement enterActionReason() {
		return actionreason;
		}
	
	@FindBy(xpath="(//button[@class='btn btn-red-round'])[2]")
    WebElement actionreasonapprove;
	
	public WebElement actionReasonApprove() {
		return actionreasonapprove;
		}
	
	@FindBy(xpath="//button[@class='btn btn-red-round']")
    WebElement ok;
	
	public WebElement clickOK() {
		return ok;
		}
	
	
	
	@FindBy(xpath="//span[@class='text-red']")
    WebElement Botname;
	
	public WebElement botname() {
		return Botname;
		}
	
	@FindBy(xpath="(//button[@class='btn btn-red-round'])[2]")
    WebElement Ok;
	
	public WebElement oK() {
		return Ok;
		}
	
	@FindBy(xpath="//h2")
    WebElement BotCreatePageText;
	
	public WebElement botCreatePageText() {
		return BotCreatePageText;
		}
}
