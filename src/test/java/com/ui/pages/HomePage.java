package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browsers;
import static com.constants.Env.*;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

import static com.utility.PropertiesUtility.*;

public final class HomePage extends BrowserUtility{

	private static final By SIGNIN_LINK_LOCATOR=By.xpath("//a[contains(text(),'Sign in')]");
	Logger logger=LoggerUtility.getLogger(this.getClass());
	
	   public HomePage(Browsers browserName,boolean isHeadless) {
			super(browserName,isHeadless);//super is used to call Parent class constructor from the child classes.
			gotowebsite(readPropertiesUtility(QA,"URL"));
		}
	   
	   public HomePage(WebDriver forlambdaDriver) {
		   super(forlambdaDriver);//super is used to call Parent class constructor from the child classes.
			gotowebsite(readPropertiesUtility(QA,"URL"));
	}

	public LoginPage gotoLoginPage() {
		   logger.info("navigating to LoginPage with logger");
		   clickon(SIGNIN_LINK_LOCATOR);
		   LoginPage lp=new LoginPage(getDriver()); //notice it , through getter and setter.
		   return lp;
	   }
        }
