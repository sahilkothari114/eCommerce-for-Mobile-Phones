package com.flipmart.actions;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.jboss.logging.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipmart.bean.UserManager;
import com.flipmart.util.FlipmartConstants;
import com.opensymphony.xwork2.ActionSupport;

@Action(value = "signup", results = { @Result(name = "success", location = "/View/login.jsp") })
public class SignupAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final Logger logger = Logger.getLogger(SignupAction.class);
	static HttpServletRequest request;

	@EJB
	private UserManager userManager;

	@Override
	public String execute() {
		logger.info("Signup Action called");

		return SUCCESS;
	}

	@Action("/user")
	public void getUserDetails() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			request = ServletActionContext.getRequest();
			String jsonResponse = IOUtils.toString(request.getInputStream(),FlipmartConstants.CHARACTER_ENCODING);
			JsonNode data = mapper.readTree(jsonResponse);
			System.out.println(data);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
