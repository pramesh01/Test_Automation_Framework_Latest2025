package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

public final class MyaccountPage extends BrowserUtility{

	private static final By USER_NAME_LOCATOR=By.xpath("//a[@title='View my customer account']/span");
	private static final By SEARCH_TEXTBOX_LOCATOR=By.id("search_query_top");
	private static final By ADD_NEW_ADDRESS_LINK_LOCATOR=By.xpath("//a[@title='Add my first address']");
	Logger logger=LoggerUtility.getLogger(this.getClass());
	
	public MyaccountPage(WebDriver driver) {
		super(driver);
	}
	
	public String getUserName() {
		logger.info("getting username - logger on page classes");
		return getVisibleText(USER_NAME_LOCATOR);
	}
	
	public SearchResultPage searchforProduct(String productName) {
	   logger.info("searching for the product "+productName);
		enterText(SEARCH_TEXTBOX_LOCATOR, productName);	
		enterSpecialKey(SEARCH_TEXTBOX_LOCATOR, Keys.ENTER);
		SearchResultPage searchResulstPage=new SearchResultPage(getDriver());
		return searchResulstPage;
      }
	
	public AddressPage gotoAddAddressPage() {
		clickon(ADD_NEW_ADDRESS_LINK_LOCATOR);
		AddressPage addressPage=new AddressPage(getDriver());
		return addressPage;
	}
	
}