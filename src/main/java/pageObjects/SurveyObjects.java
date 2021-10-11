package pageObjects;

public interface SurveyObjects {
	String composePath = "//*[@class='ms-compose-holder']/li[1]"; //xpath
	String menuItems = "ConfiguredComposeContainer"; //ID
	String expandMenu = "ComposeMoreLess"; //id
	String templateDraftAndBlank = "//li[@data-id='template']"; //xpath
	String clickContinueTemplatePage ="//a[@class=\"wizard_publish_continue_quiz wizard-step\"]"; //xpath
	String quizTitle = "//input[@class=\"quiz-survey-name\"]"; //xpath
	String descriptionBox = "//*[@class='cke_wysiwyg_frame cke_reset']"; //xpath
	
	String clickContinueDescriptionStep = "//a[@class='wizard_publish_continue_quiz  wizard-step']"; //xpath
	String questionsList = "//li[@class='lhs_tab actionbutton question-type-list-item pointer ma-h5']"; //class
	
	String questionBackButton = "//a[@class='close_trac_header ques-back-button']"; //xpath
	String selectAudience = "//*[@class='ms-flex audience-radio-boxes-wrapper']/div[4]"; //xpath
	
	String leftValue = "//input[starts-with(@id,'os_left_label_item_')]"; //xpath
	String rightValue = "//input[starts-with(@id,'os_right_label_item_')]"; //xpath
	
	
	String publishNow = "//a[@data-step='audience_share']"; //xpath
	
	
	String startAndFinishButton = "//button[@class='actionbutton actionblue left-0']"; //xpath
	String selectOption = "//div[@class='spa-ansr-item']"; //xpath
	String closeButton = "//button[@class='actionbutton actionblue ma-h5']"; //xpath
	
}
