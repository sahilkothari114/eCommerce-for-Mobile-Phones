package com.flipmart.persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "color")
public class Color implements Serializable{

	@Id
        @GeneratedValue(strategy=GenerationType.SEQUENCE)
        @SequenceGenerator(name="color_SEQ", allocationSize=1)
	@Column(name = "color_id")
	private long colorId;

	@Column(name = "color_name")
	private String colorName;

//	@ManyToMany(mappedBy = "colors")
//	private List<Users> user = new ArrayList<Users>();

	@OneToMany(mappedBy = "color", cascade = CascadeType.ALL, orphanRemoval = true)
        @JoinColumn(name = "color_id")
	private List<ColorProduct> colorProductList = new ArrayList<ColorProduct>();

	public List<ColorProduct> getProductColors() {
		return colorProductList;
	}

	public void setProductColors(List<ColorProduct> productColors) {
		this.colorProductList = productColors;
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

    @Override
    public String toString() {
        return "Color{" + "colorId=" + colorId + ", colorName=" + colorName + ", colorProductList=" + colorProductList + '}';
    }

}