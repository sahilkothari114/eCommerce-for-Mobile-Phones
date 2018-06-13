package com.flipmart.bean;

import com.flipmart.eao.Product;

public interface ProductManager {

	public Product findByProductId(Long productId);
}
