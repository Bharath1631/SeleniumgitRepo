package testCases;

import java.io.File;
import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import resources.ExtentReporterNG;
import resources.Log;

public class Listeners extends Base implements ITestListener

{
	static ExtentTest test;
	static ExtentReports extent = ExtentReporterNG.getReportObject();

	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestStart(result);
		test = extent.createTest(result.getMethod().getMethodName());
		String category = result.getTestClass().getName();                    
		String[] category_splitted = category.split("\\.",2);             //Trimmed Prefix in the Testcase Category Name
		test.assignCategory(""+category_splitted[1]);                       //Trimmed Prefix in the Testcase Category Name
		//test.assignCategory(""+result.getTestClass().getName());       // With Prefix in the TestCase Category Name                      
		Log.info("Listener OnTestStart method "+result.getMethod().getMethodName());                
		Log.startTestCase(result.getMethod().getMethodName());
		
//		try {
//			customReport.html(category_splitted[1],result.getMethod().getMethodName(),category_splitted[1]);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
	}

	
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSuccess(result);
		test.log(Status.PASS, "Test is passed");
		Log.endTestCase(result.getMethod().getMethodName());
	}

	
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailure(result);
		test.fail(result.getThrowable());
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String filepath = null;
		try {
			filepath = getScreenShot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
		Log.endTestCase(result.getMethod().getMethodName());
	}

	
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSkipped(result);
		Log.error("onTestSKipped");
		Log.endTestCase(result.getMethod().getMethodName());
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
		Log.error("OntestFailedwithinSUccessPercentage");
		Log.endTestCase(result.getMethod().getMethodName());
	}

	
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedWithTimeout(result);
		Log.error("onTestFailedWithTimeout");
		Log.endTestCase(result.getMethod().getMethodName());

		
	}

	
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onStart(context);
		Log.info("Onstart");
		
	}

	
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onFinish(context);
        
		Log.info("came to flush");
//		try {
//			sendEmail();
//		} catch (EmailException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//SendMailSSLWithAttachment.sendMail();
		extent.flush();
		File filename = new File("./reports");
        zipDirectory(filename, "AutomationReports.zip");
        Log.info("Zipping of AutomationReports successfully");
	}

}
