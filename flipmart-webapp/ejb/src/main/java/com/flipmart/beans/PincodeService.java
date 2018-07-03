/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flipmart.beans;

import com.flipmart.persistence.Pincode;
import com.flipmart.service.PincodeServiceLocal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author sahil
 */
@Stateless
public class PincodeService implements PincodeServiceLocal{
    private EntityManager entityManager;
    private static EntityTransaction transactionObj;

    public PincodeService() {
                entityManager = Persistence.createEntityManagerFactory("flipmart")
                .createEntityManager();
        transactionObj = entityManager.getTransaction();
    }
    
    @Override
    public Pincode findByPincode(Long pincode) {
        System.out.println("pin - "+pincode);
        
        Pincode Resultpincode = entityManager.find(Pincode.class,pincode);
       
        return Resultpincode;  
    }
}
