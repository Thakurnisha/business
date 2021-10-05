package tests;

import org.testng.annotations.Test;


import pageEvents.CreateProjectTemplate;
import pageEvents.LoginPage;
import pageEvents.PostActions;


public class PostsTest extends BaseTest{
	
	LoginPage login = new LoginPage();
	PostActions post =  new PostActions();
	CreateProjectTemplate ptemplate = new CreateProjectTemplate();
	
	
	@Test(priority = 3)
	void postTestCases() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		BaseTest.ext.setTest(methodName, "Posts test cases");
		
		System.out.println("postTestCases test executed>>>>>>>>>>");				
		login();
		addNewPostFromCompose();
		
	}
	
	
	void login() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
//		ext.setTest(methodName, "Posts test cases");
		
		System.out.println("Posts test executed>>>>>>>>>>"+cv.domainUrl);				
		login.loadLoginPage(cv.domainUrl);
		login.emailId(cv.userName);
		login.password(cv.userPassword);
		login.clickLogin();
		login.verifyLogin();
	}
	
	
	void addNewPostFromCompose() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
			post.clickOncompose();
			post.expandMenu();
			post.selectFromMenu("Post");
			post.addTeamName(cv.projectName);
			post.selectPhotoTemplate();
			post.continuePost();
			
			ptemplate.addPostTitle(cv.postName+"_from_compose_");
			post.scrollToBottom();
			post.hoverImage();
			post.selectImage();
			post.addAltText();
			post.closeMediaGallery();

			
			ptemplate.publishPost();
			ptemplate.confirmButton();		
			ptemplate.validatePostCreated(cv.postName+"_from_compose_");
			
			post.viewPost(cv.postName+"_from_compose_");
			post.validateAltTag();
			post.validateViewCount();
			;
		}catch(Exception e) {
			ext.logger.fail(methodName);
		}
	}
	
	
	
	

}
