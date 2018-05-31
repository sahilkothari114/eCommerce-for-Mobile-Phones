package com.ecom.dao;

public class Product {

	private int productId;
	private String modelNo;
	private String ProductName;
	private int manufacturerId;
	private double price;
	private String os;
	private int ram;
	private double Camera;
	private String processor;
	private String description;
	private int stock;
	private boolean active;

	public Product() {
	}

	public Product(String modelNo, String ProductName, int manufacturerId, double price, String os, int ram,
			double Camera, String processor, String description, int stock) {
		this.modelNo = modelNo;
		this.ProductName = ProductName;
		this.manufacturerId = manufacturerId;
		this.price = price;
		this.os = os;
		this.ram = ram;
		this.Camera = Camera;
		this.processor = processor;
		this.description = description;
		this.stock = stock;
	}

	public int getProductId() {
		return productId;
	}

	public String getModelNo() {
		return modelNo;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String ProductName) {
		this.ProductName = ProductName;
	}

	public int getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(int manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public double getCamera() {
		return Camera;
	}

	public void setCamera(double Camera) {
		this.Camera = Camera;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
