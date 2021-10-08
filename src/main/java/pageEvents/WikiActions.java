package pageEvents;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import reports.ExtentReport;
import utils.CommonVariables;
import utils.WebActions;

public class WikiActions {
	
	WebActions fetchElement = new WebActions();

	String unq = Long.toString(CommonVariables.uniqueNumber());
	
	public void addTeamName(String projectName) {
		 ExtentReport.logger.pass("Selecting team name");
		 fetchElement.getElement("ID", pageObjects.WikiObjects.teamSelection).sendKeys(projectName);
		 sleepMethod(3000);
		 fetchElement.getElement("ID", pageObjects.WikiObjects.teamSelection).sendKeys(Keys.TAB );
	 }
	
	
	public void selectFilter(){
		try {
	        fetchElement.getElement("XPATH", pageObjects.WikiObjects.filterButtonPath).click();
	        sleepMethod(1000);
			 WebElement list = fetchElement.getElement("XPATH", pageObjects.WikiObjects.filterOptions);
			 List <WebElement> each = list.findElements(By.tagName("li"));
			 for(int i=0; i<each.size();i++) {
				 String name = each.get(i).findElement(By.xpath("./a")).getAttribute("innerHTML").trim();
				 if(name.equals("Recent")) {
					 	each.get(i).findElement(By.xpath("./a")).click();
					 	//a[text()="New Wiki"]
				 		break;
				 	}
			 }	
		 }catch(Exception e) {
			System.out.println(e);
		 }
	}
	
	public void selectWikiTemplate(int index) {
		ExtentReport.logger.info("Select wiki template with table of content");
		fetchElement.getElement("XPATH", pageObjects.WikiObjects.wikiTemplate+"["+index+"]").click();
	}
	
	
	public void selectDraftWiki(String checkName) {
		ExtentReport.logger.info("Select wiki created");
		 try {
		 fetchElement.hoverOverElement("ID","wiki_wrapper");
		 WebElement list = fetchElement.getElement("XPATH", pageObjects.ProjectTemplateObjects.draftWikiListPath);
		 List <WebElement> each = list.findElements(By.tagName("li"));
		 for(int i=0; i<each.size();i++) {
			 String name = each.get(i).findElement(By.xpath("./a")).getAttribute("innerHTML").trim();
			 int index = name.indexOf(checkName);
			 if(index != -1) {
				 	each.get(i).findElement(By.xpath("./a")).click();
				 	 
				 	sleepMethod(5000);
			 		break;
			 	}
		 }
		 
		 }catch(Exception e) {
			 System.out.println(e);
		 }
	}
	
	
	public void exitFullScreen() {
		ExtentReport.logger.info("Exit full screen");
		fetchElement.getElement("XPATH", pageObjects.WikiObjects.exitFullScreen).click();
		
	}
	
	
	public void checkTableOfContent() {
		ExtentReport.logger.info("Checking Table of content");
		try {
			sleepMethod(3000);
			fetchElement.getElement("XPATH", pageObjects.WikiObjects.tableOfContentFirstLink).click();
			sleepMethod(3000);
			try {
				double scrollPosition = fetchElement.getScrollPosition(pageObjects.WikiObjects.wikiContent);
				if(scrollPosition>0) {
					 ExtentReport.logger.pass("Table of content link working fine");
				}else {
					 ExtentReport.logger.fail("Table of content link not working");
				}
			}catch(Exception e) {
				ExtentReport.logger.fail("Table of content link not working");
			}
			
			
		}catch(Exception e) {
			ExtentReport.logger.fail("Table of content link not working");
		}
		
	}
	
	
	 public void checkViewCount() {
		 ExtentReport.logger.info("Checkig view count of wiki");
		 String count = fetchElement.getElement("XPATH", pageObjects.WikiObjects.viewCoutnPath).getAttribute("innerHTML");
		 
		 if(count.equals("1 View")) {
		 		ExtentReport.logger.pass("View count increased successfully");
		 		
		 	}else {
		 		ExtentReport.logger.fail("Fail to increase view count");
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
