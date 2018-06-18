package com.flipmart.bean;

import javax.ejb.Remote;

import com.flipmart.eao.Users;

@Remote
public interface UserManager {

	public Users findByUserId(Long userId);
	public void addUser(Users user);
}
