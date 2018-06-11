package com.flipmart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class CityEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name = "city_id")
	private long cityId;

	@Column(name = "city_name")
	private String cityName;

	@ManyToOne
	@JoinColumn(name = "state_id")
	private StateEntity state;


	public long getCityId() {
		return cityId;
	}

	public void setCityId(long cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public StateEntity getState() {
		return state;
	}

	public void setState(StateEntity state) {
		this.state = state;
	}

}
