package com.flipmart.beanImpl;

import javax.ejb.Stateless;

import com.flipmart.bean.PincodeManager;
import com.flipmart.eao.Pincode;

/**
 * @author Shagufta
 *
 */
@Stateless
public class PincodeManagerBean implements PincodeManager{

	@Override
	public Pincode findByPincode(Integer pincode) {
		// TODO Auto-generated method stub
		return null;
	}

}
