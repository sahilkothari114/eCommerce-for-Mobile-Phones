package com.flipmart.persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "color_product")
public class ColorProduct implements Serializable{

	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.SEQUENCE)
	 * 
	 * @Column(name = "color_product_id") private long id;
	 * 
	 * public long getId() { return id; }
	 * 
	 * public void setId(long id) { this.id = id; }
	 */

	@EmbeddedId
	private ColorProductId colorProductId;

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@MapsId("colorId")
        @JoinColumn(name = "color_id")
	private Color color;

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@MapsId("productId")
        @JoinColumn(name = "product_id")
	private Product product;

	@Column(name = "stock")
	private int stock;

	@Column(name = "active")
	private boolean active;
        
        @ManyToMany(mappedBy = "colorProductCart",cascade = CascadeType.ALL)
	private List<Users> user = new ArrayList<Users>();
        
        @ManyToMany(mappedBy = "colorProductOrder",cascade = CascadeType.ALL)
	private List<Order> OrderList = new ArrayList<Order>();
        
        
        public List<Users> getUser() {
            return user;
        }

        public void setUser(List<Users> user) {
            this.user = user;
        }

        public List<Order> getOrderList() {
            return OrderList;
        }

        public void setOrderList(List<Order> OrderList) {
            this.OrderList = OrderList;
        }

	public ColorProduct(Product product, Color color) {
		this.product = product;
		this.color = color;
		this.colorProductId = new ColorProductId(product.getProductId(), color.getColorId());
	}
	public ColorProduct() {
	}	

	public ColorProductId getColorProductId() {
		return colorProductId;
	}


	public void setColorProductId(ColorProductId colorProductId) {
		this.colorProductId = colorProductId;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
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

		ColorProduct that = (ColorProduct) o;
		return Objects.equals(color, that.color) && Objects.equals(product, that.product);
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, product);
	}

}
