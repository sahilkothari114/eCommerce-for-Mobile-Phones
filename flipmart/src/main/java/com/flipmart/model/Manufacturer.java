package com.flipmart.model;

public class Manufacturer {
	
	private int manufacturerId;
	private String name;
	private boolean active;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getManufacturerId() {
		return manufacturerId;
	}
}
