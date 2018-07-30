/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flipmart.beans;

import com.flipmart.persistence.ColorProduct;
import com.flipmart.persistence.ColorProductId;
import com.flipmart.service.ColorProductServiceLocal;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author sahil
 */
@Stateless
public class ColorProductService implements ColorProductServiceLocal {

    private final EntityManager entityManager;
    private static EntityTransaction transactionObj;
  private static final Logger LOG = Logger.getLogger(ColorProductService.class.getName());
    public ColorProductService() {
        
        entityManager = Persistence.createEntityManagerFactory("flipmart")
                .createEntityManager();
        transactionObj = entityManager.getTransaction();
    }
  


    @Override
    public ColorProduct findColorProductById(ColorProductId colorProductId) {
        LOG.info("findColorProductById called for "+colorProductId.toString());
        ColorProduct colorProduct = entityManager.find(ColorProduct.class, colorProductId);
        return colorProduct;

    }
}
