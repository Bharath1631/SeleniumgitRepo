/*
	 * @Author : Anil kumar
	 * Module : WhatsappBOTDetails Webelements
	 * Date   : 19-oct-2022
	 */

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WhatsappPreview {
	
	
	@SuppressWarnings("unused")
	private WebDriver driver;

	public WhatsappPreview(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
	
	
	@FindBy(xpath="(//h1)[1]")
	WebElement PreviewText;
	
	public WebElement previewText() {
		return PreviewText;
		
	}
	
	@FindBy(xpath="(//button[@class='btn btn-red-round'])[2]")
	WebElement SubmitForListing;
	
	public WebElement submitForListing() {
		return SubmitForListing;
		
	}

	
	@FindBy(xpath="//button[@class='btn btn-red-btr-round']")
	WebElement BacktoEdit;
	
	public WebElement backtoEdit() {
		return BacktoEdit;
		
	}
	
	@FindBy(xpath="(//h3)[3]")
	WebElement BotNamePreview;
	
	public WebElement botNamePreview() {
		return BotNamePreview;
		
	}
	
	@FindBy(xpath="(//h4)[1]")
	WebElement PopUpText;
	
	public WebElement popUpText() {
		return PopUpText;
		
	}
	
	@FindBy(xpath="(//button[@class='btn btn-red-round'])[3]")
	WebElement PopUpConfirm;
	
	public WebElement popUpConfirm() {
		return PopUpConfirm;
		
	}
	
	@FindBy(xpath="(//h4)[3]")
	WebElement PopUpMessage;
	
	public WebElement popUpMessage() {
		return PopUpMessage;
		
	}
	
	
	
	@FindBy(xpath="//button[@class='btn btn-red-round margin-top-15']")
	WebElement GotoDashboard;
	
	public WebElement gotoDashboard() {
		return GotoDashboard;
		
	}
}


