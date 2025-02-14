package com.ui.pojo;

public class AddressDetailPOJO {
	
	private String companyName;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String postalcode;
	private String homePhone;
	private String mobilePhone;
	private String additionalInformation;
	private String assignNewAddress;
	
	public AddressDetailPOJO(String companyName, String address1, String address2, String city, String state,
			String postalcode, String homePhone, String mobilePhone, String additionalInformation,
			String assignNewAddress) {
		super();
		this.companyName = companyName;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.postalcode = postalcode;
		this.homePhone = homePhone;
		this.mobilePhone = mobilePhone;
		this.additionalInformation = additionalInformation;
		this.assignNewAddress = assignNewAddress;
	}

	

	public String getCompanyName() {
		return companyName;
	}

	public String getAddress1() {
		return address1;
	}

	public String getAddress2() {
		return address2;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public String getAdditionalInformation() {
		return additionalInformation;
	}

	public String getAssignNewAddress() {
		return assignNewAddress;
	}

	@Override
	public String toString() {
		return "AddressDetailPOJO [companyName=" + companyName + ", address1=" + address1 + ", address2=" + address2
				+ ", city=" + city + ", state=" + state + ", postalcode=" + postalcode + ", homePhone=" + homePhone
				+ ", mobilePhone=" + mobilePhone + ", additionalInformation=" + additionalInformation
				+ ", assignNewAddress=" + assignNewAddress + "]";
	}
	
}
