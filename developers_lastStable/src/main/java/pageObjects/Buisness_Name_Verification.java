package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Buisness_Name_Verification {
	
	public WebDriver driver;

	public Buisness_Name_Verification(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(id="file_type_1")
	WebElement selectdoc;
	
	public WebElement selectDocumentType() {
		return selectdoc;
		
	}
	
	@FindBy(name="doc_")
	WebElement selectfile;
	
	public WebElement selectFile() {
		return selectfile;
		
	}
	
	@FindBy(id="file_type")
	WebElement buisnessselectdoc;
	
	public WebElement BuisnessselectDocumentType() {
		return buisnessselectdoc;
		
	}
	
	
	@FindBy(xpath="//span[@class='checkbox-custom rectangular']")
	WebElement accept;
	
	public WebElement acceptMessage() {
		return accept;
		
	}
    
	@FindBy(xpath="//button[@class='btn btn-red-round']")
	WebElement next;
	
	public WebElement clickNext() {
		return next;
		
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-round margin-left-20']")
	WebElement paymentsubmit;
	
	public WebElement paymentSubmit() {
		return paymentsubmit;
		
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-round']")
	WebElement gotodashboard;
	
	public WebElement goToDashBoard() {
		return gotodashboard;
		
	}
	
	@FindBy(xpath="(//img[@alt='download'])[1]")
	WebElement downloadibuisnessnamedoc;
	
	public WebElement downloadiBuisnessnameDoc() {
		return downloadibuisnessnamedoc;
		
	}
	
	@FindBy(xpath="(//img[@alt='download'])[2]")
	WebElement downloadibuisnessaddressdoc;
	
	public WebElement downloadiBuisnessAddressDoc() {
		return downloadibuisnessaddressdoc;
		
	}
	
	@FindBy(xpath="//h3")
	WebElement BussinessVerificationPageText;
	
	public WebElement bussinessVerificationPageText() {
		return BussinessVerificationPageText;
		
	}
	
	@FindBy(xpath="(//img[@alt='download'])[1]")
	WebElement DownloadIcon1;
	
	public WebElement downloadIcon1() {
		return DownloadIcon1;
		
	}
	
	@FindBy(xpath="(//img[@class='margin-left-10'])[1]")
	WebElement DeleteIcon1;
	
	public WebElement deleteIcon1() {
		return DeleteIcon1;
		
	}
	
	@FindBy(xpath="(//img[@alt='download'])[2]")
	WebElement DownloadIcon2;
	
	public WebElement downloadIcon2() {
		return DownloadIcon2;
		
	}
	
	@FindBy(xpath="(//img[@class='margin-left-10'])[2]")
	WebElement DeleteIcon2;
	
	public WebElement deleteIcon2() {
		return DeleteIcon2;
		
	}
	
	@FindBy(xpath="(//div/span)[18]")
	WebElement BusinessAddressDocName;
	
	public WebElement businessAddressDocName() {
		return BusinessAddressDocName;
		
	}
	
	@FindBy(xpath="//p[@class='text-red position-abs']")
	WebElement ErrorWithOutCheckBox;
	
	public WebElement errorWithOutCheckBox() {
		return ErrorWithOutCheckBox;
		
	}
	
	@FindBy(xpath="//h2")
	WebElement SummaryPageText;
	
	public WebElement summaryPageText() {
		return SummaryPageText;
		
	}
	
	@FindBy(xpath="(//thead/tr[1]/th[2])[1]")
	WebElement LaunchFeesText;
	
	public WebElement launchFeesText() {
		return LaunchFeesText;
		
	}
	
	@FindBy(xpath="(//thead/tr/th[3])[1]")
	WebElement MaintainanceFeesText;
	
	public WebElement maintainanceFeesText() {
		return MaintainanceFeesText;
		
	}
	
	
}
