package tests;

import org.testng.annotations.Test;

import pageEvents.CreateProjectTemplate;
import pageEvents.LoginPage;

public class CreateProjectTemplateTest extends BaseTest {
	
	LoginPage login = new LoginPage();
	CreateProjectTemplate ptemplate = new CreateProjectTemplate();
	
	@Test(priority = 1)
	void projectTemplatesCreation() throws InterruptedException {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		ext.setTest(methodName, "Create project template");
		System.out.println("projectTemplates test executed>>>>>>>>>>");	
		login();
		navigateToCreatePage();
		addDetails();
		createPublishedPost();
		createPublishedPostWithoutFeatureImage();
		createDraftPublishedPost();		
//		createAnnouncementPostWithExpiryDate();
		createWiki();
		createDraftWiki();
		addMembers();
		uploadImageFiles();
		validateImageFilePreview();
		uploadXlsFiles();
		validateXlsFilePreview();
		uploadPptFiles();
		uploadZipFiles();
		addTask();
		addTimeSheet();
		addFeeds();
		postComment();
		
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
	
	
	void navigateToCreatePage() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
		ptemplate.navigateToProjectpage(cv.domainUrl);
		ptemplate.hoverToGetCreateAction();
		ptemplate.clickOnCreateTemplate();
		ptemplate.verifyTheCreatePageLoaded();
		}catch(Exception e) {
			ext.logger.fail(methodName);
		}
	}
	
	
	void addDetails() throws InterruptedException {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
			ptemplate.addTeamName();
			ptemplate.addTeamDecription();
			ptemplate.HoverImage();
			ptemplate.addLocalImage();
			ptemplate.saveImage();
			ptemplate.verifyImageUpload(cv.domainUrl);
			ptemplate.saveAndContiue();
			ptemplate.enableModules();
			ptemplate.saveAndExit();
			ptemplate.validateProjectTemplateCreated();
		}catch(Exception e) {
			ext.logger.fail(methodName);
		}
	}
	
	void createPublishedPost() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
			ptemplate.navigateToSubmenu("Posts");
			ptemplate.postToolButton();
			ptemplate.selectTemplate();
			ptemplate.addPostTitle(cv.postName);
			ptemplate.addDescriptionOfPost();
			ptemplate.setFeatureImage();
			ptemplate.selectUploadTab();
			ptemplate.addPostImage();
			ptemplate.clickNextButton();
			ptemplate.clickApplyButton();
			
			ptemplate.publishPost();
			ptemplate.confirmButton();
//			ptemplate.confirmWIthoutFetatureImage();
			
			ptemplate.validatePostCreated(cv.postName);
		}catch(Exception e) {
			ext.logger.fail(methodName);
		}
	}
	
	
	void createPublishedPostWithoutFeatureImage() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
			ptemplate.navigateToSubmenu("Posts");
			ptemplate.postToolButton();
			ptemplate.selectTemplate();
			ptemplate.addPostTitle(cv.postName+"_without_feature_image");
			ptemplate.addDescriptionOfPost();
			
			ptemplate.publishPost();
			ptemplate.confirmWIthoutFetatureImage();
			
			ptemplate.validatePostCreated(cv.postName+"_without_feature_image");
		}catch(Exception e) {
			ext.logger.fail(methodName);
		}
	}
	
	
	void createAnnouncementPostWithExpiryDate() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
			ptemplate.navigateToSubmenu("Posts");
			ptemplate.postToolButton();
			ptemplate.selectTemplate();
			ptemplate.addPostTitle(cv.postName+"_announcement_");
			ptemplate.addDescriptionOfPost();
			ptemplate.markAsAnnouncement();
			ptemplate.selectExpiresDateOfPost();
			ptemplate.publishPost();
			ptemplate.confirmWIthoutFetatureImage();
			ptemplate.validateAnnouncement(cv.postName+"_announcement_");
		}catch(Exception e) {
			ext.logger.fail(methodName);
		}
	}
	
	
	void createDraftPublishedPost() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
			ptemplate.navigateToSubmenu("Posts");
			ptemplate.postToolButton();
			ptemplate.selectTemplate();
			ptemplate.addPostTitle(cv.postName+"draft_");
			ptemplate.addDescriptionOfPost();
			ptemplate.createDraftPost();
			ptemplate.validateDraftPostCreated(cv.postName+"draft_");
		}catch(Exception e) {
			ext.logger.fail(methodName);
		}
	}
	
	
	void createWiki() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
			ptemplate.navigateToSubmenu("Wikis");
			ptemplate.addNewWikiButton();
			ptemplate.addWikiTitle(cv.wikiName);
			ptemplate.createWikiButton();
			ptemplate.addDataToWiki();
			ptemplate.publishWiki();
			ptemplate.selectRecentWikis();
			ptemplate.validateWiki(cv.wikiName);
		}catch(Exception e) {
			ext.logger.fail(methodName);
		}
	}
	
	void createDraftWiki() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
			ptemplate.navigateToSubmenu("Wikis");
			ptemplate.addNewWikiButton();
			ptemplate.addWikiTitle(cv.wikiName+"_draft_");
			ptemplate.createWikiButton();
			ptemplate.addDataToWiki();
			ptemplate.wikiSplitButton();
			ptemplate.saveAsDraft();
			ptemplate.selectRecentWikis();
			ptemplate.validateDraftWiki(cv.wikiName+"_draft_");
		}catch(Exception e) {
			ext.logger.fail(methodName);
		}
	}
	
	
	void addMembers() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
			ptemplate.navigateToSubmenu("Members");
			ptemplate.clickOnInviteColleague();
			ptemplate.addMemberName(cv.otherUserName);
			ptemplate.selectAndAddUser();
			ptemplate.validateAddedUser(cv.otherUserName);
		}catch(Exception e) {
			ext.logger.fail(methodName);
		}
	}
	
	
	void uploadImageFiles() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
		ptemplate.navigateToSubmenu("Files");
		ptemplate.newButton();
		ptemplate.selectAddFile();
		ptemplate.uploadFile(cv.imageFileName, "image");
		ptemplate.doneFileUpload();
		ptemplate.validateFileUploaded(cv.imageFileName, "Image");
		}catch(Exception e) {
			ext.logger.fail(methodName);
		}
	}
	
	void validateImageFilePreview() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
		ptemplate.navigateToSubmenu("Files");
		ptemplate.validateImageFilePreview(cv.imageFileName, "image");
		ptemplate.closePreview();
		}catch(Exception e) {
			ext.logger.fail(methodName);
		}
	}
	
	void uploadXlsFiles() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
		ptemplate.navigateToSubmenu("Files");
		ptemplate.newButton();
		ptemplate.selectAddFile();
		ptemplate.uploadFile(cv.xlsFileName, "xlsx");
//		ptemplate.uploadXlsFile();
		ptemplate.doneFileUpload();
		ptemplate.validateFileUploaded(cv.xlsFileName, "xlsx");
		}catch(Exception e) {
			ext.logger.fail(methodName);
		}
	}
	
	
	void validateXlsFilePreview() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
		ptemplate.navigateToSubmenu("Files");
		ptemplate.validateXlsFilePreview(cv.xlsFileName, "xlsx");
		ptemplate.closePreview();
		}catch(Exception e) {
			ext.logger.fail(methodName);
		}
	}
	
	
	void uploadPptFiles() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
		ptemplate.navigateToSubmenu("Files");
		ptemplate.newButton();
		ptemplate.selectAddFile();
		ptemplate.uploadFile(cv.pptFileName, "ppt");
		ptemplate.doneFileUpload();
		ptemplate.validateFileUploaded(cv.pptFileName, "ppt");
		}catch(Exception e) {
			ext.logger.fail(methodName);
		}
	}
	
	
	void uploadZipFiles() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
		ptemplate.navigateToSubmenu("Files");
		ptemplate.newButton();
		ptemplate.selectAddFile();
		ptemplate.uploadFile(cv.zipFileName, "zip");
		ptemplate.doneFileUpload();
		ptemplate.validateFileUploaded(cv.zipFileName, "zip");
		}catch(Exception e) {
			ext.logger.fail(methodName);
		}
	}
	
	
	void addTask() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
			ptemplate.navigateToSubmenu("Tasks");
			ptemplate.clickTaskTool();
			ptemplate.addNewTask();
			ptemplate.addTaskDescription();
			ptemplate.taskSubmit();
			ptemplate.createdTaskVerification();
		}catch(Exception e) {
			ext.logger.fail(methodName);
		}
	}
	
	void addTimeSheet() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
			ptemplate.navigateToSubmenu("Timesheets");
			ptemplate.addNewTimeLog();
			ptemplate.addTimeToTimesheet();
			ptemplate.addTitleToTimesheet();
			ptemplate.addDescriptionToTimesheet();
			ptemplate.clickAddNew();	
			ptemplate.verifyTimeSheetCreated();
		}catch(Exception e) {
			ext.logger.fail(methodName);
		}
	}
	
	void addFeeds() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
			ptemplate.navigateToSubmenu("News Feed");
			ptemplate.clickOnMessageBox();
			ptemplate.addUpdate();
			ptemplate.clickShare();
			ptemplate.selectPrimaryTab();
			ptemplate.selectPrimaryTab();
			ptemplate.validateMessage();
			
		}catch(Exception e) {
			ext.logger.fail(methodName);
		}
	}
	
	void postComment() {
		ptemplate.navigateToSubmenu("News Feeds");
		ptemplate.selectPrimaryTab();
		ptemplate.addComment();
		ptemplate.validateComment();
	}
	
	
	
}
