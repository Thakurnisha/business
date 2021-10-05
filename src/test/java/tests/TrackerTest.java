package tests;

import org.testng.annotations.Test;



import pageEvents.LoginPage;
import pageEvents.PostActions;
import pageEvents.TrackerActions;


public class TrackerTest extends BaseTest{
	
	LoginPage login = new LoginPage();
	PostActions post =  new PostActions();
	TrackerActions tracker = new TrackerActions();
	
	
	@Test(priority = 7)
	void trackerTestCases() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		BaseTest.ext.setTest(methodName, "Tracker test cases");
		
		System.out.println("trackerTestCases test executed>>>>>>>>>>");				
		login();
		addewTracker();
		importTracker();
		
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
	
	
	void addewTracker() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
		
			post.clickOncompose();
			post.expandMenu();
			post.selectFromMenu("Trackers");
			
			tracker.clickOnContinue();
			tracker.addTrackerName(cv.trackerName);
			tracker.addTeamName(cv.projectName);
			tracker.addDescription();
			tracker.clickCreateTracker();
			tracker.clickOnTool();
			tracker.addNewColumn();
			
			tracker.addColumnName();
			tracker.selectCoulmnDropDown();
			tracker.selectColumnType("Text");
			tracker.createButton();
			
			
			//add record 
			tracker.addNewEntryButton();
			tracker.addTextField();
			tracker.saveRecord();
			tracker.validateRecordAdded();
			
			
			//view active and in-active trackers
			tracker.navigateToTracker(cv.domainUrl);
			tracker.selectFilter();
			tracker.selectFiltrOption("All Active Trackers");
			tracker.validateActiveTracker(cv.trackerName, "Active");
			tracker.openTracker(cv.trackerName);
			tracker.clickTopButton("Tracker Tools");
			tracker.clickArchieveAction();
			tracker.archieveButton();
			tracker.selectFilter();
			tracker.selectFiltrOption("Archived Trackers");
			tracker.validateActiveTracker(cv.trackerName, "Archieved");
			
			
			//delete tracker
			tracker.openTracker(cv.trackerName);
			tracker.clickTopButton("Tracker Tools");
			tracker.clickDeleteAction();
			tracker.confirmDelete();
			tracker.validateDelete(cv.trackerName);
			
			
			//select active tracker filter
			tracker.selectFilter();
			tracker.selectFiltrOption("All Active Trackers");
			
			
		}catch(Exception e) {
			ext.logger.fail(methodName);
		}
	}
	
	
	void importTracker() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
			tracker.navigateToTracker(cv.domainUrl);
			
			tracker.selectFilter();
			tracker.selectFiltrOption("All Active Trackers");
			
			tracker.clickSplitButton();
			tracker.clickImportAction();
			tracker.importFileButton(System.getProperty("user.dir")+"\\assets\\" +cv.csvFileTrackerImport);
			tracker.addTrackerName(cv.trackerName+"csv_");
			tracker.addTeamName(cv.projectName);
			tracker.addDescription();
			tracker.clickCreate();
			tracker.refresh();
			
			//validate tracker
			tracker.navigateToTracker(cv.domainUrl);
			tracker.openTracker(cv.trackerName+"csv_");
			tracker.validateTrackerHeadings();
			
			//delete tracker
			tracker.clickTopButton("Tracker Tools");
			tracker.clickDeleteAction();
			tracker.confirmDelete();
			tracker.validateDelete(cv.trackerName+"csv_");
			
			
		}catch(Exception e) {
			ext.logger.fail(methodName);
		}
	}
	
	
	
	

}
