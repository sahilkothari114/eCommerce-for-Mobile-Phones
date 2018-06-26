package com.flipmart.service;

import javax.ejb.Remote;

import com.flipmart.persistence.Users;

@Remote
public interface UserService {

	public Users findByUserId(Long userId);
	public void addUser(Users user);
}
