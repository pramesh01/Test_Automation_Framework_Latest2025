package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;

import com.constants.Browsers;

public abstract class BrowserUtility {  //parent class should always be abstract...its constructor be called by child class through super keyword.
	
	private static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
	Logger logger=LoggerUtility.getLogger(this.getClass());
	
	public WebDriver getDriver() { //through Getters ans setters.
		return driver.get();
	}
	
	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
	}
	
	public BrowserUtility(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
		}
		else if(browserName.equalsIgnoreCase("firefox")){
			//driver=new FirefoxDriver();
			driver.set(new FirefoxDriver());
		}
		else {
			System.out.println("Invalid browser..please select correct browser..");
		}
		//driver.get().manage().window().maximize();
		maximizeBrowser();
		driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public BrowserUtility(Browsers browserName) {
		if(browserName==Browsers.CHROME) {
			driver.set(new ChromeDriver());
		}
		else if(browserName==Browsers.FIREFOX){
			driver.set(new FirefoxDriver());
		}
		else {
			System.out.println("Invalid browser..please select correct browser..");
		}
		maximizeBrowser();
		//driver.get().manage().window().maximize();
		driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	} 
	
	public BrowserUtility(Browsers browserName,boolean isHeadless) {
		if(browserName==Browsers.CHROME) {
		if(isHeadless) {
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--headless");//headless mode implemented for chrome.
			options.addArguments("--window-size=1920,1080");
			driver.set(new ChromeDriver(options));
		  }
		else {
			driver.set(new ChromeDriver());
		}
	}
		else if(browserName==Browsers.FIREFOX){
			if(isHeadless) {
				FirefoxOptions options=new FirefoxOptions();
				options.addArguments("--headless");//headless mode implemented for chrome.
				driver.set(new FirefoxDriver(options));
			  }
			else {
			driver.set(new FirefoxDriver());
			}
		}
		else {
			System.out.println("Invalid browser..please select correct browser..");
		}
		maximizeBrowser();
		//driver.get().manage().window().maximize();
		driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void gotowebsite(String url) {
		logger.info("navigation towards website though logger "+url);
		driver.get().get(url);
	}
	public void maximizeBrowser() {
		logger.info("maximizing the browser.");
		driver.get().manage().window().maximize();
	}
	
	public void clickon(By locator) {
		WebElement webElement = driver.get().findElement(locator);
		webElement.click();
		logger.info("clicked on element on UI successfully > "+locator);
	}
	
	public void clickon(WebElement element) {
		logger.info("clicking on webelement > ");
		element.click();
	}
	
	public void enterText(By locator, String text) {
		logger.info("Entering the text into UI  > "+text);
		WebElement webElement = driver.get().findElement(locator);
		webElement.sendKeys(text);
	}
	
	public void enterSpecialKey(By locator, Keys keystoenter) {
		logger.info("Entering the special Key  > "+keystoenter);
		WebElement webElement = driver.get().findElement(locator);
		webElement.sendKeys(keystoenter);
	}
	public String getVisibleText(By locator) {
		WebElement webElement = driver.get().findElement(locator);
		return webElement.getText();
	}
	
	public List<String> getALLVisibleText(By locator) {
		logger.info("Returning the text of all visible elements ");
		List<WebElement> allWebElement = driver.get().findElements(locator);
		logger.info("Returning list of the items.");
		List<String> visibleTextList=new ArrayList<>();
		for(WebElement element:allWebElement) {
			System.out.println(getVisibleText(element));
			visibleTextList.add(getVisibleText(element));
		}
		return visibleTextList;
	}
	
	public List<WebElement> getAllElements(By locator) {
		logger.info("Returning all the visible elements ");
		List<WebElement> allWebElement = driver.get().findElements(locator);
		logger.info("Returning list of the all elements.");
		return allWebElement;
	}
	
	public String getVisibleText(WebElement element) {
		//WebElement webElement = driver.get().findElement(element);
		logger.info("Returning the list of webelements.."+element.getText());
		return element.getText();
	}
	
	public String takeScreenShot(String name) {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("HH-mm-ss");
		String timeStamp=sdf.format(date);
		TakesScreenshot screenShot=(TakesScreenshot)driver.get();
		String path=System.getProperty("user.dir")+"//Screenshot//"+name+"-"+timeStamp+".png";
		File screenshotDataSource=screenShot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshotDataSource, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
	
	public void selectFromDropDown(By dropdownLocator,String TextToBeSelected) {
		logger.info(" selecting from drop down "+dropdownLocator);
		WebElement element = driver.get().findElement(dropdownLocator);
		logger.info("drop down item found and selected.. "+dropdownLocator);
		Select select=new Select(element);
		select.selectByVisibleText(TextToBeSelected);
		
	}
	
	public void clearText(By textlocator) {
		logger.info("clearing the previous text"+textlocator);
		WebElement element = driver.get().findElement(textlocator);
		element.clear();
		
	}

}
