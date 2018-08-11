/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flipmart.utils;

import com.flipmart.persistence.Admin;
import com.flipmart.persistence.Users;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import org.apache.log4j.Logger;

/**
 *
 * @author Shagufta
 */
public class UserValidation {

    private static final Logger LOGGER = Logger.getLogger(UserValidation.class);

    public static Boolean verifyUser(Object object, String password) {

        String className = object.getClass().getName();

        boolean valid = false;
        try {
            LOGGER.info("calling password hash");

            if (className.equals("Users")) {
                Users user = (Users) object;
                String verifyPassword = user.getPassword();
                valid = PasswordHash.validatePassword(password, verifyPassword);
            } else {
                Admin admin = (Admin) object;
                String verifyPassword = admin.getPassword();
                valid = PasswordHash.validatePassword(password, verifyPassword);
            }

            LOGGER.info("User valid? " + valid);
            return valid;
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            LOGGER.error(ex);
        }
        return valid;
    }
}
