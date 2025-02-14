package com.ui.listeners;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.base.TestBase;
import com.utility.BrowserUtility;
import com.utility.ExtentReportUtility;
import com.utility.LoggerUtility;

public class TestListener implements ITestListener {

	Logger logger=LoggerUtility.getLogger(this.getClass());
	//extentreports
	ExtentSparkReporter extentSparkReporter;
	ExtentReports extentReports;
	ExtentTest extentTest;
	
	@Override
	public void onTestStart(ITestResult result) {
		logger.info("test started ..."+result.getMethod().getMethodName());
		logger.info("test description is ..."+result.getMethod().getDescription());
		logger.info("test group information is.."+Arrays.toString(result.getMethod().getGroups()));
		ExtentReportUtility.createExtentTest(result.getMethod().getMethodName());
		//extentTest=extentReports.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getMethodName()+"  -> Passed");
		ExtentReportUtility.getTest().log(Status.PASS, result.getMethod().getMethodName()+"  -> Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.error(result.getMethod().getMethodName()+"  -> Test Failed");
		logger.error(result.getThrowable().getMessage());
		ExtentReportUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName()+"  -> Test Failed");
		ExtentReportUtility.getTest().log(Status.FAIL, result.getThrowable().getMessage());
		
		//following is code for taking screenshot from browserutility class method..finding same driver instance..
		//very important code..
		Object testBaseClass=result.getInstance();
	    BrowserUtility browserUtility=((TestBase)testBaseClass).getInstance();
	    String screenshotPath=browserUtility.takeScreenShot(result.getMethod().getMethodName());
	    ExtentReportUtility.getTest().addScreenCaptureFromPath(screenshotPath);
	   }

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.warn(result.getMethod().getMethodName()+"  -> Test Skipped");
		ExtentReportUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName()+"  -> Test Skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		logger.info("Test Suite Started ");
		ExtentReportUtility.setupSparkReports("report.html");
	  }

	@Override
	public void onFinish(ITestContext context) {
		logger.info("Test Suite Completed..");
		//extentReports.flush();
		ExtentReportUtility.flushReports();
	}
	
      }
