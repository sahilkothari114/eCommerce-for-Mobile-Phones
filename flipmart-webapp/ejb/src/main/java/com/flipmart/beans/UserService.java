package com.flipmart.beans;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import com.flipmart.service.UserServiceLocal;
import javax.ejb.Stateless;

import com.flipmart.persistence.Users;

/**
 *
 * @author Shagufta
 */
@Stateless(name = "userService")
public class UserService implements UserServiceLocal {

	@Override
	public Users findByUserId(Long userId) {
		System.out.println("Find user by id");
		return null;
	}

	@Override
	public void addUser(Users user) {
		System.out.println("Add user");
	}

}
