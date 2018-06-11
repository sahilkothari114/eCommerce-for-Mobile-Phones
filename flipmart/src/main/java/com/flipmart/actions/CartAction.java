package com.flipmart.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.flipmart.config.DatabaseConfiguration;
import com.opensymphony.xwork2.ActionSupport;

@Action(value = "cart", results = { @Result(name = "success", location = "/View/cart.jsp") })
public class CartAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private CartEntity products;

	@Override
	public String execute() {
		//this.products = new CartEntity();
		
		/*ColorEntity color = new ColorEntity();
		color.setColorName("purple");
		products.setColor(color);
*/
		DatabaseConfiguration db = new DatabaseConfiguration();
		db.createEntity();
		db.testInsert();

		return SUCCESS;
	}

/*	public CartEntity getProducts() {
		return products;
	}*/

	/*
	 * public void setProducts(Cart products) { this.products = products; }
	 */
}
