package com.flipmart.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.flipmart.util.FlipmartConstants;
import com.opensymphony.xwork2.ActionSupport;

@Action(value = "userprofile", results = {
		@Result(name = FlipmartConstants.SUCCESS, location = FlipmartConstants.CLIENT_URI + "profile.jsp") })
public class UserProfile extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Override
	public String execute() {
		System.out.println("Called");
		return SUCCESS;
	}

}
