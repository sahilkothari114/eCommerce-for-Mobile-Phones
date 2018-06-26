package com.flipmart.service;

import com.flipmart.persistence.Pincode;

public interface PincodeService {

	public Pincode findByPincode(Integer pincode);
}
