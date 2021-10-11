package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;



public class WebActions {
	
	public WebElement getElement(String identifiedType, String identifierValue) {
		switch(identifiedType){
			case "ID":
				return DriverConfig.webDriver.findElement(By.id(identifierValue));
			case "XPATH":
				return DriverConfig.webDriver.findElement(By.xpath(identifierValue));
			case "CLASS":
				return DriverConfig.webDriver.findElement(By.className(identifierValue));
			case "TAG":
				return DriverConfig.webDriver.findElement(By.tagName(identifierValue));
			case "LINK":
				return DriverConfig.webDriver.findElement(By.linkText(identifierValue));
			case "CSS":
				return DriverConfig.webDriver.findElement(By.cssSelector(identifierValue));	
				default:
				return null;
		}
	}
	
	
	public List<WebElement> getListElements(String identifiedType, String identifierValue) {
		switch(identifiedType){
			case "ID":
				return DriverConfig.webDriver.findElements(By.id(identifierValue));
			case "XPATH":
				return DriverConfig.webDriver.findElements(By.xpath(identifierValue));
			case "CLASS":
				return DriverConfig.webDriver.findElements(By.className(identifierValue));
			case "TAG":
				return DriverConfig.webDriver.findElements(By.tagName(identifierValue));
			case "LINK":
				return DriverConfig.webDriver.findElements(By.linkText(identifierValue));
			case "CSS":
				return DriverConfig.webDriver.findElements(By.cssSelector(identifierValue));	
				default:
				return null;
		}
	}
	
	
	public String getUrl() {
		String URL = DriverConfig.webDriver.getCurrentUrl();
		return URL;
	}
	
	
	public void navaigateToUrl(String url) {
		try {
		DriverConfig.webDriver.navigate().to(url);
		DriverConfig.webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	public void hoverOverElement(String identifiedType, String identifiedValue) {
		try {
		Actions actions = new Actions(DriverConfig.webDriver);
		WebElement menu = getElement(identifiedType, identifiedValue);
		actions.moveToElement(menu);
		actions.click().build().perform();
		Thread.sleep(5000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void hoverElement(WebElement identifierElement) {
		try {
		Actions actions = new Actions(DriverConfig.webDriver);
		WebElement menu = identifierElement;
		actions.moveToElement(menu);
		actions.click().build().perform();
		Thread.sleep(5000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void addDataToCKEditor(WebElement elem, String data) {
		WebElement editorFrame = elem;
		DriverConfig.webDriver.switchTo().frame(editorFrame);
		DriverConfig.webDriver.findElement(By.tagName("body")).click();
		DriverConfig.webDriver.findElement(By.tagName("body")).sendKeys(data);
		DriverConfig.webDriver.switchTo().defaultContent();
	}
	
	
	
	public void scrollToBottom() {
		JavascriptExecutor js = (JavascriptExecutor) DriverConfig.webDriver;
		 js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
	}
	
	
	public void scrollToElement(String ID) {
		JavascriptExecutor js = (JavascriptExecutor) DriverConfig.webDriver;
		js.executeScript("document.getElementById('"+ID+"').scrollIntoView({behavior: \"smooth\", block: \"center\", inline: \"nearest\"});");
	}
	
	public void scrollToWebElement(WebElement element) {
		((JavascriptExecutor) DriverConfig.webDriver).executeScript("arguments[0].scrollIntoView(true);", element);
		
	}
	
	
	public void executeJavaScript(String script) {
		 System.out.println("executing js started");
		 JavascriptExecutor js = (JavascriptExecutor) DriverConfig.webDriver;
		 js.executeScript(script);
		 System.out.println("executing js");
	}
	
	
	public void reloadPage() {
		DriverConfig.webDriver.navigate().refresh();
	
	}
	
	
	public double getScrollPosition(String ID) {
		double value1 = (long) 1.00;
		try {
			JavascriptExecutor executor = (JavascriptExecutor) DriverConfig.webDriver;
			double value = (double) executor.executeScript("return (document.getElementById('"+ID+"').scrollTop);");
			System.out.println(value);
			return value;
		}catch(Exception e){
			System.out.println(e);
		}
		
		return value1;
	}
	
	
	public void rightClick(WebElement element) {
		Actions builder = new Actions(DriverConfig.webDriver);
        builder.contextClick(element);
        builder.perform();
	}
	
	
	public void uploadFile(String fileName) {
		try {
			
			Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\autoIt\\"+fileName+".exe");
			
			System.out.println("File uploaded");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
