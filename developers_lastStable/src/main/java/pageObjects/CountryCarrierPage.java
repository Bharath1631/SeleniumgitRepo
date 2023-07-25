package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CountryCarrierPage {
	
	public WebDriver driver;

	public CountryCarrierPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h2")
	WebElement ListofcountryCarrierText;
	
	public WebElement listofcountryCarrierText() {
		return ListofcountryCarrierText;
	}
	

}
