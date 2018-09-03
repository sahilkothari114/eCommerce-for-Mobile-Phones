package com.flipmart.service;

import com.flipmart.persistence.Manufacturer;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Shagufta
 */
@Local
public interface ManufacturerServiceLocal {

	public Manufacturer findByManufacturerId(Long manufaturerId);
        public List<Manufacturer> getManufacturers();
}
