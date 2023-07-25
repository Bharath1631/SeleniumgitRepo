package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Review_details {
	
	
	public WebDriver driver;

	public Review_details(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=("button[class='btn btn-round-red-bdr']"))
	WebElement backbutton;
	
	public WebElement backButton() {
		return backbutton;
	}
	
	@FindBy(css=("button[class='btn btn-red-round']"))
	WebElement submitbutton;
	
	public WebElement submitButton() {
		return submitbutton;
	}
	
	@FindBy(css=("a[href='/developer-tos'][0]"))
	WebElement termsconditionlink;
	
	public WebElement clickTermsCondition(){
		return termsconditionlink;
	}
	
	@FindBy(css=("a[href='/developer-pp'][0]"))
	WebElement privacyPolicylink;
	
	public WebElement clickPrivacyPolicy(){
		return privacyPolicylink;
	}

}
