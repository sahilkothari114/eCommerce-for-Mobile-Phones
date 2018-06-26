package com.flipmart.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "color")
public class Color {

	@Id
	@Column(name = "color_id")
	private long colorId;

	@Column(name = "color_name")
	private String colorName;

	@ManyToMany(mappedBy = "colors")
	private List<Users> user = new ArrayList<Users>();

	@OneToMany(mappedBy = "color", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ColorProduct> colorProductList = new ArrayList<ColorProduct>();

	public List<ColorProduct> getProductColors() {
		return colorProductList;
	}

	public void setProductColors(List<ColorProduct> productColors) {
		this.colorProductList = productColors;
	}

	public List<Users> getUser() {
		return user;
	}

	public void setUser(List<Users> user) {
		this.user = user;
	}

	public long getColorId() {
		return colorId;
	}

	public void setColorId(long colorId) {
		this.colorId = colorId;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Color color = (Color) o;
		return Objects.equals(colorName, color.colorName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(colorName);
	}

}