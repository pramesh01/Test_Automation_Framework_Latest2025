package com.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {
	
	private static ExtentReports extentReports;
	private static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	//creating ThreadLocal for parrel execution.. 
	
	public static void setupSparkReports(String reportName) {
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		String timeStamp=sdf.format(d);
		ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"//ExtentReports//"+timeStamp+"_"+reportName);
		extentReports=new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
	  }
	
	public static void createExtentTest(String testName) {
	  
		ExtentTest test=extentReports.createTest(testName);
		extentTest.set(test); //setting up local to instance variable..	
	}
	
	public static void flushReports() {
		extentReports.flush();
	  }
	
	public static ExtentTest getTest() {
		return extentTest.get();
	  }
        }
