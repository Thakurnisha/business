package tests;

import org.testng.annotations.Test;


import pageEvents.CreateProjectFromTemplate;
import pageEvents.CreateProjectTemplate;
import pageEvents.LoginPage;

public class CreateProjectFromTemplateTest extends BaseTest {
	
	LoginPage login = new LoginPage();
	CreateProjectFromTemplate project = new CreateProjectFromTemplate();
	
	
	@Test(priority = 2)
	void createProjectFromTemplates() throws InterruptedException {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		ext.setTest(methodName, "Create project from template");
		login();
		createProjectFromTemplate();
		addDetails();
		validatePostsCopied();
		validateWikiCopied();
		validateFilesCopied();
		validateTasksCopied();
		validateTimesheetCopied();
		validateFeedCopied();
		validateCommentCopied();
	}
	
	void login() {	
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {				
			login.loadLoginPage(cv.domainUrl);
			login.emailId(cv.userName);
			login.password(cv.userPassword);
			login.clickLogin();
			login.verifyLogin();
		}catch(Exception e) {
			ext.logger.fail(methodName);
		}
	}
	
	void createProjectFromTemplate() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
			project.navigateToProjectpage(cv.domainUrl);
			project.clickOnCreateButton();
		}catch(Exception e) {
			ext.logger.fail(methodName);
		}
	}
	
	void addDetails() throws InterruptedException {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
			project.addTeamName();
			project.selectTemplate();
			project.saveAndContiue();
			project.saveAndExit();
			project.validateProjectCreated();
		}catch(Exception e) {
			ext.logger.fail(methodName);
		}
		
	}
	
	void validatePostsCopied() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
			project.navigateToSubmenu("Posts");
			project.validatePostCreated(cv.postName);
			project.validatePostCreated(cv.postName+"_without_feature_image");
//			project.validateAnnouncement(cv.postName+"_announcement_"); 
			project.validateDraftPostCreated(cv.postName+"draft_");
		}catch(Exception e) {
			ext.logger.fail(methodName);
		}
	}
	
	void validateWikiCopied() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
			project.navigateToSubmenu("Wikis");
			project.selectRecentWikis();
			project.validateWiki(cv.wikiName);
			project.validateDraftWiki(cv.wikiName+"_draft_");
		}catch(Exception e) {
			ext.logger.fail(methodName);
		}
	}
	
	void validateFilesCopied() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
			project.navigateToSubmenu("Files");
			project.validateFileUploaded(cv.imageFileName, "Image");
			project.validateFileUploaded(cv.xlsFileName, "xlsx");
			project.validateFileUploaded(cv.pptFileName, "ppt");
			project.validateFileUploaded(cv.zipFileName, "zip");
		}catch(Exception e) {
			ext.logger.fail(methodName);
		}
		
	}
	
	void validateTasksCopied() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
			project.navigateToSubmenu("Tasks");
			project.selectTaskFilter();
			project.selectTaskFilterAction("All Pending Tasks");
			project.createdTaskVerification();
		}catch(Exception e) {
			ext.logger.fail(methodName);
		}
	}
	
	
	void validateTimesheetCopied() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
//			project.navigateToSubmenu("Timesheets");
			project.checkInMore("Timesheets");
			project.verifyTimeSheetCreated();
		}catch(Exception e) {
			ext.logger.fail(methodName);
		}
	}
	
	void validateFeedCopied() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
			project.navigateToSubmenu("News Feed");
			project.selectPrimaryTab();
			project.validateMessage();
		}catch(Exception e) {
			ext.logger.fail(methodName);
		}
	}
	
	void validateCommentCopied() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
			project.navigateToSubmenu("News Feed");
			project.selectPrimaryTab();
			project.validateComment();
		}catch(Exception e) {
			ext.logger.fail(methodName);
		}
	}
	

}

