package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.ui.pages.AddressPage;
import com.ui.pages.MyaccountPage;
import com.ui.pojo.AddressDetailPOJO;
import com.utility.FakeAddressUtility;

public class AddNewFirstAddressTest extends TestBase {

	private MyaccountPage myaccountPage;
	private AddressPage addressPage;
	private AddressDetailPOJO addressdetailPojo;

	@BeforeMethod(description = "for valid First time User Only")
	public void setupforvalidusers() {
		myaccountPage = homePage.gotoLoginPage().doLoginWith("bloggerdelhi123@gmail.com", "Password");
		addressdetailPojo = FakeAddressUtility.getFakeAddress();
	}

	@Test
	public void addNewAddress() {
		String newAddress=myaccountPage.gotoAddAddressPage().saveAddress(addressdetailPojo);
		Assert.assertEquals(newAddress, addressdetailPojo.getAssignNewAddress().toUpperCase());
	}
}
