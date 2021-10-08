package pageEvents;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import pageObjects.CleanUp;
import reports.ExtentReport;
import utils.CommonVariables;
import utils.WebActions;

public class CleanUpActions {
	
	WebActions fetchElement = new WebActions();
	String unq = Long.toString(CommonVariables.uniqueNumber());
	
	 public void navigateToAdminProject(String url) {
		 fetchElement.navaigateToUrl(url+"/admin/allprojects");
	 }
	 
	 
	 public void selectDeleteAction(String projectName) {
		 ExtentReport.logger.info("Clicking to get drop down action");
		 try {
		 List <WebElement> eachItem = fetchElement.getListElements("XPATH", pageObjects.CleanUp.projectsList);
			for(int i=0; i<eachItem.size();i++) {
				eachItem = fetchElement.getListElements("XPATH", pageObjects.CleanUp.projectsList);
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>"+i);
				String name = "";
				try {
					name = eachItem.get(i).findElement(By.xpath("./td[1]/div/div[2]/p/a")).getAttribute("innerHTML").split("<!--")[0].trim();
					
				}catch(Exception e) {
					System.out.println(e);
				}
				
				if(name.contains(projectName)) {
					eachItem.get(i).findElement(By.xpath("./td[3]/div[2]/ul")).click();
					sleepMethod(3000);
					DeleteAction( eachItem.get(i).findElement(By.xpath("./td[3]/div[2]/ul/li[2]/ul")) );
					
				}
			}
	 }catch(Exception e) {
		 System.out.println(e);
	 	}
	 }
	 
	 
	 public void DeleteAction(WebElement actions) {
		 ExtentReport.logger.info("Selecting delete actions");
		 try {
		 WebElement listItems = actions;
		 List <WebElement> eachItem = listItems.findElements(By.tagName("li"));
			for(int i=0; i<eachItem.size();i++) {
				String name = "";
				try {
					name = eachItem.get(i).findElement(By.xpath("./a")).getAttribute("innerHTML").trim();
				
				}catch(Exception e) {
					System.out.println(e);
				}
				
				if(name.equals("Delete Project")) {
					eachItem.get(i).click();
					sleepMethod(5000);
					addDeleteText();
					clickOnDelete();
					break;
				}
			}
	 }catch(Exception e) {
		 ExtentReport.logger.fail("Fail to delete project");
	 	}
	 }
	 
	 
	 
	 public void addDeleteText() {
		 ExtentReport.logger.info("Adding delete text");
		 fetchElement.getElement("XPATH", pageObjects.CleanUp.deleteConfirm).sendKeys("DELETE");
	 }
	 
	 
	 public void clickOnDelete() {
		 ExtentReport.logger.info("Clicking on delete action");
		 fetchElement.getElement("ID", pageObjects.CleanUp.deleteButton).click();
		 sleepMethod(10000);
		 ExtentReport.logger.pass("Deleted the project");
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
