package com.flipmart.service;

import com.flipmart.persistence.Product;

public interface ProductService {

	public Product findByProductId(Long productId);
}
