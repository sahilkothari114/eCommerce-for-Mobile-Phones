package edu.ECoMoPho.model;

public class Manufacturer {
	private int manufacturerId;
	private String name;
	private boolean active;
	public Manufacturer(String name) {
		super();
		this.name = name;
	}
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
