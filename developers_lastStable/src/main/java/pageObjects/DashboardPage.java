/*
	 * @Author : Anil kumar
	 * Module : Dashboard Webelements
	 * Date   : 
	 */
package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	
	private WebDriver driver;


	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(css="button[class='btn btn-blue']")
	WebElement CreateNewRcsBot;
	
	
	public WebElement createNewRcsBot() {
		//CreateNewRcsBot.click();
		//RcsBotDetailsPage rcsBotDetail = new RcsBotDetailsPage(driver);
		return CreateNewRcsBot;
		
	}
	
	
	
	@FindBy(xpath="(//tr[@role='row'])[2]/td[1]")
	WebElement RecentBotName;
	
	public WebElement recentBotName() {
		return RecentBotName;
		
	}
	
	@FindBy(xpath="(//tr[@role='row'])[2]/td[2]")
	WebElement RecentBrandName;
	
	public WebElement recentBrandName() {
		return RecentBrandName;
		
	}
	
	
	@FindBy(xpath="(//tr[@role='row'])[2]/td[4]")
	WebElement RecentBotStatus;
	
	public WebElement recentBotStatus() {
		return RecentBotStatus;
		
	}
	
	@FindBy(linkText="Click Here")
	WebElement WhatsAppBotCreateLink;
	
	public WebElement whatsAppBotCreateLink() {
		return WhatsAppBotCreateLink;
		
	}
	
	@FindBy(css="a[style*='black; text-decoration']")
	WebElement WhatsAppBotListedName;
	
	public WebElement whatsAppBotListedName() {
		return WhatsAppBotListedName;
		
	}
	
	@FindBy(xpath="(//div[@class='panel-body'])[2]/div/table/tbody/tr/td[4]")
	WebElement WhatsAppBotStatus;
	
	public WebElement WhatsAppBotStatus() {
		return WhatsAppBotStatus;
		
	}
	
	@FindBy(xpath="//a[@data-toggle='dropdown']")
	WebElement Dropdown;
	
	public WebElement dropdown() {
		return Dropdown;
		
	}

	@FindBy(linkText="Change Password")
	WebElement ChangePassword;
	
	public WebElement changePassword() {
		return ChangePassword;
		
	}
	@FindBy(linkText="Logout")
	WebElement Logout;
	
	public WebElement logout() {
		return Logout;
		
	}


	
	//@FindBy(xpath="(//a[@class='margin-right-30'])[1]")
	@FindBy(xpath="(//a/img)[3]")
	WebElement ViewDetails;
	
	public WebElement viewDetails() {
		return ViewDetails;
		
	}
	
	
	@FindBy(xpath="(//a[@class='ol-nav-link'])[4]")
	WebElement MyCampaigns;
	
	public WebElement myCampaigns() {
		return MyCampaigns;
		
	}
	
	
	@FindBy(xpath="(//tr[@role='row'])[2]/td[5]")
	WebElement FirstBotRatings;
	
	public WebElement firstBotRatings() {
		return FirstBotRatings;
		
	}
	
	@FindBy(xpath="(//tr[@role='row'])[2]/td[6]")
	WebElement FirstBotReviews;
	
	public WebElement firstBotReviews() {
		return FirstBotReviews;
		
	}
	
	@FindBy(xpath="(//tr[@role='row'])[3]/td[5]")
	WebElement SecondBotRatings;
	
	public WebElement secondBotRatings() {
		return SecondBotRatings;
		
	}
	
	@FindBy(xpath="(//tr[@role='row'])[3]/td[6]")
	WebElement SecondBotReviews;
	
	public WebElement secondBotReviews() {
		return SecondBotReviews;
		
	}
	
	
}
