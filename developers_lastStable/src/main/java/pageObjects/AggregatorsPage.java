package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AggregatorsPage {
	
	public WebDriver driver;


	public AggregatorsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath=("//h3[@data-tabs='dotgo-aggregator']"))
	WebElement dotgoaggregators;
	
	public WebElement dotgoAggregatorsRequest() {
		return dotgoaggregators;
		}
	
	@FindBy(xpath=("//tbody/tr[1]/td[4]/div[1]/div[1]/a[1]/a[1]"))
	WebElement ApproveReject;
	
	public WebElement approveReject() {
		return ApproveReject;
		}

	
	
	@FindBy(xpath="(//th[@title='Toggle SortBy'])[2]")
	WebElement SubmittedDate;
	
	public WebElement submittedDate() {
		return SubmittedDate;
		}
	

	@FindBy(xpath="(//th[@title='Toggle SortBy'])[3]")
	WebElement DateOfSubmission;
	
	public WebElement dateOfSubmission() {
		return DateOfSubmission;
		}
	
	@FindBy(xpath="(//thead)[2]/tr[1]/th[3]")
	WebElement DateOfApproval;
	
	public WebElement dateOfApproval() {
		return DateOfApproval;
		}
	
	@FindBy(xpath="(//tr[1]/td[5]/a[1])[1]")
	WebElement CarrierApproveReject;
	
	public WebElement carrierApproveReject() {
		return CarrierApproveReject;
		}
	
	
	@FindBy(xpath="(//h3)[2]")
	WebElement AggregatorDetailsText;
	
	public WebElement aggregatorDetailsText() {
		return AggregatorDetailsText;
		}
	
	
	@FindBy(xpath="//button[@class='btn btn-green-round']")
	WebElement Approve;
	
	public WebElement approve() {
		return Approve;
		}
	
	@FindBy(xpath="//h5")
	WebElement PopUpText;
	
	public WebElement popUpText() {
		return PopUpText;
		}
	
	@FindBy(xpath="//button[@class='btn btn-red-round']")
	WebElement Yes;
	
	public WebElement yes() {
		return Yes;
		}
	
	
	@FindBy(name="reason")
	WebElement Reason;
	
	public WebElement reason() {
		return Reason;
		}
	
	@FindBy(xpath="//button[@class='btn btn-red-round']")
	WebElement RedApprove;
	
	public WebElement redapprove() {
		return RedApprove;
		}
	
	@FindBy(xpath="//button[@class='btn btn-red-round']")
	WebElement Ok;
	
	public WebElement ok() {
		return Ok;
		}
	
	@FindBy(xpath="(//h3)[1]")
	WebElement AggregatorName;
	
	public WebElement aggregatorName() {
		return AggregatorName;
		}
	
	@FindBy(xpath="(//thead)[2]")
	WebElement ApprovedAggregator;
	
	public WebElement approvedAggregator() {
		return ApprovedAggregator;
		}
	
	@FindBy(xpath="(//tbody/tr[1])[2]/td[1]")
	WebElement ApprovedAggregatorName;
	
	public WebElement approvedAggregatorName() {
		return ApprovedAggregatorName;
		}
	
	@FindBy(xpath="(//tbody/tr[1])[2]/td[4]")
	WebElement ApprovedAggregatorStatus;
	
	public WebElement approvedAggregatorStatus() {
		return ApprovedAggregatorStatus;
		}
}

