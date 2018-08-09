package com.flipmart.persistence;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class City implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
        @SequenceGenerator(name="city_SEQ", allocationSize=1)
	@Column(name = "city_id")
	private long cityId;

	@Column(name = "city_name")
	private String cityName;

	@ManyToOne
	@JoinColumn(name = "state_id")
	private State state;


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

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

    @Override
    public String toString() {
        return "City{" + "cityId=" + cityId + ", cityName=" + cityName + ", state=" + state + '}';
    }

}
