package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class OrderSummaryPage extends BrowserUtility {
	private static final By I_CONFIRM_MY_ORDER_BUTTON_LOCATOR = By.xpath("//*[@id='cart_navigation']/button/span");

	public OrderSummaryPage(WebDriver driver) {
		super(driver);
	}

	public OrderConfirmationPage confirmingOrder() {
		clickon(I_CONFIRM_MY_ORDER_BUTTON_LOCATOR);
		return new OrderConfirmationPage(getDriver());
	}

}
