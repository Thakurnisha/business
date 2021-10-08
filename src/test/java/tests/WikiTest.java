package tests;

import org.testng.annotations.Test;



import pageEvents.CreateProjectTemplate;
import pageEvents.LoginPage;
import pageEvents.PostActions;
import pageEvents.WikiActions;


public class WikiTest extends BaseTest{
	
	LoginPage login = new LoginPage();
	PostActions post =  new PostActions();
	WikiActions wiki =  new WikiActions();
	CreateProjectTemplate ptemplate = new CreateProjectTemplate();
	
	
	@Test(priority = 4)
	void wikiTestCases() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		BaseTest.ext.setTest(methodName, "Wiki test cases");
		login();
		addNewWikiFromComposeWithTableOfContent();
		
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
	
	
	void addNewWikiFromComposeWithTableOfContent() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
//			post.clickOncompose();
//			post.expandMenu();
//			post.selectFromMenu("Wikis");
//			wiki.addTeamName("abc(project)");
//			
//			ptemplate.addWikiTitle(cv.wikiName+"_from_compose_");
//			wiki.selectWikiTemplate(2);
//			ptemplate.createWikiButton();
//			
//			wiki.selectFilter();
//			ptemplate.validateDraftWiki(cv.wikiName+"_from_compose_");
//			wiki.selectDraftWiki(cv.wikiName+"_from_compose_");
//						
//			ptemplate.addDataToWiki();			
//			ptemplate.publishWiki();
			wiki.exitFullScreen();
			
			wiki.checkTableOfContent();
			
			ptemplate.validateWiki(cv.wikiName+"_from_compose_");
			wiki.checkViewCount();
			
		}catch(Exception e) {
			ext.logger.fail(methodName);
		}
	}
	
}
