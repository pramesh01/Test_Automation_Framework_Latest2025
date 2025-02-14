package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.pojo.AddressDetailPOJO;
import com.utility.BrowserUtility;

public class AddressPage extends BrowserUtility {

	private static final By COMPANY_TEXT_LOCATOR = By.id("company");
	private static final By ADDRESS1_TEXT_LOCATOR = By.id("address1");
	private static final By ADDRESS2_TEXT_LOCATOR = By.id("address2");
	private static final By CITY_TEXT_LOCATOR = By.id("city");
	private static final By STATE_TEXT_LOCATOR = By.id("id_state");
	private static final By POSTCODE_TEXT_LOCATOR = By.id("postcode");
	private static final By HOME_PHONE_TEXT_LOCATOR = By.id("phone");
	private static final By MOBILE_PHONE_TEXT_LOCATOR = By.id("phone_mobile");
	private static final By ADDITIONAL_INFORMATION_TEXT_LOCATOR = By.id("other");
	private static final By ASSIGN_ANOTHER_ADDRESS_TEXT_LOCATOR = By.id("alias");
	private static final By SAVE_BUTTON_LOCATOR = By.id("submitAddress");
	private static final By MY_ADDRESS_CONFIRMATION_LOCATOR = By.tagName("h3");

	public AddressPage(WebDriver driver) {
		super(driver);
	}

	public String saveAddress(AddressDetailPOJO address) {
		enterText(COMPANY_TEXT_LOCATOR, address.getCompanyName());
		enterText(ADDRESS1_TEXT_LOCATOR, address.getAddress1());
		enterText(ADDRESS2_TEXT_LOCATOR, address.getAddress2());
		enterText(CITY_TEXT_LOCATOR, address.getCity());
		enterText(STATE_TEXT_LOCATOR, address.getState());
		enterText(POSTCODE_TEXT_LOCATOR, address.getPostalcode());
		enterText(HOME_PHONE_TEXT_LOCATOR, address.getHomePhone());
		enterText(MOBILE_PHONE_TEXT_LOCATOR, address.getMobilePhone());
		enterText(ADDITIONAL_INFORMATION_TEXT_LOCATOR, address.getAdditionalInformation());
		clearText(ASSIGN_ANOTHER_ADDRESS_TEXT_LOCATOR);
		enterText(ASSIGN_ANOTHER_ADDRESS_TEXT_LOCATOR, address.getAssignNewAddress());
		clickon(SAVE_BUTTON_LOCATOR);
		String newAddress=getVisibleText(MY_ADDRESS_CONFIRMATION_LOCATOR);
		return newAddress;
	}

}
