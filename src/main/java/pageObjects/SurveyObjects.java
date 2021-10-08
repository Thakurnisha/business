package pageObjects;

public interface SurveyObjects {
	String composePath = "//*[@class='ms-compose-holder']/li[1]"; //xpath
	String menuItems = "ConfiguredComposeContainer"; //ID
	String expandMenu = "ComposeMoreLess"; //id
	String blankTemplate = "//li[@data-id='template']"; //xpath
	String clickContinueTemplatePage ="//a[@class=\"wizard_publish_continue_quiz wizard-step\"]"; //xpath
	String quizTitle = "//input[@class=\"quiz-survey-name\"]"; //xpath
	String descriptionBox = "//*[@class='cke_wysiwyg_frame cke_reset']"; //xpath
	
	String clickContinueDescriptionStep = "//a[@class='wizard_publish_continue_quiz  wizard-step']"; //xpath
	String questionsList = "lhs_tab actionbutton question-type-list-item pointer ma-h5"; //class
	
	String questionBackButton = "//a[@class='close_trac_header ques-back-button']"; //xpath
	String selectAudience = "//*[@class='ms-flex audience-radio-boxes-wrapper']/div[4]"; //xpath
	
}
