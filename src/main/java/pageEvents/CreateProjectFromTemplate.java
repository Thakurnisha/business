package pageEvents;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



import reports.ExtentReport;

import utils.CommonVariables;
import utils.WebActions;

public class CreateProjectFromTemplate {
	WebActions fetchElement = new WebActions();
//	SoftAssert softAssert = new SoftAssert();

	
	String unq = Long.toString(CommonVariables.uniqueNumber());
	
	//project list page
	public void navigateToProjectpage(String url) {
		fetchElement.navaigateToUrl(url + "/user/project");		
		ExtentReport.logger.info("Navigate to projects list page");
	}
	
	public void clickOnCreateButton() {
		fetchElement.getElement("XPATH", pageObjects.CreateProjectFromTemplateObjects.createButtonPath).click();
		sleepMethod(5000);
	}
	
	
	// Details page
		public void addTeamName() {
			fetchElement.getElement("ID", pageObjects.CreateProjectFromTemplateObjects.teamNamePath).sendKeys("Mango_project_"+unq);
			ExtentReport.logger.info("Adding team name");
		}
		
		
		public void selectTemplate() {			
			 fetchElement.getElement("XPATH",  pageObjects.CreateProjectFromTemplateObjects.selectTemplatePath).click();
			 WebElement list = fetchElement.getElement("XPATH", pageObjects.CreateProjectFromTemplateObjects.listPath);
			 List <WebElement> each = list.findElements(By.tagName(pageObjects.CreateProjectFromTemplateObjects.tagName));
			 for(int i=0; i<each.size();i++) {
				 String templateName = each.get(i).getAttribute("innerHTML");
				 int index = templateName.indexOf("mango_template_");
				 if(index != -1) {
					 each.get(i).click();
					 sleepMethod(20000);
					 break;
				 }
				 
			 }
			
		}
		
		public void addTeamDecription() {
			fetchElement.getElement("ID", pageObjects.CreateProjectFromTemplateObjects.descriptionPath).sendKeys("Project_ description_"+unq);
			ExtentReport.logger.info("Adding descriptions");
		}
		
		
		public void HoverImage() {
			fetchElement.hoverOverElement("ID", pageObjects.CreateProjectFromTemplateObjects.photHoverPath);
			ExtentReport.logger.info("Hover over image");
		}
		
		public void addLocalImage() throws InterruptedException {
			System.out.println(System.getProperty("user.dir")+"\\assets\\sample.jpg");
			fetchElement.getElement("ID", pageObjects.CreateProjectFromTemplateObjects.uploadOwnImagePath).click();
			
			ExtentReport.logger.info("Adding local image");
			try {
				Thread.sleep(3000);
				Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\autoIt\\uploadTeamImage.exe");
				Thread.sleep(10000);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		public void saveImage() {
			fetchElement.getElement("ID", pageObjects.CreateProjectFromTemplateObjects.saveButtonPath).click();
			ExtentReport.logger.info("Save Image");
		}
		
		public void verifyImageUpload(String url) {
			
				sleepMethod(5000);
				String defaultImage = fetchElement.getElement("ID", pageObjects.CreateProjectFromTemplateObjects.imageUploadPath).getAttribute("value");
				
				if(defaultImage.equals(url+"/ce/pulse/images/default_images/group-250.png")) {
					ExtentReport.logger.fail("Team Image not uploaded");
				}else {
					ExtentReport.logger.pass("Team image uploaded successfully");
				}
			
			
		}
		
		public void saveAndContiue() {
			fetchElement.getElement("ID", pageObjects.CreateProjectFromTemplateObjects.saveAndContinuePath).click();
			ExtentReport.logger.info("Saving project and configuring module");
			sleepMethod(180000);
		}
		
		//configure page
		public void saveAndExit() {

			fetchElement.getElement("CLASS", pageObjects.CreateProjectFromTemplateObjects.saveAndExit).click();
			ExtentReport.logger.info("Config page loaded successfully");
			sleepMethod(5000);
			
		}
		
		public void enableModules() {
			
			WebElement menu = fetchElement.getElement("ID", pageObjects.CreateProjectFromTemplateObjects.modules);
			List <WebElement> eachItem = menu.findElements(By.tagName("li"));
			for(int i=0; i<eachItem.size();i++) {
				try {
					String name = eachItem.get(i).getAttribute("data_name");
					
					if(name.equals("TRACKER")||name.equals("TIMESHEET")||name.equals("PAGES")||name.equals("IDEA")) {
						if(name.equals("TRACKER")) {
							fetchElement.scrollToElement("enable_tracker");
						}else if(name.equals("TIMESHEET")){
							fetchElement.scrollToElement("enable_timesheets");
						}else if(name.equals("PAGES")){
							fetchElement.scrollToElement("enable_overview");
						}else if(name.equals("IDEA")){
							fetchElement.scrollToElement("enable_idea");
						}
						
						
						
						eachItem.get(i).findElement(By.xpath("./div[3]")).click();
					}
				}catch(Exception e) {
					System.out.println(e);
				}
			}
		}
		
		
		public void validateProjectCreated() {
			String url = fetchElement.getUrl();
			int isUrlCorrect = url.indexOf("/ce/pulse/user/teams/project_teams/profile_view?project_id=");
			if(isUrlCorrect != -1) {
				ExtentReport.logger.pass("Project created successfully");
			}else {
				ExtentReport.logger.fail("Creation of project failed");
			}
			
		}
		
		//copied content validation
		 public void navigateToSubmenu(String subMenu) {
			 ExtentReport.logger.info("Navigating to "+subMenu+" page");
			 WebElement menu = fetchElement.getElement("CLASS", pageObjects.CreateProjectFromTemplateObjects.menuList);
			 List <WebElement> eachItem = menu.findElements(By.tagName("li"));
			 for(int i=0; i<eachItem.size();i++) {
				 String item ="";
				 try {
					  item = eachItem.get(i).findElement(By.xpath("./a/div[2]")).getAttribute("innerHTML");
					 
				 }catch (Exception e) {
					  item = eachItem.get(i).findElement(By.xpath("./a/div")).getAttribute("innerHTML");
				 }
				 
				 if(item.equals(subMenu)) {
					 eachItem.get(i).findElement(By.xpath("./a")).click();
					 sleepMethod(5000);
					 
					 break;
				 }
			 }
		 }
		 
		 
		//check in more
		 public void checkInMore(String subMenu) {
			 try {
			 fetchElement.getElement("XPATH", pageObjects.ProjectTemplateObjects.more).click();
			 WebElement menu = fetchElement.getElement("XPATH", pageObjects.ProjectTemplateObjects.moreMenu);
			 List <WebElement> eachItem = menu.findElements(By.tagName("li"));
			 for(int i=0; i<eachItem.size();i++) {
				 String item ="";
				 
					  item = eachItem.get(i).findElement(By.xpath("./a/div")).getAttribute("innerHTML");
					 
					  if(item.contains("&nbsp;")) {
						  item = eachItem.get(i).findElement(By.xpath("./a/div[2]")).getAttribute("innerHTML");
					  }
				 
				 
				 System.out.println(item);
				 
				 if(item.toLowerCase().contains(subMenu.toLowerCase())) {
					 eachItem.get(i).click();
					 sleepMethod(5000);
					 break;
				 }
			 }
			 
			 }catch(Exception e) {
				 System.out.println(e);
			 }
		 }
		 
		 
		 
		 public void validatePostCreated(String name) {
			 ExtentReport.logger.info("Validating posts copied");
			 boolean validPost = false;
			 try {
			 List <WebElement> each = fetchElement.getListElements("CLASS", pageObjects.CreateProjectFromTemplateObjects.postElementPresent);
			 for(int i=0; i<each.size();i++) {
				 String title = "";
				 try {
					 title = each.get(i).findElement(By.xpath("./div/div[2]")).getAttribute("innerHTML").trim(); //without feature image post
				 }catch(Exception e) {
					 title = each.get(i).findElement(By.xpath("./div/section/header/div")).getAttribute("innerHTML").trim(); //with feature image post 
				 }
				 
				 int index = title.indexOf(name);
				 
				 if(index != -1) {
					 validPost = true;
				 		break;
				 	}
				 
			 }
			 
			 if(validPost == true) {
				 ExtentReport.logger.info("Post copied successfully");
			 }else {
				 ExtentReport.logger.info("Failed to copy post");
			 }
			 
			 }catch(Exception e) {
				 ExtentReport.logger.info("Failed to copy post");
			 }
				 	
		 }
		 
		 
		 
		 
		 
		 public void validateAnnouncement(String name) {
			 ExtentReport.logger.info("Validating announcement posts");
			 try {
			 boolean validPostAnnouncement = false;
			 List <WebElement> each = fetchElement.getListElements("CLASS", pageObjects.CreateProjectFromTemplateObjects.postElementPresent);
			 for(int i=0; i<each.size();i++) {
				 
				 String title = "";
				 try {
					 title = each.get(i).findElement(By.xpath("./div/div[2]")).getAttribute("innerHTML").trim(); //without feature image post
				 }catch(Exception e) {
					 title = each.get(i).findElement(By.xpath("./div/section/header/div")).getAttribute("innerHTML").trim(); //with feature image post 
				 }
				 				 
				 int index = title.indexOf(name);

				 if(index != -1) {
					 	validPostAnnouncement = true;
				 		break;
				 	}
				 
			 }
			 
			 if(validPostAnnouncement == true) {
				 ExtentReport.logger.pass("Announcment post copied successfully");
			 }else {
				 ExtentReport.logger.fail("Failed to copy Announcment post");
			 }
			 
			 
			 }catch(Exception e) {
				 ExtentReport.logger.fail("Failed to create announcement post");
			 }
				 	
		 }
		 
		 
		 public void validateDraftPostCreated(String name) {
			 boolean validDraftPost = false;
			 ExtentReport.logger.info("Validating draft posts copied");
			 try {
			 List <WebElement> each = fetchElement.getListElements("CLASS", pageObjects.CreateProjectFromTemplateObjects.postElementPresent);
			 for(int i=0; i<each.size();i++) {
				 
				 String title = "";
				 try {
					 title = each.get(i).findElement(By.xpath("./div/div[2]")).getAttribute("innerHTML").trim(); //without feature image post
				 }catch(Exception e) {
					 title = each.get(i).findElement(By.xpath("./div/section/header/div")).getAttribute("innerHTML").trim(); //with feature image post 
				 }
				 
				 int index = title.indexOf(name);
				 
				 if(index != -1) {
					 validDraftPost = true;
				 		break;
				 	}
				 
			 }
			 
			 if(validDraftPost == true) {
				 ExtentReport.logger.info("Draft post copied successfully");
			 }else {
				 ExtentReport.logger.info("Failed to copy draft post");
			 }
			 
			 
			 }catch(Exception e) {
				 ExtentReport.logger.info("Failed to copy draft post");
			 }
				 	
		 }
		 
		 
		 public void selectRecentWikis() {
			 try {
		        fetchElement.getElement("XPATH", "//*[@class='messages-button-group wiki-button-group wk-prjct-btns-grp wk-tree-project-tabs-btn']").click();
		        sleepMethod(500);
				 WebElement list = fetchElement.getElement("XPATH", pageObjects.CreateProjectFromTemplateObjects.wikiFilterOptions);
				 List <WebElement> each = list.findElements(By.tagName("li"));
				 for(int i=0; i<each.size();i++) {
					 String name = each.get(i).findElement(By.xpath("./a")).getAttribute("innerHTML").trim();
					 if(name.equals("Recent")) {
						 each.get(i).findElement(By.xpath("./a")).click();
					 		break;
					 	}
				 }	
			 }catch(Exception e) {
				System.out.println(e);
			 }
		 }
		 
		 
		 public void validateDraftWiki(String checkName) {
			 ExtentReport.logger.info("Validating draft wiki copied");
			 boolean validDraftWiki = false;
			 WebElement list = fetchElement.getElement("XPATH", pageObjects.CreateProjectFromTemplateObjects.draftWikiListPath);
			 List <WebElement> each = list.findElements(By.tagName("li"));
			 for(int i=0; i<each.size();i++) {
				 String name = each.get(i).findElement(By.xpath("./a")).getAttribute("innerHTML").trim();
				 int index = name.indexOf(checkName);
				 if(index != -1) {
				 		
				 		validDraftWiki = true;
				 		break;
				 	}
			 }	
			 
			 if(validDraftWiki == true) {
				 ExtentReport.logger.pass("Draft Wiki copied from template successfully");
			 }else {
				 ExtentReport.logger.fail("Fail to copy draft wiki from template");
			 }
		 }
		 
		 
		 public void validateWiki(String checkName) {
			 ExtentReport.logger.info("Validating wiki copied");
			 boolean validWiki = false;
			 WebElement list = fetchElement.getElement("XPATH", pageObjects.CreateProjectFromTemplateObjects.wikiListPath);
			 List <WebElement> each = list.findElements(By.tagName("li"));
			 for(int i=0; i<each.size();i++) {
				 String name = each.get(i).findElement(By.xpath("./a")).getAttribute("innerHTML").trim();
				 int index = name.indexOf(checkName);
				 
				 if(index != -1) {
					 	validWiki = true;
				 		break;
				 	}
			 }
			 
			 if(validWiki == true) {
				 ExtentReport.logger.pass("Wiki copied from template successfully");
			 }else {
				 ExtentReport.logger.fail("Fail to copy wiki from template");
			 }
			 
		 }
		 
		 public void validateFileUploaded(String filename, String filetype) {
			 ExtentReport.logger.info("Validating uploaded file");
			 sleepMethod(1000);
			 boolean validFileUpload = false;
			 try {
				 List <WebElement> each = fetchElement.getListElements("XPATH", pageObjects.CreateProjectFromTemplateObjects.fileList);
				 for(int i=0; i<each.size();i++) {
					 
					 String name = each.get(i).findElement(By.xpath("./span/a/span")).getAttribute("innerHTML").trim();
					 
					 if(name.equals(filename)) {
							
							 validFileUpload = true;
						 		break;
						 	}
				 }
				 
				 if(validFileUpload == true) {
					 ExtentReport.logger.pass(filetype+" file copied successfully"); 
				 }else {
					 ExtentReport.logger.fail(filetype+" file failed to copy from template");
				 }
				 
				 
				 
			 }catch(Exception e){
				 ExtentReport.logger.fail("Unable to upload "+filetype+" file");
			 }
		 }
		 
		 
		 public void selectTaskFilter() {
			 try {
			 fetchElement.getElement("XPATH", pageObjects.CreateProjectFromTemplateObjects.taskFilter).click();
			 }catch(Exception e) {
				 ExtentReport.logger.pass("Failed to create task");
			 }
		 }
		 
		 public void selectTaskFilterAction(String action) {
			 WebElement options =  fetchElement.getElement("ID", pageObjects.CreateProjectFromTemplateObjects.taskFilterActions);
			 List <WebElement> each = options.findElements(By.tagName("li"));
			 for(int i=0; i<each.size();i++) {
				 try {
					 String option ="";
					 try {
						 option = each.get(i).findElement(By.xpath("./a/span")).getAttribute("innerHTML").trim();
					 }catch (Exception e){
						 
					 }
					 
					 if(option.equals(action)) {
						 each.get(i).findElement(By.xpath("./a")).click();
						 break;
					 }
				 }catch(Exception e) {
					 ExtentReport.logger.pass("Failed to create task");
				 }
			 }
		 }
		 
		 public void createdTaskVerification() {
			 ExtentReport.logger.info("Verifying task");
			 WebElement options = fetchElement.getElement("XPATH", "//ul[@id='taskListUl']");
			 List <WebElement> each = options.findElements(By.tagName("li"));
			 boolean validateTask = false;
			 for(int i=0; i<each.size();i++) {
				 try {
					 
					 String option = each.get(i).findElement(By.xpath("./div/span[1]/span")).getAttribute("innerHTML").trim();
					 int  index = option.indexOf("Task_");
					 if(index != -1) {
						 validateTask = true;
						 break;
					 }else {
						 ExtentReport.logger.fail("Failed to create task");
						 
					 }
				 }catch(Exception e) {
					
				 }
			 }
			 
			 if(validateTask == true) {
				 ExtentReport.logger.pass("Task created successfully");
			 }else {
				 ExtentReport.logger.fail("Failed to create task");
				 
			 }
		 }
		 
		 public void verifyTimeSheetCreated() {
			 ExtentReport.logger.info("Verifying added timesheet");
			 List <WebElement> each = fetchElement.getListElements("XPATH", pageObjects.CreateProjectFromTemplateObjects.timesheetList);
			 for(int i=0; i<each.size();i++) {
				 try {
					 String option = each.get(i).findElement(By.xpath("./td[3]/div")).getAttribute("innerHTML").trim();
					 if(option.equals("Template_timesheet")) {
						 ExtentReport.logger.pass("Timesheet added successfully");
						 break;
					 }else {
						 ExtentReport.logger.fail("Failed to add timesheet");
					 }
				 }catch(Exception e) {
					 ExtentReport.logger.pass("Failed to add timesheet");
				 }
			 }
		 }
		 
		 public void selectPrimaryTab() {
			 ExtentReport.logger.info("Selecting primary tab");
			 fetchElement.getElement("ID", pageObjects.CreateProjectFromTemplateObjects.primaryTab).click();
			 sleepMethod(5000);
		 }
		 
		 public void validateMessage() {
			 ExtentReport.logger.info("Validating message posted");
			 
				 try {
					 String option = fetchElement.getElement("XPATH", pageObjects.CreateProjectFromTemplateObjects.postedMessagePath).getAttribute("innerHTML").trim(); 
					 int index = option.indexOf("update_");
							 
					 if(index != -1) {
						 ExtentReport.logger.pass("Update copied successfully");
						 
					 }else {
						 ExtentReport.logger.fail("Failed to copy update");
					 }
				 }catch(Exception e) {
					 ExtentReport.logger.fail("Failed to copy update");
				 }
			 }
			
		 
		 
		 
		 public void validateComment(){
			 try {
				String comment = fetchElement.getElement("XPATH", pageObjects.CreateProjectFromTemplateObjects.commentMessagePath).getAttribute("innerHTML").trim();
			 	sleepMethod(2000);
			 	int index = comment.indexOf("Comment_to_update_");
			 	if(index != -1) {
					 ExtentReport.logger.pass("Comment copied successfully");
					 
				 }else {
					 ExtentReport.logger.fail("Failed to copy comment");
					 
				 }
			 	
			 }catch(Exception e) {
				 ExtentReport.logger.fail("Failed to copy comment");
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

