package com.flipmart.actions;

import com.flipmart.dao.Admin;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

<<<<<<< HEAD
@Action(value = "Login", results = {@Result(name = "success" , location = "/View/login.jsp")})
public class LoginAction extends ActionSupport {
    
    private Admin adm;
=======
@Action(value = "login", results = {@Result(name = "success" , location = "/View/login.jsp")})
public class LoginAction extends ActionSupport {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Admin adm;
>>>>>>> e38e16daa5301536119ab5a368511cd910b6df2e
    
    @Override
    public String execute() {
        this.adm = new Admin("Palak","Mittal","admin@gmail.com","root",395007,"Vesu","9714773181","hiii picture");
        return SUCCESS;
    }

    public Admin getAdm() {
        return adm;
    }

    public void setAdm(Admin adm) {
        this.adm = adm;
    }

    
}
