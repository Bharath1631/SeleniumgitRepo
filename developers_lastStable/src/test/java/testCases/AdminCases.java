package testCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObjects.AdminDashBoard;

import pageObjects.AggregatorsPage;
import pageObjects.LoginPage;

import pageObjects.ViewDotgoAggregatorsDetails;
import resources.Base;
import resources.Log;

public class AdminCases extends Base{
	
	@Parameters("value")
	@BeforeTest
	public void invokeBrowser(String value) throws IOException {
		driver =  driverInitialize(value);
		//driver.get(readProperties("BaseURL"));
	}
	
	
	@Test(priority=-1, dependsOnGroups={"OnBoarding.DirectRBMAccount"})
	public void adminLogin()  throws IOException, InterruptedException {
        driver.get(readProperties("adminurl"));
		
        LoginPage login=new LoginPage(driver);
        login.email().sendKeys(readProperties("AdminEmailID"));
        Log.info("Entered SuperAdmin Email");
        login.password().sendKeys(readProperties("AdminPassword"));
        Log.info("Entered Admin Password");
        login.submit().click();
        Log.info("---------Successfully Clicked on Submit BUtton--------");
        Listeners.test.log(Status.INFO,"--------Successfully Clicked on Submit BUtton------");
	}
        
    @Test(priority=0, dependsOnGroups={"OnBoarding.DirectRBMAccount"})
    public void clickAggregator() throws InterruptedException, IOException {
        AdminDashBoard admin=new AdminDashBoard(driver);
        admin.aggregators().click();
        Log.info("Clicked on Admin Aggregator");
        Assert.assertEquals(driver.getCurrentUrl(), readProperties("adminAggregatorURL"));
        Log.info("--------Successfully Redirected to Admin Aggregator Tab-----------");
        Listeners.test.log(Status.INFO,"--------Successfully Redirected to Admin Aggregator Tab-----------");
    }   
        
    @Test(priority=1, dependsOnGroups={"OnBoarding.DirectRBMAccount"})
    public void clickDotgoAggregatorRequest() throws IOException {
       
        AggregatorsPage aggregator=new AggregatorsPage(driver);
        aggregator.dotgoAggregatorsRequest().click();
        Assert.assertEquals(driver.getCurrentUrl(), readProperties("DotogAggregatorRequestURL"));
        Log.info("------Successfully clicked on DotgoAggregatorRequest-------");
        Listeners.test.log(Status.INFO,"------Successfully clicked on DotgoAggregatorRequest-------");
    }   
    
    @Test(priority=2, dependsOnGroups={"OnBoarding.DirectRBMAccount"})
	public void clickApproveRejectButton() throws InterruptedException {
    	
    	AggregatorsPage aggregator=new AggregatorsPage(driver);
    	aggregator.submittedDate().click();
    	aggregator.submittedDate().click();
        aggregator.approveReject().click();
        Log.info("---------Successfully Clicked on Approve/reject Button----------");
        Listeners.test.log(Status.INFO,"---------Successfully Clicked on Approve/reject Button----------");
        
    }
    
    
    @Test(priority=3, dependsOnGroups={"OnBoarding.DirectRBMAccount"})
    public void clickApprove() throws InterruptedException {
    	
        ViewDotgoAggregatorsDetails viewdetails= new ViewDotgoAggregatorsDetails(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        viewdetails.clickApprove().click();
        Log.info("Clicked on Approve Button");
        wait.until(ExpectedConditions.visibilityOf(viewdetails.approvePopup()));
        Assert.assertEquals(viewdetails.approvePopup().getText(), "Are you sure you want to approve as an aggregator?");
        Log.info("------SUccessfully POPUP dispalyed---------");
        Listeners.test.log(Status.INFO,"------SUccessfully POPUP dispalyed--------");
    }
    
    @Test(priority=4, groups={"AdminCases.clickOKwithReason"}, dependsOnGroups={"OnBoarding.DirectRBMAccount"})
    public void clickOKWithReason() throws IOException, InterruptedException {
    	
    	ViewDotgoAggregatorsDetails viewdetails= new ViewDotgoAggregatorsDetails(driver);
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        viewdetails.clickOk().click();
        viewdetails.EnterReason().sendKeys(readProperties("reasontext"));
        Log.info("Entered Reason in the Text Field");
        wait.until(ExpectedConditions.elementToBeClickable(viewdetails.reasonApprove()));
        viewdetails.reasonApprove().click();
        Log.info("Clicked on Approve Button");
		wait.until(ExpectedConditions.elementToBeClickable(viewdetails.clickOk()));
		Assert.assertEquals(viewdetails.clickOk().getText(), "OK");
        viewdetails.clickOk().click();
        Log.info("------Successfully Approved with Reason--------");
        Listeners.test.log(Status.INFO,"------Successfully Approved with Reason--------");
    
        
	}
	

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
    
    
}
