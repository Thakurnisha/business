package pageObjects;

public interface CreateProjectFromTemplateObjects {
	String createButtonPath = "//*[@title='Create Project']"; //xpath
	String selectTemplatePath = "//*[@name='template_id']"; //xpath
	String teamNamePath = "teamName";
	String listPath = "//*[@name='template_id']"; //xpath
	String tagName = "option"; //tag
	
	String descriptionPath = "description";
	String photHoverPath = "preview_icon_cont";
	String uploadOwnImagePath = "ms-pulse-team-photo-upload";
	String saveButtonPath = "save-team-icon";
	String imageUploadPath = "room_image";
	String defaultImage = "/ce/pulse/images/default_images/group-250.png";
	String saveAndContinuePath = "submit_create_edit_team";
	String saveAndExit = "wizard_publish_continue";
	
	
	String modules = "modules_content"; //ID
	
	
	//menu list
	String menuList = "lhs_dynamic_menu"; //class
	
	//posts
	String postElementPresent = "show-post-title-in-box"; //class
	
	//wiki
	String wikiFilterOptions = "//*[@class='messages-button-group wiki-button-group wk-prjct-btns-grp wk-tree-project-tabs-btn']/ul/li/ul"; //xpath
	String draftWikiListPath ="//*[@id='wkRecentWikis']/ul[2]"; //xpath
	String wikiListPath ="//*[@id='wkRecentWikis']/ul[1]"; //xpath
	
	//files
	String fileList = "//*[@class='details-filename']"; //xpath
	
	//tasks
	String taskList = "taskListUl"; //id
	String taskFilter = "//*[@class='ms-flex-auto']/div[3]/div[2]/ul"; //xpath
	String taskFilterActions = "teams_filter_options"; //id
	
	//timesheet
	String timesheetList = "//tr[starts-with(@id,'time_log_')]"; //xpath
	
	//feeds
	String primaryTab = "primary_tab"; //ID	
	String messageList = "message-list"; //ID
	String postedComment = "//*[@class='mango-comment-content comment-details']/div[1]/span[1]"; //xpath
	String postedMessagePath = "//div[@class='editableMessage mangostream-body notranslate']/span"; //xpath 
	String commentMessagePath = "//span[@class='ch-emoji--parse editableDescription notranslate ']"; //xpath
			
	
}
