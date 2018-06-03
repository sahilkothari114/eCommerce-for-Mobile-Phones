package com.flipmart.dao;

public class ColorProduct {

	private long colorProductId;
	private Color color;
	private Product product;
	private int stock;

	public ColorProduct() {
	}

	public ColorProduct(Color color, Product product, int stock) {
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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public long getColorProductId() {
		return colorProductId;
	}

	public void setColorProductId(long colorProductId) {
		this.colorProductId = colorProductId;
	}
}
