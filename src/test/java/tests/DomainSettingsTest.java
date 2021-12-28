package tests;

import org.testng.annotations.Test;

import pageEvents.CreateProjectTemplate;
import pageEvents.DomainSettingsActions;
import pageEvents.LoginPage;
import pageEvents.PostActions;
import pageEvents.WikiActions;


public class DomainSettingsTest extends BaseTest{
	
	LoginPage login = new LoginPage();
	DomainSettingsActions ds = new DomainSettingsActions();
	
	
	@Test(priority = 8)
	void domainSettingTestCases() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		ext.setTest(methodName, "Domain setting test cases");
		login();
		setLandingPage();
//		changePassword();
//		importUser();
	}
	
	
	void login() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
		System.out.println("DOmainSettings test executed>>>>>>>>>>");				
		login.loadLoginPage(cv.domainUrl);
		login.emailId(cv.userName);
		login.password(cv.userPassword);
		login.clickLogin();
		login.verifyLogin();
		}catch(Exception e) {
			ext.logger.fail(methodName);
		}
	}
	
	void setLandingPage() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
		ds.navigateToLandingPageSetting(cv.domainUrl);
		ds.selectFromNavigationList("Default Network Users Navigation");
		ds.clickLandingPageDropDown();
		ds.selectOptions("Company");

		ds.save();
		//validate 
		ds.navigateToHomePage(cv.domainUrl);
		ds.validateCompanyAsLandingPage();
		
		//revert to default landing page
		ds.navigateToLandingPageSetting(cv.domainUrl);
		ds.selectFromNavigationList("Default Network Users Navigation");
		ds.clickLandingPageDropDown();
		ds.selectOptions("News Feed");

		ds.save();
		//validate 
		ds.navigateToHomePage(cv.domainUrl);
		ds.validateNewsFeedAsLandingPage();
		
		
		}catch(Exception e) {
			ext.logger.fail(methodName);
			
		}
		
	}
	
	
	void changePassword() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
			//change password
			ds.navigateToPasswordSettingPage(cv.domainUrl);
			ds.addExistingPassword(cv.userPassword);
			ds.addNewPassword("temp12345");
			ds.addConfirmPassword("temp12345");
			ds.savePassword();
			
			//validate new password
			ds.logout();
			login.loadLoginPage(cv.domainUrl);
			login.emailId(cv.userName);
			login.password("temp12345");
			login.clickLogin();
			ds.verifyLoginAfterChangedPassword();
			
			//revert to previous password
			ds.navigateToPasswordSettingPage(cv.domainUrl);
			ds.addExistingPassword("temp12345");
			ds.addNewPassword(cv.userPassword);
			ds.addConfirmPassword(cv.userPassword);
			ds.savePassword();
			
		
		}catch(Exception e) {
			ext.logger.fail(methodName);
			
		}
		
	}
	
	
	void importUser() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
			//import users
			ds.navigateToimportUsers(cv.domainUrl);
			ds.clickImportFile();
			ds.uploadCsvFile(cv.csvFileUserImport);
			ds.scrollToBottom();
			ds.importNowButton();
			
			ds.okButton();
			ds.searchImportedUsers(cv.domainUrl);
			ds.scrollToBottom();
			ds.validateImportedUSers();
			ds.selectUsers();
			ds.selectUserTool();
			ds.selectDeleteAction();
			ds.confrimDelte();
			ds.addDelteConfirm();
			ds.deleteButton();
			ds.okButton();
			ds.scrollToBottom();
			ds.validateUsersDeleted();
		
		}catch(Exception e) {
			ext.logger.fail(methodName);
			
		}
		
	}
	
	
}
