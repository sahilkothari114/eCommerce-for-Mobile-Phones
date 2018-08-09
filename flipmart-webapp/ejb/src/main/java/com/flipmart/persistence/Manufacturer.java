package com.flipmart.persistence;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "manufacturer")
public class Manufacturer implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
        @SequenceGenerator(name="manufacturer_SEQ", allocationSize=1)
	@Column(name = "manufacturer_id")
	private long manufacturerId;

	@Column(name = "name")
	private String name;

	@Column(name = "active")
	private boolean active;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public long getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(long manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

    @Override
    public String toString() {
        return "Manufacturer{" + "manufacturerId=" + manufacturerId + ", name=" + name + ", active=" + active + '}';
    }

}
