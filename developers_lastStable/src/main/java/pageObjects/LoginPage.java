package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Log;


public class LoginPage {

	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//span/strong")
	WebElement SignIn;
	
	@FindBy(id="username")
	WebElement Email;
	
	@FindBy(id="pwd")
	WebElement Password;
	
	@FindBy(css="button[type='submit']")
	WebElement Submit;
	public WebElement submit() {
		return Submit;
	}
	
	@FindBy(css="a[href*='developers']")
	WebElement Signup;
	
	@FindBy(css="a[id='anchor']")
	WebElement Forgotpassword;
	
	@FindBy(id="invalidCred")
	WebElement InvaildLogin;
	
	@FindBy(id="emailMsg")
	WebElement ProvideEmail;
	
	@FindBy(id="passwordMsg")
	WebElement ProvidePassword;
	
	public WebElement provideEmail() {
		return ProvideEmail;
	}
	
	public WebElement providePassword() {
		return ProvidePassword;
	}
////	
	public WebElement password() {
		return Password;
	}
	
	public WebElement email() {
		return Email;
	}
//	
//	public WebElement signup() {
//		return Signup;
//	}
//	
//	public WebElement forgotPassword() {
//		return Forgotpassword;
//	}
//	
	public WebElement signin() {
		return SignIn;
	}
	
	
	
	public DashboardPage loginApplication(String email, String password)
	{	
		Log.info("Clicking on SingIn");
		Log.info(email);
		Log.info(password);
		SignIn.click();
		Email.sendKeys(email);
		Log.info("Entered the Email ID: "+email);
		Password.sendKeys(password);
		Log.info("Entered the password :"+password);
		Submit.click();
		Log.info("Clicked on Login Button");
		DashboardPage dashboard = new DashboardPage(driver);
	    return dashboard;
	}
	
    public WebElement getErrormessage()
	{		
    	 
          return InvaildLogin;
		
	}
    
    @FindBy(id="accountLocked")              
	WebElement AccountLocked;
	
	public WebElement accountLocked() {
		return AccountLocked;
	}
	
}
