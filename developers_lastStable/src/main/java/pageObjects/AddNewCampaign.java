/*
	 * @Author : Anil kumar
	 * Module : Add New Campaign Page Objects
	 * Date   : 06 March 2023
	 */

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCampaign {
	
	private WebDriver driver;


	public AddNewCampaign(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}

	@FindBy(xpath="//button[@class='btn btn-red-round margin-top-10']")
	WebElement AddNewCampaign;
	
	public WebElement addNewCampaign() {
		return AddNewCampaign;
		
	}
	
	@FindBy(xpath="(//button[@class='bot-name--trigger auto-fill'])[1]")
	WebElement SelectBot;
	
	public WebElement selectBot() {
		return SelectBot;
		
	}
	@FindBy(xpath="(//button[@class='bot-name--trigger auto-fill'])[2]")
	WebElement SelectTemplate;
	
	public WebElement SelectTemplate() {
		return SelectTemplate;
		
	}
	
	
	@FindBy(xpath="//button[@class='btn btn-red-round']")
	WebElement ScheduleCampaign;
	
	public WebElement scheduleCampaign() {
		return ScheduleCampaign;
		
	}
	
	@FindBy(xpath="(//ul[@class='bot-list']/li)[1]")
	WebElement FirstBot;
	
	public WebElement firstBot() {
		return FirstBot;
		
	}
	
	@FindBy(xpath="((//ul[@class='bot-list'])[2]/li)[1]")
	WebElement FirstTemplate;
	
	public WebElement firstTemplate() {
		return FirstTemplate;
		
	}
}
