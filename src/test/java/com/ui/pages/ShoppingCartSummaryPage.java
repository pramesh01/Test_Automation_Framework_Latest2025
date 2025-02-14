package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShoppingCartSummaryPage extends BrowserUtility{
	
	
	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR=By.xpath("(//a[@title='Proceed to checkout'])[2]");
	
	public ShoppingCartSummaryPage(WebDriver driver) {
		super(driver);
	}
	
	public BillingAddressPage proceedtoCheckout_from_shopingCartSummaryPage() {
		clickon(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		return new BillingAddressPage(getDriver());
	}


}
