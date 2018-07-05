package com.flipmart.service;

import com.flipmart.persistence.Product;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ProductServiceLocal {
        public boolean addProduct(Product item);
        public Product findByProductId(Long productId);
        public List<Product> getProducts();
}
