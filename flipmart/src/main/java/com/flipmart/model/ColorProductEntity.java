package com.flipmart.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "color_product")
public class ColorProductEntity {

	@EmbeddedId
	private ColorProductId colorProductId;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("colorId")
	private ColorEntity color;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("productId")
	private ProductEntity product;

	@Column(name = "stock")
	private int stock;

	@Column(name = "active")
	private boolean active;

	public ColorProductEntity(ProductEntity product, ColorEntity color) {
		this.product = product;
		this.color = color;
		this.colorProductId = new ColorProductId(product.getProductId(), color.getColorId());
	}

	public ColorProductId getColorProductId() {
		return colorProductId;
	}

	public void setColorProductId(ColorProductId colorProductId) {
		this.colorProductId = colorProductId;
	}

	public ColorEntity getColor() {
		return color;
	}

	public void setColor(ColorEntity color) {
		this.color = color;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		ColorProductEntity that = (ColorProductEntity) o;
		return Objects.equals(color, that.color) && Objects.equals(product, that.product);
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, product);
	}

}
