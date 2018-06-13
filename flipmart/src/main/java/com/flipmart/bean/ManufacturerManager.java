package com.flipmart.bean;

import com.flipmart.eao.Manufacturer;

public interface ManufacturerManager {

	public Manufacturer findByManufacturerId(Long manufaturerId);
}
