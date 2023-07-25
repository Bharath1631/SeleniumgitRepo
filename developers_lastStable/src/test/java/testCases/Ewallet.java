package testCases;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*; 

import resources.Base;
import resources.Log;

public class Ewallet extends Base {
	
	
	String Aggstatus="null";
	String devStatus="null";
	int is_aggregator=6;
	
	@Parameters("value")
	@BeforeTest
	public void invokeBrowser(String value) throws IOException {
		driver =  driverInitialize(value);
		driver.get(readProperties("BaseURL"));
	}
	
//	String api = "http://172.20.20.126:8084/ewallet/ewapi/get_ewallet_balance?email=aksubramani@kirusa.com";
//	
//	@Test (dependsOnGroups={"OnBoarding.DirectRBMAccount"})
//	public void Get() {
//		Response code = get(api);
//		Log.info("response is"+code );
//		
//	}
//	
	
	
	@Test(dependsOnGroups={"AdminCases.clickOKwithReason"})
	public void aggregatorMainEwallet() throws SQLException, InstantiationException, IllegalAccessException, IOException {
		Connection DB = getDBconnection(readProperties("Ewalleturl"), readProperties("Ewalletuser"), readProperties("Ewalletpassword"));
		Listeners.test.log(Status.INFO,"---------Database Connection opened Sucessfully-------");
		PreparedStatement pstmt = DB.prepareStatement("select * from ewallet where user_id=(select id from user where email=?) limit 1");
		pstmt.setString(1, OnBoarding.Email);
		Log.info("Aggregator Email ID is"+OnBoarding.Email);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Aggstatus = rs.getString("status");
			Log.info("status is" +Aggstatus);
		}
		
		DB.close();
		Log.info("--------Database connection closed successfully----------");
		Listeners.test.log(Status.INFO,"--------Database connection closed successfully----------");
		
		if(Aggstatus.equals("a")) {
			Assert.assertTrue(true);
			Log.info("---------Ewallet is Created for the Aggregator Account "+OnBoarding.Email+"-----------");
			Listeners.test.log(Status.INFO,"---------Ewallet is Created for the Aggregator Account "+OnBoarding.Email+"------------");
		}
		else {
			Log.info("Ewallet is not Created for the Aggreator Account "+OnBoarding.Email);
			Assert.assertTrue(false);
			
		}
	
		
	}
	
	
	@Test(dependsOnGroups={"CarrierAdmin.clickApproveCarrier"})
	public void aggregatorCarrierEwallet() throws SQLException, InstantiationException, IllegalAccessException, IOException {
		Connection DB = getDBconnection(readProperties("Ewalleturl"), readProperties("Ewalletuser"), readProperties("Ewalletpassword"));
		Listeners.test.log(Status.INFO,"---------Database Connection opened Sucessfully-------");
    	PreparedStatement pstmt = DB.prepareStatement("select * from ewallet where user_id=(select id from user where email=?) limit 1");
    	pstmt.setString(1, OnBoarding.Email);
    	Log.info("Aggregator Email ID is"+OnBoarding.Email);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Aggstatus = rs.getString("status");
			Log.info("status is" +Aggstatus);
		}
		
		DB.close();
    	Log.info("--------Database connection closed successfully----------");
    	Listeners.test.log(Status.INFO,"--------Database connection closed successfully----------");
    	
    	if(Aggstatus.equals("a")) {
    		Assert.assertTrue(true);
    		Log.info("---------Ewallet is Created for the Aggregator Account "+OnBoarding.Email+"-----------");
    		Listeners.test.log(Status.INFO,"---------Ewallet is Created for the Aggregator Account "+OnBoarding.Email+"------------");
    	}
    	else {
    		Log.info("Ewallet is not Created for the Aggreator Account "+OnBoarding.Email);
    		Assert.assertTrue(false);
    		
    	}

		
	}
	
	
	@Test(dependsOnGroups={"CarrierAdmin.clickApproveCarrier"})
	public void aggregatorPartnersProfile() throws SQLException, InstantiationException, IllegalAccessException, IOException {
		Connection DB = getDBconnection(readProperties("url"), readProperties("user"), readProperties("password"));
		Listeners.test.log(Status.INFO,"---------Database Connection opened Sucessfully-------");
    	PreparedStatement pstmt = DB.prepareStatement("select * from partners_profile where email=?");
    	pstmt.setString(1, OnBoarding.Email);
    	Log.info("Aggregator Email ID is"+OnBoarding.Email);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			is_aggregator = rs.getInt("is_aggregator");
			Log.info("Aggregator flag is " +is_aggregator);
		}
		
		DB.close();
    	Log.info("--------Database connection closed successfully----------");
    	Listeners.test.log(Status.INFO,"--------Database connection closed successfully----------");
    	
    	if(is_aggregator==1) {
    		Assert.assertTrue(true);
    		Log.info("---------Partners profile Row is created for the Aggregator Account "+OnBoarding.Email+"-----------");
    		Listeners.test.log(Status.INFO,"---------Partners profile Row is created for the Aggregator Account "+OnBoarding.Email+"------------");
    	}
    	else {
    		Assert.assertTrue(false);
    		Log.info("Partners profile Row is not created for the Aggreator Account "+OnBoarding.Email);
    	}
	}
	
	
	
	@Test(dependsOnGroups={"OnBoarding.createDeveloperAccount"})
	public void developersPartnersProfile() throws SQLException, InstantiationException, IllegalAccessException, IOException {
		Connection DB = getDBconnection(readProperties("url"), readProperties("user"), readProperties("password"));
		Listeners.test.log(Status.INFO,"---------Database Connection opened Sucessfully-------");
    	PreparedStatement pstmt = DB.prepareStatement("select * from partners_profile where email=?");
    	pstmt.setString(1, OnBoarding.Email);
    	Log.info("Aggregator Email ID is"+OnBoarding.Email);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			is_aggregator = rs.getInt("is_aggregator");
			Log.info("Aggregator flag is " +is_aggregator);
		}
		
		DB.close();
    	Log.info("--------Database connection closed successfully----------");
    	Listeners.test.log(Status.INFO,"--------Database connection closed successfully----------");
    	
    	if(is_aggregator==0) {
    		Assert.assertTrue(true);
    		Log.info("---------Partners profile Row is created for the Developers Account "+OnBoarding.Email+"-----------");
    		Listeners.test.log(Status.INFO,"---------Partners profile Row is created for the Developers Account "+OnBoarding.Email+"------------");
    	}
    	else {
    		Assert.assertTrue(false);
    		Log.info("Partners profile Row is not created for the Developers Account "+OnBoarding.Email);
    	}
	}
	
	
	
	@Test(dependsOnGroups={"OnBoarding.createDeveloperAccount"})
	public void developersMainEwallet() throws SQLException, InstantiationException, IllegalAccessException, IOException {
		
		Connection DB = getDBconnection(readProperties("Ewalleturl"), readProperties("Ewalletuser"), readProperties("Ewalletpassword"));
		Listeners.test.log(Status.INFO,"---------Database Connection opened Sucessfully-------");
		PreparedStatement pstmt = DB.prepareStatement("select * from ewallet where user_id=(select id from user where email=?) limit 1");
		pstmt.setString(1, OnBoarding.Email);
		Log.info("Aggregator Email ID is"+OnBoarding.Email);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			devStatus = rs.getString("status");
			Log.info("status is" +devStatus);
		}
		
		DB.close();
		Log.info("--------Database connection closed successfully----------");
		Listeners.test.log(Status.INFO,"--------Database connection closed successfully----------");
		
		if(devStatus.equals("a")) {
			Assert.assertTrue(true);
			Log.info("---------Ewallet is Created for the Developer Account "+OnBoarding.Email+"-----------");
			Listeners.test.log(Status.INFO,"---------Ewallet is Created for the Developers Account "+OnBoarding.Email+"------------");
		}
		else {
			Log.info("Ewallet is not Created for the Developer Account "+OnBoarding.Email);
			Assert.assertTrue(false);
			
		}
	}
	
	@Test(dependsOnGroups={"OnBoarding.createDeveloperAccount"})
	public void developersCarrierEwallet() throws SQLException, InstantiationException, IllegalAccessException, IOException {
		
		Connection DB = getDBconnection(readProperties("Ewalleturl"), readProperties("Ewalletuser"), readProperties("Ewalletpassword"));
		Listeners.test.log(Status.INFO,"---------Database Connection opened Sucessfully-------");
		PreparedStatement pstmt = DB.prepareStatement("select * from ewallet where user_id=(select id from user where email=?) limit 1");
		pstmt.setString(1, OnBoarding.Email);
		Log.info("Aggregator Email ID is"+OnBoarding.Email);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			devStatus = rs.getString("status");
			Log.info("status is" +devStatus);
		}
		
		DB.close();
		Log.info("--------Database connection closed successfully----------");
		Listeners.test.log(Status.INFO,"--------Database connection closed successfully----------");
		
		if(devStatus.equals("a")) {
			Assert.assertTrue(true);
			Log.info("---------Carrier Ewallet is Created for the Developer Account "+OnBoarding.Email+"-----------");
			Listeners.test.log(Status.INFO,"---------Carrier Ewallet is Created for the Developers Account "+OnBoarding.Email+"------------");
		}
		else {
			Log.info("Carrier Ewallet is not Created for the Developer Account "+OnBoarding.Email);
			Assert.assertTrue(false);
			
		}
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
	

}
