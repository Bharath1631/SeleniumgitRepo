package resources;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class ExtentReporterNG {
	ExtentReports extent;
	
	public static ExtentReports getReportObject()
	
	{
		//String path=System.getProperty("user.dir")+"reports/index.html";
		//String path="/home/anilkumars/git/repository/developers/reports/index.html";
		//String path=Base.localDir+"/reports/index.html";
		String timeStamp =new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		//String path=Base.localDir+"/reports/Reports_"+timeStamp+".html";
		//String path=Base.localDir+"/reports/Reports.html";
		String path="./reports/Reports.html";
		//ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		ExtentSparkReporter reporter = new ExtentSparkReporter(path).viewConfigurer().viewOrder().as(new ViewName[] {ViewName.DASHBOARD,ViewName.CATEGORY,ViewName.TEST,ViewName.LOG,ViewName.EXCEPTION,ViewName.AUTHOR,ViewName.DEVICE}).apply();                                                                                     
		//reporter = new ExtentSparkReporter(path1).viewConfigurer().viewOrder().as(new ViewName[] {ViewName.DASHBOARD,ViewName.CATEGORY,ViewName.TEST,ViewName.LOG,ViewName.EXCEPTION,ViewName.AUTHOR,ViewName.DEVICE}).apply();                                                                                     
		
		//reporter.config().setAutoCreateRelativePathMedia(true);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setTheme(Theme.DARK);

		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		//extent.setSystemInfo("Testers", "Anil & Archana");
		
		
		
		
		
		
//		
//		String html = "<div> <h1> Sanity Test Cases  </h1>"
//				+ ""
//				+ ""
//				+ ""
//				+ ""
//				+ ""
//				+ ""
//				+ ""
//				+ "</div>";
//		
//		File file = new File(Base.localDir+"/reports/test1.html");
//		System.out.println("this is logger");
//		BufferedWriter bw = null;
//		try {
//			bw = new BufferedWriter(new FileWriter(file));
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		try {
//			bw.write(html);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			bw.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		return extent;
		
	}

}
