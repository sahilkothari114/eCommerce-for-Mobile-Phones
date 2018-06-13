package com.flipmart.actions;

import javax.ejb.EJB;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.flipmart.bean.CartManager;
import com.opensymphony.xwork2.ActionSupport;

@Action(value = "cart", results = { @Result(name = "success", location = "/View/cart.jsp") })
public class CartAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private CartManager cartManager;

	@Override
	public String execute() {
		return SUCCESS;
	}
}
