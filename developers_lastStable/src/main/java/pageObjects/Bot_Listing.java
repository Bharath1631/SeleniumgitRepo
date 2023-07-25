package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Bot_Listing {
	
	
	public WebDriver driver;

	public Bot_Listing(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//div[normalize-space()='Click Here to List']")
	WebElement clickheretolist;
	
	public WebElement clickHereToList() {
		return clickheretolist;
		
	}
	
	@FindBy(name="screenshot")
	WebElement screenshot;
	
	public WebElement uploadScreenshot() {
		return screenshot;
		
	}
	
	@FindBy(name="desc")
	WebElement description;
	
	public WebElement addDescription() {
		return description;
		
	}
	
	@FindBy(xpath="//div[@class=' css-1hwfws3']")
	WebElement category;
	
	public WebElement addcategory() {
		return category;
		
	}
	
	@FindBy(name="developed_by")
	WebElement developedby;
	
	public WebElement adddevelopedby() {
		return developedby;
		
	}
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement previewlisting;
	
	public WebElement previewListing() {
		return previewlisting;
		
	}
	
	@FindBy(xpath="(//button[@class='btn btn-red-round'])[2]")
	WebElement submitforlisting;
	
	public WebElement submitForListing() {
		return submitforlisting;
		
	}
	
	@FindBy(xpath="(//button[@class='btn btn-red-round'])[3]")
	WebElement confirm;
	
	public WebElement clickConfirm() {
		return confirm;
		
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-round margin-top-15']")
	WebElement gotodashboard;
	
	public WebElement goToDashboard() {
		return gotodashboard;
		
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-btr-round']")
	WebElement BackToEdit;
	
	public WebElement backToEdit() {
		return BackToEdit;
		
	}
	
	@FindBy(xpath="//button[@class='btn btn-white-round']")
	WebElement Cancel;
	
	public WebElement cancel() {
		return Cancel;
		
	}
	
	@FindBy(xpath="(//h4)[3]")
	WebElement SuccessPOPUP;
	
	public WebElement successPOPUP() {
		return SuccessPOPUP;
		
	}
	
}
