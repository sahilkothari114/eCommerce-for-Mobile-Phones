package com.flipmart.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Action(value = "cart", results = { @Result(name = "success", location = "/View/cart.jsp") })
public class CartAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	@Override
	public String execute() {
		/*DatabaseConfiguration configuration = new DatabaseConfiguration();
		configuration.createEntity();*/
		System.out.println("In Cart");
		return SUCCESS;
	}
}
