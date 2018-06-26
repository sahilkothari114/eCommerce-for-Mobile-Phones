package com.flipmart.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.flipmart.util.FlipmartConstants;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Shagufta
 *
 */
@Action(value = "product", results = {
		@Result(name = FlipmartConstants.SUCCESS, location = FlipmartConstants.CLIENT_URI + "products.jsp") })
public class ProductAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	//static final Logger logger = Logger.getLogger(SignupAction.class);
	

	@Override
	public String execute() {
		System.out.println("Signup Action called");

		return SUCCESS;
	}
}
