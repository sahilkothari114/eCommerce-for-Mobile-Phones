package com.flipmart.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pincode")
public class Pincode {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "pincode")
	private long pincode;

	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
}
