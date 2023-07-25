package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewDotgoAggregatorsDetails {
	
	public WebDriver driver;


	public ViewDotgoAggregatorsDetails(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath=("//button[@class='btn btn-green-round']"))
	WebElement approve;
	
	public WebElement clickApprove() {
		return approve;
		}
	
	@FindBy(xpath=("//button[@class='btn btn-red-round']"))
	WebElement ok;
	
	public WebElement clickOk() {
		return ok;
		}
	@FindBy(xpath=("//button[@class='btn btn-white-round']"))
	WebElement cancle;
	
	public WebElement clickCancle() {
		return cancle;
		}
	@FindBy(xpath=("//button[@class='btn btn-red-round']"))
	WebElement reasonapprove;
	
	public WebElement reasonApprove() {
		return reasonapprove;
		}
	
	@FindBy(name=("reason"))
	WebElement reason;
	
	public WebElement EnterReason() {
		return reason;
		}
	
	@FindBy(xpath="//h5")
	WebElement ApprovePopup;
	
	public WebElement approvePopup() {
		return ApprovePopup;
		}

	
	
}

