package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterSignUpEmail {
	
	public WebDriver driver;

	public EnterSignUpEmail(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="user-signup-email")
	WebElement signupemailid;
	
	public WebElement enterSignUpEmail() {
		return signupemailid;
	}
	
	@FindBy(xpath=("//button[@class='btn btn-red-round']"))
	WebElement signup;
	
	public WebElement clickSignUp() {
		return signup;
	}
	
	@FindBy(xpath=("//button[@class='btn btn-light-gray-round']"))
	WebElement reset;
	
	public WebElement clickReset() {
		return reset;
	}
	
	@FindBy(xpath="//p[@class='text-red ']")
	WebElement ErrorMessage;
	
	public WebElement errorMessage() {
		return ErrorMessage;
	}
	
}
