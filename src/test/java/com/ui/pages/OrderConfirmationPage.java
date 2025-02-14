package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class OrderConfirmationPage extends BrowserUtility{

	  private static final By ORDER_CONFIRMATION_MESSAGE_LOCATOR=By.xpath("//*[@id='center_column']/p[1]");
	public OrderConfirmationPage(WebDriver driver) {
		super(driver);
	}
	
	public String OrderCompleteConfirmation() {
		String confirmationMessage=getVisibleText(ORDER_CONFIRMATION_MESSAGE_LOCATOR);
		return confirmationMessage;
	}

}
