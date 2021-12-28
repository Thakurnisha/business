package tests;

import org.testng.annotations.Test;

import pageEvents.CleanUpActions;
import pageEvents.LoginPage;
import pageEvents.PagesActions;


public class CleanUpTest extends BaseTest{
	
	LoginPage login = new LoginPage();
	PagesActions pages =  new PagesActions();
	CleanUpActions clean = new CleanUpActions();
	
	
	@Test(priority = 100)
	void cleanUpTestCases() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		BaseTest.ext.setTest(methodName, "Cleanup cases");
		login();
		deleteProject();		
		deletePage();
	}
	
	
	void login() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
//		ext.setTest(methodName, "Posts test cases");
		
		System.out.println("Posts test executed>>>>>>>>>>");				
		login.loadLoginPage(cv.domainUrl);
		login.emailId(cv.userName);
		login.password(cv.userPassword);
		login.clickLogin();
		login.verifyLogin();
	}
	
	
	void deleteProject() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
			clean.navigateToAdminProject(cv.domainUrl);
			clean.selectDeleteAction(cv.projectName);
			
		}catch(Exception e) {
			ext.logger.fail(methodName);
		}
	}
	
	
	void deletePage() {
		//delete page
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		
		try {
			pages.navigateToCompanyPage(cv.domainUrl);
			boolean isPresent = pages.findPage(cv.pageTitle+"_edited_static_");
			if(isPresent) {
				pages.clickTools();
				pages.selectToolOption("Delete Current Page");
				pages.addDeleteText();
				pages.deletePage();
			}
			
			
			//delete dynamic page
			pages.navigateToCompanyPage(cv.domainUrl);
			isPresent = pages.findPage(cv.pageTitle+"_dynamic_");
			if(isPresent) {
				pages.clickTools();
				pages.selectToolOption("Delete Current Page");
				pages.addDeleteText();
				pages.deletePage();
			}
		} catch (Exception e) {
			// TODO: handle exception
			ext.logger.fail(methodName);
		}
	
	}
	
	
}
