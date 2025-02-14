package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class BillingAddressPage extends BrowserUtility{
       private static final By CHECKOUT_BUTTON_LOCATOR=By.xpath("//button[@name='processAddress']");
	
	public BillingAddressPage(WebDriver driver) {
		super(driver);
		
	}
	public ShipingPage processAddressCheckout() {
		clickon(CHECKOUT_BUTTON_LOCATOR);
		return new ShipingPage(getDriver());
	}

}
