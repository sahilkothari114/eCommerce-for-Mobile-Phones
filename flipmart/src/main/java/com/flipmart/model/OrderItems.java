package com.flipmart.model;

public class OrderItems {

	private ColorProduct colorProduct;
	private long orderId;

	public ColorProduct getColorProduct() {
		return colorProduct;
	}

	public void setColorProduct(ColorProduct colorProduct) {
		this.colorProduct = colorProduct;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

}
