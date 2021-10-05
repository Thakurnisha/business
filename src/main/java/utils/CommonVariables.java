package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

public class CommonVariables {
	public Properties props = new Properties();
	public String domainUrl = "";
	public String userName = "";
	public String userPassword = "";
	public String otherUserName = "";
	public String postName ="";
	public String wikiName ="";
	public String imageFileName ="";
	public String xlsFileName="";
	public String pptFileName="";
	public String zipFileName="";
	public String pageTitle ="";
	public String projectName ="";
	public String trackerName ="";
	public String csvFileUserImport ="";
	public String csvFileTrackerImport ="";
	
	public void readConfigFile() throws IOException {
//		System.setProperty("env", "EE"); //for testing in local comment when adding to git
		String dir = System.getProperty("user.dir");
		try {
			InputStream input;
			String environmentData = System.getProperty("env");
			if(environmentData.equals("QA")) {
				
				input = new FileInputStream(dir+"\\src\\main\\java\\environments\\qa.properties");
			}else {
				input = new FileInputStream(dir+"\\src\\main\\java\\environments\\ee.properties");
			}
			
			props.load(input);
			domainUrl = props.getProperty("domain");
			userName =  props.getProperty("userName");
			userPassword =  props.getProperty("password");
			otherUserName = props.getProperty("otherUser");
			postName = props.getProperty("postName");
			wikiName = props.getProperty("wikiName");
			imageFileName = props.getProperty("uploadedImageFileName");
			xlsFileName = props.getProperty("uploadxlsFileName");
			pptFileName = props.getProperty("uploadPptFileName");
			zipFileName = props.getProperty("uploadZipFileName");
			pageTitle = props.getProperty("pageTitle");
			projectName = props.getProperty("projectName");
			trackerName = props.getProperty("trackerName");
			csvFileUserImport = props.getProperty("uploadUserCsv");
			csvFileTrackerImport = props.getProperty("uploadTrackerCsv");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static long uniqueNumber() {
		Date date = new Date();
		long unq = date.getTime() / 1000;
		return unq;
	}
	
}
