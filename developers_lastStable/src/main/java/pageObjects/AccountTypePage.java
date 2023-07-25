package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountTypePage {
	
	@SuppressWarnings("unused")
	private WebDriver driver;
	
	public AccountTypePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(css=("button[class='btn btn-round-red-bdr margin-right-10 ']"))
	WebElement back;
	
	public WebElement clickBackButton() {
		return back;
	}
	
	@FindBy(xpath=("//button[@class='btn btn-red-round']"))
	WebElement nextbutton;
	
	public WebElement clickNextButton() {
		return nextbutton;
	}
	
	@FindBy(xpath="//label[@for='Radio1']")
	WebElement radiobutton1;
	
	public WebElement radioButton1() {
		return radiobutton1;
	}
	
	@FindBy(id="Radio1")
	WebElement VerifyradioButton1;
	
	public WebElement verifyradioButton1() {
		return VerifyradioButton1;
	}
	
	@FindBy(id="Radio2")
	WebElement VerifyradioButton2;
	
	public WebElement verifyradioButton2() {
		return VerifyradioButton2;
	}
	
	@FindBy(xpath="//label[@for='Radio2']")
	WebElement radiobutton2;
	
	public WebElement radioButton2() {
		return radiobutton2;
	}
	
	@FindBy(css=("a[href='/country-carrier-page']"))
	WebElement link;
	
	public WebElement clickLink() {
		return link;
	}
	
	
	@FindBy(xpath="//h4")
	WebElement Text;
	
	public WebElement text() {
		return Text;
	}
	
	@FindBy(xpath="(//h4)[2]")
	WebElement DirectRBMText;
	
	public WebElement directRBMText() {
		return DirectRBMText;
	}
	
	@FindBy(id="searchcarrier")
	WebElement SearchBox;
	
	public WebElement searchBox() {
		return SearchBox;
	}
	
	
	@FindBy(xpath="//span[@class='checkbox-custom rectangular']")
	WebElement SelectAllCheckBox;
	
	public WebElement selectAllCheckBox() {
		return SelectAllCheckBox;
	}
	
	
	@FindBy(xpath="//div[@class='account-type-carriers-box']")
	WebElement CarrierList;
	
	public WebElement carrierList() {
		return CarrierList;
	}
	
	@FindBy(xpath="(//div[@class='carrier-name margin-left-5'])[1]")
	WebElement SelectFirstCarrier;
	
	public WebElement selectFirstCarrier() {
		return SelectFirstCarrier;
	}
	
	@FindBy(id="input-check-487")
	WebElement DocomoJapanCarrier;
	
	public WebElement docomoJapanCarrier() {
		return DocomoJapanCarrier;
	}
}
