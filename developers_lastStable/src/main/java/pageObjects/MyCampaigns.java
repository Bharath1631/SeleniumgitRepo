package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyCampaigns {
	
	private WebDriver driver;


	public MyCampaigns(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}

	@FindBy(xpath="//a[@title='Edit Campaign']")
	WebElement Edit;
	
	public WebElement edit() {
		return Edit;
		
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-round']")
	WebElement ViewCampaignEdit;
	
	public WebElement viewCampaignEdit() {
		return ViewCampaignEdit;
		
	}
	
	@FindBy(xpath="//tbody/tr[1]/td[1]")
	WebElement RecentCampaign;
	
	public WebElement recentCampaign() {
		return RecentCampaign;
		
	}
	
	@FindBy(xpath="//a[@title='Cancel Campaign']")
	WebElement Cancel;
	
	public WebElement cancel() {
		return Cancel;
		
	}
	
	@FindBy(xpath="//button[@class='btn  btn-red-bdr-round text-16']")
	WebElement CancelCampaignNo;
	
	public WebElement CancelCampaignNo() {
		return CancelCampaignNo;
		
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-round text-16']")
	WebElement CancelCampaignYes;
	
	public WebElement CancelCampaignYes() {
		return CancelCampaignYes;
		
	}
	
	@FindBy(xpath="//input[@class='form-control margin-top-10']")
	WebElement Reason;
	
	public WebElement reason() {
		return Reason;
		
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-round']")
	WebElement CancelCampaignSubmit;
	
	public WebElement cancelCampaignSubmit() {
		return CancelCampaignSubmit;
		
	}
	
	@FindBy(xpath="(//h3)[2]")
	WebElement CanceledCampaignAlertText;
	
	public WebElement canceledCampaignAlertText() {
		return CanceledCampaignAlertText;
		
	}
}
