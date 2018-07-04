
package com.flipmart.beans;

import com.flipmart.persistence.Product;
import com.flipmart.service.ProductServiceLocal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.apache.log4j.Logger;

/**
 *
 * @author jayesh
 * 
 * 
 * Testing
 */
@Stateless
public class ProductService implements ProductServiceLocal{
    
    private final EntityManager entityManager;
    private static EntityTransaction transactionObj;

    private static final Logger logger = Logger.getLogger(UserService.class);

    public ProductService() 
    {
        entityManager = Persistence.createEntityManagerFactory("flipmart").createEntityManager();
        transactionObj = entityManager.getTransaction();
    }

    @Override
    public Product findByProductId(Long productId) {        
        return entityManager.find(Product.class, productId);
    }

    @Override
    public boolean addProduct(Product item) {
        logger.info("Begining transaction");
        try
        {
            if (!transactionObj.isActive()) {
                transactionObj.begin();
            }
            logger.info("Persisting Product");
            entityManager.persist(item);

            logger.info("Persisting user success");
            transactionObj.commit();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public List<Product> getProducts() {
        System.out.println("\n\n\n\n\nall Products");
        return entityManager.createQuery("select e from Product e").getResultList();
    }
    
}
