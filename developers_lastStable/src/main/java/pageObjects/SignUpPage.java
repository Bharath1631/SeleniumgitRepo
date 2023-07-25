package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
	
	public WebDriver driver;

	public SignUpPage(WebDriver driver) {
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
	
	@FindBy(xpath="//div[@class='col-lg-12 col-md-12']")
	WebElement ThankYouText;
	
	public WebElement thankYouText() {
		return ThankYouText;
	}
	
	@FindBy(xpath="//a[@class='font-color-blue']")
	WebElement ViewListOfCarriersAndCarriers;
	
	public WebElement viewListOfCarriersAndCarriers() {
		return ViewListOfCarriersAndCarriers;
	}
	
	@FindBy(xpath="//h3")
	WebElement CreateYourFreeAccount;
	
	public WebElement CreateYourFreeAccount() {
		return CreateYourFreeAccount;
	}
	
	
	@FindBy(name="tc_checkbox")
	WebElement TermsAndConditionsCheckBox;
	
	public WebElement trmsAndConditionsCheckBox() {
		return TermsAndConditionsCheckBox;
	}
	
	
	@FindBy(xpath="//span/strong")
	WebElement SignIN;
	
	public WebElement signIN() {
		return SignIN;
	}
}
