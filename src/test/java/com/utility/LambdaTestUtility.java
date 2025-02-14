package com.utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LambdaTestUtility {
	
	private static final String HUB_URL="https://hub.lambdatest.com/wd/hub";
	private static ThreadLocal<DesiredCapabilities> capabilitiesLocal=new ThreadLocal<DesiredCapabilities>();
	private static ThreadLocal<WebDriver> driverLocal=new ThreadLocal<WebDriver>();
	
	public static String username="pramesh.cs";
	public static String accesskey="dNhl0zFzTVae7njz830Ev3Ywo394ZHP7ffAsEYZm5CI17vde7U";
	//public static String username="bloggerdelhi123";
	//public static String accesskey="J6tY97lVtE0F5Ane1YEg0gqOwpFJPlYv2e6GIkBNdgz5P0IAX2";
	//public  RemoteWebDriver driver = null;
	public static  String gridURL="@hub.lambdatest.com/wd/hub";
	
	@SuppressWarnings("deprecation")
	public static WebDriver LambdaTestSession(String browser,String testName) {
		DesiredCapabilities capabilities =new DesiredCapabilities();
		capabilities.setCapability("browserName", browser);
		capabilities.setCapability("browserVersion", 127);
		Map<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username",username);
		ltOptions.put("accessKey",accesskey);
		ltOptions.put("visual", true);
		ltOptions.put("video", true);
		ltOptions.put("network", true);
		ltOptions.put("build", "lambdaTest_Assignment_Feb2025");
		ltOptions.put("project", "LambdaTest_Selenium_AssignmentFeb2025");
		ltOptions.put("name", testName);
		ltOptions.put("selenium_version", "4.25.0");
		ltOptions.put("w3c", true);	
		capabilitiesLocal.set(capabilities);
		WebDriver driver=null;
		try {
			//@SuppressWarnings("deprecation")
			driver=new RemoteWebDriver(new URL("https://"+username+":"+accesskey+gridURL),capabilitiesLocal.get());
			//driver=new RemoteWebDriver(new URL(HUB_URL),capabilitiesLocal.get());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driverLocal.set(driver);
		return driverLocal.get();

	  }
	
	public static void quitSession() {
		if(driverLocal.get()!=null) {
			driverLocal.get().quit();
		}
	}
       }
