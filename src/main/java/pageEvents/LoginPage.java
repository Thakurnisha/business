package pageEvents;

import utils.DriverConfig;
import utils.WebActions;

import java.util.concurrent.TimeUnit;



import reports.ExtentReport;




public class LoginPage{
	WebActions fetchElement = new WebActions();
//	SoftAssert softAssert = new SoftAssert();
//	BaseTest bs;
	
	public void loadLoginPage(String url) {
		fetchElement.navaigateToUrl(url + pageObjects.LoginObjects.pageUrl);		
		ExtentReport.logger.info("Navigate to login page");
	}
	
	public void emailId(String username) {
		fetchElement.getElement("ID", pageObjects.LoginObjects.emailPath).sendKeys(username);
		ExtentReport.logger.info("Entering email id");		
	}
	
	public void password(String password) {
		fetchElement.getElement("ID", pageObjects.LoginObjects.passPath).sendKeys(password);
		ExtentReport.logger.info("Entering password");
	}
	
	
	public void clickLogin() {
		fetchElement.getElement("XPATH", pageObjects.LoginObjects.buttonLoginPath).click();
		ExtentReport.logger.info("Login button clicked");
		DriverConfig.webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void verifyLogin() {
	
		String currentUrl = fetchElement.getUrl();
		ExtentReport.logger.info("Verifying login");
		boolean isVisible= false;
		try {
			isVisible = fetchElement.getElement("ID", pageObjects.LoginObjects.lhsContaier).isDisplayed();
		}catch(Exception e){
		
		}
		
		
//		int index = currentUrl.indexOf("/ce/pulse/user");
//		softAssert.assertNotEquals(index, -1, "User logged in successfully"); //testNG report
//		softAssert.assertAll(); 
		
		//extent report
		if(isVisible == true) {
			ExtentReport.logger.pass("Login Successfull");
		}else {
			ExtentReport.logger.fail("Login failed");
		}
		
		
	}
	
	
	
}
