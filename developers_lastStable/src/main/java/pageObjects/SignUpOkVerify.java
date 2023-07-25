package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpOkVerify {
	
	public WebDriver driver;

	public SignUpOkVerify(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//@FindBy(xpath="//a[@class='btn btn-red-round btn-lg text-no-underline']")
	@FindBy(linkText="OK")
	WebElement ok;
	
	public WebElement clickOK() {
		return ok;
	}


}
