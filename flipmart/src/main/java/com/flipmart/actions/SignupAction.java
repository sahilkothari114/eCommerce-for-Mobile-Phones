package com.flipmart.actions;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

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
import com.flipmart.beanImpl.UserManagerBean;
import com.flipmart.eao.City;
import com.flipmart.eao.Pincode;
import com.flipmart.eao.State;
import com.flipmart.eao.Users;
import com.flipmart.util.FlipmartConstants;
import com.flipmart.util.PasswordHash;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Shagufta
 *
 */
@Action(value = "signup", results = {
		@Result(name = FlipmartConstants.SUCCESS, location = FlipmartConstants.CLIENT_URI + "login.jsp") })
public class SignupAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	static final Logger logger = Logger.getLogger(SignupAction.class);
	static HttpServletRequest request;

	@EJB(beanName = "UserManagerBean")
	private UserManager userManager;

	@Override
	public String execute() {
		logger.info("Signup Action called");

		return SUCCESS;
	}

	@Action("/user")
	public void addUserDetails() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			request = ServletActionContext.getRequest();
			String jsonResponse = IOUtils.toString(request.getInputStream(), FlipmartConstants.CHARACTER_ENCODING);
			JsonNode data = mapper.readTree(jsonResponse);
			logger.info("Consuming data from client: " + data);

			createNewUser(data);

		} catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void createNewUser(JsonNode userDetails) throws NoSuchAlgorithmException, InvalidKeySpecException {
		// TODO Auto-generated method stub
		System.out.println("User Datils: " + userDetails);

		String password = new String(userDetails.get(FlipmartConstants.KEY_PASSWORD).textValue());
		
		password = PasswordHash.generatePasswordHash(password);

		State state = new State();
		state.setStateName("Gujarat");

		City city = new City();
		city.setState(state);
		city.setCityName("Nadiad");

		Pincode pincode = new Pincode();
		pincode.setPincode(387001);
		pincode.setCity(city);

		Users user = new Users();
		user.setFirstName(userDetails.get(FlipmartConstants.KEY_FIRST_NAME).textValue());
		user.setLastName(userDetails.get(FlipmartConstants.KEY_LAST_NAME).textValue());
		user.setEmail(userDetails.get(FlipmartConstants.KEY_EMAIL).textValue());
		user.setStreetAddress(userDetails.get(FlipmartConstants.KEY_STREET_ADDRESS).textValue());
		user.setContactNo(userDetails.get(FlipmartConstants.KEY_CONTACT_NUMBER).textValue());
		user.setPassword(password);
		user.setPincode(pincode);
		user.setActive(true);

		// userManager = new UserManagerBean();
		UserManagerBean bean = new UserManagerBean();
		bean.initialize();
		bean.addUser(user);
	}
}
