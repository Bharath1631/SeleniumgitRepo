package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyBrandsPage {

	@SuppressWarnings("unused")
	private WebDriver driver;
	
	public MyBrandsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath="(//a[@class='ol-nav-link'])[1]")
	WebElement MyBrands;
	
	public WebElement myBrands() {
		return MyBrands;
	}
	
	@FindBy(xpath="(//button[@class='btn btn-white-bdr'])[1]")
	WebElement ViewDetails;
	
	public WebElement viewDetails() {
		return ViewDetails;
	}
}
