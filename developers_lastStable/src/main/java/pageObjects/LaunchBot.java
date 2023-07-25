package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LaunchBot {
	
	public WebDriver driver;


	public LaunchBot(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath="//tbody/tr[1]/td[4]/a[1]")
	WebElement viewlaunchstatus;
	
	public WebElement viewLaunchStatus() {
		return viewlaunchstatus;
		
	}
	
	@FindBy(xpath="//a[normalize-space()='Click Here']")
	WebElement clickhere;
	
	public WebElement clickHere() {
		return clickhere;
		
	}
	
	@FindBy(xpath="//input[@id='97']")
	WebElement carrierselection;
	
	public WebElement carrierSelection() {
		return carrierselection;
		
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-round']")
	WebElement submit;
	
	public WebElement clickSubmit() {
		return submit;
		
	}

}
