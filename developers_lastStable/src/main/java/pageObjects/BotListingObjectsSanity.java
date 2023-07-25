package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BotListingObjectsSanity {
	public WebDriver driver;
	public BotListingObjectsSanity(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath="(//img[@src='images/icon_view.svg'])[1]")
	WebElement viewdetail;
	
	public WebElement clickBotViewDetail() {
		return viewdetail;
	}
	
	@FindBy(xpath="//div[normalize-space()='Click Here to List']")
	WebElement clickheretolist;
	
	public WebElement clickHereToList() {
		return clickheretolist;
	}
	
	@FindBy(name="screenshot")
	WebElement clickuploadimage;
	
	public WebElement clickUploadImage() {
		return clickuploadimage;
	}
	
	@FindBy(xpath="//h3")
	WebElement verifytextbotlisting;
	
	public WebElement botListingTextverify() {
		return verifytextbotlisting;
	}

}
