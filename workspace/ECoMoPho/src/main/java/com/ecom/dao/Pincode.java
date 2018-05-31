package com.ecom.dao;

public class Pincode {
	private int pincode;
	private int cityId;
	public Pincode(int pincode, int cityId) {
		super();
		this.pincode = pincode;
		this.cityId = cityId;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
}
