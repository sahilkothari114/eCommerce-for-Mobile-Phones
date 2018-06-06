package com.flipmart.actions;

import com.flipmart.DatabaseOperations;
import com.flipmart.dao.Cart;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

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
        System.out.println("Test");
        DatabaseOperations db = new DatabaseOperations();
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
