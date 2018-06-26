package com.flipmart.service;

import com.flipmart.persistence.Manufacturer;

public interface ManufacturerService {

	public Manufacturer findByManufacturerId(Long manufaturerId);
}
