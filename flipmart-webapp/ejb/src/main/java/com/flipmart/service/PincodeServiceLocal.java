package com.flipmart.service;

import com.flipmart.persistence.Pincode;
import javax.ejb.Local;

/**
 *
 * @author sahil
 */
@Local
public interface PincodeServiceLocal {
    public Pincode findByPincode(Long pincode);
}

