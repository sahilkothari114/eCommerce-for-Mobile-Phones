package com.flipmart.beanImpl;

import javax.ejb.Stateless;

import com.flipmart.bean.ProductManager;
import com.flipmart.eao.Product;

/**
 * @author Shagufta
 *
 */
@Stateless
public class ProductManagerBean implements ProductManager{

	@Override
	public Product findByProductId(Long productId) {
		// TODO Auto-generated method stub
		return null;
	}

}
