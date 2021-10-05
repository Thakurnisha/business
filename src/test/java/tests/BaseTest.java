package tests;


import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import reports.ExtentReport;
import utils.CommonVariables;
import utils.DriverConfig;

public class BaseTest {
	
	public static DriverConfig WebDriver = new DriverConfig();
    public static ExtentReport ext = new ExtentReport();
    LoginTest login = new LoginTest();
    CommonVariables cv = new CommonVariables();

	@BeforeSuite
	public void beforeSuiteMethod() throws IOException {
		System.out.println("Before Suite executed");
//		cv.readConfigFile();
		ext.initializeReport();
	}
	
	
	@BeforeClass
	public void beforeClassMethod() {
		System.out.println("Before Class executed");
	}
	
	
	@BeforeMethod()
	@Parameters({"browser"})
	public void beforeMethod(String browser) throws IOException{
		System.out.println("Before Method executed");
		cv.readConfigFile();
		WebDriver.launchBrowser(browser);
		
	}
	
	
	@AfterMethod()
	public void afterMethod(){
		System.out.println("After Method executed");
		ext.extent.flush();
		WebDriver.closeBrowser();
	}
	
	
	@AfterClass
	public void afterClassMethod() {
		System.out.println("After Class executed");
	}
	
}
