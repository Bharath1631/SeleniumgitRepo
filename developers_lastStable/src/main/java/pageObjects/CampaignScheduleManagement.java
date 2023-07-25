/*
	 * @Author : Anil kumar
	 * Module : Campaign Schedule Management Objects
	 * Date   : 06 March 2023
	 */
package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignScheduleManagement {
	
	private WebDriver driver;


	public CampaignScheduleManagement(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}

	@FindBy(name="campaign_name")
	WebElement CampaignName;
	
	public WebElement campaignName() {
		return CampaignName;
		
	}
	
	@FindBy(xpath="//input[@type='file']")
	WebElement UploadFile;
	
	public WebElement UploadFile() {
		return UploadFile;
		
	}
	
	@FindBy(xpath="//div[@id='tab']/a[1]")
	WebElement RunNow;
	
	public WebElement runNow() {
		return RunNow;
		
	}
	
	@FindBy(xpath="//div[@id='tab']/a[2]")
	WebElement RunLater;
	
	public WebElement RunLater() {
		return RunLater;
		
	}
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement Submit;
	
	public WebElement submit() {
		return Submit;
		
	}
	
	
	@FindBy(xpath="//p[@class='font-size-20']")
	WebElement ErrorAlert;
	
	public WebElement errorAlert() {
		return ErrorAlert;
		
	}
	
	@FindBy(xpath="(//h3)[2]")
	WebElement RemoveFileAlert;
	
	public WebElement removeFileAlert() {
		return RemoveFileAlert;
		
	}
	
	@FindBy(xpath="(//h3)[2]")
	WebElement SubmitCampaignAlert;
	
	public WebElement submitCampaignAlert() {
		return SubmitCampaignAlert;
		
	}
	
	@FindBy(xpath="//button[@class='btn  btn-red-bdr-round text-16']")
	WebElement RemoveFileAlertYes;
	
	public WebElement removeFileAlertYes() {
		return RemoveFileAlertYes;
		
	}
	@FindBy(xpath="//button[@class='btn  btn-red-bdr-round text-16']")
	WebElement SubmitCampaignNo;
	
	public WebElement submitCampaignNo() {
		return SubmitCampaignNo;
		
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-round text-16']")
	WebElement RemoveFileAlertNo;
	
	public WebElement removeFileAlertNo() {
		return RemoveFileAlertNo;
		
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-round text-16']")
	WebElement SubmitCampaignYes;
	
	public WebElement submitCampaignYes() {
		return SubmitCampaignYes;
		
	}
	
	@FindBy(xpath="//span[@class='font-color-green-upload']")
	WebElement FileUploadSuccessText;
	
	public WebElement fileUploadSuccessText() {
		return FileUploadSuccessText;
		
	}
	
	@FindBy(xpath="(//span/img)[1]")
	WebElement Delete;
	
	public WebElement delete() {
		return Delete;
		
	}
	
	@FindBy(xpath="//p[@class='margin-top-15']")
	WebElement SubmitSuccessAlert;
	
	public WebElement submitSuccessAlert() {
		return SubmitSuccessAlert;
		
	}
	
	@FindBy(xpath="(//button[@class='btn btn-red-round'])[2]")
	WebElement SubmitSuccessAlertMyCampaigns;
	
	public WebElement submitSuccessAlertMyCampaigns() {
		return SubmitSuccessAlertMyCampaigns;
		
	}
	
	@FindBy(xpath="//input[@type='date']")
	WebElement Date;
	
	public WebElement date() {
		return Date;
		
	}
	
	@FindBy(name="Hours")
	WebElement Hours;
	
	public WebElement hours() {
		return Hours;
		
	}
	
	@FindBy(name="Minutes")
	WebElement Minutes;
	
	public WebElement minutes() {
		return Minutes;
		
	}
	
	@FindBy(name="Seconds")
	WebElement seconds;
	
	public WebElement Seconds() {
		return Minutes;
		
	}
	
	@FindBy(name="AM/PM")
	WebElement AMorPM;
	
	public WebElement amORpm() {
		return AMorPM;
		
	}
	
	
	
	
}

