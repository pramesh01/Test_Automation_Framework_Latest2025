package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.ui.pages.MyaccountPage;

@Listeners(com.ui.listeners.TestListener.class)
public class SearchProductTest extends TestBase {

	private MyaccountPage myaccountPage;
  private static final String SEARCH_ITEMS="Printed Summer Dress";
	
  @BeforeMethod(description = "for valid credentials")
	public void setupforvalidusers() {
		myaccountPage = homePage.gotoLoginPage().doLoginWith("bloggerdelhi123@gmail.com", "Password");
	}

	@Test(description = "verifying product search", groups = { "e2e", "sanity", "smoke" })
	public void verifyproductsearchTest() {
		boolean actualSearchResult=myaccountPage.searchforProduct(SEARCH_ITEMS).isProductPresentinSearchList(SEARCH_ITEMS);
		Assert.assertEquals(actualSearchResult, true);
		//System.out.println(data);
	}

}
