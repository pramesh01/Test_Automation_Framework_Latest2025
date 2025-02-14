package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import static com.constants.Size.*;
import com.ui.pages.SearchResultPage;

public class ProductCheckoutTest extends TestBase {
	private static final String SEARCH_ITEM = "Printed Summer Dress";
	private SearchResultPage searchResultPage;
	
	@BeforeMethod(description = "Searching item for user")
	public void setupforvalidusers() {
		searchResultPage=homePage.gotoLoginPage().doLoginWith("bloggerdelhi123@gmail.com", "Password").searchforProduct(SEARCH_ITEM);

	}

	@Test(description = "complete checkout process", groups = { "e2e", "smoke", "sanity" })
	public void checkoutTest() {
		String message=searchResultPage.clickOntheProductAt(1).selectSize(L)
		.addProductToCart().proceedToCheckout().proceedtoCheckout_from_shopingCartSummaryPage()
		.processAddressCheckout()
		.processToPayment().proceedToOrderSummary().confirmingOrder().OrderCompleteConfirmation();
		
		Assert.assertEquals(message,"Your order on My Shop is complete.");
	}
}
