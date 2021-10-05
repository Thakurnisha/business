package pageEvents;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import reports.ExtentReport;

import utils.CommonVariables;
import utils.WebActions;

public class FileActions {
	WebActions fetchElement = new WebActions();

	String unq = Long.toString(CommonVariables.uniqueNumber());
	
	//File  page
		public void navigateToFilespage(String url) {
			fetchElement.navaigateToUrl(url + "/user/document");		
			ExtentReport.logger.info("Navigate to files page");
		}
		
		
	public void navigateToUrl(String url) {
		ExtentReport.logger.info("Navigating to url");
		fetchElement.navaigateToUrl(url);
	}
	
	public void expandProjectNode() {
		ExtentReport.logger.info("Expanding project node");
		fetchElement.getElement("XPATH", pageObjects.FilesObjects.projectNode).click();
		sleepMethod(5000);
	}
	
	public void selectProjectNode(String folderName) {
		 ExtentReport.logger.info("Selecting project");
		try {
		WebElement list = fetchElement.getElement("XPATH", pageObjects.FilesObjects.projectsList);
		List <WebElement> each = list.findElements(By.tagName("li"));
		
		for(int i=0; i<each.size();i++) {
			 String title ="";
			 title = each.get(i).findElement(By.xpath("./a")).getAttribute("innerHTML").trim(); //with feature image post 
			 String removedPre = title.replace("<ins class=\"jstree-icon\">&nbsp;</ins>", " ");
			 String removePost = removedPre.replace("<span>&nbsp;&nbsp;</span>", " ").trim();
			 int index = removePost.indexOf(folderName);
			 if(index != -1) {
				 fetchElement.scrollToWebElement(each.get(i));
				 each.get(i).findElement(By.xpath("./a")).click(); 
				 fetchElement.rightClick(each.get(i).findElement(By.xpath("./a")));
				 sleepMethod(3000);
				 break;
			 }
 
		 }
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void selectAndAddFolder(String action, String folderName, String projectName) {
		 ExtentReport.logger.info("Executing '"+action+"' action ");
		try {
		WebElement fileActions = fetchElement.getElement("XPATH", pageObjects.FilesObjects.fileActions);
		List <WebElement> each = fileActions.findElements(By.tagName("li"));
		boolean breakAll = false;
		for(int i=0; i<each.size();i++) {
			 String title ="";
			 try {
				 String actionName = each.get(i).findElement(By.xpath("./a")).getAttribute("innerHTML").split("</i>")[1].trim(); //with feature image post 
				 title = actionName.replace("\n", " ").trim();
			 }catch(Exception e) {
				 System.out.println(e);
			 }
			 if(title.equals(action)) {
				 each.get(i).click(); 
				 WebElement list = fetchElement.getElement("XPATH", pageObjects.FilesObjects.projectsList);
					List <WebElement> each2 = list.findElements(By.tagName("li"));
					
					for(int j=0; j<each2.size();j++) {
						 String title2 ="";
						 try {
						 title2 = each2.get(j).findElement(By.xpath("./a")).getAttribute("innerHTML").trim(); //with feature image post 
						 }catch(Exception e) {
							 
						 }
						 String removedPre = title2.replace("<ins class=\"jstree-icon\">&nbsp;</ins>", " ");
						 String removePost = removedPre.replace("<span>&nbsp;&nbsp;</span>", " ").trim();
						 int index = removePost.indexOf(projectName);
						 if(index != -1) {
							 each2.get(j).findElement(By.xpath("./ul/li[1]/input")).sendKeys(folderName);
							 breakAll = true;
							 each2.get(j).findElement(By.xpath("./a")).click();
							 sleepMethod(5000);
							 break;
						 }	 
						 
			 
					 }
					if(breakAll == true) {
						 break;
					 }
				 
			 }

		 }
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	public void selectFolderAction(String action, String folderName, String projectName) {
		 ExtentReport.logger.info("Executing '"+action+"' action ");
		try {
		WebElement fileActions = fetchElement.getElement("XPATH", pageObjects.FilesObjects.fileActions);
		List <WebElement> each = fileActions.findElements(By.tagName("li"));
		
		for(int i=0; i<each.size();i++) {
			 String title ="";
			 try {
				 String actionName = each.get(i).findElement(By.xpath("./a")).getAttribute("innerHTML").split("</i>")[1].trim(); //with feature image post 
				 title = actionName.replace("\n", " ").trim();
			 }catch(Exception e) {
				 System.out.println(e);
			 }
			 if(title.equals(action)) {
				 sleepMethod(3000);
				 each.get(i).click(); 
				 sleepMethod(5000);
				 break;
				 
			 }

		 }
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	public void validateFolderCreated(String folderName, String projectName) {
		 ExtentReport.logger.info("Validating folder created");
		WebElement list = fetchElement.getElement("XPATH", pageObjects.FilesObjects.projectsList);
		List <WebElement> each2 = list.findElements(By.tagName("li"));
		
		for(int j=0; j<each2.size();j++) {
			 String title2 ="";
			 title2 = each2.get(j).findElement(By.xpath("./a")).getAttribute("innerHTML").trim(); //with feature image post 
			 String removedPre = title2.replace("<ins class=\"jstree-icon\">&nbsp;</ins>", " ");
			 String removePost = removedPre.replace("<span>&nbsp;&nbsp;</span>", " ").trim();
			 int index = removePost.indexOf(projectName);
			 if(index != -1) {
				 String title3 = each2.get(j).findElement(By.xpath("./ul/li[1]/a")).getAttribute("innerHTML").trim();
				 String removedPre2 = title3.replace("<ins class=\"jstree-icon\">&nbsp;</ins>", " ");
				 String removePost2 = removedPre2.replace("<span>&nbsp;&nbsp;</span>", " ").trim();
				 if(removePost2.equals(folderName)) {
					 ExtentReport.logger.pass("Folder created successfully");
				 }else {
					 ExtentReport.logger.pass("Failed to create folder");
				 }
				 break;
			 }		 
 
		 }
	}
	
	public void rightClickProjectSubfolder(String folderName, String projectName) {
		 	ExtentReport.logger.info("Getting right click actions of "+folderName);
		 	try {
			WebElement list = fetchElement.getElement("XPATH", pageObjects.FilesObjects.projectsList);
			List <WebElement> each2 = list.findElements(By.tagName("li"));
			
			for(int j=0; j<each2.size();j++) {
				 String title2 ="";
				 title2 = each2.get(j).findElement(By.xpath("./a")).getAttribute("innerHTML").trim(); //with feature image post 
				 String removedPre = title2.replace("<ins class=\"jstree-icon\">&nbsp;</ins>", " ");
				 String removePost = removedPre.replace("<span>&nbsp;&nbsp;</span>", " ").trim();
				 int index = removePost.indexOf(projectName);
				 if(index != -1) {
					 String title3 = each2.get(j).findElement(By.xpath("./ul/li[1]/a")).getAttribute("innerHTML").trim();
					 String removedPre2 = title3.replace("<ins class=\"jstree-icon\">&nbsp;</ins>", " ");
					 String removePost2 = removedPre2.replace("<span>&nbsp;&nbsp;</span>", " ").trim();
					 if(removePost2.equals(folderName)) {
						 each2.get(j).findElement(By.xpath("./ul/li[1]/a")).click();
						 fetchElement.rightClick(each2.get(j).findElement(By.xpath("./ul/li[1]/a")));
						 sleepMethod(5000);
						 break;
					 }
					 
				 }		 
	 
			 }
		 	}catch(Exception e) {
		 		
		 	}
	}
	
	
	
	public void shareFolderOptions() {
		ExtentReport.logger.info("Clicking to get share folder link");
		fetchElement.getElement("XPATH", pageObjects.FilesObjects.shareFolderPublicLinkPath).click();
		sleepMethod(5000);
	}
	
	
	public void makePublic() {
		ExtentReport.logger.info("Click on make it public button");
		fetchElement.getElement("XPATH", pageObjects.FilesObjects.makePublicButtonPath).click();
		sleepMethod(5000);
	}
	
	
	public String getPublicLink() {
		ExtentReport.logger.info("Getting public link");
		String link ="";
		try {
		link = fetchElement.getElement("ID", pageObjects.FilesObjects.publicLink).getAttribute("value");
		sleepMethod(2000);
		
		}catch(Exception e) {
			
		}
		return link;
	}
	
	public void closePermissionPopup() {
		ExtentReport.logger.info("Closing popup");
		fetchElement.getElement("XPATH", pageObjects.FilesObjects.closePermissinPopupPath).click();
	}
	
	
	public void validatePublicFolderFiles(String filename) {
		ExtentReport.logger.info("Validating public folder files with public link");
		String file = fetchElement.getElement("XPATH", pageObjects.FilesObjects.publiLinkFilePath).getAttribute("innerHTML");
		try {
			if(file.equals(filename)) {
				ExtentReport.logger.pass("Folder shared publicly and files are visible");
			}else {
				ExtentReport.logger.fail("Failed to share folder publicly");
			}
		}catch(Exception e) {
			ExtentReport.logger.fail("Failed to share folder publicly");
		}
	}
	
	
	public void hoverAndClickToGetFileAction(String filename) {
		ExtentReport.logger.info("Hovering and getting file actions");
		ExtentReport.logger.info("Validating uploaded file");
		 sleepMethod(1000);
		 try {
			 fetchElement.hoverOverElement("XPATH", pageObjects.ProjectTemplateObjects.fileList);	
			 fetchElement.getElement("XPATH", pageObjects.FilesObjects.fileActionMore).click();
			 sleepMethod(5000);
			 
			 
		 }catch(Exception e){
			 ExtentReport.logger.fail("Unable to get file actions");
		 }
	}
	
	
	public void fileActionList(String action) {
		ExtentReport.logger.info("Performing file actions");
		try {
		WebElement list = fetchElement.getElement("ID", pageObjects.FilesObjects.fileActionsList);
		List <WebElement> each2 = list.findElements(By.tagName("li"));
		for(int j=0; j<each2.size();j++) {
			 String title2 ="";
			 try {
				 title2 = each2.get(j).findElement(By.xpath("./a")).getAttribute("innerHTML").split("</i>")[1].trim(); //with feature image post 
			 }catch(Exception e) {
				 System.out.println("Sperator found");
			 }
			 
			 if(title2.equals(action)) {
				 each2.get(j).findElement(By.xpath("./a")).click();
				 sleepMethod(5000);
				 break;
			 }		 

		 }
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	
	public void clickFileUpload() throws IOException {
		ExtentReport.logger.info("Uploading new version of file");
		fetchElement.getElement("ID", pageObjects.FilesObjects.fileUploadButtton).click();
		sleepMethod(3000);
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\autoIt\\uploadTeamImage.exe");
		
	}
	
	public void doNotNotify() {
		ExtentReport.logger.info("Clicking on do not notify");
		fetchElement.getElement("ID", pageObjects.FilesObjects.doNotNotifyButton).click();
		
	}
	
	
	public void validateNewVersionUploaded(String action) {
		ExtentReport.logger.info("Validating uploaded version of file");
		boolean isVersionUpdated = false;
		try {
			ExtentReport.logger.pass("Files actions list");
			WebElement list = fetchElement.getElement("ID", pageObjects.FilesObjects.fileActionsList);
			List <WebElement> each2 = list.findElements(By.tagName("li"));
			for(int j=0; j<each2.size();j++) {
				 String title2 ="";
				 try {
					 title2 = each2.get(j).findElement(By.xpath("./a")).getAttribute("innerHTML").split("</i>")[1].trim(); //with feature image post 
				 }catch(Exception e) {
					 System.out.println("Sperator found");
				 }
				 
				 if(title2.equals(action)) {
					 isVersionUpdated = true;
					 break;
				 }		 

			 }
			
			if(isVersionUpdated == true) {
				ExtentReport.logger.pass("File version uploaded successfully");
			}else {
				ExtentReport.logger.fail("Fail to upload file version");
			}
			
			}catch(Exception e) {
				System.out.println(e);
			}
	}
	
	
	public void addDeleteText() {
		ExtentReport.logger.info("Adding delete text");
		fetchElement.getElement("ID", pageObjects.FilesObjects.deleteText).sendKeys("DELETE");
		sleepMethod(5000);
		
	}
	
	public void deleteFolderAndContent() {
		ExtentReport.logger.info("Delete folder and its content");
		fetchElement.getElement("XPATH", pageObjects.FilesObjects.deleteFolderAndContentPath).click();
		sleepMethod(5000);
	}
	
	
	public void validateFolderDelete(String folderName, String projectName) {
		
		 	ExtentReport.logger.info("Checking folder deleted or not");
			WebElement list = fetchElement.getElement("XPATH", pageObjects.FilesObjects.projectsList);
			List <WebElement> each2 = list.findElements(By.tagName("li"));
			
			boolean isDeleted = false;
			
			for(int j=0; j<each2.size();j++) {
				 String title2 ="";
				 title2 = each2.get(j).findElement(By.xpath("./a")).getAttribute("innerHTML").trim(); //with feature image post 
				 String removedPre = title2.replace("<ins class=\"jstree-icon\">&nbsp;</ins>", " ");
				 String removePost = removedPre.replace("<span>&nbsp;&nbsp;</span>", " ").trim();
				 int index = removePost.indexOf(projectName);
				 if(index != -1) {
					 try {
						 String title3 = each2.get(j).findElement(By.xpath("./ul/li[1]/a")).getAttribute("innerHTML").trim();
						 String removedPre2 = title3.replace("<ins class=\"jstree-icon\">&nbsp;</ins>", " ");
						 String removePost2 = removedPre2.replace("<span>&nbsp;&nbsp;</span>", " ").trim();
						 if(removePost2.equals(folderName)) {
							 each2.get(j).findElement(By.xpath("./ul/li[1]/a")).click();
							 fetchElement.rightClick(each2.get(j).findElement(By.xpath("./ul/li[1]/a")));
							 sleepMethod(5000);
							 isDeleted = false;
							 break;
						 }
					 }catch(Exception e) {
						 isDeleted = true;
					 }
					 
				 }		 
	 
			 
			}
			
			if(isDeleted == true) {
				ExtentReport.logger.pass("Folder and its contet deleted");
			}else {
				ExtentReport.logger.fail("Fail to delete folder and its content");
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
