package tests;

import org.testng.annotations.Test;


import pageEvents.CreateProjectTemplate;
import pageEvents.LoginPage;
import pageEvents.PagesActions;


public class PagesTest extends BaseTest{
	
	LoginPage login = new LoginPage();
	PagesActions pages =  new PagesActions();
	int createdPageId = 0;
	
	
	
	@Test(priority = 6)
	void pagesTestCases() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		BaseTest.ext.setTest(methodName, "Pages test cases");
		
		if(System.getProperty("env").equals("YMCA")) {
			System.out.println("pagesTestCases skipped for >>>>>>>>>>"+System.getProperty("env"));
		}else {
			System.out.println("pagesTestCases test executed>>>>>>>>>>");				
			login();
			addNewCompanyStaticPage();
			addNewCompanyDynamicPage();
		}
		
	}
	
	
	void login() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
//		ext.setTest(methodName, "Posts test cases");
		
		System.out.println("Pages test executed>>>>>>>>>>");				
		login.loadLoginPage(cv.domainUrl);
		login.emailId(cv.userName);
		login.password(cv.userPassword);
		login.clickLogin();
		login.verifyLogin();
	}
	
	
	void addNewCompanyStaticPage() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
			
			//create page
			pages.navigateToCompanyPage(cv.domainUrl);
			pages.clickTools();
			pages.selectToolOption("New Page");
			pages.addPageTitile(cv.pageTitle+"_static_");
			pages.openIconPopup();
			pages.selectIcon();
			pages.closeIconPoup();
			pages.selectStaticTemplate(2);
			pages.doneButtonPath();
			pages.doneButtonPath();
			pages.saveAndPublish();
			
			//validate page created
			createdPageId = pages.getPageId();
			pages.validatePagePosted(cv.pageTitle+"_static_");
			
			//edit static page
			pages.navigateToPage(cv.domainUrl, createdPageId);
			pages.clickTools();
			pages.selectToolOption("Edit Current Page");
			pages.addPageTitile(cv.pageTitle+"_edited_static_");
			pages.doneButtonPath();
			pages.doneButtonPath();
			pages.saveAndPublish();
			pages.confirmPublish();
//			pages.validatePageDeleted(cv.pageTitle+"_edited_static_");
			
			
			//delete page
			pages.navigateToPage(cv.domainUrl, createdPageId);
			pages.clickTools();
			pages.selectToolOption("Delete Current Page");
			pages.addDeleteText();
			pages.deletePage();
			
			//validate delete page
			pages.validatePageDeleted(cv.pageTitle+"_edited_static_");
			
			
			
			
		}catch(Exception e) {
			ext.logger.fail(methodName);
		}
	}
	
	
	void addNewCompanyDynamicPage() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
			//Add dynamic page
			pages.navigateToCompanyPage(cv.domainUrl);
			pages.clickTools();
			pages.selectToolOption("New Page");
			pages.addPageTitile(cv.pageTitle+"_dynamic_");
			pages.openIconPopup();
			pages.selectIcon();
			pages.closeIconPoup();
			
			pages.selectDynamicPage();
			pages.selectDynamicTemplate(2);
			
			pages.doneButtonPath();
			pages.doneButtonPath();
			pages.saveAndPublish();
			
			//validate dynamic page created
			createdPageId = pages.getPageId();
			pages.validatePagePosted(cv.pageTitle+"_dynamic_");
			
			//edit static page
			pages.navigateToPage(cv.domainUrl, createdPageId);
			pages.clickTools();
			pages.selectToolOption("Edit Current Page");
			pages.addPageTitile(cv.pageTitle+"_edited_dynamic_");
			pages.doneButtonPath();
			pages.doneButtonPath();
			pages.saveAndPublish();
			pages.confirmPublish();
//			pages.validatePageDeleted(cv.pageTitle+"_edited_dynamic_");
			
			
			//delete dynamic page
			pages.navigateToPage(cv.domainUrl, createdPageId);
			pages.clickTools();
			pages.selectToolOption("Delete Current Page");
			pages.addDeleteText();
			pages.deletePage();
			
			//validate dynamic delete page
			pages.validatePageDeleted(cv.pageTitle+"_dynamic_");
			
		}catch(Exception e) {
			ext.logger.fail(methodName);
		}
		}
	
}
