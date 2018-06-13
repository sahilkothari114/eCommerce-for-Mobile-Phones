package com.flipmart.eao;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ColorProductId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "color_id")
	private long colorId;

	@Column(name = "product_id")
	private long productId;

	public ColorProductId(long productId, long colorId) {
		// TODO Auto-generated constructor stub
		this.colorId = colorId;
		this.productId = productId;
	}

	public ColorProductId() {
	}

	public long getColorId() {
		return colorId;
	}

	public void setColorId(long colorId) {
		this.colorId = colorId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		ColorProductId that = (ColorProductId) o;
		return Objects.equals(colorId, that.colorId) && Objects.equals(productId, that.productId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(colorId, productId);
	}
}
