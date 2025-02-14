package com.utility;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.ui.pojo.AddressDetailPOJO;

public class FakeAddressUtility {

	public static AddressDetailPOJO getFakeAddress() {
		Faker faker = new Faker(Locale.US);

		AddressDetailPOJO addressdetailPojo = new AddressDetailPOJO(faker.company().name(),
				faker.address().buildingNumber(), faker.address().streetAddress(), faker.address().city(),
				faker.address().state(), faker.numerify("#####"), faker.phoneNumber().cellPhone(),
				faker.phoneNumber().cellPhone(), "not required", "My_Alternate_Address");

		return addressdetailPojo;
	}
}
