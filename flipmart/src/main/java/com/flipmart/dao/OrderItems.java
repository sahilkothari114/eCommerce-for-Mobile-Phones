package com.flipmart.dao;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "order_items")
public class OrderItems {

	private ColorProduct colorProduct;

	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long orderId;

	public OrderItems() {
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "color_product_id")
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
