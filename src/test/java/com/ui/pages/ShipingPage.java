package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShipingPage extends BrowserUtility{
     private static final By TERMS_OF_SERVICE_CHECKBOX_LOCATOR=By.id("cgv");
    		 private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR=By.xpath("//button[@name='processCarrier']");
	
	public ShipingPage(WebDriver driver) {
		super(driver);
		
	}
	
	public PaymentPage processToPayment() {
		clickon(TERMS_OF_SERVICE_CHECKBOX_LOCATOR);
		clickon(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		return new PaymentPage(getDriver());
	}

}
