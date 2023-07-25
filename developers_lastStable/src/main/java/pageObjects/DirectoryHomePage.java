package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DirectoryHomePage {
	private WebDriver driver;


	public DirectoryHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath="(//a/span)[1]")
	WebElement SignIn;
	
	public WebElement signIn() {
		return SignIn;
		
	}
	
	@FindBy(xpath="(//a/span)[1]")
	WebElement SignUp;
	
	public WebElement signUp() {
		return SignUp;
		
	}
	

}
