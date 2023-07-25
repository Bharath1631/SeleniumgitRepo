/*
	 * @Author : Anil kumar
	 * Module : Carrier Admin Approval Test cases
	 * Date   : 06-Jan-2022
	 */
package testCases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.AdminDashBoard;
import pageObjects.AggregatorsPage;
import pageObjects.LoginPage;
import resources.Base;
import resources.Log;

public class CarrierAdmin extends Base{
	
	String aggregatorName;
	
	
	@Parameters("value")
	@BeforeTest
	public void invokeBrowser(String value) throws IOException {
		driver =  driverInitialize(value);
		driver.get(readProperties("BaseURL"));
		LoginPage login =new LoginPage(driver);
		login.loginApplication(readProperties("DocomoJapanAdmin"), readProperties("DocomoJapanAdminPwd"));
	}
	
	@Test(priority=-1, dependsOnGroups={"AdminCases.clickOKwithReason"})
	public void carrierApproveRejectButton() {
		
		AdminDashBoard carrierAdmin = new AdminDashBoard(driver);
		AggregatorsPage aggregatorTab = new AggregatorsPage(driver);
		Log.info("Logged in to the Carrier Admin Dashboard");
		carrierAdmin.aggregators().click();
		Log.info("Clicked on Aggregator Tab");
		aggregatorTab.dateOfSubmission().click();
		aggregatorTab.dateOfSubmission().click();
		Log.info("Clicked on Date of Submission to sort-by Latest Date");
		aggregatorTab.carrierApproveReject().click();
		Log.info("clicked on Approve/Reject Button");
		Assert.assertEquals(aggregatorTab.aggregatorDetailsText().getText(), "Aggregator Details");
		Log.info("-------Sucessfully Clicked on Approve/Reject Button and Redirected to Aggreagtor Details Page----------");
		
		
	}
	
	@Test(groups= {"CarrierAdmin.clickApproveCarrier"}, dependsOnGroups={"AdminCases.clickOKwithReason"})
	public void clickApproveCarrier() throws IOException {
		
		AggregatorsPage aggregatorTab = new AggregatorsPage(driver);
		aggregatorName = aggregatorTab.aggregatorName().getText();
		aggregatorTab.approve().click();
		Log.info("Clicked on Approve Button");
		WebDriverWait wait = explicitWait(driver,30);
		wait.until(ExpectedConditions.textToBePresentInElement(aggregatorTab.popUpText(), "Are you sure you want to approve"));
		aggregatorTab.yes().click();
		Log.info("Clicked Yes in the Pop up Window");
		aggregatorTab.reason().sendKeys("Approved");
		Log.info("Entered Reason in the Text box");
		aggregatorTab.redapprove().click();
		Log.info("Clicked on Approve after giving Reason");
		wait.until(ExpectedConditions.textToBePresentInElement(aggregatorTab.popUpText(), " has been approved successfully."));
		Assert.assertEquals(aggregatorTab.popUpText().getText(),aggregatorName+" has been approved successfully.");
		aggregatorTab.ok().click();
		Log.info("'Successfully Approved' Message PopUP displayed and clicked on OK");
		wait.until(ExpectedConditions.urlToBe(readProperties("AggregatorTab")));
		JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
		//scrollPage.executeScript("arguments[0].scrollIntoView(true);", aggregatorTab.approvedAggregator());
		scrollPage.executeScript("window.scrollBy(0,1200)", "");
		Log.info("Scrolling the page till the Approved Aggregator list is visible");
		aggregatorTab.dateOfApproval().click();
		Assert.assertEquals(aggregatorTab.approvedAggregatorName().getText(),aggregatorName );
		Assert.assertEquals(aggregatorTab.approvedAggregatorStatus().getText(), "Approved by carrier");
		Log.info("--------Successfully Clicked on Approve Button and Aggregator is listed in Approved Aggregators List-------");
	}

	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
}
