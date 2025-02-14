package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

public final class LoginPage extends BrowserUtility {

	Logger logger = LoggerUtility.getLogger(this.getClass());
	static final By EMAIL_TEXTBOX_LOCATOR = By.xpath("//input[@id='email']");
	static final By PASSWORD_TEXTBOX_LOCATOR = By.xpath("//input[@id='passwd']");
	static final By SUBMIT_BUTTON_LOCATOR = By.xpath("//button[@id='SubmitLogin']");
	static final By INVALID_AUTHENTICATION_MESSAGE = By.xpath("//*[text()='Authentication failed.']");

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	public MyaccountPage doLoginWith(String emailid, String password) {
		logger.info("doing login with the credentials..logger.");
		enterText(EMAIL_TEXTBOX_LOCATOR, emailid);
		enterText(PASSWORD_TEXTBOX_LOCATOR, password);
		clickon(SUBMIT_BUTTON_LOCATOR);
		MyaccountPage myaccountPage = new MyaccountPage(getDriver());
		return myaccountPage;
	}

	public LoginPage doLoginWithInvalidCredentials(String emailid, String password) {
		logger.info("doing login with the invalid credentials..logger.");
		enterText(EMAIL_TEXTBOX_LOCATOR, emailid);
		enterText(PASSWORD_TEXTBOX_LOCATOR, password);
		clickon(SUBMIT_BUTTON_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}

	public String getAuthenticationErrorMessage() {
		return getVisibleText(INVALID_AUTHENTICATION_MESSAGE);
	}
}
