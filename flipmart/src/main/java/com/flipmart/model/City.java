package com.flipmart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class City {

	@Id
	@Column(name = "city_id")
	private int cityId;

	@Column(name = "city_name")
	private String cityName;

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	@ManyToOne
	@JoinColumn(name = "state_id")
	private State state;

	public City() {

	}

	public City(String cityName, State state) {
		super();
		this.cityName = cityName;
		this.state = state;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public int getCityId() {
		return cityId;
	}

}
