package com.flipmart.actions;

import com.flipmart.dao.Cart;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

@Action(value = "Cart", results = {@Result(name = "success" , location = "/View/cart.jsp")})
public class CartAction extends ActionSupport {
    
    private Cart products;
    
    @Override
    public String execute() {
        this.products = new Cart(1, 1);
        return SUCCESS;
    }

    public Cart getProducts() {
        return products;
    }

    public void setProducts(Cart products) {
        this.products = products;
    }
}
