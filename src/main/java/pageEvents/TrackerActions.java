package pageEvents;


import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import reports.ExtentReport;
import utils.CommonVariables;
import utils.WebActions;

public class TrackerActions {
	WebActions fetchElement = new WebActions();
//	BaseTest bs;
	String unq = Long.toString(CommonVariables.uniqueNumber());
	
	List<String> headresList = Arrays.asList("Amount","Checkbox","Date","Dropdown","Email","File","Number","Phone Number","Radio Box","Rich Text",	"Text","URL","User Lookahead","Team","Tracker Lookup","Submitted By","Submitted Date","Last Modified By","Last Modified Date");
	
	//File  page
//		public void navigateToFilespage(String url) {
//			fetchElement.navaigateToUrl(url + "/user/document");		
//			ExtentReport.logger.info("Navigate to files page");
//		}
		
		
	public void clickOnContinue() {
		ExtentReport.logger.info("Clicking  on continue");
		fetchElement.getElement("XPATH", pageObjects.TrackerObjects.trackerLinkInCompose).click();
		sleepMethod(5000);
	}
	
	public void addTrackerName(String name) {
		ExtentReport.logger.info("Add tracker name");
		fetchElement.getElement("ID", pageObjects.TrackerObjects.trackerName).sendKeys(name+unq);
		
	}
	
	public void addTeamName(String name) {
		ExtentReport.logger.info("Adding team name");
		fetchElement.getElement("ID", pageObjects.TrackerObjects.trackerProject).sendKeys(name);
		sleepMethod(5000);
		fetchElement.getElement("ID", pageObjects.TrackerObjects.trackerProject).sendKeys(Keys.TAB);
		
	}
	
	
	public void addDescription() {
		ExtentReport.logger.info("Adding description");
		fetchElement.getElement("ID", pageObjects.TrackerObjects.trackerDescription).sendKeys("Tracker created from automation");
	}
	
	
	public void clickCreateTracker() {
		ExtentReport.logger.info("Clicking on create tracker");
		fetchElement.getElement("ID", pageObjects.TrackerObjects.createTrackerButton).click();
		sleepMethod(5000);
	}
	
	
	public void clickOnTool() {
		ExtentReport.logger.info("Clicking on tool");
		try {
//		 WebElement menu = fetchElement.getElement("CLASS", pageObjects.TrackerObjects.clickOnToolsButton);
			List <WebElement> eachItem = fetchElement.getListElements("XPATH", pageObjects.TrackerObjects.clickOnToolsButton);
			for(int i=0; i<eachItem.size();i++) {
				try {
					String name = eachItem.get(i).getAttribute("innerHTML").split("<i")[0].trim();
					
					if(name.equals("Tools")) {
						eachItem.get(i).click();
						sleepMethod(3000);
						break;
					}
				}catch(Exception e) {
					System.out.println(e);
				}
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	public void addNewColumn() {
		ExtentReport.logger.info("Adding new column");
		fetchElement.getElement("XPATH", pageObjects.TrackerObjects.toolsActions).click();
		sleepMethod(5000);
		
	}
	
	
	public void selectCoulmnDropDown() {
		ExtentReport.logger.info("Clicking dropdown ");
		fetchElement.getElement("XPATH", pageObjects.TrackerObjects.columnDropDown).click();
		sleepMethod(1000);
	}
	
	
	public void selectColumnType(String type) {
		ExtentReport.logger.info("Selecting cloumn type");
		WebElement element = fetchElement.getElement("XPATH", pageObjects.TrackerObjects.coulmnTypeOptions);
		List <WebElement> eachItem = element.findElements(By.tagName("li"));
		
		for(int i=0; i<eachItem.size();i++) {
			String action = eachItem.get(i).getAttribute("innerHTML").trim();
			if(action.equals(type)) {
				eachItem.get(i).click();
				break;
			}
		}
	}
	
	
	public void addColumnName() {
		ExtentReport.logger.info("Adding column name");
		fetchElement.getElement("XPATH", pageObjects.TrackerObjects.addColumnName).sendKeys("Name");
		
	}
	
	
	public void createButton() {
		ExtentReport.logger.info("Click on create button");
		fetchElement.getElement("XPATH", pageObjects.TrackerObjects.createButtonPath).click();
		sleepMethod(5000);		
	}
	
	
	public void addNewEntryButton() {
		ExtentReport.logger.info("Clickingon new entry button");
		fetchElement.getElement("XPATH", pageObjects.TrackerObjects.addNewEntryButton).click();
		sleepMethod(5000);
	}
	
	
	public void addTextField() {
		ExtentReport.logger.info("Adding data to tracker");
		fetchElement.getElement("XPATH", pageObjects.TrackerObjects.addDataToTracker).sendKeys("Automated_record");
		
	}
	
	
	public void saveRecord() {
		ExtentReport.logger.info("Click on save record");
		fetchElement.getElement("XPATH", pageObjects.TrackerObjects.saveButton).click();
		sleepMethod(5000);
	}
	
	
	public void validateRecordAdded() {
		ExtentReport.logger.info("Validating added record");
		List <WebElement> eachItem = fetchElement.getListElements("XPATH", pageObjects.TrackerObjects.recordRows);
		sleepMethod(1000);
		boolean isrecordPresent = false;
		for(int i=0; i<eachItem.size();i++) {
			String action = eachItem.get(i).findElement(By.xpath("./div")).getAttribute("innerHTML").trim();
			if(action.equals("Automated_record")) {
				isrecordPresent = true;
				break;
			}
			
			
		}
		
		if(isrecordPresent == true) {
			ExtentReport.logger.pass("Record added successfully to tracker");
		}else {
			ExtentReport.logger.fail("Fail to add record to tracker");
		}
	}
	
	
	public void navigateToTracker(String url) {
		ExtentReport.logger.info("Navigating to trackers page");
		fetchElement.navaigateToUrl(url+"/user/v2/trackers");
		sleepMethod(5000);
	}
	
	public void selectFilter() {
		ExtentReport.logger.info("Selectig filter");
		fetchElement.getElement("CLASS", pageObjects.TrackerObjects.filter).click();
	}
	
	public void selectFiltrOption(String actionName) {
		ExtentReport.logger.info("Executing "+actionName +" action");
		WebElement element = fetchElement.getElement("ID", pageObjects.TrackerObjects.filterType);
		List <WebElement> eachItem = element.findElements(By.tagName("li"));
		
		for(int i=0; i<eachItem.size();i++) {
			String action = "";
			try {
				 action = eachItem.get(i).findElement(By.xpath("./a/span")).getAttribute("innerHTML").trim();	
			}catch(Exception e) {
				
			}
			
			if(action.equals(actionName)) {
				eachItem.get(i).findElement(By.xpath("./a")).click();
				sleepMethod(5000);
				break;
			}
					
		}
		
	}
	
	
	public void validateActiveTracker(String trackerName, String type) {
		ExtentReport.logger.info("Validating tracker created");
		List <WebElement> eachItem = fetchElement.getListElements("XPATH", pageObjects.TrackerObjects.trackerList);
		boolean isActiveTrackerPresent = false;
		for(int i=0; i<eachItem.size();i++) {
			String name = "";
			try {
				 name = eachItem.get(i).findElement(By.xpath("./div/div[2]/div/a")).getAttribute("innerHTML").trim();	
			}catch(Exception e) {
				
			}
			
			int index = name.indexOf(trackerName);
			
			if(index != -1) {
				isActiveTrackerPresent = true;
				sleepMethod(1000);
				break;
			}
					
		}
		
		if(isActiveTrackerPresent == true) {
			ExtentReport.logger.pass("Tracker is "+type);
		}else {
			ExtentReport.logger.fail(type+" tracker is not present");
		}
		
	}
	
	
	public void openTracker(String trackerName) {
		ExtentReport.logger.info("Previewing tracker");
		List <WebElement> eachItem = fetchElement.getListElements("XPATH", pageObjects.TrackerObjects.trackerList);
		boolean isActiveTrackerPresent = false;
		for(int i=0; i<eachItem.size();i++) {
			String name = "";
			try {
				 name = eachItem.get(i).findElement(By.xpath("./div/div[2]/div/a")).getAttribute("innerHTML").trim();	
			}catch(Exception e) {
				
			}
			
			int index = name.indexOf(trackerName);
			
			if(index != -1) {
				eachItem.get(i).click();
				sleepMethod(5000);
				break;
			}
					
		}
		
	}
	
	
	public void clickTopButton(String topButton) {
		ExtentReport.logger.info("Clicking on on top tool action");
		try {
		List <WebElement> eachItem = fetchElement.getListElements("XPATH", pageObjects.TrackerObjects.tackerTopButtons);
		for(int i=0; i<eachItem.size();i++) {
			String name = "";
			try {
				 name = eachItem.get(i).getAttribute("innerHTML").split("<i")[0].trim();	
			}catch(Exception e) {
				System.out.println("not found");
			}

			if(name.equals(topButton)) {
				eachItem.get(i).click();
				sleepMethod(4000);
				break;
			}
					
		}
	 }catch(Exception e){
		 System.out.println(e);
	 }
	}
	
	
	public void clickArchieveAction() {
		ExtentReport.logger.info("Archieving tracker");
		fetchElement.getElement("ID", pageObjects.TrackerObjects.archiveAction).click();
		sleepMethod(5000);
	}
	
	public void archieveButton() {
		ExtentReport.logger.info("Confirm archiev project");
		fetchElement.getElement("XPATH", pageObjects.TrackerObjects.clickArchiveButton).click();
		sleepMethod(5000);
	}
	
	
	
	//import trackers actions
	public void navigateToTrakers(String url) {
		fetchElement.navaigateToUrl(url +"user/v2/trackers");
	}
	
	public void clickSplitButton() {
		ExtentReport.logger.info("Clicking on split button");
		fetchElement.getElement("XPATH", pageObjects.TrackerObjects.splitbutton).click();
	}
	
	public void clickImportAction() {
		ExtentReport.logger.info("Clicking on import action");
		try {
		fetchElement.getElement("ID", pageObjects.TrackerObjects.importAction).click();
			sleepMethod(5000);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void importFileButton(String localPath) {
		ExtentReport.logger.info("Clicking on import");
		try {
		fetchElement.getElement("ID", "import_spreadsheet_file").sendKeys(localPath);
		sleepMethod(3000);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void importFile(String fileName) {
		ExtentReport.logger.info("Giving file import path");
		fetchElement.uploadFile(fileName);
	}
	
	
	public void clickCreate() {
		ExtentReport.logger.info("Clicking on create");
		fetchElement.getElement("XPATH", pageObjects.TrackerObjects.createButton).click();
		sleepMethod(10000);
	}
	
	public void refresh() {
		ExtentReport.logger.info("Refreshing page");
		fetchElement.reloadPage();
	}
	
	
	
	public void validateTrackerHeadings(){
		ExtentReport.logger.info("Validating tracker headers");
		sleepMethod(5000);
		try {
			boolean isHeaderPresent = true;
			List <WebElement> headers = fetchElement.getListElements("XPATH", pageObjects.TrackerObjects.trackerHeaders);
			for(int i=0; i<headers.size(); i++) {
				String headerName = "";
				try {
				headerName = headers.get(i).getAttribute("innerHTML").split("</i>")[1].trim();
				}catch(Exception e) {
					System.out.println(e);
				}
				boolean isPresent = headresList.contains(headerName);
				System.out.println(headerName);
				if(isPresent== true) {
					
				}else {
					isHeaderPresent = false;
				}
			}
			
			if(isHeaderPresent == true) {
				ExtentReport.logger.pass("All tracker headers imported from csv");
			}else {
				ExtentReport.logger.fail("Failed to import tracker header");
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	public void clickDeleteAction() {
		ExtentReport.logger.info("Clickingon on delete action");
		fetchElement.getElement("ID", pageObjects.TrackerObjects.deleteAction).click();
		sleepMethod(5000);
	}
	
	public void confirmDelete() {
		ExtentReport.logger.info("Confirming delete");
		fetchElement.getElement("XPATH", pageObjects.TrackerObjects.confirmDelete).click();
		sleepMethod(5000);
	}
	
	
	public void validateDelete(String trackerName) {
		ExtentReport.logger.info("Validating deleted tracker");
		boolean isDeleted = true;
		List <WebElement> eachItem = fetchElement.getListElements("XPATH", pageObjects.TrackerObjects.trackerList);
		boolean isActiveTrackerPresent = false;
		for(int i=0; i<eachItem.size();i++) {
			String name = "";
			try {
				 name = eachItem.get(i).findElement(By.xpath("./div/div[2]/div/a")).getAttribute("innerHTML").trim();	
			}catch(Exception e) {
				
			}
			
			int index = name.indexOf(trackerName);
			
			if(index != -1) {
				isDeleted = false;
				break;
			}
					
		}
		
		if(isDeleted == true) {
			ExtentReport.logger.pass("Tracker is deleted");
		}else {
			ExtentReport.logger.fail("Failed to delete tracker");
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
