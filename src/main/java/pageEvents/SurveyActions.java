package pageEvents;


import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import reports.ExtentReport;
import utils.CommonVariables;
import utils.WebActions;

public class SurveyActions {
	WebActions fetchElement = new WebActions();

	String unq = Long.toString(CommonVariables.uniqueNumber());


	 public void clickOncompose() {
		 ExtentReport.logger.info("Clicking on compose button");
		 fetchElement.getElement("XPATH", pageObjects.SurveyObjects.composePath).click();
		 sleepMethod(2000);
		 
	 } 
	 
	 
	 public void expandMenu() {
		 ExtentReport.logger.info("Expanding menu");
		 fetchElement.getElement("ID", pageObjects.SurveyObjects.expandMenu).click();
		 sleepMethod(2000);
	 }
	 
	 public void selectFromMenu(String option) {
		 ExtentReport.logger.info("Selecting "+ option +" menu ");
		 WebElement menu = fetchElement.getElement("ID", pageObjects.SurveyObjects.menuItems);
			List <WebElement> eachItem = menu.findElements(By.tagName("li"));
			for(int i=0; i<eachItem.size();i++) {
				try {
					String name = eachItem.get(i).findElement(By.xpath("./a")).getAttribute("innerHTML").split("</i>")[1];
					
					if(name.equals(option)) {
						eachItem.get(i).findElement(By.xpath("./a")).click();
						sleepMethod(5000);
					}
				}catch(Exception e) {
					System.out.println(e);
				}
			}
	 } 
	 
	 
	 
	 
	 
	 public void selectBlankTemplate() {
		 ExtentReport.logger.info("Selecting blank template");
		 List <WebElement> eachItem = fetchElement.getListElements("XPATH", pageObjects.SurveyObjects.templateDraftAndBlank);
			for(int i=0; i<eachItem.size();i++) {
				String name="";
				try {
					try {
					name = eachItem.get(i).findElement(By.xpath("./div[1]/div[2]/span")).getAttribute("innerHTML");
					}catch(Exception e){
						
					}
					if(name.equals("Blank Template")) {
						eachItem.get(i).click();
						sleepMethod(5000);
						break;
					}
				}catch(Exception e) {
					System.out.println(e);
				}
			}

	 }
	 
	 
	 public void clickContinue() {
		 ExtentReport.logger.info("Clicking continue");
		 fetchElement.getElement("XPATH", pageObjects.SurveyObjects.clickContinueTemplatePage).click();
		 sleepMethod(5000);
	 }
	 
	 
	 public void surveyTitle(String name) {
		 ExtentReport.logger.info("Add quiz title");
		 fetchElement.getElement("XPATH", pageObjects.SurveyObjects.quizTitle).clear();
		 fetchElement.getElement("XPATH", pageObjects.SurveyObjects.quizTitle).sendKeys(name+unq);
	 }
	 
	 
	 public void addDataToCkEditor(String data) {
//		 sleepMethod(1000);
		 ExtentReport.logger.info("Add data to tracker");
		 WebElement ckEditor = fetchElement.getElement("XPATH", pageObjects.SurveyObjects.descriptionBox);
		 fetchElement.addDataToCKEditor(ckEditor, data+unq);
	 }
	 
	 public void clickOnContinueDescription() {
		 ExtentReport.logger.info("Clicking on continue");
		 fetchElement.getElement("XPATH", pageObjects.SurveyObjects.clickContinueDescriptionStep).click();
		 sleepMethod(5000);
	 }
	 
	 
	 public void nextStep() {
		 ExtentReport.logger.info("Clicking on continue");
		 fetchElement.getElement("XPATH", pageObjects.SurveyObjects.clickContinueDescriptionStep).click();
		 sleepMethod(5000);
	 }
	 
	 public void selectQuestion(String questionType) {
//		 sleepMethod(1000);
		 ExtentReport.logger.info("Adding question +"+questionType);
		 List <WebElement> eachItem = fetchElement.getListElements("XPATH", pageObjects.SurveyObjects.questionsList);
			for(int i=0; i<eachItem.size();i++) {
				try {
					String name = eachItem.get(i).findElement(By.xpath("./span")).getAttribute("innerHTML");
					
					if(name.equals(questionType)) {
						eachItem.get(i).click();
						sleepMethod(5000);
						break;
					}
				}catch(Exception e) {
					System.out.println(e);
				}
			}
	 }
	 
	 
	 public void clickBackButton() {
		 ExtentReport.logger.info("Clicking on question back");
		 fetchElement.getElement("XPATH", pageObjects.SurveyObjects.questionBackButton).click();
		 sleepMethod(2000);
	 }
	 
	 
	 public void selectAllAudience() {
		 ExtentReport.logger.info("Selecting audience");
		 fetchElement.getElement("XPATH", pageObjects.SurveyObjects.selectAudience).click();
	 }
	 
	 
	 
	 public void addLeftLabel() {
		 ExtentReport.logger.info("Add left label");
		 fetchElement.getElement("XPATH", pageObjects.SurveyObjects.leftValue).sendKeys("Poor");
	 }
	 
	 
	 public void addRightLabel() {
		 ExtentReport.logger.info("Add right label");
		 fetchElement.getElement("XPATH", pageObjects.SurveyObjects.rightValue).sendKeys("Excellent");
	 }
	 
	 
	 public void publish() {
		 ExtentReport.logger.info("Publishing survey");
		 try {
			 fetchElement.getElement("XPATH", pageObjects.SurveyObjects.publishNow).click();
			 sleepMethod(5000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	 }
	 
	 
	 public void validateSurveyPublished(String surveyName) {
		 ExtentReport.logger.info("Validating survey created");
		 boolean isSurveyCreated = false;
		 List<WebElement> surveys = fetchElement.getListElements("TAG", "tr");
		 for(int i=0;i<surveys.size();i++) {
			 String name = surveys.get(i).findElement(By.xpath("//span[@class='block right-10 bold ma-h4']")).getAttribute("innerHTML");
			 
			 if(name.contains(surveyName)) {
				isSurveyCreated = true;
				 break;
			 }
		 }
		 
		 if(isSurveyCreated == true) {
			 ExtentReport.logger.pass("Survey created successfully"); 	
		 }else {
			 ExtentReport.logger.fail("Failed to create survey");
		 }
		
	 }
	 
	 
	 
	 public void navigateToSurvey(String url) {
		 ExtentReport.logger.info("Navigating to survey page");
		 fetchElement.navaigateToUrl(url+"/user/surveys");
	 }
	 
	 
	 public void selectSurvey(String surveyName) {
		 ExtentReport.logger.info("Selecting created survey");
		 List<WebElement> surveys = fetchElement.getListElements("TAG", "tr");
		 for(int i=0;i<surveys.size();i++) {
			 String name = surveys.get(i).findElement(By.xpath("//span[@class='block right-10 bold ma-h4']")).getAttribute("innerHTML");
			 
			 if(name.contains(surveyName)) {
				 fetchElement.hoverElement(surveys.get(i));
				 surveys.get(i).findElement(By.xpath("//a[text()='Take the Survey']")).click();
				 sleepMethod(5000);
				 break;
			 }
		 }
	 }
	 
	 
	 public void startSurvey() {
		 ExtentReport.logger.info("Starting survey");
		 fetchElement.getElement("XPATH", pageObjects.SurveyObjects.startAndFinishButton).click();
		 sleepMethod(5000);
	 }
	 
	 
	 public void selectOption() {
		 ExtentReport.logger.info("Selecting option");
		 try {
		 List<WebElement> surveys =  fetchElement.getListElements("XPATH", pageObjects.SurveyObjects.selectOption);
			 for(int i=0;i<surveys.size();i++) {
					 surveys.get(i).click();
					 sleepMethod(1000);
					 break;
				 
			 }
		 }catch(Exception e) {
			 System.out.println(e);
		 }
	 }
	 
	 
	 public void finsihSurvey() {
		 ExtentReport.logger.info("Clicking on finish");
		 fetchElement.getElement("XPATH", pageObjects.SurveyObjects.startAndFinishButton).click();
		 sleepMethod(5000);
	 }
	 
	 
	 public void closeButton() {
		 try {
		 ExtentReport.logger.info("Clicking on close");
		 fetchElement.getElement("XPATH", pageObjects.SurveyObjects.closeButton).click();
		 sleepMethod(5000);
		 
			 ExtentReport.logger.pass("Survey completed successfully"); 
		
	 }catch(Exception e) {
		 ExtentReport.logger.fail("Fail to complete survey");
		 }
	 }
	 
//	 public void validateSurveyCompleted(String surveyName) {
//		 try {
//		 ExtentReport.logger.info("Validating survey completed");
//		 boolean isSurveyCompleted = false;
//		 List<WebElement> surveys = fetchElement.getListElements("TAG", "tr");
//		 for(int i=0;i<surveys.size();i++) {
//			 String name ="";
//			 try {
//			  name = surveys.get(i).findElement(By.xpath("//span[@class='block right-10 bold ma-h4']")).getAttribute("innerHTML");
//			 }catch(Exception e){
//				 
//			 }
//			 if(name.contains(surveyName)) {
//				 fetchElement.hoverElement(surveys.get(i));
//				 sleepMethod(1000);
//				 try {
//					boolean a = surveys.get(i).findElement(By.xpath("//a[text()='Take the Survey']")).isDisplayed();
//					break;
//				 }catch(Exception e) {
//					 isSurveyCompleted = true;
//					 break;
//				 }
//				 
//			 }			 
//		 }
//		 
//		 if(isSurveyCompleted == true) {
//			 ExtentReport.logger.pass("Survey completed successfully"); 
//		 }else {
//			 ExtentReport.logger.fail("Fail to complete survey");
//		 }
//		 
//		 }catch(Exception e) {
//			 System.out.println(e);
//		 }
//	 }
	 
	 
	
	
	public void sleepMethod(int time)  {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
