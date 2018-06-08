package com.flipmart.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.flipmart.config.DatabaseConfiguration;
import com.flipmart.model.Cart;
import com.opensymphony.xwork2.ActionSupport;

@Action(value = "cart", results = {@Result(name = "success" , location = "/View/cart.jsp")})
public class CartAction extends ActionSupport {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Cart products;
    
    @Override
    public String execute() {
        this.products = new Cart(1, 1);
        
        DatabaseConfiguration db = new DatabaseConfiguration();
		db.createEntity();
		db.testInsert();
		
        return SUCCESS;
    }

    public Cart getProducts() {
        return products;
    }

    /*public void setProducts(Cart products) {
        this.products = products;
    }*/
}
