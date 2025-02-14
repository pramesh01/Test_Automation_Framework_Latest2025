package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.Env;
import com.utility.PropertiesUtility;

public class MyRetryAnalyzer implements IRetryAnalyzer {

	private static final int MAX_NUMBER_OF_ATTEMPTS=Integer.parseInt(PropertiesUtility.readPropertiesUtility(Env.QA, "MAX_NUMBER_OF_ATTEMPTS"));
	private static int CURRENT_ATTEMPTS=1;
	@Override
	public boolean retry(ITestResult result) {
		if(CURRENT_ATTEMPTS<=MAX_NUMBER_OF_ATTEMPTS){
			CURRENT_ATTEMPTS++;
			return true;
		 }
		return false;
	   }
      }
