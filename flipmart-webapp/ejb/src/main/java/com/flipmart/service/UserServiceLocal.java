package com.flipmart.service;

import com.flipmart.persistence.Users;
import javax.ejb.Local;

@Local
public interface UserServiceLocal {
        public Users findUserByEmailAndPassword(Users user);
	public Users findByUserId(Long userId);
	public void addUser(Users user);
        public Users findByUserName(String userName);
}
