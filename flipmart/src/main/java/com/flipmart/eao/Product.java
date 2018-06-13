package com.flipmart.eao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "product_id")
	private long productId;

	@Column(name = "model_no")
	private String modelNo;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "price")
	private double price;

	@Column(name = "OS")
	private String os;

	@Column(name = "RAM")
	private int ram;

	@Column(name = "camera")
	private double camera;

	@Column(name = "processor")
	private String processor;

	@Column(name = "description")
	private String description;

	@Column(name = "active")
	private boolean active;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "manufaturer_id")
	private Manufacturer manufacturer;

	@ManyToMany(mappedBy = "products")
	private List<Users> user = new ArrayList<Users>();

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ColorProduct> productColorList = new ArrayList<>();

	public List<ColorProduct> getProductColor() {
		return productColorList;
	}

	public void setProductColor(List<ColorProduct> productColor) {
		this.productColorList = productColor;
	}

	public List<Users> getUser() {
		return user;
	}

	public void setUser(List<Users> user) {
		this.user = user;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getModelNo() {
		return modelNo;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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
		return camera;
	}

	public void setCamera(double camera) {
		this.camera = camera;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public void addColor(Color color) {
		ColorProduct colorProduct = new ColorProduct(this, color);
		productColorList.add(colorProduct);
		color.getProductColors().add(colorProduct);
	}

	public void removeColor(Color color) {
		for (Iterator<ColorProduct> iterator = productColorList.iterator(); iterator.hasNext();) {
			ColorProduct colorProducts = iterator.next();

			if (colorProducts.getProduct().equals(this) && colorProducts.getColor().equals(color)) {
				iterator.remove();
				colorProducts.getColor().getProductColors().remove(colorProducts);
				colorProducts.setProduct(null);
				colorProducts.setColor(null);
			}
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		Product product = (Product) o;
		return Objects.equals(modelNo, product.modelNo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(modelNo);
	}
}
