package com.flipmart.model;

public class ColorProduct {

	private long colorProductId;
	private ColorEntity color;
	private Product product;
	private int stock;

	public ColorProduct() {
	}

	public ColorProduct(ColorEntity color, Product product, int stock) {
		this.color = color;
		this.product = product;
		this.stock = stock;
	}

	public Product getProduct() {
		return product;
	}

	public void setProductId(Product product) {
		this.product = product;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public ColorEntity getColor() {
		return color;
	}

	public void setColor(ColorEntity color) {
		this.color = color;
	}

	public long getColorProductId() {
		return colorProductId;
	}

	public void setColorProductId(long colorProductId) {
		this.colorProductId = colorProductId;
	}
}
