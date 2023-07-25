/*
	 * @Author : Anil kumar
	 * Module : Custom Report to Send Email From Jenkins
	 * Date   : 30 Nov 2022
	 */
package testCases;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;

import resources.Base;

public class customReport implements IReporter{
	
	public static int Passedsize;
	public static int Failedsize;
	public static int SkippedSize;
	public static int TotalTests;
	public static float passpercentage;
	public static float Failpercentage;
	public static String Category; 
	public static String classname; 
	public static String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	
   @Override
   public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,String outputDirectory) {
    
      //Iterating over each suite included in the test
      for (ISuite suite : suites) {

         //Following code gets the suite name
         String suiteName = suite.getName();
         

         //Getting the results for the said suite
         Map<String, ISuiteResult> suiteResults = suite.getResults();
         for (ISuiteResult sr : suiteResults.values()) {
            ITestContext tc = sr.getTestContext();
            System.out.println("Passed tests for suite '" + suiteName +
               "' is:" + tc.getPassedTests().getAllResults().size());
            System.out.println("Failed tests for suite '" + suiteName +
               "' is:" + tc.getFailedTests().getAllResults().size());
            System.out.println("Skipped tests for suite '" + suiteName +
               "' is:" + tc.getSkippedTests().getAllResults().size());
            
            
            Passedsize = tc.getPassedTests().getAllResults().size();
            Category = tc.getCurrentXmlTest().getName();
            Failedsize = tc.getFailedTests().getAllResults().size();
            SkippedSize = tc.getSkippedTests().getAllResults().size();
            TotalTests = tc.getAllTestMethods().length;
            passpercentage = (float)Passedsize/TotalTests*100;
            Failpercentage = (float)Failedsize/TotalTests*100;
            classname = suite.getAllInvokedMethods().getClass().getSimpleName();
         }
      }
      
      
      String X = "<html>\n"
    		    +"<head>\n"
				+ "<style>\n"
				+ "table, th, td, tr { border:1px solid #000000;}\n"
				+ "border-collapse: collapse;\n"
				+ "</style>\n"
				+ "</head>\n"
				+ "<body>\n"
				+ "\n"
				+ "<h3> <span style=\"font-weight:normal\"> Hi Team,"
			    + "<br>\n"
				+ "Please find below Automation test report for sanity on Gupshup Dotgo Developer Portal-Automation </span></h3>\n"
				+ "\n"
				 + "<br>"
				    + "<br>"
				+"<table style=\"border: 1px solid black; border-style: collapse;\">\n"
				+ "  <tr style=\"border: 1px solid black; padding: 10px;\">\n"
				+ "    <th style=\"border: 1px solid black; padding: 10px;\">Project:</th>\n"
				+ "    <td style=\"border: 1px solid black; padding: 10px;\">Gupshup Dotgo Developer-client</td>\n"
				+ "  </tr>\n"
				+ "  <tr style=\"border: 1px solid black; padding: 10px;\">\n"
				+ "    <th style=\"border: 1px solid black; padding: 10px;\">Release:</th>\n"
				+ "    <td style=\"border: 1px solid black; padding: 10px;\">DailyExecution</td>\n"
				+ "  </tr>\n"
				+ "  <tr style=\"border: 1px solid black; padding: 10px;\">\n"
				+ "    <th style=\"border: 1px solid black; padding: 10px;\">Build:</th>\n"
				+ "    <td style=\"border: 1px solid black; padding: 10px;\">DailyExecution</td>\n"
				+ "  </tr>\n"
				+ "  <tr style=\"border: 1px solid black; padding: 10px;\">\n"
				+ "    <th style=\"border: 1px solid black; padding: 10px;\">Execution Time:</th>\n"
				+ "    <td style=\"border: 1px solid black; padding: 10px;\">"+timeStamp+" IST</td>\n"
				+ "  </tr>\n"
				+ "</table>"
				+ "<br>"
			    + "<br>"
			    + "<br>"
			    +"<h2> Automation Details </h2> "
				+ "<table style=\"border: 1px solid black; border-style: collapse;\">\n"
				+ "  <tr style=\"border: 1px solid black; padding: 10px;\">\n"
				+ "    <th style=\"border: 1px solid black; padding: 10px;\">Test Category</th>\n"
				+ "    <th style=\"border: 1px solid black; padding: 10px;\">Total Tests</th>\n"
				+ "    <th style=\"border: 1px solid black; padding: 10px;\">Total Passed</th>\n"
				+ "    <th style=\"border: 1px solid black; padding: 10px;\">Total Failed</th>\n" 
				+ "    <th style=\"border: 1px solid black; padding: 10px;\">Total Skipped</th>\n" 
				+ "    <th style=\"border: 1px solid black; padding: 10px;\">Passed Percentage %</th>\n" 
				+ "    <th style=\"border: 1px solid black; padding: 10px;\">Failed Percentage %</th>\n" 
				+ "  </tr>\n"
				+ "  <tr style=\"border: 1px solid black; padding: 10px;\">\n"
				+ "    <td style=\"border: 1px solid black; padding: 10px;\">"+Category+"</td>\n"
				+ " <td style=\"border: 1px solid black; padding: 10px;\">"+TotalTests+"</td>\n"
				+ "    <td style=\"border: 1px solid black; padding: 10px;\">"+Passedsize+"</td>\n"
				+ "    <td style=\"border: 1px solid black; padding: 10px;\">"+Failedsize+"</td>\n"
				+ "  <td style=\"border: 1px solid black; padding: 10px;\">"+SkippedSize+"</td>\n"
				+ " <td style=\"border: 1px solid black; padding: 10px;\">"+passpercentage+"%</td>\n"
				+ " <td style=\"border: 1px solid black; padding: 10px;\">"+Failpercentage+"%</td>\n"
				+ "  </tr>\n"
				+ "</table>"
				+ "<pre>\n"
				+ "Note:"
				+ "Please find the Detailed Downloadable HTML Reports i.e 'Reports.html' which is inside the Zipped Folder Attached Below. (Extract and open the Reports.html)"
				+ "</pre>\n"
				+ "<br>\n"
			    + "<br>\n"
			    + "<br>\n"
				+ "<pre>\n"
				+ "Regards,\n"
				+ "Developers-client QA Team."
				+ "</pre>\n"
				+ "</body>\n"
				+ "</html>";
		
//		File file = new File(Base.localDir+"/reports/custom.html");
//		System.out.println("this is logger");
//		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
//		//bw.write(html);
//		
//		file.append(X);
//		ExtentReports extent=new ExtentReports();
//		//bw.append(extent.getReport());
//		
//		bw.close();
		String path = Base.localDir+"/reports/custom.html";
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(path, false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedWriter bufferFileWriter = new BufferedWriter(fileWriter);
		try {
			fileWriter.append(X);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			bufferFileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   
   }
}
