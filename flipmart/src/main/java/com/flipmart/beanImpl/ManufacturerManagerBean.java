package com.flipmart.beanImpl;

import javax.ejb.Stateless;

import com.flipmart.bean.ManufacturerManager;
import com.flipmart.eao.Manufacturer;

/**
 * @author Shagufta
 *
 */
@Stateless
public class ManufacturerManagerBean implements ManufacturerManager{

	@Override
	public Manufacturer findByManufacturerId(Long manufaturerId) {
		// TODO Auto-generated method stub
		return null;
	}

}
