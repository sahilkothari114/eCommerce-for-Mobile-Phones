/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flipmart.beans;

import com.flipmart.persistence.Color;
import com.flipmart.service.ColorServiceLocal;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author sahil
 */
public class ColorService implements ColorServiceLocal {

    private final EntityManager entityManager;
    private static EntityTransaction transactionObj;

    public ColorService() {
        entityManager = Persistence.createEntityManagerFactory("flipmart")
                .createEntityManager();
        transactionObj = entityManager.getTransaction();
    }

    @Override
    public Color findById(Long colorId) {
        Color color = entityManager.find(Color.class, colorId);
        return color;
    }

    @Override
    public void addColor(Color color) {
        entityManager.persist(color);
        transactionObj.commit();
    }
}
