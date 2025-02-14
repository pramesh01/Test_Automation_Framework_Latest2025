package com.base;

import static com.constants.Browsers.CHROME;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browsers;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.LoggerUtility;

public class TestBase {

	protected HomePage homePage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private boolean isLamdaTestEnabled;
	// private boolean isHeadlessEnabled=true;

	@Parameters({ "browser", "isLamdaTestEnabled", "isHeadlessEnabled" })
	@BeforeMethod(description = "before method, loadign here homepage in setup")
	public void setup(@Optional("chrome") String browser, @Optional("false") boolean isLamdaTestEnabled,
			@Optional("false") boolean isHeadlessEnabled, ITestResult result) {
		this.isLamdaTestEnabled = isLamdaTestEnabled;
		WebDriver lambdaDriver;
		if (isLamdaTestEnabled) {
			// lamdatest is enabled..
			lambdaDriver = LambdaTestUtility.LambdaTestSession(browser, result.getMethod().getMethodName());
			homePage = new HomePage(lambdaDriver);
		} else {
			// lambdatest cloud execution is not enabled
			logger.info("Loading homepag of HomePage Class.");
			// homePage=new HomePage(CHROME, isHeadlessEnabled);
			homePage = new HomePage(Browsers.valueOf(browser.toUpperCase()), isHeadlessEnabled);
		}
	}

	public BrowserUtility getInstance() {
		return homePage;
	}

	@AfterMethod(description = "closing browser session after test finished.")
	public void teardown() {
		if (isLamdaTestEnabled) {
			LambdaTestUtility.quitSession(); // quit the browser session on LambdaTest
		} else {
			homePage.getDriver().quit(); // local session quit;
		}
	}
}
