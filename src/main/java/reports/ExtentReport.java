package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class ExtentReport {

	public  ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;

	
	public void initializeReport() {
		// start reporters
		htmlReporter = new ExtentHtmlReporter("extent.html");

		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		// creates a toggle for the given test, adds all log events under it    
		//        ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
	}
	
	
	public void setTest(String methodName, String description) {
		// TODO Auto-generated method stub
		String name = methodName;
		logger = extent.createTest(methodName, description);
	}
	
	
}
