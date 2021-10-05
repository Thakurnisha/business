package pageObjects;

public interface FilesObjects {
	String projectNode = "//*[@id='tree']/ul/li[2]/a"; //xpath
	String projectsList = "//*[@id='tree']/ul/li[2]/ul"; //xpath
	String fileActions = "//*[@id='vakata-contextmenu']/ul"; //xpath
	String shareFolderPublicLinkPath = "//li[@class='copy-public ']/a"; //xpath
	String makePublicButtonPath = "//span[text()='Make Public']"; //xpath 
	String publicLink = "input_copy_link"; //ID
	String closePermissinPopupPath = "//span[@class='container-close']"; //xpath
	String publiLinkFilePath = "//span[@title='sample.jpg']"; //xpath
	String fileActionMore = "//*[@class='dropdown-arrow arrow_container ms-files-more-actions madn-button']"; //xpath
	String fileActionsList = "file_actions"; //ID
	String fileUploadButtton = "fileupload"; //ID
	String doNotNotifyButton = "doNotNotifyFile"; //ID
	String deleteText = "delete_confirm"; //ID
	String deleteFolderAndContentPath = "//span[text()='Delete the folder and its contents']"; //xpath
	
}
