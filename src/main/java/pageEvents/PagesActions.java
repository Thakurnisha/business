package pageEvents;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import reports.ExtentReport;
//import tests.BaseTest;
import utils.CommonVariables;
import utils.WebActions;

public class PagesActions {
	
	WebActions fetchElement = new WebActions();
//	BaseTest bs;
	String unq = Long.toString(CommonVariables.uniqueNumber());
	
	 public void navigateToCompanyPage(String url) {
		 ExtentReport.logger.info("Navigate to company pages");
		 fetchElement.navaigateToUrl(url + "/sites/posts");
		 sleepMethod(5000);
			
	 }
	 
	 public void navigateToPage(String url, int createdPageId) {
		 ExtentReport.logger.info("Navigate to company pages");
		 fetchElement.navaigateToUrl(url + "/sites/site_pages/"+createdPageId);	
			
	 }
	 
	 public void clickTools() {
		 ExtentReport.logger.info("Clicking page tool");
		 fetchElement.getElement("XPATH", pageObjects.PagesObjects.toolsPath).click();
	 }
	 
	 
	 public void selectToolOption(String action) {
		 	ExtentReport.logger.pass("Executing page '"+action+"' action ");
			try {
			WebElement pageActions = fetchElement.getElement("CLASS", pageObjects.PagesObjects.toolActions);
			List <WebElement> each = pageActions.findElements(By.tagName("li"));
			boolean breakAll = false;
			for(int i=0; i<each.size();i++) {
				 String title ="";
				 try {
					 title = each.get(i).findElement(By.xpath("./a")).getAttribute("innerHTML").trim();  
					 
				 }catch(Exception e) {
					 System.out.println(e);
				 }
				 if(title.equals(action)) {
					 each.get(i).findElement(By.xpath("./a")).click();
					 sleepMethod(5000);
					 break;
				 }

			 }
			}catch(Exception e) {
				ExtentReport.logger.fail("Failed to execute page '"+action+"' action ");
			}
	 }
	 
	 
	 public void addPageTitile(String pagetitle) {
		 ExtentReport.logger.info("Adding page title");
		 fetchElement.getElement("ID", pageObjects.PagesObjects.pageTitle).clear();
		 fetchElement.getElement("ID", pageObjects.PagesObjects.pageTitle).sendKeys(pagetitle+unq);
	 }
	 
	 public void openIconPopup() {
		 ExtentReport.logger.info("Opening icon poupup");
		 try {
		 fetchElement.getElement("XPATH", pageObjects.PagesObjects.iconPopupPath).click();
		 sleepMethod(5000);
		 }catch(Exception e) {
			 System.out.println(e);
		 }
	 }
	 
	 public void selectIcon() {
		 ExtentReport.logger.info("Selecting icon");
		 fetchElement.getElement("XPATH", pageObjects.PagesObjects.iconlist).click();
	 }
	 
	 
	 public void closeIconPoup() {
		 ExtentReport.logger.info("Closing popup");
		 fetchElement.getElement("XPATH", pageObjects.PagesObjects.closeIconPopup).click();
		 
	 }
	 
	 public void selectStaticTemplate(int templatePostion) {
		 ExtentReport.logger.info("Selecting template");
		 try {
			 WebElement element = fetchElement.getElement("XPATH", pageObjects.PagesObjects.secondStaticTemplatePath+ templatePostion +"]");
			 fetchElement.scrollToWebElement(element);
			 sleepMethod(3000);
			 fetchElement.getElement("XPATH", pageObjects.PagesObjects.secondStaticTemplatePath+ templatePostion +"]/div/span").click();
		 }catch(Exception e) {
			 System.out.println(e);
	 	}
	 }
	 
	 
	 public void selectDynamicTemplate(int templatePostion) {
		 ExtentReport.logger.info("Selecting template");
		 try {
			 WebElement element = fetchElement.getElement("XPATH", pageObjects.PagesObjects.secondDynamicTemplatePath+ templatePostion +"]");
			 fetchElement.scrollToWebElement(element);
			 sleepMethod(3000);
			 fetchElement.getElement("XPATH", pageObjects.PagesObjects.secondDynamicTemplatePath+ templatePostion +"]/div/span").click();
		 }catch(Exception e) {
			 System.out.println(e);
	 	}
	 }
	 
	 
	 public void doneButtonPath() {
		 ExtentReport.logger.info("Clicking done button");
		 fetchElement.getElement("XPATH", pageObjects.PagesObjects.doneButtonPath).click();
		 sleepMethod(5000);
	 }
	 
	 
	 public void saveAndPublish() {
		 ExtentReport.logger.info("Clicking save and publish button");
		 fetchElement.getElement("XPATH", pageObjects.PagesObjects.saveAndPublish).click();
		 sleepMethod(5000);
	 }
	 
	 
	 public void confirmPublish() {
		 fetchElement.getElement("ID", pageObjects.PagesObjects.confirmPublish).click();
		 sleepMethod(5000);
	 }
	 
	 
	 public int getPageId() {
		 String url ="";
		 String Id ="";
		 try {
			  url = fetchElement.getUrl();
			  Id = url.split("\\?")[0].replace("https://toke.mangopulse.com/sites/site_pages/", " ").trim();
			  Id = Id.split("site_pages/")[1].trim();
		 }catch(Exception e) {
			 System.out.println(e);
		 	}
		 return Integer.parseInt(Id);
		}
	 
	 
	 public void validatePagePosted(String pageName) {
		 ExtentReport.logger.info("Validating page created");
		 WebElement pages =  fetchElement.getElement("ID", pageObjects.PagesObjects.pageTabBar);
		 List <WebElement> each = pages.findElements(By.tagName("li"));
			boolean isPagePresent = false;
		try {
			for(int i=0; i<each.size();i++) {
				 String title ="";
				 try {
					 title = each.get(i).findElement(By.xpath("./a/span")).getAttribute("innerHTML").trim();  
					 
				 }catch(Exception e) {
					 System.out.println(e);
				 }
				 if(title.equals(pageName+unq)) {
					 isPagePresent = true;
					 break;
				 }
			 }
		}catch(Exception e) {
			System.out.println(e);
		}	
		
			if(isPagePresent == true) {
				ExtentReport.logger.pass("Page created successfully");
			}else {
				ExtentReport.logger.info("Fail to create page");
			}
	 }
	 
	 public void addDeleteText() {
		 ExtentReport.logger.info("Entering delete keyword");
		 fetchElement.getElement("ID", pageObjects.PagesObjects.sendDeleteText).sendKeys("DELETE");
	 }
	 
	 public void deletePage() {
		 ExtentReport.logger.info("Clicking delete button");
		 fetchElement.getElement("ID", pageObjects.PagesObjects.deletePageButton).click();
		 sleepMethod(10000);
	 }
	 
	 
	 public void validatePageDeleted(String pageName) {
		 ExtentReport.logger.info("Validating page deleted");
		 WebElement pages =  fetchElement.getElement("ID", pageObjects.PagesObjects.pageTabBar);
		 List <WebElement> each = pages.findElements(By.tagName("li"));
			boolean isPagePresent = false;
			
			for(int i=0; i<each.size();i++) {
				 String title ="";
				 try {
					 title = each.get(i).findElement(By.xpath("./a/span")).getAttribute("innerHTML").trim();  
					 
				 }catch(Exception e) {
					 System.out.println(e);
				 }
				 if(title.equals(pageName+unq)) {
					 isPagePresent = true;
					 break;
				 }
			 }
			
			if(isPagePresent == false) {
				ExtentReport.logger.pass("Page deleted successfully");
			}else {
				ExtentReport.logger.info("Fail to delete page");
			}
	 }
	 
	 
	 public void selectDynamicPage() {
		 fetchElement.getElement("ID", pageObjects.PagesObjects.dynamicPageTab).click();
		 sleepMethod(3000);
	 }
	 
	 public void findPage(String pageName) {
		 ExtentReport.logger.info("Finding pages created from automation");
		 WebElement pages =  fetchElement.getElement("ID", pageObjects.PagesObjects.pageTabBar);
		 List <WebElement> each = pages.findElements(By.tagName("li"));
			boolean isPagePresent = false;
		try {
			for(int i=0; i<each.size();i++) {
				 String title ="";
				 try {
					 title = each.get(i).findElement(By.xpath("./a/span")).getAttribute("innerHTML").trim();   
				 }catch(Exception e) {
					 System.out.println(e);
				 }
				 if(title.contains(pageName)) {
					 isPagePresent = true;
					 each.get(i).findElement(By.xpath("./a")).click();
					 sleepMethod(5000);
					 ExtentReport.logger.info("Page is present");
					 break;
				 }
			 }
		}catch(Exception e) {
			System.out.println(e);
		}	
		
		
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
