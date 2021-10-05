package pageObjects;



public interface ProjectTemplateObjects {
	//project page
		String projectsListUrl =  "/user/project";
		String hoverIconPath = "//*[@id=\"project-main-div\"]/div[1]/div/ul[2]";
		String createButtonPath = "Create Project Template";
		String modules = "modules_content"; //ID
		
	//Create page
		String teamNamePath = "teamName";
		String descriptionPath = "description";
		String photHoverPath = "preview_icon_cont";
		String uploadOwnImagePath = "ms-pulse-team-photo-upload";
		String saveButtonPath = "save-team-icon";
		String imageUploadPath = "room_image";
		String defaultImage = "/ce/pulse/images/default_images/group-250.png";
		String saveAndContinuePath = "submit_create_edit_team";
		String saveAndExit = "wizard_publish_continue";
		
		
    //menu list
		String menuList = "lhs_dynamic_menu"; //class
		
	//posts
		String postToolButtonPath = "//div[@class=\"list-container\"]/div/ul"; //xpath
		String createNewPost = "New Post"; //link
		String continueButtonPath ="post_actn_save_li"; //class
		String postTitlePath = "post_title"; //id
		String ckEditorDescriptionPath = "cke_wysiwyg_frame"; //class
		String publishButtonPath = "preview_post_btn"; //id
		String publishWithoutFetaureImagePath ="//button[contains(text(),'Publish Now')]"; //id
		String postElementPresent = "//*[starts-with(@id,'pv_tmln_itm_')]"; //xpath
		String splitButtonPath = "//*[@class='filter-container']/ul"; //xpath
		String splitButtonActions = "//*[@class='filter-container']/ul/li/ul"; //xpath
		
		String featureImageButtonPath = "pfi_st_btn"; //id
		String selectUploadTab = "//*[@class='cke_dialog_body']/div/a[2]"; //xpath
		String firstImagePath = "//*[@id='ckeditor_filescke_2MediaLibrary']/div[2]/ul/li[1]"; //xapth
		String mediaGalleryNextPath = "//span[contains(text(),'Next')]"; //xpath
		String mediaGalleryFileUploadButtonPath = "ckeFileUploadBtn"; //id
		String mediaGalleryApplyPath = "//span[contains(text(),'Apply')]"; //xpath
		String confirmButtonPath = "//button[contains(text(),'Yes')]"; //xpath
		
		String announcementCheckBoxPath = "//label[@for='post_is_announcement']"; //xpath
		String expiresOptionList = "post_expire_option"; //ID
		
		
	//wikis
		String newWikiButtonPath ="New Wiki"; //link
		String wikiTitlePath = "wiki_title"; //ID 
		String createWikiButton = "//*[@id='ms_global_dialog_body']/form/div[2]/button[2]"; //xpath
		String publishWikiPath ="wiki_save_button"; //ID
		String wikiListPath ="//*[@id='wkRecentWikis']/ul[1]"; //xpath
		String draftWikiListPath ="//*[@id='wkRecentWikis']/ul[2]"; //xpath
		String splitButtonPathWiki ="//*[@id='wkLstEditTitle']/div/div[2]/div[2]/ul"; //xpath
		String actionSaveAsDaft ="wiki_save_as_draft"; //id		
		String wikiFilterButton ="messages-button-group wiki-button-group wk-prjct-btns-grp wk-tree-project-tabs-btn"; //class
		String wikiFilterOptions = "//*[@class='messages-button-group wiki-button-group wk-prjct-btns-grp wk-tree-project-tabs-btn']/ul/li/ul"; //xpath
		
	//files
		String newButtonPath = "//*[@id='filter-container']/div/div/ul"; //xpath
		String options = "//*[@id='filter-container']/div/div/ul"; //xpath
		String addFileButton = "file_upload"; //id
		String fileUploadDonePath = "file_upload_btn"; //id
		String fileList = "//*[@class='details-filename']"; //xpath
		String xlsPreview = "file_container"; //id
		String imagePreview = "imageCanvas"; //id
		String previewClose = "close"; //id
		
		
	//tasks
		String taskToolButtonPath = "//div[@class='ms-flex-auto']/div/ul"; //xpath
		String taskToolsActions = "//div[@class='ms-flex-auto']/div/ul/li/ul"; //xpath
		String taskName = "task_name"; //id
		String taskSubmitButton = "task_submit_button"; //id
		String taskList = "newtaskListUl"; //id
		
		
	//timesheet
		String timesheetCreateButton = "//a[text()='New Time log']"; //xpath
		String timeID = "time_log_time_str"; //ID
		String timeSheetTitle = "time_log_for_whom"; //ID
		String timeLogDescription = "time_log_doing_what"; //ID
		String addTimeSheetButton = "addTimeLogBtn"; //ID
		String timesheetList = "//tr[starts-with(@id,'time_log_')]"; //xpath
		
	//feeds
		String messageBox ="msgBoxContainer"; //ID
		String messageBoxContainer = "project_status_update"; //ID
		String shareButton = "//button[@class='actionbutton waves-effect ma-h5 waves-dark actionblue waves-effect waves-light tweet-submit']"; //xpath
		String primaryTab = "primary_tab"; //ID		
		String messageList = "message-list"; //ID
		String postedComment = "//*[@class='mango-comment-content comment-details']/div[1]/span[1]"; //xpath
}
