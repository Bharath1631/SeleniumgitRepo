package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDashBoard {
	
	public WebDriver driver;


	public AdminDashBoard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
	
	//@FindBy(xpath=("//ul[@class='collapse navbar-collaps']/li[4]/a"))
	@FindBy(xpath=("//a[normalize-space()='AGGREGATORS']"))
	WebElement Aggregators;
	
	public WebElement aggregators() {
		return Aggregators;
		}
	
	@FindBy(xpath=("//ul[contains(@class,'navbar-left')]//li[2]//a[1]"))
	WebElement Bots;
	
	public WebElement bots() {
		return Bots;
		}
	
	
}
