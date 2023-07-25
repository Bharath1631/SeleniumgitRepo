package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewAllTemplatesObjects {
	
	public WebDriver driver;
	public ViewAllTemplatesObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath="//a[normalize-space()='Puma_bot']")
	WebElement botclick;
	
	public WebElement clickBotButton() {
		return botclick;
	}
	
	@FindBy(xpath="//strong[normalize-space()='View All Templates']")
	WebElement viewtemplates;
	
	public WebElement viewAllTemplates() {
		return viewtemplates;
	}
	
	@FindBy(xpath="//strong[normalize-space()='View and Add Templates']")
	WebElement verifyviewtemplatepage;
	
	public WebElement verifyViewAndAddTemplate() {
		return verifyviewtemplatepage;
	}
	
	@FindBy(xpath="(//a[@style='text-decoration: none;'])[1]")
	WebElement FirstTemplateName;
	
	public WebElement firstTemplateName() {
		return FirstTemplateName;
		
	}
	
	@FindBy(xpath="(//i[@class='fa fa-ellipsis-v font-size-24 margin-right-15 font-color-light-gray cursor-pointer'])[1]")
	WebElement dropdown;
	
	public WebElement clickDropDown() {
		return dropdown;
		
	}

	@FindBy(id="downloadTemplate")
	WebElement downloadtemplate;
	
	public WebElement clickDownloadTemplate() {
		return downloadtemplate;
		
	}
	
	@FindBy(xpath="(//a[@class='link-black-popup font-size-14 cursor-pointer margin-bottom-15'])[1]")
	WebElement previewtemplate;
	
	public WebElement clickPreviewTemplate() {
		return previewtemplate;
		
	}
	
	@FindBy(xpath="//div[@class='col-sm-12 font-size-30 font-weight-500']")
	WebElement verifypreview;
	
	public WebElement verifyPreview() {
		return verifypreview;
		
	}
	
	@FindBy(xpath="//img[@class='cursor-pointer margin-right-25']")
	WebElement downloadfrompreview;
	
	public WebElement downloadPreviewObject() {
		return downloadfrompreview;
		
	}
	
	@FindBy(xpath="//img[@src='images/icon_edit_preview.svg']")
	WebElement editpreviewtemplate;
	
	public WebElement editPreviewTemplateObject() {
		return editpreviewtemplate;
		
	}
	
	@FindBy(xpath="//a[@class='link-red padding-top-30 ']")
	WebElement verifyeditpage;
	
	public WebElement verifyEditPage() {
		return verifyeditpage;
		
	}
	
	@FindBy(xpath="//a[@class='link-red']")
	WebElement editback;
	
	public WebElement editBack() {
		return editback;
		
	}
	
	@FindBy(xpath="//img[@src='images/icon_delete_preview.svg']")
	WebElement deletepreviewpopup;
	
	public WebElement deletePreviewPOPUP() {
		return deletepreviewpopup;
		
	}
	
	@FindBy(xpath="//h4[@class='padding-bottom-5 padding-top-10']")
	WebElement deletepreviewpopuptext;
	
	public WebElement deletePreviewPOPUPText() {
		return deletepreviewpopuptext;
		
	}
	@FindBy(xpath="//button[@class='btn btn-red-round margin-top-15']")
	WebElement deletepreviewpopupyes;
	
	public WebElement deletePreviewPOPUPYes() {
		return deletepreviewpopupyes;
		
	}
	
	@FindBy(xpath="//h4[@class='padding-bottom-5 padding-top-10']")
	WebElement deleteconfirmation;
	
	public WebElement deleteConfirmation() {
		return deleteconfirmation;
		
	}
	
	@FindBy(xpath="//button[@class='btn btn-round-red-bdr margin-top-15']")
	WebElement deletecancel;
	
	public WebElement deleteCancel() {
		return deletecancel;
		
	}
	
	@FindBy(xpath="//button[@class='btn btn-red-round margin-top-15']")
	WebElement clickok;
	
	public WebElement clickFinalDeleteOk() {
		return clickok;
		
	}
	
	@FindBy(xpath="//strong[normalize-space()='View and Add Templates']")
	WebElement viewalltemplatetext;
	
	public WebElement viewAllTemplateText() {
		return viewalltemplatetext;
		
	}
	
	@FindBy(xpath="(//a[@class='link-black-popup font-size-14 cursor-pointer margin-bottom-15'])[2]")
	WebElement hemburgeredit;
	
	public WebElement hemburgerEDit() {
		return hemburgeredit;
		
	}
	
	@FindBy(xpath="//a[@class='link-red-popup cursor-pointer font-size-14 margin-bottom-15']")
	WebElement hemburgerdelete;
	
	public WebElement hemburgerDelete() {
		return hemburgerdelete;
		
	}
}
