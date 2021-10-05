package pageEvents;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import reports.ExtentReport;
import utils.CommonVariables;
import utils.WebActions;

public class DomainSettingsActions {
	WebActions fetchElement = new WebActions();
//	BaseTest bs;
	String unq = Long.toString(CommonVariables.uniqueNumber());
	
	public void navigateToLandingPageSetting(String url) {
		ExtentReport.logger.info("Navigate to landing setting page");
		fetchElement.navaigateToUrl(url + "/ce/pulse/admin/domain/landing_page_setup");
	}
	
	
	public void clickLandingPageDropDown() {
		ExtentReport.logger.info("Navigate to landing setting page");
		fetchElement.getElement("ID", pageObjects.DomainSettingsObjects.landPageSelectionButton).click();
	}
	
	
	public void selectOption(String option) {
		try {
		WebElement list = fetchElement.getElement("ID", pageObjects.DomainSettingsObjects.landPageSelectionButton);
		List <WebElement> each = list.findElements(By.tagName("option"));
		
		for(int i=0; i<each.size();i++) {
			String title = each.get(i).getAttribute("innerHTML").trim();
			
			if(title.equals(option)) {
				 each.get(i).click();
				 break;
			}
		}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	public void selectForAll() {
		ExtentReport.logger.info("Selecting setting change for all");
		fetchElement.getElement("XPATH", pageObjects.DomainSettingsObjects.selectChangeForAll).click();
	}
	
	
	public void save() {
		ExtentReport.logger.info("Clicking on save");
		fetchElement.getElement("ID", pageObjects.DomainSettingsObjects.saveChanges).click();
		sleepMethod(3000);
		
	}
	
	
	public void clickApplySetting() {			
		ExtentReport.logger.info("Clicking on confirm ");
		fetchElement.getElement("XPATH", pageObjects.DomainSettingsObjects.appySettings).click();
		sleepMethod(3000);
		
	}
	
	public void navigateToHomePage(String url) {
		ExtentReport.logger.info("Navigate to home page");
		fetchElement.navaigateToUrl(url + "/u");
	}
	
	public void validateCompanyAsLandingPage() {
		ExtentReport.logger.info("Validate landing page");
		String curentUrl = fetchElement.getUrl();
		int index = curentUrl.indexOf("/sites/posts");
		if(index != -1) {
			ExtentReport.logger.pass("Landing page changed to company page successfully");
		}else {
			ExtentReport.logger.fail("Failed to change landing page to company page");
		}
		
	}
	
	
	public void validateNewsFeedAsLandingPage() {
		ExtentReport.logger.info("Validate landing page");
		String curentUrl = fetchElement.getUrl();
		int index = curentUrl.indexOf("/ce/pulse/user/home");
		if(index != -1) {
			ExtentReport.logger.pass("Landing page changed to news feed successfully");
		}else {
			ExtentReport.logger.fail("Failed to change landing page to news feed");
		}
		
	}
	
	public void navigateToSetLandingPage(String url) {
		ExtentReport.logger.info("Navigate to set landing page");
		fetchElement.navaigateToUrl(url);
	}
	
	public void navigateToPasswordSettingPage(String url) {
		ExtentReport.logger.info("Navigate to settings page");
		fetchElement.navaigateToUrl(url+"/user/settings/password");
		sleepMethod(5000);
	}
	
	public void addExistingPassword(String currentPass) {
		ExtentReport.logger.info("Adding existing password");
		fetchElement.getElement("ID", pageObjects.DomainSettingsObjects.oldPass).sendKeys(currentPass);
	}
	
	public void addNewPassword(String newPass) {
		ExtentReport.logger.info("Adding new password");
		fetchElement.getElement("ID", pageObjects.DomainSettingsObjects.newPass).sendKeys(newPass);
	}
	
	public void addConfirmPassword(String reConfirmPass) {
		ExtentReport.logger.info("Adding confirm password");
		fetchElement.getElement("ID", pageObjects.DomainSettingsObjects.confirmPass).sendKeys(reConfirmPass);
	}
	
	public void savePassword() {
		ExtentReport.logger.info("Clicking on save");
		fetchElement.getElement("ID", pageObjects.DomainSettingsObjects.save).click();
		sleepMethod(5000);
	}
	
	
	public void logout() {
		ExtentReport.logger.info("Clicking on logout");
		fetchElement.hoverOverElement("XPATH", pageObjects.DomainSettingsObjects.hoverOnGearIcon);
		sleepMethod(2000);
		fetchElement.getElement("XPATH", pageObjects.DomainSettingsObjects.logoutAction).click();
		sleepMethod(5000);
	}
	
	
	public void verifyLoginAfterChangedPassword() {
		ExtentReport.logger.info("Verififying change password");
		String currentUrl = fetchElement.getUrl();
		ExtentReport.logger.info("Verifying login");
		
		int index = currentUrl.indexOf("/ce/pulse/user");
		
		//extent report
		if(index != -1) {
			ExtentReport.logger.pass("Password changed Successfully");
		}else {
			ExtentReport.logger.fail("Login to change password ");
		}
		
		
	}
	
	
	public void navigateToimportUsers(String url) {
		ExtentReport.logger.info("Navigate to import users");
		fetchElement.navaigateToUrl(url+"/admin/import?tab_path=import_wizard_csv");
	}
	
	
	public void clickImportFile() {
		ExtentReport.logger.info("Clicking on browse");
		fetchElement.getElement("XPATH", pageObjects.DomainSettingsObjects.importFileButton).click();
	}
	
	
	public void uploadCsvFile(String fileName) {
		ExtentReport.logger.info("Selecting csv file");
		sleepMethod(5000);
		fetchElement.uploadFile(fileName);
		sleepMethod(5000);
	}
	
	public void importNowButton() {
		
		ExtentReport.logger.info("Clicking on import now");
		fetchElement.getElement("ID", pageObjects.DomainSettingsObjects.importNowButon).click();
		sleepMethod(10000);
	}
	
	
	public void okButton() {
		ExtentReport.logger.info("Clicking on ok button");
		fetchElement.getElement("XPATH", pageObjects.DomainSettingsObjects.okButton).click();
		sleepMethod(3000);
	}
	
	
	public void searchImportedUsers(String url) {
		ExtentReport.logger.info("Search imported users");
		fetchElement.navaigateToUrl(url+"/ce/pulse/admin/colleague/find?limit=50&name=Automated_0&u_status=A&email=&emp_id=&u_role=B&manager=&login_status=&u_department=&organization=&office_location=");
		sleepMethod(5000);
	}
	
	public void validateImportedUSers() {
		ExtentReport.logger.info("Validatig imported users");
		boolean isUsersPresent = false;
		List <WebElement> users = fetchElement.getListElements("XPATH", pageObjects.DomainSettingsObjects.getUsers);
		for(int i =0; i< users.size(); i++) {
			String name = users.get(i).findElement(By.xpath("./td[3]/div")).getAttribute("innerHTML");
			int index = name.indexOf("Automated_0");
			
			if(index != -1) {
				isUsersPresent = true;
			}else {
				isUsersPresent = false;
			}
		}
		
		
		if(isUsersPresent == true) {
			ExtentReport.logger.pass("Users imported Successfully");
		}else {
			ExtentReport.logger.fail("Fail to import users");
		}
	}
	
	
	
	public void selectUsers() {
		ExtentReport.logger.info("Selecting users");
		try {
//		fetchElement.getElement("XPATH", "//label[@for='managr_user_chk']").click();
			
			List <WebElement> users = fetchElement.getListElements("XPATH", "//input[starts-with(@id,'user_')]");
			for(int i =0; i< users.size(); i++) {
				String id = users.get(i).getAttribute("value");
				
				if(id.length() != 0) {
			
				fetchElement.executeJavaScript("document.getElementById('user_"+id+"').checked = true ");
				}
			}
			
			
//			sleepMethod(7000);
//			fetchElement.executeJavaScript("document.getElementById('managr_user_chk').checked = true ");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	public void selectUserTool() {
		ExtentReport.logger.info("Clicking on users tool");
		fetchElement.getElement("ID", pageObjects.DomainSettingsObjects.userToolButton).click();
	}
	
	
	public void selectDeleteAction() {
		ExtentReport.logger.info("Clicking on delete actions");
		fetchElement.getElement("ID", pageObjects.DomainSettingsObjects.deleteUserAction).click();
		sleepMethod(5000);
	}
	
	
	public void confrimDelte() {
		ExtentReport.logger.info("Clicking on confirm delete");
		fetchElement.getElement("XPATH", pageObjects.DomainSettingsObjects.deleteConfirm).click();
		sleepMethod(5000);
	}
	
	
	public void addDelteConfirm() {
		ExtentReport.logger.info("Adding delete text");
		fetchElement.getElement("XPATH", pageObjects.DomainSettingsObjects.addDeleteConfirm).sendKeys("DELETE");
	}
	
	public void deleteButton() {
		ExtentReport.logger.info("Clicking on delete button");
		fetchElement.getElement("XPATH", pageObjects.DomainSettingsObjects.deleteButton).click();
		sleepMethod(5000);
	}
	
	
	public void validateUsersDeleted() {
		ExtentReport.logger.info("Validating users deleted");
		boolean isUsersPresent = false;
		List <WebElement> users = fetchElement.getListElements("XPATH", pageObjects.DomainSettingsObjects.getUsers);
		
		
		if(users.size() == 0) {
			ExtentReport.logger.pass("Users deleted Successfully");
		}else {
			ExtentReport.logger.fail("Fail to delete users");
		}
	}
	
	
	public void scrollToBottom() {
		fetchElement.scrollToBottom();
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
