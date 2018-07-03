package com.flipmart.actions;

import com.fasterxml.jackson.databind.JsonNode;
import com.flipmart.persistence.Users;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.flipmart.util.FlipmartConstants;
import com.opensymphony.xwork2.ActionSupport;

@Action(value = "userprofile", results = {
		@Result(name = FlipmartConstants.SUCCESS, location = FlipmartConstants.CLIENT_URI + "profile.jsp") })
public class UserProfileAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Override
	public String execute() {
		System.out.println("Called");
		return SUCCESS;
	}
        
        @Action("userdetails")
        public JsonNode fetchUserDetails(String userName){
            
            return null;
        }

}
