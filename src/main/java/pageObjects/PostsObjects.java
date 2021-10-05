package pageObjects;

public interface PostsObjects {
	String composePath = "//*[@class='ms-compose-holder']/li[1]"; //xpath
	String menuItems = "ConfiguredComposeContainer"; //ID
	String teamNamePath = "token-input-mypostTeams"; //ID
	String continueKeyPath = "//span[text()='Continue']"; //xpath
	String selectPhotTemplate = "//*[@class='mt-preview-dialog--lhs ms-scrollbar set_ms_scrollbar_height']/li[2]"; //xpath
	String viewCoutnPath = "post_count_text"; //class
	String expandMenu = "ComposeMoreLess"; //id
	String imageHover = "//div[@class='ps-column ps-column-view ps-outline-hover ps_column_image  ps-6-column']"; //xpath
	String replaceImageButtonPath = "//div[@class='ps-column ps-column-view ps-outline-hover ps_column_image  ps-6-column']/div[2]/div"; //xapth
	String selectMediaGalleryImage = "//ul[@class='gallery-icons ']/li[1]"; //xpath
	String inputTextElements = "//div[@class='row mg-row mg-detail-sec']"; //xpath
	String okButton ="//button[text()='Ok']"; //xpath
	String altTextPath = "//a[@class='attachment_file']/img"; //xpath
	String closePostpOpupPath = "//*[@id='ms-overlay-wrapper']/div[1]/span"; //xpath
}
