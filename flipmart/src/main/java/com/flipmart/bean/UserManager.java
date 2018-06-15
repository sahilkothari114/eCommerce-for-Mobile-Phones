package com.flipmart.bean;

import com.flipmart.eao.Users;

public interface UserManager {

	public Users findByUserId(Long userId);
	public void addUser(Users user);
}
