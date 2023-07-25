package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddTemplatePage {
	
	public WebDriver driver;
	public AddTemplatePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath="//a[normalize-space()='Puma_bot']")
	WebElement botclick;
	
	public WebElement clickBotButton() {
		return botclick;
	}
	
	@FindBy(xpath="(//i[@class='fa fa-ellipsis-v font-size-24 font-color-light-gray cursor-pointer '])[1]")
	WebElement clickdropdown;
	
	public WebElement clickDropDown() {
		return clickdropdown;
	}
	
	@FindBy(id="downloadTemplate")
	WebElement downloadtemplate;
	
	public WebElement downloadTemplate() {
		return downloadtemplate;
	}
	
	@FindBy(xpath="//a[normalize-space()='Preview Template']")
	WebElement previewtemplate;
	
	public WebElement previewTemplate() {
		return previewtemplate;
	}
	@FindBy(xpath="//a[normalize-space()='Edit Template']")
	WebElement EditTemplate;
	
	public WebElement EditTemplate() {
		return EditTemplate;
	}
	
	@FindBy(xpath="//a[normalize-space()='Delete Template']")
	WebElement deletetemplate;
	
	public WebElement deleteTemplate() {
		return deletetemplate;
	}
	
	@FindBy(xpath="//img[@class='cursor-pointer margin-right-25']")
	WebElement downloadfrompreview;
	
	public WebElement downloadFromPreview() {
		return downloadfrompreview;
	}
	
	@FindBy(xpath="//a[@class='link-red padding-top-30 ']")
	WebElement CancelEdit;
	
	public WebElement cancelEdit() {
		return CancelEdit;
	}
	
	@FindBy(xpath="//img[@src='images/icon_edit_preview.svg']")
	WebElement editfrompreview;
	
	public WebElement editFromPreview() {
		return editfrompreview;
	}
	
	@FindBy(xpath="//img[@src='images/icon_delete_preview.svg']")
	WebElement deletefrompreview;
	
	public WebElement deleteFromPreview() {
		return deletefrompreview;
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-round margin-top-15']")
	WebElement deletepreviewyes;
	
	public WebElement deletePreviewYes() {
		return deletepreviewyes;
	}
	
	@FindBy(xpath="//button[@class='btn btn-round-red-bdr margin-top-15']")
	WebElement deletepreviewcancel;
	
	public WebElement deletePreviewCancel() {
		return deletepreviewcancel;
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-round margin-top-15']")
	WebElement deletehamburgeryes;
	
	public WebElement deleteHamburgeryes() {
		return deletehamburgeryes;
	}
	
	@FindBy(xpath="//button[@class='btn btn-round-red-bdr margin-top-15']")
	WebElement deletehamburgercancel;
	
	public WebElement deletehamburgerCancel() {
		return deletehamburgercancel;
	}
	
	@FindBy(xpath="(//a[@style='text-decoration: none;'])[1]")
	WebElement RichfirstTemplateName;
	
	public WebElement richFirstTemplateName() {
		return RichfirstTemplateName;
		
	}
	
	@FindBy(xpath="//div[@class='col-sm-12 font-size-30 font-weight-500']")
	WebElement previewrichfirstTemplateName;
	
	public WebElement previewRichFirstTemplateName() {
		return previewrichfirstTemplateName;
		
	}
	
	@FindBy(xpath="//h4[@class='padding-bottom-5 padding-top-10']")
	WebElement deletepreviewtext;
	
	public WebElement deletePreviewText() {
		return deletepreviewtext;
		
	}
	
	@FindBy(xpath="//h2")
	WebElement PreviewText;
	
	public WebElement previewText() {
		return PreviewText;
		
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-round margin-top-15']")
	WebElement deletepreviewok;
	
	public WebElement deletePreviewOk() {
		return deletepreviewok;
		
	}
	
	@FindBy(xpath="//a[@class='link-red padding-top-30 ']")
	WebElement hamburgeredittemplatename;
	
	public WebElement hamburgerEditTemplateName() {
		return hamburgeredittemplatename;
		
	}
	@FindBy(xpath="//strong[normalize-space()='+ Add a Template']")
	WebElement addtemplate;
	
	public WebElement addTemplate() {
		return addtemplate;
		
	}
	
	@FindBy(name="templateName")
	WebElement templatename;
	
	public WebElement enterTemplateName() {
		return templatename;
		
	}
	
	@FindBy(name="rich_card")
	WebElement templatetype;
	
	public WebElement templatetype() {
		return templatetype;
	}
	
	@FindBy(name="cardOrientation")
	WebElement cardorientation;
	
	public WebElement cardOrientation() {
		return cardorientation;
	}	
	
	@FindBy(xpath="//i[@class='fa fa-plus font-size-28']")
	WebElement plussymbol;
	
	public WebElement plusSymbol() {
		return plussymbol;
	}
	
	@FindBy(xpath="//a[normalize-space()='Card 3']")
	WebElement card3;
	
	public WebElement newCard3() {
		return card3;
	}	
	
	@FindBy(xpath="//label[normalize-space()='Type of Action']")
	WebElement typeofactionText;
	
	public WebElement typeOfActionText() {
		return typeofactionText;
	}	
	
	@FindBy(name="suggestionType00")
	WebElement typeofaction;
	
	public WebElement typeOfAction() {
		return typeofaction;
	}
	
	@FindBy(xpath="//button[normalize-space()='Upload']")
	WebElement uploadimg;
	
	public WebElement clickUploadButton() {
		return uploadimg;
		
	}
	@FindBy(name="myFile")
	WebElement selectimg;
	
	public WebElement clickSelectImage() {
		return selectimg;
		
	}
	
	@FindBy(xpath="(//button[@class='btn btn-red-round'])[2]")
	WebElement clickselectbutton;
	
	public WebElement clickSelectButton() {
		return clickselectbutton;
		
	}
	
	@FindBy(name="cardTitle")
	WebElement cardtitle;
	
	public WebElement cardTitle() {
		return cardtitle;
		
	}
	@FindBy(name="cardDescription")
	WebElement cardDescription;
	
	public WebElement cardDescription() {
		return cardDescription;
		
	}
	@FindBy(xpath="//button[@class='btn btn-red-template pull-right']")
	WebElement addsuggestion;
	
	public WebElement addSuggestion() {
		return addsuggestion;
		
	}
	@FindBy(name="suggestionType00")
	WebElement suggestiontype;
	
	public WebElement suggestionType() {
		return suggestiontype;
		
	}
	
	@FindBy(name="suggestionText00")
	WebElement suggestiontext;
	
	public WebElement suggestionText() {
		return suggestiontext;
		
	}
	@FindBy(name="suggestionPostback00")
	WebElement suggestionpostback;
	
	public WebElement suggestionPostback() {
		return suggestionpostback;
		
	}
	@FindBy(name="suggestionType10")
	WebElement suggestiontype2;
	
	public WebElement suggestionType2() {
		return suggestiontype2;
		
	}
	
	
	@FindBy(name="suggestionText10")
	WebElement suggestiontext2;
	
	public WebElement suggestionText2() {
		return suggestiontext2;
		
	}
	@FindBy(name="suggestionPostback10")
	WebElement suggestionPostback2;
	
	public WebElement suggestionPostback2() {
		return suggestionPostback2;
		
	}
	
	@FindBy(name="suggestionUrl10")
	WebElement suggestionUrl2;
	
	public WebElement suggestionUrl2() {
		return suggestionUrl2;
		
	}
	
	
	@FindBy(name="suggestionType20")
	WebElement suggestiontype3;
	
	public WebElement suggestionType3() {
		return suggestiontype3;
		
	}
	
	@FindBy(name="suggestionText20")
	WebElement suggestiontext3;
	
	public WebElement suggestionText3() {
		return suggestiontext3;
		
	}
	
	@FindBy(name="suggestionPostback20")
	WebElement suggestionpostback3;
	
	public WebElement suggestionpostback3() {
		return suggestionpostback3;
		
	}
	
	@FindBy(name="suggestionPhoneNo00")
	WebElement suggestionPhoneNo1;
	
	public WebElement suggestionPhoneNo1() {
		return suggestionPhoneNo1;
		
	}
	
	@FindBy(xpath="//span[@class='pull-right margin-top-5']//p[contains(text(),'+ Add Variable')]")
	WebElement addvariable;
	
	public WebElement addVariable() {
		return addvariable;
		
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-round margin-left-10']")
	WebElement templatecreationyes;
	
	public WebElement templateCreationYes() {
		return templatecreationyes;
		
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-round margin-top-15']")
	WebElement templatecreationok;
	
	public WebElement templateCreationOK() {
		return templatecreationok;
		
	}
	
	@FindBy(xpath="//p[@class='font-color-red ']")
	WebElement tostermessage;
	
	public WebElement tosterMessage() {
		return tostermessage;
		
	}
	
	@FindBy(xpath="//a[normalize-space()='Business Info']")
	WebElement buisnessinfo;
	
	public WebElement buisnessInfo() {
		return buisnessinfo;
		
	}
	
	@FindBy(xpath="(//span[@style='color: rgb(153, 153, 153);'])[1]")
	WebElement phone;
	
	public WebElement phoneBuisenessInfo() {
		return phone;
		
	}
	
	@FindBy(xpath="(//span[@style='color: rgb(153, 153, 153);'])[2]")
	WebElement url;
	
	public WebElement urlBuisenessInfo() {
		return url;
   }
	
	@FindBy(xpath="(//span[@style='color: rgb(153, 153, 153);'])[3]")
	WebElement emailid;
	
	public WebElement emailIDBuisenessInfo() {
		return emailid;
   }
	
	@FindBy(xpath="//a[normalize-space()='Options']")
	WebElement options;
	
	public WebElement optionsBuisnessInfo() {
		return options;
   }
	@FindBy(xpath="//p[normalize-space()='Notification']")
	WebElement notification;
	
	public WebElement optionsNotificationBuisnessInfo() {
		return notification;
   }
	
	@FindBy(xpath="//p[normalize-space()='View Privacy Policy']")
	WebElement privacyPolicy;
	
	public WebElement optionsPrivacyPolicy() {
		return privacyPolicy;
   }
	
	@FindBy(xpath="//p[normalize-space()='View Terms of Services']")
	WebElement termsofservices;
	
	public WebElement optionstermsOfServices() {
		return termsofservices;
   }
	
	@FindBy(name="suggestionType00")
	WebElement urlaction;
	
	public WebElement selectUrlAction() {
		return urlaction;
   }
	
	@FindBy(xpath="//div[@class='text-center suggestion-button-no-bdr']/a/img")
	WebElement youtubeimg;
	
	public WebElement youtubeImageDisplayed() {
		return youtubeimg;
   }
	@FindBy(name="suggestionUrl00")
	WebElement urlfirstfield;
	
	public WebElement urlSuggestionfirstfield() {
		return urlfirstfield;
		
	}
	
	@FindBy(xpath="//label[normalize-space()='URL/URI to open']")
	WebElement urltoopen;
	
	public WebElement urlToOpen() {
		return urltoopen;
		
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-round']")
	WebElement submit;
	
	public WebElement clickSubmitButton() {
		return submit;
		
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-round margin-left-10']")
	WebElement yes;
	
	public WebElement yesTemplate() {
		return yes;
		
	}

	@FindBy(xpath="//h4[@class='text-center margin-bottom-10']")
	WebElement poptext;
	
	public WebElement submitPop() {
		return poptext;
		
	}
	
	@FindBy(xpath="//h4[@class='padding-bottom-5 padding-top-10']")
	WebElement templatesubmitted;
	
	public WebElement templateSubmittedSucessfully() {
		return templatesubmitted;
		
	}
	@FindBy(xpath="//button[@class='btn btn-red-round margin-top-15']")
	WebElement ok;
	
	public WebElement templateSubmittedSucessfullyOK() {
		return ok;
		
	}
	
	@FindBy(xpath="//h4[@class='text-center margin-bottom-10']")
	WebElement dialerpopupmessage;
	
	public WebElement clickDialerPopMessage() {
		return dialerpopupmessage;
		
	}
	
	@FindBy(xpath="(//button[@class='btn btn-round-red-bdr'])[2]")
	WebElement no;
	
	public WebElement clickSubmitNo() {
		return no;
		
	}
	
	@FindBy(xpath="(//div[@class='call-details']/p)[4]")
	WebElement BlockAndReportSpamText;
	
	public WebElement blockAndReportSpamText() {
		return BlockAndReportSpamText;
		
	}
	
	@FindBy(xpath="(//div[@class='email']/p)[2]")
	WebElement LearnMoreText;
	
	public WebElement learnMoreText() {
		return LearnMoreText;
		
	}
   }

