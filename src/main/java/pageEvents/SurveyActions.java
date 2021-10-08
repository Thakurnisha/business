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
		 fetchElement.getElement("XPATH", pageObjects.SurveyObjects.blankTemplate).click();
		 sleepMethod(2000);
	 }
	 
	 
	 public void clickContinue() {
		 ExtentReport.logger.info("Clicking continue");
		 fetchElement.getElement("XPATH", pageObjects.SurveyObjects.clickContinueTemplatePage).click();
		 sleepMethod(5000);
	 }
	 
	 
	 public void surveyTitle(String name) {
		 ExtentReport.logger.info("Add quiz title");
		 fetchElement.getElement("XPATH", pageObjects.SurveyObjects.quizTitle).sendKeys(name+unq);
	 }
	 
	 
	 public void addDataToCkEditor(String data) {
		 WebElement ckEditor = fetchElement.getElement("XPATH", pageObjects.SurveyObjects.descriptionBox);
		 fetchElement.addDataToCKEditor(ckEditor, data);
	 }
	 
	 public void clickOnContinueDescription() {
		 fetchElement.getElement("XPATH", pageObjects.SurveyObjects.clickContinueDescriptionStep).click();
		 sleepMethod(5000);
	 }
	 
	 
	 public void questionsList() {
		 fetchElement.getElement("XPATH", pageObjects.SurveyObjects.clickContinueDescriptionStep).click();
		 sleepMethod(5000);
	 }
	 
	 public void selectQuestion(String questionType) {
		 List <WebElement> eachItem = fetchElement.getListElements("CLASS", pageObjects.SurveyObjects.questionsList);
			for(int i=0; i<eachItem.size();i++) {
				try {
					String name = eachItem.get(i).findElement(By.xpath("./span")).getAttribute("innerHTML").split("</i>")[1];
					
					if(name.equals(questionType)) {
						eachItem.get(i).click();
						sleepMethod(5000);
					}
				}catch(Exception e) {
					System.out.println(e);
				}
			}
	 }
	 
	 
	 public void clickBackButton() {
		 fetchElement.getElement("XPATH", pageObjects.SurveyObjects.questionBackButton).click();
		 sleepMethod(2000);
	 }
	 
	 
	 public void selectAllAudience() {
		 fetchElement.getElement("XPATH", pageObjects.SurveyObjects.selectAudience).click();
		 sleepMethod(10000);
	 }
	 
	 
	
	
	public void sleepMethod(int time)  {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
