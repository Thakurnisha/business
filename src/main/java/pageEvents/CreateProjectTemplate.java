package pageEvents;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.mongodb.Tag;

import reports.ExtentReport;

import utils.CommonVariables;
import utils.DriverConfig;
import utils.WebActions;

public class CreateProjectTemplate {
	WebActions fetchElement = new WebActions();
//	SoftAssert softAssert = new SoftAssert();
//	BaseTest bs;
	
	String unq = Long.toString(CommonVariables.uniqueNumber());
	
	//project list page
	public void navigateToProjectpage(String url) {
		ExtentReport.logger.info("Navigate project list page");
		fetchElement.navaigateToUrl(url + pageObjects.ProjectTemplateObjects.projectsListUrl);		
		
	}
	
	
		
	public void hoverToGetCreateAction() {
		ExtentReport.logger.info("Hover to get icon");
		fetchElement.hoverOverElement("XPATH", pageObjects.ProjectTemplateObjects.hoverIconPath);
		
	}
	
	
	public void clickOnCreateTemplate() {
		ExtentReport.logger.info("Click on create action");
		fetchElement.hoverOverElement("LINK", pageObjects.ProjectTemplateObjects.createButtonPath);
		
	}
	
	
	public void verifyTheCreatePageLoaded() {
		ExtentReport.logger.info("Verify create page loaded");
		String url = fetchElement.getUrl();
		System.out.println(url);
		
		 
	     int index = url.indexOf("/ce/pulse/user/teams/template/create_projects");
		
	     if(index != -1) {
				ExtentReport.logger.pass("Navigated to create template create page successfully");
			}else {
				ExtentReport.logger.fail("Failed to navigated to template create");
			}	
	}
	
	// Details page
	public void addTeamName() {
		ExtentReport.logger.info("Adding team name");
		fetchElement.getElement("ID", pageObjects.ProjectTemplateObjects.teamNamePath).sendKeys("mango_template_"+unq);
		
	}
	
	public void addTeamDecription() {
		ExtentReport.logger.info("Adding descriptions");
		fetchElement.getElement("ID", pageObjects.ProjectTemplateObjects.descriptionPath).sendKeys("mango_template_ description_"+unq);
		
	}
	
	
	public void HoverImage() {
		ExtentReport.logger.info("Hover over image");
		fetchElement.hoverOverElement("ID", pageObjects.ProjectTemplateObjects.photHoverPath);
		
	}
	
	public void addLocalImage() throws InterruptedException {
		ExtentReport.logger.info("Adding local image");
		System.out.println(System.getProperty("user.dir")+"\\assets\\sample.jpg");
		fetchElement.getElement("ID", pageObjects.ProjectTemplateObjects.uploadOwnImagePath).click();
		
		
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
		ExtentReport.logger.info("Saving Image");
		fetchElement.getElement("ID", pageObjects.ProjectTemplateObjects.saveButtonPath).click();
		sleepMethod(5000);
		
	}
	
	public void verifyImageUpload(String url) {
			ExtentReport.logger.info("Verifying uploaded image");
			
			sleepMethod(5000);
			String defaultImage = fetchElement.getElement("ID", pageObjects.ProjectTemplateObjects.imageUploadPath).getAttribute("value");
			
			if(defaultImage.equals(url+"/ce/pulse/images/default_images/group-250.png")) {
				ExtentReport.logger.fail("Team Image not uploaded");
			}else {
				ExtentReport.logger.pass("Team image uploaded successfully");
			}
		
		
	}
	
	
	public void saveAndContiue() {
		ExtentReport.logger.info("Saving template and configuring module");
		fetchElement.getElement("ID", pageObjects.ProjectTemplateObjects.saveAndContinuePath).click();
		sleepMethod(5000);
	}
	
	//configure page
	
	public void enableModules() {
		ExtentReport.logger.info("Enabling tracker,timesheet, pages and idea module");
		WebElement menu = fetchElement.getElement("ID", pageObjects.ProjectTemplateObjects.modules);
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
	
	
	public void saveAndExit() {
		ExtentReport.logger.info("Saving and exiting the configure page");
		fetchElement.getElement("CLASS", pageObjects.ProjectTemplateObjects.saveAndExit).click();
		sleepMethod(5000);
		
	}
	
	
	public void validateProjectTemplateCreated() {
		ExtentReport.logger.info("Verifying project created");
		String url = fetchElement.getUrl();
		int isUrlCorrect = url.indexOf("/ce/pulse/user/teams/template/profile_view?project_id=");
		if(isUrlCorrect != -1) {
			ExtentReport.logger.pass("Template created successfully");
		}else {
			ExtentReport.logger.fail("Creation of template failed");
		}
		
	}
	
	
	//posts
	 public void navigateToSubmenu(String subMenu) {
		 ExtentReport.logger.info("Navigating to "+subMenu+" page");
		 
		 WebElement menu = fetchElement.getElement("CLASS", pageObjects.ProjectTemplateObjects.menuList);
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
	 
	 
	 public void postToolButton() {
		 ExtentReport.logger.info("Clicking tools button");
		 fetchElement.getElement("XPATH", pageObjects.ProjectTemplateObjects.postToolButtonPath).click();
		 fetchElement.getElement("LINK", pageObjects.ProjectTemplateObjects.createNewPost).click();
		 sleepMethod(5000);
		 
	 }
	 
	 
	 public void selectTemplate() {
		 ExtentReport.logger.info("Selecting template");
		 fetchElement.getElement("CLASS", pageObjects.ProjectTemplateObjects.continueButtonPath).click();
		 sleepMethod(5000);
		 
	 }
	 
	 public void addPostTitle(String postTitle) {
		 fetchElement.getElement("ID", pageObjects.ProjectTemplateObjects.postTitlePath).clear();
		 fetchElement.getElement("ID", pageObjects.ProjectTemplateObjects.postTitlePath).sendKeys(postTitle+unq);
		 ExtentReport.logger.info("Add data to post");
		 
	 }
	 
	 public void addDescriptionOfPost() {
		 ExtentReport.logger.info("Adding description to post");
		 WebElement container =  fetchElement.getElement("CLASS", pageObjects.ProjectTemplateObjects.ckEditorDescriptionPath);
		 fetchElement.addDataToCKEditor(container, "Description of post _ "+unq);
		 
	 }
	 
	 public void publishPost() {
		 ExtentReport.logger.info("Publishing posts");
		 fetchElement.getElement("ID", pageObjects.ProjectTemplateObjects.publishButtonPath).click();
		 sleepMethod(5000);
		 
	 }
	 
	 public void confirmWIthoutFetatureImage() {
		 ExtentReport.logger.info("Confirm without feature image");
		 fetchElement.getElement("XPATH", pageObjects.ProjectTemplateObjects.publishWithoutFetaureImagePath).click();
		 sleepMethod(5000);
	 }
	 
	 
	 public void setFeatureImage() {
		 ExtentReport.logger.info("Clicking on featured image");
		 fetchElement.getElement("ID", pageObjects.ProjectTemplateObjects.featureImageButtonPath).click();
		 sleepMethod(5000);
		 
	 }
	 
	 public void selectUploadTab() {
		 ExtentReport.logger.info("Select upload tab");
		 fetchElement.getElement("XPATH", pageObjects.ProjectTemplateObjects.selectUploadTab).click(); 
	 }
	 
	 public void addPostImage() throws InterruptedException {
		 	ExtentReport.logger.info("Uploading new image file from local");
			System.out.println(System.getProperty("user.dir")+"\\assets\\sample.jpg");
			fetchElement.getElement("ID", pageObjects.ProjectTemplateObjects.mediaGalleryFileUploadButtonPath).click();
			
			ExtentReport.logger.info("Adding local image");
			try {
				sleepMethod(3000);
				Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\autoIt\\uploadTeamImage.exe");
				sleepMethod(10000);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	 
	 public void selectFirstImageFromMediaGallery() {
		 ExtentReport.logger.info("Select first item from image gallery");
		 fetchElement.getElement("XPATH", pageObjects.ProjectTemplateObjects.firstImagePath).click();
		 sleepMethod(5000);
	 }
	 
	 public void clickNextButton() {
		 ExtentReport.logger.info("Clicking on next button");
		 fetchElement.getElement("XPATH", pageObjects.ProjectTemplateObjects.mediaGalleryNextPath).click();
		 sleepMethod(2000);
	 }
	 
	 public void clickApplyButton() {
		 ExtentReport.logger.info("Clicking on apply button");
		 fetchElement.getElement("XPATH", pageObjects.ProjectTemplateObjects.mediaGalleryApplyPath).click();
		 sleepMethod(10000);
	 }
	 
	 
	 public void confirmButton() {
		 ExtentReport.logger.info("Confirm button");
		 fetchElement.getElement("XPATH", pageObjects.ProjectTemplateObjects.confirmButtonPath).click();
		 sleepMethod(5000);
		
	 }
	 
	 
	 public void validatePostCreated(String name) {
		 ExtentReport.logger.info("Validating posts created");
		 try {
		 List <WebElement> each = fetchElement.getListElements("XPATH", pageObjects.ProjectTemplateObjects.postElementPresent);
		 for(int i=0; i<each.size();i++) {
			 String title ="";
			 try {
				 title = each.get(i).findElement(By.xpath("./div/div[2]")).getAttribute("innerHTML").trim(); //without feature image post
			 }catch(Exception e) {
				 title = each.get(i).findElement(By.xpath("./div/section/header/div")).getAttribute("innerHTML").trim(); //with feature image post 
			 }
			 
			 if(title.equals(name+unq)) {
			 		ExtentReport.logger.pass("Post created successfully");
			 		break;
			 	}else {
			 		ExtentReport.logger.fail("Failed to create post");
			 	}
			 
		 }
		 }catch(Exception e) {
			 System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
		 }
			 	
	 }
	 
	 public void createDraftPost() {
		 ExtentReport.logger.info("Saving and exiting posts");
		 fetchElement.getElement("XPATH", pageObjects.ProjectTemplateObjects.splitButtonPath).click();
		 WebElement list = fetchElement.getElement("XPATH", pageObjects.ProjectTemplateObjects.splitButtonActions);
		 List <WebElement> each = list.findElements(By.tagName("li"));
		 for(int i=0; i<each.size();i++) {
			 String getElemet = each.get(i).findElement(By.xpath("./a")).getAttribute("innerHTML").trim();
			 System.out.println(getElemet);
			 if(getElemet.equals("Save as Draft &amp; Close")) {
				 each.get(i).findElement(By.xpath("./a")).click();
				 sleepMethod(5000);
				 break;
			 }
		 }
		 
	 }
	 
	 public void validateDraftPostCreated(String name) {
		 ExtentReport.logger.info("Validating draft posts");
		 try {
		 List <WebElement> each = fetchElement.getListElements("CLASS", pageObjects.ProjectTemplateObjects.postElementPresent);
		 for(int i=0; i<each.size();i++) {
			 
			 String title = each.get(i).findElement(By.xpath("./div/div[2]")).getAttribute("innerHTML").trim();
			 
			 if(title.equals(name+unq)) {
			 		ExtentReport.logger.pass("Draft Post created successfully");
			 		break;
			 	}else {
			 		ExtentReport.logger.fail("Failed to create draft post");
			 	}
			 
		 }
		 }catch(Exception e) {
			 System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
		 }
			 	
	 }
	 
	 
	 public void markAsAnnouncement() {
		 fetchElement.getElement("XPATH", pageObjects.ProjectTemplateObjects.announcementCheckBoxPath).click();
		
	 }
	 
	 public void selectExpiresDateOfPost() {
		 try {
		 fetchElement.getElement("ID", pageObjects.ProjectTemplateObjects.expiresOptionList).click();
//		 fetchElement.getElement("XPATH", "//div[@id='expiry_li']/select").click();
		 WebElement options =  fetchElement.getElement("ID", pageObjects.ProjectTemplateObjects.expiresOptionList);
		
		 
		 List <WebElement> eachOptions = options.findElements(By.tagName("option"));
		 for(int i=0; i<eachOptions.size();i++) {
			 String getElemet = eachOptions.get(i).getAttribute("innerHTML").trim();
			 System.out.println(getElemet);
			 if(getElemet.equals("Auto Expires On")) {
				 eachOptions.get(i).click();
				 sleepMethod(5000);
				 break;
			 }
		 }
	   }catch(Exception e) {
		  System.out.println(e); 
	   }		
	 }
	 
	 public void validateAnnouncement(String name) {
		 ExtentReport.logger.info("Validating announcement posts");
		 try {
		 List <WebElement> each = fetchElement.getListElements("CLASS", pageObjects.ProjectTemplateObjects.postElementPresent);
		 for(int i=0; i<each.size();i++) {
			 
			 String title = each.get(i).findElement(By.xpath("./div/div[2]")).getAttribute("innerHTML").trim();
			 String label = each.get(i).findElement(By.xpath("./div/div[1]/span")).getAttribute("innerHTML").trim();
			 
			 if(title.equals(name+unq) && label.equals("ANNOUNCEMENT")) {
			 		ExtentReport.logger.pass("Announcement Post created successfully");
			 		break;
			 	}else {
			 		ExtentReport.logger.fail("Failed to create announcement post");
			 	}
			 
		 }
		 }catch(Exception e) {
			 System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
		 }
			 	
	 }
	 
	 
	 //wikis
	 
	 public void addNewWikiButton() {
		 ExtentReport.logger.info("CLicking on new wiki button");
		 fetchElement.getElement("LINK", pageObjects.ProjectTemplateObjects.newWikiButtonPath).click();
		 sleepMethod(5000);
	 }
	 
	 public void addWikiTitle(String name) {
		 ExtentReport.logger.info("Adding title to wiki");
		 fetchElement.getElement("ID", pageObjects.ProjectTemplateObjects.wikiTitlePath).sendKeys(name+unq);
	 }
	 
	 public void createWikiButton() {
		 ExtentReport.logger.info("Clickig on ceate wiki button");
		 fetchElement.scrollToBottom();
		
		 fetchElement.getElement("XPATH", pageObjects.ProjectTemplateObjects.createWikiButton).click();
		 sleepMethod(5000);
	 }
	 
	 
	 public void addDataToWiki() {
		 ExtentReport.logger.info("Adding data to wiki");
		 WebElement container =  fetchElement.getElement("CLASS", pageObjects.ProjectTemplateObjects.ckEditorDescriptionPath);
		 fetchElement.addDataToCKEditor(container, "Description of post _ "+unq);
	 }
	 
	 public void publishWiki(){
		 ExtentReport.logger.info("Publishing wiki");
		 fetchElement.getElement("ID", pageObjects.ProjectTemplateObjects.publishWikiPath).click();
		 sleepMethod(5000);		 
	 }
	 
	 public void validateWiki(String checkName) {
		 ExtentReport.logger.info("Validating wiki created");
		 
		 WebElement list = fetchElement.getElement("XPATH", pageObjects.ProjectTemplateObjects.wikiListPath);
		 List <WebElement> each = list.findElements(By.tagName("li"));
		 for(int i=0; i<each.size();i++) {
			 String name = each.get(i).findElement(By.xpath("./a")).getAttribute("innerHTML").trim();
			 if(name.equals(checkName+unq)) {
			 		ExtentReport.logger.pass("Wiki created successfully");
			 		break;
			 	}else {
			 		ExtentReport.logger.fail("Fail to create wiki");
			 	}
		 }
		 
	 }
	 
	 
	 public void clickSaveAsDraft() {
		 ExtentReport.logger.info("Clicking on save as draft");
		 WebElement container =  fetchElement.getElement("CLASS", pageObjects.ProjectTemplateObjects.ckEditorDescriptionPath);
		 fetchElement.addDataToCKEditor(container, "Description of post _ "+unq);
	 }
	 
	 
	 public void wikiSplitButton() {
		 ExtentReport.logger.info("Clicking on split button");
		 fetchElement.getElement("XPATH", pageObjects.ProjectTemplateObjects.splitButtonPathWiki).click();
		 
	 }
	 
	 
	 public void saveAsDraft() {
		 ExtentReport.logger.info("Clicking on save as draft");
		 fetchElement.getElement("ID", pageObjects.ProjectTemplateObjects.actionSaveAsDaft).click();	 
	 }
	 
	 
	 public void selectRecentWikis() {
		 try {
	        fetchElement.getElement("XPATH", "//*[@class='messages-button-group wiki-button-group wk-prjct-btns-grp wk-tree-project-tabs-btn']").click();
	        sleepMethod(500);
			 WebElement list = fetchElement.getElement("XPATH", pageObjects.ProjectTemplateObjects.wikiFilterOptions);
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
		 ExtentReport.logger.info("Validating draft wiki created");
		 
		 try {
	
		 WebElement list = fetchElement.getElement("XPATH", pageObjects.ProjectTemplateObjects.draftWikiListPath);
		 List <WebElement> each = list.findElements(By.tagName("li"));
		 for(int i=0; i<each.size();i++) {
			 String name = each.get(i).findElement(By.xpath("./a")).getAttribute("innerHTML").trim();
			 
			 int index = name.indexOf(checkName);
			 
			 if(index != -1) {
			 		ExtentReport.logger.pass("Draft Wiki created successfully");
			 		break;
			 	}else {
			 		ExtentReport.logger.fail("Fail to create draft wiki");
			 	}
		 }	
		 }catch(Exception e) {
			 ExtentReport.logger.fail("Fail to create draft wiki");
		 }
	 }
	 
	 //add members
	 public void clickOnInviteColleague() {
		 ExtentReport.logger.info("Clicking on invite colleague  button");
		 fetchElement.getElement("ID", "invite_colleagues").click();
		 sleepMethod(5000);
		 
	 }
	 
	 public void addMemberName(String userName) {
		 ExtentReport.logger.info("Add new members name in search");
		 fetchElement.getElement("XPATH", "//*[@placeholder='Find People']").sendKeys(userName);
		 sleepMethod(5000);
		 fetchElement.getElement("XPATH", "//*[@placeholder='Find People']").sendKeys(Keys.ENTER);
		 sleepMethod(2000);
	 }
	 
	 public void selectAndAddUser() {
		 ExtentReport.logger.info("Selecting and addding new user");
		 fetchElement.getElement("XPATH", "//*[@class='searched-data-left']/ul/li[2]/ul/li[1]").click();
		 sleepMethod(2000);
		 fetchElement.getElement("ID", "addSelectedItem").click(); 
		 sleepMethod(2000);
		 fetchElement.getElement("XPATH", "//*[@id='addUsersCoursesTab']/div[3]/a[3]").click();
		 sleepMethod(5000);
	 }
	 
	 
	 public void validateAddedUser(String expectedName) {
		 try {
		 ExtentReport.logger.info("Validating added user");
		 List <WebElement> each = fetchElement.getListElements("XPATH", "//*[starts-with(@id, 'each-member-row')]"); 
//		 System.out.println("each-member-row");
		 for(int i=0; i<each.size();i++) {
			 String name = each.get(i).findElement(By.xpath("./td[1]/div/div[2]/span[1]/a")).getAttribute("innerHTML").trim();
			 if(name.equals(expectedName)) {
			 		ExtentReport.logger.pass("User added successfully");
			 		break;
			 	}else {
			 		ExtentReport.logger.fail("Failed to add users");
			 	}
		 }
		 }catch(Exception e) {
			 
		 }
	 }
	 
	 
	 //files
	 public void newButton() {
		 fetchElement.getElement("XPATH", pageObjects.ProjectTemplateObjects.newButtonPath).click();
	 }
	 
	 public void selectAddFile() {
		 WebElement list = fetchElement.getElement("XPATH", pageObjects.ProjectTemplateObjects.options);
		 List <WebElement> each = list.findElements(By.tagName("li"));
		 for(int i=0; i<each.size();i++) {
			 try {
			 String name = each.get(i).findElement(By.xpath("./a")).getAttribute("innerHTML").trim();
			 System.out.println(name);
			 int index = name.indexOf("Upload New Files");
			 if(index != -1) {
				 	each.get(i).findElement(By.xpath("./a")).click();
				 	 sleepMethod(2000);
			 		break;
			 	}
			 }catch(Exception e){
				 System.out.println(e);
			 }
		 }
	 }
	 
	 
	 public void uploadFile(String fileName, String type) {
		 ExtentReport.logger.info("Uploading new image file from local");
		 try {
			System.out.println(System.getProperty("user.dir")+"\\assets\\sample.jpg");
			fetchElement.getElement("ID", pageObjects.ProjectTemplateObjects.addFileButton).click();
			
			ExtentReport.logger.info("Adding local image");
			
				sleepMethod(3000);
				if(type.equals("image")) {
					Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\autoIt\\uploadTeamImage.exe");
				}else if(type.equals("xlsx")) {
					Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\autoIt\\uploadxlsFile.exe");
				}else if(type.equals("ppt")) {
					Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\autoIt\\uploadpptFile.exe");
				}else if(type.equals("zip")) {
					Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\autoIt\\uploadZipFile.exe");
				}
				
				sleepMethod(10000);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				ExtentReport.logger.fail("Unable to upload file");
			}
	 }
	 
//	 public void uploadXlsFile() {
//		 ExtentReport.logger.info("Uploading new xls file from local");
//		 try {
//			System.out.println(System.getProperty("user.dir")+"\\assets\\sample.jpg");
//			fetchElement.getElement("ID", pageObjects.ProjectTemplateObjects.addFileButton).click();
//			
//			ExtentReport.logger.info("Adding local image");
//			
//				sleepMethod(3000);
//				Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\autoIt\\uploadxlsFile.exe");
//				sleepMethod(5000);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				ExtentReport.logger.fail("Unable to upload xlsx file");
//			}
//	 }
	 
	 
	 public void doneFileUpload() {
		 ExtentReport.logger.info("Clicking on done");
		 fetchElement.getElement("ID", pageObjects.ProjectTemplateObjects.fileUploadDonePath).click();
		 sleepMethod(5000);
		 
	 }
	 
	 
	 public void validateFileUploaded(String filename, String filetype) {
		 ExtentReport.logger.info("Validating "+filetype+" uploaded file");
		 sleepMethod(1000);
		 try {
			 List <WebElement> each = fetchElement.getListElements("XPATH", pageObjects.ProjectTemplateObjects.fileList);
			 for(int i=0; i<each.size();i++) {
				 
				 String name = each.get(i).findElement(By.xpath("./span/a/span")).getAttribute("innerHTML").trim();
				 
				 if(name.equals(filename)) {
						 ExtentReport.logger.pass(filetype+" file uploaded successfully");
					 		break;
					 	}else {
					 		ExtentReport.logger.fail("Unable to upload "+filetype+" file");
					 	}
			 }
		 }catch(Exception e){
			 ExtentReport.logger.fail("Unable to upload "+filetype+" file");
		 }
	 }
	 
	 
	 
	 public void validateXlsFilePreview(String filename, String filetype) {
		 ExtentReport.logger.info("Validating xls preview");
		 try {
			 List <WebElement> each = fetchElement.getListElements("XPATH", pageObjects.ProjectTemplateObjects.fileList);
			 for(int i=0; i<each.size();i++) {
				 
				 String name = each.get(i).findElement(By.xpath("./span/a/span")).getAttribute("innerHTML").trim();
				 
				 if(name.equals(filename)) {
					 each.get(i).click();
					 sleepMethod(5000);
					 
					 try {
						 boolean isXlsPreviewVisible = fetchElement.getElement("ID", pageObjects.ProjectTemplateObjects.xlsPreview).isDisplayed();
						 ExtentReport.logger.pass("XLS preview is displayed");
					 }catch(Exception e) {
						 ExtentReport.logger.fail("XLS preview is not displayed");
					 }
					 
					 
				 }
			 }
		 }catch(Exception e){
			 ExtentReport.logger.fail("Unable to upload "+filetype+" file");
		 }
	 }
	 
	 
	 public void validateImageFilePreview(String filename, String filetype) {
		 ExtentReport.logger.info("Validating image file preview");
		 try {
			 List <WebElement> each = fetchElement.getListElements("XPATH", pageObjects.ProjectTemplateObjects.fileList);
			 for(int i=0; i<each.size();i++) {
				 
				 String name = each.get(i).findElement(By.xpath("./span/a/span")).getAttribute("innerHTML").trim();
				 
				 if(name.equals(filename)) {
					 each.get(i).click();
					 sleepMethod(5000);
					 
					 try {
						 String isImagePreviewVisible = fetchElement.getElement("ID", pageObjects.ProjectTemplateObjects.imagePreview).getAttribute("data-image");
						 if(isImagePreviewVisible.length()>0) {
							 ExtentReport.logger.pass("Image preview is displayed");
						 }else {
							 ExtentReport.logger.fail("Image preview failed to display");
						 }
						
					 }catch(Exception e) {
						 ExtentReport.logger.fail("Image preview failed to display");
					 }
					 
					 
				 }
			 }
		 }catch(Exception e){
			 ExtentReport.logger.fail("Unable to upload "+filetype+" file");
		 }
	 }
	 
	 
	 public void closePreview() {
		 ExtentReport.logger.info("Close preview");
		 fetchElement.getElement("ID", pageObjects.ProjectTemplateObjects.previewClose).click();
		 sleepMethod(5000);
	 }
	 
	 
	//Tasks
	 public void clickTaskTool() {
		 ExtentReport.logger.info("Click on tasks tool button");
		 fetchElement.getElement("XPATH", pageObjects.ProjectTemplateObjects.taskToolButtonPath).click();
	 }
	 
	 public void addNewTask() {
		 ExtentReport.logger.info("Clicking on add new task action");
		 try {
			 WebElement options = fetchElement.getElement("XPATH", pageObjects.ProjectTemplateObjects.taskToolsActions);
			 List <WebElement> each = options.findElements(By.tagName("li"));
			 for(int i=0; i<each.size();i++) {
				 String option = each.get(i).findElement(By.xpath("./div/a/span")).getAttribute("innerHTML").trim();
				 if(option.equals("Add New Task")) {
					 each.get(i).findElement(By.xpath("./div/a")).click();
					 sleepMethod(5000);
					 break;
				 }
			 }
		 }catch(Exception e) {
			System.out.println(e); 
		 }
		 
	 }
	 
	 public void addTaskDescription() {
		 ExtentReport.logger.info("Adding description to the task");
		 fetchElement.getElement("ID", pageObjects.ProjectTemplateObjects.taskName).sendKeys("Task_"+unq);
	 }
	 
	 public void taskSubmit() {
		 ExtentReport.logger.info("Clicking on submit task");
		 fetchElement.getElement("ID", pageObjects.ProjectTemplateObjects.taskSubmitButton).click();
		 sleepMethod(5000);
	 }
	 
	 
	 public void createdTaskVerification() {
		 ExtentReport.logger.info("Verifying task");
		 WebElement options = fetchElement.getElement("ID", pageObjects.ProjectTemplateObjects.taskList);
		 List <WebElement> each = options.findElements(By.tagName("li"));
		 for(int i=0; i<each.size();i++) {
			 try {
				 String option = each.get(i).findElement(By.xpath("./div/span[1]/span")).getAttribute("innerHTML").trim();
				 if(option.equals("Task_"+unq)) {
					 ExtentReport.logger.pass("Task created successfully");
					 break;
				 }else {
					 ExtentReport.logger.fail("Failed to create task");
					 
				 }
			 }catch(Exception e) {
				 ExtentReport.logger.pass("Failed to create task");
			 }
		 }
	 }
	 
	 
	 //timesheet
	 
	 public void addNewTimeLog() {
		 ExtentReport.logger.info("Clicking on add timesheet button");
		 fetchElement.getElement("XPATH", pageObjects.ProjectTemplateObjects.timesheetCreateButton).click();
		 sleepMethod(5000);
		
	 }
	 
	 public void addTimeToTimesheet() {
		 ExtentReport.logger.info("Adding time to timesheet");
		 fetchElement.getElement("ID", pageObjects.ProjectTemplateObjects.timeID).sendKeys("04:00");
	 }
	 
	 public void addTitleToTimesheet() {
		 ExtentReport.logger.info("Adding Title to timesheet");
		 fetchElement.getElement("ID", pageObjects.ProjectTemplateObjects.timeSheetTitle).sendKeys("Template_timesheet");
	 }
	 
	 public void addDescriptionToTimesheet() {
		 ExtentReport.logger.info("Adding description to timesheet");
		 fetchElement.getElement("ID", pageObjects.ProjectTemplateObjects.timeLogDescription).sendKeys("Template_timesheet_description");
	 }
	 
	 public void clickAddNew() {
		 ExtentReport.logger.info("Clicking on add new");
		 fetchElement.getElement("ID", pageObjects.ProjectTemplateObjects.addTimeSheetButton).click();
		 sleepMethod(5000);
	 }
	 
	 public void verifyTimeSheetCreated() {
		 ExtentReport.logger.info("Verifying added timesheet");
		 List <WebElement> each = fetchElement.getListElements("XPATH", pageObjects.ProjectTemplateObjects.timesheetList);
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
	 
	 
	 //feeds
	 
	 public void clickOnMessageBox() {
		 ExtentReport.logger.info("Enablling message box");
		 fetchElement.getElement("ID", pageObjects.ProjectTemplateObjects.messageBox).click();
		 sleepMethod(2000);
	 }
	
	 
	 public void addUpdate() {
		 ExtentReport.logger.info("Entering Update message");
		 fetchElement.getElement("ID", pageObjects.ProjectTemplateObjects.messageBoxContainer).sendKeys("update_"+unq);
	 }
	 
	 public void clickShare() {
		 ExtentReport.logger.info("Clicking on share");
		 fetchElement.getElement("XPATH", pageObjects.ProjectTemplateObjects.shareButton).click();
	 }
	 
	 public void selectPrimaryTab() {
		 ExtentReport.logger.info("Selecting primary tab");
		 fetchElement.getElement("ID", pageObjects.ProjectTemplateObjects.primaryTab).click();
		 sleepMethod(5000);
	 }
	 
	 
	 public void validateMessage() {
		 ExtentReport.logger.info("Validating message posted");
		 boolean isMessagePresent = false;
		 try {
		 WebElement options = fetchElement.getElement("ID", pageObjects.ProjectTemplateObjects.messageList);
		 List <WebElement> each = options.findElements(By.tagName("li"));
		 for(int i=0; i<each.size();i++) {
			 try {
				 String option ="";
				 try {
					 option = each.get(i).findElement(By.xpath("./div/div[3]/div[2]/div[1]/div[1]/span")).getAttribute("innerHTML").trim();
				 }catch(Exception e) {
					 
				 }
				 
				 int index = option.indexOf("update_");
				 if(index != -1) {
					 isMessagePresent = true;
					 break;
				 }
			 }catch(Exception e) {
				 ExtentReport.logger.fail("Failed to post update");
			 }
		 }
		 
		 if(isMessagePresent = true) {
			 ExtentReport.logger.pass("Update posted successfully");
			 
		 }else {
			 ExtentReport.logger.fail("Failed to post update");
			 
		 }
		 
		 }catch(Exception e) {
			 System.out.println(e);
		 }
	 }
	 
	 
	 public void addComment(){
		 try {
			 WebElement options = fetchElement.getElement("ID", pageObjects.ProjectTemplateObjects.messageList);
			 List <WebElement> each = options.findElements(By.tagName("li"));
			 for(int i=0; i<each.size();i++) {
				 try {
					 String option = each.get(i).findElement(By.xpath("./div/div[3]/div[2]/div[1]/div[1]/span")).getAttribute("innerHTML").trim();
					 if(option.equals("update_"+unq)) {
						 each.get(i).findElement(By.xpath("//textarea[starts-with(@id,'box-')]")).click();
						 each.get(i).findElement(By.xpath("//textarea[starts-with(@id,'box-')]")).sendKeys("Comment_to_update_"+unq);
						 each.get(i).findElement(By.xpath("//*[starts-with(@id, 'submit-')]")).click();
						 
						 sleepMethod(5000);
						 break;
					 }
				 }catch(Exception e) {
					 ExtentReport.logger.fail("Failed to post update");
				 }
			 }
			 }catch(Exception e) {
				 System.out.println(e);
			 }
	 }
	 
	 
	 public void validateComment(){
		 try {
			String comment = fetchElement.getElement("XPATH", "//*[@class='feed-name-message notranslate']/span[1]/span[1]").getAttribute("innerHTML").trim();
		 	sleepMethod(2000);
		 	if(comment.equals("Comment_to_update_"+unq)) {
				 ExtentReport.logger.pass("Comment posted successfully");
				 
			 }else {
				 ExtentReport.logger.fail("Failed to post comment");
				 
			 }
		 	
		 }catch(Exception e) {
			 ExtentReport.logger.fail("Failed to post comment");
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
