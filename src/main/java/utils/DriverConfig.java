package utils;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverConfig {
	
//	public static ChromeDriver webDriver ;
	public static RemoteWebDriver webDriver;
	
	public static final String USERNAME = "mangoapps2";
	public static final String AUTOMATE_KEY = "QLrNFTyEGgyMz8rtxNpm";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	public void launchBrowser(String browser) {
		String dir = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",dir+"\\drivers\\chromedriver.exe");
		ChromeOptions chromeProfile = new ChromeOptions();
		chromeProfile.addArguments("--start-maximized");
		chromeProfile.addArguments("--disable-notifications");
		webDriver = new ChromeDriver(chromeProfile);
		
		try {
		
		//docker
//			DesiredCapabilities  caps = new DesiredCapabilities();
//			if(browser.equals("chrome")){
//				caps.setBrowserName(BrowserType.CHROME);
//			}else {
//				caps.setBrowserName(BrowserType.FIREFOX);
//			}
//			webDriver = new RemoteWebDriver( new java.net.URL("http://localhost:4446/wd/hub"), caps);
//			
//			System.out.println("Launched driver");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	public void closeBrowser() {
//		webDriver.close();
		webDriver.quit();
	}
}
