package tests;

import org.testng.annotations.Test;

import pageEvents.CreateProjectTemplate;
import pageEvents.FileActions;
import pageEvents.LoginPage;

public class FilesTest extends BaseTest {
	LoginPage login = new LoginPage();
	FileActions file = new FileActions();
	CreateProjectTemplate ptemplate = new CreateProjectTemplate();
	
	String folderPublicLink ="";
	String folderName ="Automated_folder";
	
	
	@Test(priority = 5)
	void filesTestCases() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		ext.setTest(methodName, "Files test cases");
		
		System.out.println("filesTestCases test executed>>>>>>>>>>");				
		login();
		createNewFolder();
		shareFolderWithFilesAndViewWithLink();
		uploadNewVersionOfFile();
		deleteFolderAndItsContents();
		
	}
	
	void login() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {		
		System.out.println("Posts test executed>>>>>>>>>>");				
		login.loadLoginPage(cv.domainUrl);
		login.emailId(cv.userName);
		login.password(cv.userPassword);
		login.clickLogin();
		login.verifyLogin();
		}catch(Exception e) {
			ext.logger.fail(methodName);
		}
	}
	
	
	void createNewFolder() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
		// Create a folder in project created
		file.navigateToFilespage(cv.domainUrl);
		file.expandProjectNode();
		file.selectProjectNode(cv.projectName);
		file.selectAndAddFolder("Create New Sub-Folder", folderName, cv.projectName);
		file.validateFolderCreated(folderName, cv.projectName);
		}catch(Exception e) {
			ext.logger.fail(methodName);
		}
	}
	
	
	void shareFolderWithFilesAndViewWithLink() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
//			share folder with file 
			file.rightClickProjectSubfolder(folderName, cv.projectName);
			file.selectFolderAction("Share Folder", folderName, cv.projectName);
			file.shareFolderOptions();
			file.makePublic();
			folderPublicLink = file.getPublicLink();
			file.closePermissionPopup();
			file.rightClickProjectSubfolder(folderName, cv.projectName);
			file.selectFolderAction("Upload New Files", folderName, cv.projectName);
			
			ptemplate.uploadFile(cv.imageFileName, "image");
			ptemplate.doneFileUpload();
			ptemplate.validateFileUploaded(cv.imageFileName, "image");
		
			//validate  public folder
			file.navigateToUrl(folderPublicLink);
			file.validatePublicFolderFiles(cv.imageFileName);
			
			
		}catch(Exception e) {
			ext.logger.fail(methodName);
		}
	}
	
	void uploadNewVersionOfFile() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
			//upload new version of file
			file.navigateToFilespage(cv.domainUrl);
			file.expandProjectNode();
			file.selectProjectNode(cv.projectName);
			file.hoverAndClickToGetFileAction(cv.imageFileName);
			file.fileActionList("Upload new version");
			ptemplate.uploadFile(cv.imageFileName, "image");
			file.doNotNotify();
			
			//verify uploaded new version
			file.navigateToFilespage(cv.domainUrl);
			file.expandProjectNode();
			file.selectProjectNode(cv.projectName);
			file.hoverAndClickToGetFileAction(cv.imageFileName);
			file.validateNewVersionUploaded("Archive latest version");
			
			
		}catch(Exception e) {
			ext.logger.fail(methodName);
		}
	}

	
	void deleteFolderAndItsContents() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
			//Delete folder and its content
			file.navigateToFilespage(cv.domainUrl);
			file.expandProjectNode();
			file.selectProjectNode(cv.projectName);
			file.expandProjectNode();
			file.rightClickProjectSubfolder(folderName, cv.projectName);
			file.selectFolderAction("Delete", folderName, cv.projectName);
			file.addDeleteText();
			file.deleteFolderAndContent();
			
			
			//validate delete
			file.navigateToFilespage(cv.domainUrl);
			file.expandProjectNode();
			file.selectProjectNode(cv.projectName);
			file.validateFolderDelete(folderName, cv.projectName);			
			
		}catch(Exception e) {
			ext.logger.fail(methodName);
		}
	}
}
