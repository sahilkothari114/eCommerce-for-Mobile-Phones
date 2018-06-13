package com.flipmart.bean;

import com.flipmart.eao.Pincode;

public interface PincodeManager {

	public Pincode findByPincode(Integer pincode);
}
