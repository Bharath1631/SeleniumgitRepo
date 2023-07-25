/*
	 * @Author : Anil kumar
	 * Module : ChangePassword WebElements
	 * Date   : Nov 9th 2022
	 */

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPage {
	
	@SuppressWarnings("unused")
	private WebDriver driver;


	public ChangePasswordPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(name="old_passwd")
	WebElement OldPassword;
	
	public WebElement oldPassword() {
		return OldPassword;
		
	}
	
	@FindBy(name="new_passwd")
	WebElement NewPassword;
	
	public WebElement newPassword() {
		return NewPassword;
		
	}
	
	@FindBy(name="confirm_passwd")
	WebElement ConfirmPassword;
	
	public WebElement confirmPassword() {
		return ConfirmPassword;
		
	}
	
	@FindBy(id="confirm-set-password")
	WebElement ConfirmSetPassword;
	
	public WebElement confirmSetPassword() {
		return ConfirmSetPassword;
		
	}
	
	@FindBy(xpath="//h4")
	WebElement PasswordUpdatePopup;
	
	public WebElement passwordUpdatePopup() {
		return PasswordUpdatePopup;
		
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-round margin-top-15']")
	WebElement GotoDashboard;
	
	public WebElement gotoDashboard() {
		return GotoDashboard;
		
	}
	
	
	@FindBy(xpath="//p[@class='text-red ']")
	WebElement MainErrorMessage;
	
	public WebElement mainErrorMessage() {
		return MainErrorMessage;
		
	}

	@FindBy(linkText="Cancel")
	WebElement Cancel;
	
	public WebElement cancel() {
		return Cancel;
		
	}
	
	@FindBy(xpath="(//small[@class='text-red'])[2]")
	WebElement FieldErrorMessage;
	
	public WebElement fieldErrorMessage() {
		return FieldErrorMessage;
		
	}
	
	@FindBy(xpath="(//div/img)[2]")
	WebElement ProfilePicture;
	
	public WebElement profilePicture() {
		return ProfilePicture;
		
	}
	
	@FindBy(xpath="//div/h3")
	WebElement FirstAndLastName;
	
	public WebElement FirstAndLastName() {
		return FirstAndLastName;
		
	}
	
	@FindBy(xpath="(//div/p)[1]")
	WebElement EmailID;
	
	public WebElement emailID() {
		return EmailID;
		
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-round text-18']")
	WebElement CountryName;
	
	public WebElement countryName() {
		return CountryName;
		
	}
}
