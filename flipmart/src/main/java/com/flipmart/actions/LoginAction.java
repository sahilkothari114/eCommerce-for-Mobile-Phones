package com.flipmart.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Action(value = "login", results = { @Result(name = "success", location = "/View/login.jsp") })
public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Override
	public String execute() {
		
		return SUCCESS;
	}

}
