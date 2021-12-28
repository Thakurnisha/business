package pageObjects;

public interface DomainSettingsObjects {
	String landPageSelectionButton = "domain_navigation_landing_page"; //ID
	String selectChangeForAll = "//*[@for=\"landing_page_apply_to_all\"]"; //xpath
	String saveChanges = "//*[@class='actionbutton waves-effect ma-h5 waves-dark actionbutton actionblue waves-effect waves-light']"; //xpath
	String appySettings = "//*[@id='fancybox-content']/div/div[3]/a[1]"; //xpath
	String oldPass = "currentp"; //ID
	String newPass = "newp"; //ID
	String confirmPass = "confirmnewp"; //ID
	String save = "submit_password"; //ID
	
	String hoverOnGearIcon ="//li[@class='hover-object matop-nav-link']"; //XPATH
	String logoutAction = "//*[@id='ms-top-def-nav']/li[6]/ul/li[5]/a"; //XPATH
	String importFileButton ="//div[@id='file_input_div']/div"; //xpath
	String importNowButon ="choose_csv_file"; //ID
	String okButton = "//button[text()='Ok']"; //xpath
	String getUsers = "//tr[starts-with(@id,'user_row_')]"; //xpath
	String selectAllButton ="//table[@id='admin_user_table_list']/thead/tr[1]/th[1]/label"; //xpath
	String userToolButton = "user_actions"; //ID
	String deleteUserAction ="delete_ma_user"; //ID
	String deleteConfirm ="//span[text()='Delete Users']"; //xpath
	String addDeleteConfirm = "//input[@name=\"delete_confirm\"]"; //xpath
	String deleteButton = "//span[text()=\"Delete\"]"; //xpath
	
	
	String navigationList = "manage_domain_navigation"; //ID
	String selectDropdown = "//div[@class='col-md-12 left-p-0 top-5 right-p-0']"; //xpath
	String optionList = "domain_navigation_landing_page"; //xpath
	
}
