package com.flipmart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "color")
public class ColorEntity {

	@Id
	@Column(name = "color_id")
	private int colorId;

	@Column(name = "color_name")
	private String colorName;

	public int getId() {
		return colorId;
	}

	public void setId(int colorId) {
		this.colorId = colorId;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

}