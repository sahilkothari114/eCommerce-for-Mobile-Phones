/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flipmart.service;

import com.flipmart.persistence.Admin;
import javax.ejb.Local;

/**
 *
 * @author Shagufta
 */
@Local
public interface AdminServiceLocal {
    public Admin findAdminByEmailAndPassword(Admin admin);
}
