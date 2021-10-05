package pageEvents;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Keyboard;

import reports.ExtentReport;
import utils.CommonVariables;
import utils.WebActions;

public class PostActions {
	
	WebActions fetchElement = new WebActions();
//	BaseTest bs;
	String unq = Long.toString(CommonVariables.uniqueNumber());
	
	 public void clickOncompose() {
		 ExtentReport.logger.info("Clicking on compose button");
		 fetchElement.getElement("XPATH", pageObjects.PostsObjects.composePath).click();
		 sleepMethod(2000);
		 
	 } 
	 
	 
	 public void expandMenu() {
		 ExtentReport.logger.info("Expanding menu");
		 fetchElement.getElement("ID", pageObjects.PostsObjects.expandMenu).click();
		 sleepMethod(2000);
	 }
	 
	 public void selectFromMenu(String option) {
		 ExtentReport.logger.info("Selecting "+ option +" menu ");
		 WebElement menu = fetchElement.getElement("ID", pageObjects.PostsObjects.menuItems);
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
	 
	 
	 public void addTeamName(String projectName) {
		 ExtentReport.logger.info("Selecting team name");
		 fetchElement.getElement("ID", pageObjects.PostsObjects.teamNamePath).sendKeys(projectName);
		 sleepMethod(3000);
		 fetchElement.getElement("ID", pageObjects.PostsObjects.teamNamePath).sendKeys(Keys.TAB );
	 }
	 
	 public void continuePost() {
		 ExtentReport.logger.info("Clicking on continue");
		 fetchElement.getElement("XPATH", pageObjects.PostsObjects.continueKeyPath).click();
		 sleepMethod(5000);
	 }
	 
	 //new
	 public void selectPhotoTemplate() {
		 ExtentReport.logger.info("Selecting photo template post");
		 fetchElement.getElement("XPATH", pageObjects.PostsObjects.selectPhotTemplate).click();
	 }
	 
	 // new hover over element
	 public void hoverImage() {
		 ExtentReport.logger.info("Hovering over post image");
		 fetchElement.getElement("XPATH", pageObjects.PostsObjects.imageHover).click();
		 sleepMethod(5000);
	 }
	 
	 //new
	 public void scrollToBottom() {
		 ExtentReport.logger.info("Scrolling to bottom");
		 fetchElement.scrollToBottom();
	 }
	 
	 //new
	 public void clickReplaceButton() {
		 ExtentReport.logger.info("Clicking on replace button");
		 fetchElement.getElement("XPATH", pageObjects.PostsObjects.replaceImageButtonPath).click();
		 sleepMethod(5000);
	 }
	 
	 
	 //new 
	 public void selectImage() {
		 ExtentReport.logger.info("Selecting image from media gallery");
		 fetchElement.getElement("XPATH", pageObjects.PostsObjects.selectMediaGalleryImage).click();
		 
	 }
	 
	 //new
	 public void addAltText() {
		 ExtentReport.logger.info("Adding alt tag to image");
		 try {
		 List<WebElement> inputs = fetchElement.getListElements("XPATH", pageObjects.PostsObjects.inputTextElements);
		 for(int i=0; i<inputs.size();i++) {
			 String label = inputs.get(i).findElement(By.xpath("./div[1]")).getAttribute("innerHTML").trim();
			 int index = label.indexOf("Alt Text");
			 if(index != -1) {
				 inputs.get(i).findElement(By.xpath("./div[2]/input")).sendKeys("automated_image_alt_text");
				 break;
			 }
		 }
		 }catch(Exception e) {
			 System.out.println(e);
		 }
	 }
	 
	 //new 
	 public void closeMediaGallery() {
		 ExtentReport.logger.info("Closing media gallery");
		 fetchElement.getElement("XPATH", pageObjects.PostsObjects.okButton).click();
	 }
	 
	
	 
	 public void viewPost(String name) {
		 ExtentReport.logger.info("Viewing post details");
		 try {
		 List <WebElement> each = fetchElement.getListElements("XPATH", pageObjects.ProjectTemplateObjects.postElementPresent);
		 for(int i=0; i<each.size();i++) {
			 String title = "";
			 
			 try {
				 title = each.get(i).findElement(By.xpath("./div/div[2]")).getAttribute("innerHTML").trim(); 
			 }catch(Exception e) {
				 title = title = each.get(i).findElement(By.xpath("./div/section/header/div")).getAttribute("innerHTML").trim(); //with feature image post
			 }
			 
			 int index = title.indexOf(name);
			 if(index != -1) {
			 
				 try {
					 each.get(i).findElement(By.xpath("./div/div[2]")).click(); //without feature image post
					 sleepMethod(5000);
					 break;
				 }catch(Exception e) {
					 each.get(i).findElement(By.xpath("./div/section//header/div")).click(); //with feature image post 
					 sleepMethod(5000);
					 break;
				 }
			 
			 }
			 
			 
			 
		 }
		 }catch(Exception e) {
			 System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
			 ExtentReport.logger.fail("Fail to view post details");
		 }
			 	
	 }
	 
	 
	 
	 
	 public void validateViewCount() {
		 ExtentReport.logger.info("Validating view count");
		 String count ="";
		 boolean countFound = false;
		 List <WebElement> each = fetchElement.getListElements("CLASS", pageObjects.PostsObjects.viewCoutnPath);
		 for(int i=0; i<each.size();i++) {
			 
			 try {
				 count = each.get(i).getAttribute("innerHTML"); 
				
			 }catch(Exception e) {
				 
			 }
			 
			 if(count.equals("1 view")) {
				 countFound = true;
				 break;
			 }
		 }
		 
		 
		 if(countFound == true) {
		 		ExtentReport.logger.pass("View count increased successfully");
		 	}else {
		 		ExtentReport.logger.fail("Fail to increase view count");
		 	}
		 
	 }
	 


	
	 
	 public void validateAltTag() {
		 ExtentReport.logger.info("Verifying alt tag in the image applied");
		String altText = fetchElement.getElement("XPATH", pageObjects.PostsObjects.altTextPath).getAttribute("alt");
		if(altText.equals("automated_image_alt_text")) {
	 		ExtentReport.logger.pass("Alt tag in image verified successfully");
	 	}else {
	 		ExtentReport.logger.fail("Failed to view alt tag in image");
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
