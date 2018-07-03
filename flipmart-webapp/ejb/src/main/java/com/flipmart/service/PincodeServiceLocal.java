/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flipmart.service;

import com.flipmart.persistence.Pincode;
import javax.ejb.Local;

/**
 *
 * @author sahil
 */
@Local
public interface PincodeServiceLocal {
    public Pincode findByPincode(Long pincode);
}

