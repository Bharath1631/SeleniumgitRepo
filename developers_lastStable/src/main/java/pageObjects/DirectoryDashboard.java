package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DirectoryDashboard {

	private WebDriver driver;


	public DirectoryDashboard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath="//button[@class='btn btn-review margin-left-25 margin-top-25']")
	WebElement MyReview;
	
	public WebElement myReview() {
		return MyReview;
		
	}
	@FindBy(xpath="//label[@for='hover-feedback-1']")
	WebElement Rating1;
	
	public WebElement rating1() {
		return Rating1;
		
	}
	
	@FindBy(xpath="//label[@for='hover-feedback-2']")
	WebElement Rating2;
	
	public WebElement rating2() {
		return Rating2;
		
	}
	
	@FindBy(xpath="//label[@for='hover-feedback-3']")
	WebElement Rating3;
	
	public WebElement rating3() {
		return Rating3;
		
	}
	
	@FindBy(xpath="//label[@for='hover-feedback-4']")
	WebElement Rating4;
	
	public WebElement rating4() {
		return Rating4;
		
	}
	@FindBy(xpath="//label[@for='hover-feedback-5']")
	WebElement Rating5;
	
	public WebElement rating5() {
		return Rating5;
		
	}
	
	@FindBy(id="hover-feedback-1")
	WebElement radioRating1;
	
	public WebElement radiorating1() {
		return radioRating1;
		
	}
	
	
	@FindBy(xpath="(//textarea)[1]")
	WebElement Review;
	
	public WebElement review() {
		return Review;
		
	}
	
	@FindBy(xpath="//button[@class=' btn btn-red-bdr']")
	WebElement Cancel;
	
	public WebElement Cancel() {
		return Cancel;
		
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-round']")
	WebElement Update;
	
	public WebElement update() {
		return Update;
		
	}

	
	@FindBy(xpath="//div[@class='MuiAlert-message']")
	WebElement SuccessfullToastMessage;
	
	public WebElement successfullToastMessage() {
		return SuccessfullToastMessage;
		
	}
}
