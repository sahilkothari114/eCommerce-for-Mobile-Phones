/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flipmart.beans;

import javax.ejb.Stateless;

import com.flipmart.persistence.Users;
import com.flipmart.service.UserService;

/**
 *
 * @author Shagufta
 */
@Stateless(name="UserService")
public class UserServiceBean implements UserService {

	@Override
	public Users findByUserId(Long userId) {
		// TODO Auto-generated method stub
		System.out.println("Find user by id");
		return null;
	}

	@Override
	public void addUser(Users user) {
		// TODO Auto-generated method stub
		System.out.println("Add user");
	}

}
