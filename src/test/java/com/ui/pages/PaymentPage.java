package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class PaymentPage extends BrowserUtility{
	
  private static final By PAY_BY_BANKWIRE_LINK_LOCATOR=By.xpath("//*[@title='Pay by bank wire']");
	
  public PaymentPage(WebDriver driver) {
		super(driver);
	}
  
  public OrderSummaryPage proceedToOrderSummary() {
	  clickon(PAY_BY_BANKWIRE_LINK_LOCATOR);
	  return new OrderSummaryPage(getDriver());
  }
	
	

}
