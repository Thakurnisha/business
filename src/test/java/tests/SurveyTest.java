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
	
	
	@Test(priority = 9)
	void surveyTestCases() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		BaseTest.ext.setTest(methodName, "Survey test cases");
		
		System.out.println("trackerTestCases test executed>>>>>>>>>>");				
		login();
		createSurvey();
		completeSurvey();
		
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
			
			
			survey.selectQuestion("Multiple Choice");
			survey.addDataToCkEditor("Multiple Choice_");
			survey.clickBackButton();
			
//			survey.selectQuestion("Star Rating");
//			survey.addDataToCkEditor("Star Rating_");
//			survey.clickBackButton();
//			
//			survey.selectQuestion("Opinion Scale");
//			survey.addDataToCkEditor("Opinion Scale_");
//			survey.addLeftLabel();
//			survey.addRightLabel();
//			survey.clickBackButton();
//			
//			
//			survey.selectQuestion("Text");
//			survey.addDataToCkEditor("Text_");
//			survey.addLeftLabel();
//			survey.addRightLabel();
//			survey.clickBackButton();
//			
//			survey.selectQuestion("Teams List");
//			survey.addDataToCkEditor("Teams List_");
//			survey.addLeftLabel();
//			survey.addRightLabel();
//			survey.clickBackButton();
//			
//			
//			survey.selectQuestion("Users List");
//			survey.addDataToCkEditor("Users List_");
//			survey.addLeftLabel();
//			survey.addRightLabel();
//			survey.clickBackButton();
//			
//			
//			survey.selectQuestion("Date");
//			survey.addDataToCkEditor("Date_");
//			survey.addLeftLabel();
//			survey.addRightLabel();
//			survey.clickBackButton();
			
			
			
			survey.nextStep();
			survey.nextStep();
			survey.nextStep();
			survey.selectAllAudience();
			survey.publish();
			
			survey.navigateToSurvey(cv.domainUrl);
			survey.validateSurveyPublished(cv.surveyName);
			
		}catch(Exception e) {
			ext.logger.fail(methodName);
		}
	}
	
	
	void completeSurvey() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
			survey.navigateToSurvey(cv.domainUrl);
			survey.selectSurvey(cv.surveyName);
			survey.startSurvey();
			survey.selectOption();
			survey.finsihSurvey();
			survey.closeButton();
		}catch(Exception e) {
			ext.logger.fail(methodName);
		}
	}
	
	}
	
	
	

