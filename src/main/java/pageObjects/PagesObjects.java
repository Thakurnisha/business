package pageObjects;

public interface PagesObjects {
	String toolsPath = "//*[@class='tools_setting_icon normal']"; //xpath
	String toolActions = "page_options_menu"; //class
	String pageTitle = "site_page_name"; //ID
	String iconPopupPath = "//*[@class='far fa-th-large']"; //xpath
	String iconlist = "//*[@id='fancybox-content']/div/div[2]/div/div[2]/a[2]"; //xpath
	String closeIconPopup = "//*[@id='fancybox-content']/div/div[3]/a"; //xpath
	String secondStaticTemplatePath = "//*[@class='select_layout_static control-group']/div/div["; //xpath
	String secondDynamicTemplatePath = "//*[@class='select_layout_dynamic control-group']/div/div["; //xpath 
	String doneButtonPath = "//div[@id='internal_page_create_footer']/div[3]/a"; //xpath
	String saveAndPublish = "//div[@id='internal_page_create_footer']/div[3]/span/a"; //xpath
	String pageTabBar = "site_page_tab"; //ID
	String sendDeleteText = "delete_confirm"; //ID
	String deletePageButton = "submit_deleteSitePage"; //ID
	String dynamicPageTab = "dynamic_template_page"; //ID
	String confirmPublish = "save_publish"; //ID
}
