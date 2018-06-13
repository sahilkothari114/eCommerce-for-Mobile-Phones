package com.flipmart.beanImpl;

import javax.ejb.Stateless;

import com.flipmart.bean.UserManager;
import com.flipmart.eao.Users;

/**
 * @author Shagufta
 *
 */
@Stateless
public class UserManagerBean implements UserManager{

	@Override
	public Users findByUserId(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
