package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.constants.User;
import com.utility.LoggerUtility;

@Listeners(com.ui.listeners.TestListener.class)
public class LoginTest_InvalidCredentials extends TestBase {
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private static final String INVALID_EMAIL_NAME = "pramesh.cs@hotmail.com";
	private static final String INVALID_PASSWORD = "DEMO12345";

	@Test(description = "verifies login for invalid users", groups = { "e2e", "sanity" })
	public void loginExcelTest_invalidCredentials() {

		logger.info("@test starting , login with invalid user data");
		assertEquals(homePage.gotoLoginPage().doLoginWithInvalidCredentials(INVALID_EMAIL_NAME, INVALID_PASSWORD)
				.getAuthenticationErrorMessage(), "Authentication failed.");

		// logger.info("@test completed , login with excell through logger");
	}
}
