package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {
	public WebDriver driver;

	public ForgotPasswordPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="anchor")
	WebElement forgetpassword;
	
	public WebElement forgetPasswrd() {
		return forgetpassword;
	}
	@FindBy(id="userId")
	WebElement emailid;
	
	public WebElement enterEmailId() {
		return emailid;
	}
	@FindBy(id="otp")
	WebElement otp;
	
	public WebElement enterOtp() {
		return otp;
		
	}
	@FindBy(xpath="//button[@class='btn  resend-otp']")
	WebElement resendOtp;
	
	public WebElement eneterResendOtp() {
		return resendOtp;
	}
	
    @FindBy(id="newPassword")
    WebElement newpassword;
    
    public WebElement enterNewPassword() {
    	return newpassword;
    	
    }
    
    @FindBy(id="confirmPassword")
    WebElement confirmpassword;
    
    public WebElement enterConfirmPassword() {
    	return confirmpassword;
    }
    
    @FindBy(id="btn")
    WebElement submit;
    
    public WebElement submitBtn() {
    	return submit;
    }
    @FindBy(xpath="(//button[@class='btn btn-round'])[2]")
    WebElement ok;
    
    public WebElement clickOK() {
    	return ok;
    }
    
    
    @FindBy(xpath="//div[@class='modal-body']")
    WebElement PopUpMessage;
    
    public WebElement popUpMessage() {
    	return PopUpMessage;
    }
    
    @FindBy(id="matchingMsg")
    WebElement PwdNotMatch;
    
    public WebElement pwdNotMatch() {
    	return PwdNotMatch;
    }
    
    @FindBy(id="samePwdError")
    WebElement SamePWDError;
    
    public WebElement samePWDError() {
    	return SamePWDError;
    }
    
   
    @FindBy(id="invalidOtp")
    WebElement InvalidOTPError;
    
    public WebElement invalidOTPError() {
    	return InvalidOTPError;
    }
    
    
    @FindBy(xpath="//h2")
    WebElement SetPasswordText;
    
    public WebElement setPasswordText() {
    	return SetPasswordText;
    }
   
    @FindBy(xpath="//div[@id='pwdValidation']/p")
    WebElement InvalidPasswordText;
    
    public WebElement invalidPasswordText() {
    	return InvalidPasswordText;
    }
    
    @FindBy(xpath="//div[@style='display: inline; color: rgb(216, 31, 38);']")
    WebElement ErrorVisible;
    
    public WebElement errorVisible() {
    	return ErrorVisible;
    }
    
    @FindBy(xpath="(//button[@class='btn btn-round'])[3]")
    WebElement OkOTP;
    
    public WebElement okOTP() {
    	return OkOTP;
    }
}

