package com.ui.tests;

import static com.constants.Browsers.*;

import static org.testng.Assert.*;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.constants.User;
import com.ui.pages.HomePage;
import com.utility.LoggerUtility;

@Listeners(com.ui.listeners.TestListener.class)
public class LoginTest3 extends TestBase {
	//HomePage homePage;
	Logger logger=LoggerUtility.getLogger(this.getClass());
	
	/*@BeforeMethod(description="before method, loadign here homepage in setup")
	public void setup() {
		homePage=new HomePage(CHROME);
      }*/

	
	@Test(description="verifies login through csv file",groups= {"e2e","sanity"},
			dataProviderClass=com.ui.dataproviders.LoginDataProviders.class,dataProvider="LoginTestCSVDataProvider",
			retryAnalyzer=com.ui.listeners.MyRetryAnalyzer.class)
	public void loginCSVTest(User user) {
		
	assertEquals(homePage.gotoLoginPage()
			.doLoginWith(user.getEmailid(),user.getPassword())
			.getUserName(),"Parthik Verma");
	   }
	
	@Test(description="verifies login through excel sheet",groups= {"e2e","sanity"},
			dataProviderClass=com.ui.dataproviders.LoginDataProviders.class,dataProvider="LoginTestExcelDataProvider")
	public void loginExcelTest(User user) {
	    
	   // logger.info("@test starting , login with excell through logger");
		assertEquals(homePage.gotoLoginPage()
			  .doLoginWith(user.getEmailid(),user.getPassword())
			  .getUserName(),"Parthik Verma");
		//logger.info("@test completed , login with excell through logger");
	     }
          }