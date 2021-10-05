package pageObjects;

public interface TrackerObjects {
	String trackerLinkInCompose = "//a[@id='new_tracker_by_template']"; //xpath
	String trackerName = "trackername"; //ID
	String trackerProject = "token-input-myFormTeams"; //ID
	String trackerDescription ="trackerdesc"; //ID
	String createTrackerButton = "create-tracker-v2"; //ID
	String clickOnToolsButton = "//a[@class='actionbutton feeds-moremenu left-0 left-p-15 more-tracbtn more-tblOpts  tracker-main-dropdown selectedViewLabel chg-dvdcolr']"; //XPATH
	String toolsActions = "//ul[@class='Track-Opts tracker_more_ops']/li[1]"; //xpath
	String addColumnName = "//input[@name='tracker_column[name]']"; //xpath
	String createButtonPath = "//button[text()='Create']"; //xpath
	String columnDropDown = "//span[starts-with(@id,'select2-tracker_columndata_type-')]"; //xpath
	String coulmnTypeOptions = "//ul[starts-with(@id,'select2-tracker_columndata_type-')]"; //xpath
	String addNewEntryButton = "//div[@class='inr-wrptrac-btns right-p-10']/a"; //xpath
	String addDataToTracker = "//span[@class='tracker_input_tag ']/input"; //xpath
	String saveButton = "//button[@id='data-row-save']"; //xpath
	String recordRows = "//td[@class='htLeft htMiddle textEditor']"; //xpath
	String filter = "filter_options_text"; //xpath 
	String filterType = "people_sub_type_filter"; //ID
	String trackerList = "//div[@class='mango-grid-item-container new-ms-tracker-reader hand']"; //xpath
	String tackerTopButtons = "//a[@class='actionbutton waves-effect waves-dark feeds-moremenu left-0']"; //xpath
	String archiveAction = "archive-tracker-v2"; //ID
	String clickArchiveButton = "//a[text()='Archive']"; //xpath
	
	
	String splitbutton = "//a[@class='actionbutton actionblue waves-effect waves-light ma-h5 ma-action-smn']"; //class
	String importAction = "tracker-import-spreadsheet"; //ID
	String importFileButton = "import_spreadsheet_file"; //ID
	String createButton = "//a[text()='Create']";//xpath
	
	String trackerHeaders = "//span[@class='colHeaderText right-3']"; //XPATH
	String deleteAction = "delete-tracker-v2"; //ID
	String confirmDelete = "//a[text()=\"Delete\"]"; //xpath
	
	
	
}
