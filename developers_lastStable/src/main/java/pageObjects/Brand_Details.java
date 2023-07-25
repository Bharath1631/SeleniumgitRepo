package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Brand_Details {
	
	public WebDriver driver;

	public Brand_Details(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(name="brand_website")
	WebElement brandwebsite;
	
	public WebElement BrandWebsite() {
		return brandwebsite;
		
	}
	
	@FindBy(xpath="//button[@class='btn-link text-red']")
	WebElement uploadbrandlogo;
	
	public WebElement uploadBrandLogo() {
		return uploadbrandlogo;
		
	}
	
	@FindBy(xpath="(//div[@class=' css-1hwfws3'])[1]")
	WebElement industyclick;
	
	public WebElement industryClick() {
		return industyclick;
		
	}
		
	
	@FindBy(xpath="//div[@class=' css-1uccc91-singleValue']")
	WebElement industrytype;
	
	public WebElement industryType() {
		return industrytype;
		
	}
	
	
	@FindBy(name="brand_emails_json.0.contact_first_name")
	WebElement firstname;
	
	public WebElement firstNmae() {
		return firstname;
		
	}
	
	@FindBy(name="brand_emails_json.0.contact_last_name")
	WebElement lastname;
	
	public WebElement lastName() {
		return lastname;
		
	}
	
	@FindBy(name="brand_emails_json.0.contact_designation")
	WebElement contactdesignation;
	
	public WebElement contactDesignation() {
		return contactdesignation;
		
	}
	
	@FindBy(name="brand_emails_json.0.mobile")
	WebElement mobile;
	
	public WebElement enterMobile() {
		return mobile;
		
	}
	
	@FindBy(name="brand_emails_json.0.email")
	WebElement email;
	
	public WebElement enterEmail() {
		return email;
		
	}
	
	@FindBy(xpath="//a[@class='pull-left col-lg-5 col-md-5 col-sm-5 link-purple ']")
	WebElement addcontactperson;
	
	public WebElement addContactPerson() {
		return addcontactperson;
		
	}
	
	@FindBy(name="address_line_1")
	WebElement addressline1;
	
	public WebElement enterAddressLine1l() {
		return addressline1;
		
	}
	
	@FindBy(name="address_line_2")
	WebElement addressline2;
	
	public WebElement enterAddressLine2() {
		return addressline2;
		
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
	
	@FindBy(xpath="(//div[@class=' css-1hwfws3'])[2]")
	WebElement countryselect;
	
	public WebElement countrySelect() {
		return countryselect;
		
	}
	
	@FindBy(xpath="(//div[@class=' css-tlfecz-indicatorContainer'])[2]")
	WebElement country;
	
	public WebElement enterCountry() {
		return country;
		
	}
	
	@FindBy(name="zip_code")
	WebElement zipcode;
	
	public WebElement enterZipcode() {
		return zipcode;
		
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-round']")
	WebElement next;
	
	public WebElement clickNext() {
		return next;
		
	}
	
	@FindBy(name="myFile")
	WebElement myfile;
	
	public WebElement myFile() {
		return myfile;
		
	}
	
	@FindBy(xpath="(//button[@class='btn btn-red-round'])[2]")
	WebElement selectfile;
	
	public WebElement selectFile() {
		return selectfile;
		
	}

}
