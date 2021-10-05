package tests;

import org.testng.annotations.Test;

import pageEvents.LoginPage;


public class LoginTest{
	
	LoginPage login = new LoginPage();
	
	
	void loginTestCases(BaseTest baseTest) {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
//		ext.setTest(methodName, "Posts test cases");
//		baseTest.ext.setTest(methodName, "Posts test cases");
//		baseTest.login.login.loadLoginPage();
//		baseTest.login.login.emailId();
//		baseTest.login.login.password();
		baseTest.login.login.clickLogin();
		baseTest.login.login.verifyLogin();
		System.out.println("login test executed>>>>>>>>>>");
	}
	
}
