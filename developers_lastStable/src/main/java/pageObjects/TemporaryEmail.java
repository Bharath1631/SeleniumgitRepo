package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TemporaryEmail {
	
	public WebDriver driver;

	
	public TemporaryEmail(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[@title='noreply@dotgo.com']")
	WebElement inboxemail;
	
	public WebElement clickInboxLink() {
		return inboxemail;
	}
	
	@FindBy(xpath="//button[normalize-space()='CONFIRM EMAIL']")
	WebElement inboxconfirmemail;
	
	public WebElement inboxConfirm() {
		return inboxconfirmemail;
	}
	

}
