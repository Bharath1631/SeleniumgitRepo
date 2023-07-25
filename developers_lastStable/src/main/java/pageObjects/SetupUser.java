package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SetupUser {
	
	public WebDriver driver;

	public SetupUser(WebDriver driver) {
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
	
	@FindBy(xpath="//a[@class='btn btn-red-round btn-lg text-no-underline']")
	WebElement ok;
	
	public WebElement clickOK() {
		return ok;
	}
	
	@FindBy(name="first_name")
	WebElement firstname;
	
	public WebElement firstNameEnter() {
		return firstname;
	}
	
	@FindBy(name="last_name")
	WebElement lastname;
	
	public WebElement lastNameEnter() {
		return lastname;
	}
	
	@FindBy(name="phone_number")
	WebElement contactnumber;
	
	public WebElement phoneNumberEnter() {
		return contactnumber;
	}
	
	@FindBy(xpath="(//button[@class='btn btn-red-round'])[1]")
	WebElement verify;
	
	public WebElement verify() {
		return verify;
	}
	
	
	@FindBy(xpath="(//h4)[3]")
	WebElement OtpPopUp;
	
	public WebElement otpPopUp() {
		return OtpPopUp;
	}
	
	
	@FindBy(xpath="//button[@data-dismiss='modal']")
	WebElement GotIt;

	public WebElement gotIt() {
		return GotIt;
	}
	
	
	
	@FindBy(xpath="//input[@placeholder='Enter OTP']")
	WebElement EnterOTP;

	public WebElement enterOTP() {
		return EnterOTP;
	}
	
	@FindBy(name="company_name")
	WebElement companyname;
	
	public WebElement companyNmaeEnter() {
		return companyname;
	}
	

	@FindBy(name="job_title")
	WebElement jobtitle;
	
	public WebElement jobTitleenter() {
		return jobtitle;
	}
	
	@FindBy(name="company_website")
	WebElement companywebsite;
	
	public WebElement companyWebsiteEnter() {
		return companywebsite;
	}
	
	@FindBy(name="address_1")
	WebElement address1;
	
	public WebElement addressOneEnter() {
		return address1;
	}
	
	@FindBy(name="address_2")
	WebElement address2;
	
	public WebElement addressTwoEnter() {
		return address2;
	}
	@FindBy(name="city")
	WebElement city;
	
	public WebElement enterCity() {
		return city;
	}
	
	@FindBy(name="state")
	WebElement state;
	
	public WebElement enterState() {
		return state;
	}
	
	
	
	
	//@FindAll(@FindBy(xpath="//div[@class=' css-182gzek-menu']"))
	@FindAll(@FindBy(xpath="//div[@class=' css-2b097c-container']"))
	List<WebElement> CountryMenus;
	
	public List<WebElement> countryMenus() {
		return CountryMenus;
	}
	
	@FindBy(xpath="//div[@class=' css-ql68v7-control']")
	WebElement SelectCountry;
	
	public WebElement selectCountry() {
		return SelectCountry;
	}
	
	@FindBy(xpath="//div[@class= css-1uccc91-singleValue]")
	WebElement pickcountry;
	
	public WebElement pickcountry() {
		return pickcountry;
	}
	
	
	@FindBy(name="country")
	WebElement country;
	
	public WebElement enterCountry() {
		return country;
	}
	
	@FindBy(name="zip_code")
	WebElement zipcode;
	
	public WebElement enterZipCode() {
		return zipcode;
	}
	
	@FindBy(name="preferred_time_zone")
	WebElement timezone;
	
	public WebElement enterTimeZone() {
		return timezone;
	}
	
	@FindBy(id="file_type_1")
	WebElement Selectdocument;
	
	public WebElement selectdocument() {
		return Selectdocument;
	}
	
	@FindBy(name="doc_")
	WebElement browse;
	
	public WebElement browseDoc() {
		return browse;
	}
	
	@FindBy(id="file_type")
	WebElement SelectBusinessDocument;
	
	public WebElement selectBusinessDocument() {
		return SelectBusinessDocument;
	}
	
	@FindBy(css="a[pointer='+Add more']")
	WebElement addmore;
	
	public WebElement clickAddMore() {
		return addmore;
	}
	
	@FindBy(xpath="('//span')[10]")
	WebElement verifydoc;
	
	public WebElement docVerification() {
		return verifydoc;
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-round']")
	WebElement next;
	
	public WebElement clickNext() {
		return next;
	}
	
	
	@FindBy(name=("phone_numberCountry"))
	WebElement PhoneCountry;
	
	public WebElement phoneCountry() {
		return PhoneCountry;
	}
	
	@FindBy(xpath="//small")
	WebElement ResendOTP;
	
	public WebElement resendOTP() {
		return ResendOTP;
	}
	
}

