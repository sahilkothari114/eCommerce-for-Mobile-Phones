package com.flipmart.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.flipmart.DatabaseOperations;

@Entity
@Table(name = "color")
public class Color {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "color_id")
	private long colorId;

	@Column(name = "color_name")
	private String colorName;

	public void setColorId(long colorId) {
		this.colorId = colorId;
	}

	public Color() {
	}

	public Color(String colorName) {
		this.colorName = colorName;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public long getColorId() {
		return colorId;
	}

	public void colorList(){
		new DatabaseOperations().testInsert();
	}
}

