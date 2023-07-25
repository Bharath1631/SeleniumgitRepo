/*
	 * @Author : Anil kumar
	 * Module : Create New RCS BOT functionality
	 * Date   : 13 Oct 2022
	 */
	

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectCarriers {

	@SuppressWarnings("unused")
	private WebDriver driver;


	public SelectCarriers(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[normalize-space()='View Launch Status']")
	WebElement viewlaunchstatus;
	public WebElement viewLaunchStatus( ) {
		return viewlaunchstatus;
	}
	
	@FindBy(xpath="//a[normalize-space()='Click Here']")
	WebElement clickhere;
	public WebElement ClickHere( ) {
		return clickhere;
	}
	
	@FindBy(xpath="//div[contains(text(),'MTN Nigeria')]")
	WebElement mtnnigeris;
	public WebElement mtnMigeris( ) {
		return mtnnigeris;
	}
	
	@FindBy(xpath="//div[contains(text(),'Globacom Nigeria')]")
	WebElement globacomnigeria;
	public WebElement globacomNigeria( ) {
		return globacomnigeria;
	}
	
	@FindBy(xpath="//div[contains(text(),'Reliance Jio India')]")
	WebElement reliancejio;
	public WebElement relienceJio( ) {
		return reliancejio;
	}

	@FindBy(xpath="(//div[@class='carrier-rbm-box cursor-pointer'])[1]")
	WebElement FirstCarrierSelect;
	public WebElement firstCarrierSelect( ) {
		return FirstCarrierSelect;
	}

	
	@FindBy(xpath="//div[@class='carrier-name']")
	WebElement FirstCarrierName;
	public WebElement firstCarrierName( ) {
		return FirstCarrierName;
	}
	
	
	@FindBy(xpath="//button[@class='btn btn-red-round']")
	WebElement Submit;
	public WebElement submit() {
		return Submit;
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-round margin-left-10']")
	WebElement yes;
	public WebElement clickYes() {
		return yes;
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-round  margin-bottom-35']")
	WebElement ok;
	public WebElement clickOK() {
		return ok;
	}
	
	@FindBy(xpath="(//button[@class='btn btn-red-round'])[2]")
	WebElement GotoDashboard;
	public WebElement gotoDashboard() {
		return GotoDashboard;
	}
	
	
	@FindBy(xpath="//h2/h4")
	WebElement GetPopupText;
	public WebElement getPopupText() {
		return GetPopupText;
	}
	
	@FindBy(xpath="//p[@class='text-center']")
	WebElement GetNextPopupText;
	public WebElement getNextPopupText() {
		return GetNextPopupText;
	}
	
	@FindBy(xpath="//tbody/tr[1]/td[7]/div[1]/a[1]/img[1]")
	WebElement viewdetails;
	public WebElement viewDetails() {
		return viewdetails;
	}
	@FindBy(xpath="//button[@class='btn  btn-red-bdr-round text-16']")
	WebElement carrieryes;
	public WebElement carrierYes() {
		return carrieryes;
	}
	
	@FindBy(xpath="//button[@class='btn  btn-red-bdr-round text-16']")
	WebElement carriernext;
	public WebElement carrierNext() {
		return carriernext;
	}
	
}
