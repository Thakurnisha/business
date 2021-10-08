package tests;

import org.testng.annotations.Test;



import pageEvents.LoginPage;
import pageEvents.PostActions;
import pageEvents.SurveyActions;
import pageEvents.TrackerActions;


public class SurveyTest extends BaseTest{
	
	LoginPage login = new LoginPage();
	PostActions post =  new PostActions();
	SurveyActions survey = new SurveyActions();
	
	
	@Test(priority = 7)
	void surveyTestCases() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		BaseTest.ext.setTest(methodName, "Survey test cases");
		
		System.out.println("trackerTestCases test executed>>>>>>>>>>");				
		login();
		createSurvey();
		
	}
	
	
	void login() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
//		ext.setTest(methodName, "Posts test cases");
		
		System.out.println("Tracker test executed>>>>>>>>>>"+cv.domainUrl);				
		login.loadLoginPage(cv.domainUrl);
		login.emailId(cv.userName);
		login.password(cv.userPassword);
		login.clickLogin();
		login.verifyLogin();
	}
	
	
	void createSurvey() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
			survey.clickOncompose();
			survey.expandMenu();
			survey.selectFromMenu("Survey");
			survey.selectBlankTemplate();
			survey.clickContinue();
			survey.surveyTitle(cv.surveyName);
			survey.addDataToCkEditor("Description of the survey");
			survey.clickOnContinueDescription();
			survey.questionsList();
			
			survey.selectQuestion("Multiple Choice");
			survey.addDataToCkEditor("Automated Multichoice question");
			survey.clickBackButton();
			
			
			
		}catch(Exception e) {
			ext.logger.fail(methodName);
		}
	}
	
	
	}
	
	
	

