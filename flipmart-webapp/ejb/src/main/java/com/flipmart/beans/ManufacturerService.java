/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flipmart.beans;

import com.flipmart.persistence.Manufacturer;
import com.flipmart.service.ManufacturerServiceLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.apache.log4j.Logger;

/**
 *
 * @author Shagufta
 */
@Stateless
public class ManufacturerService implements ManufacturerServiceLocal{
    
     private final EntityManager entityManager;
    private static EntityTransaction transactionObj;

    private static final Logger LOGGER = Logger.getLogger(ManufacturerService.class);

    public ManufacturerService() {
        entityManager = Persistence.createEntityManagerFactory("flipmart")
                .createEntityManager();
        transactionObj = entityManager.getTransaction();
    }

    @Override
    public Manufacturer findByManufacturerId(Long manufaturerId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Manufacturer> getManufacturers() {
        if (!transactionObj.isActive()) {
            transactionObj.begin();
        }
        
        List<Manufacturer> manufacturers = new ArrayList<>();
        
        manufacturers = entityManager.createNamedQuery("findAll").getResultList();
       // System.out.println("*********"+manufacturers);
        return manufacturers;
    }
    
}
