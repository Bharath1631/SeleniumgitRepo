package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SetPassword {
	
	public WebDriver driver;

	public SetPassword(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="new_password")
	WebElement password;
   
	public WebElement setPassword() {
		return password;
	}
	
	@FindBy(name="confirm_password")
	WebElement confirmpassword;
	
	public WebElement confirmPassword() {
		return confirmpassword;
	}
	
	@FindBy(id="confirm-set-password")
	WebElement confirmbutton;
	
	public WebElement clickConfirm() {
		return confirmbutton;
	}

}
