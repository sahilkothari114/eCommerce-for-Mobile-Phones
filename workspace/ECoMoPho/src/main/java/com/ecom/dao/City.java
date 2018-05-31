package com.ecom.dao;

public class City {
	private int cityId;
	private String cityName;
	private int stateId;
	public City(String cityName, int stateId) {
		super();
		this.cityName = cityName;
		this.stateId = stateId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public int getCityId() {
		return cityId;
	}
	
}
