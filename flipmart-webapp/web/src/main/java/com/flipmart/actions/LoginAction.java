package com.flipmart.actions;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipmart.service.UserServiceLocal;
import com.flipmart.util.FlipmartConstants;
import com.opensymphony.xwork2.ActionSupport;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Action(value = "login", results = {
    @Result(name = FlipmartConstants.SUCCESS, location = FlipmartConstants.CLIENT_URI + "login.jsp")})
public class LoginAction extends ActionSupport {

//        @EJB
//    private UserServiceLocal service;

    @Override
    public String execute() {
        System.out.println("Called");
        return SUCCESS;
    }
    static HttpServletRequest request;

    @Action("user")
    public void addUserDetails() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            request = ServletActionContext.getRequest();
            String jsonResponse = IOUtils.toString(request.getInputStream(), FlipmartConstants.CHARACTER_ENCODING);
            JsonNode data = mapper.readTree(jsonResponse);
            createNewUser(data);

        } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }

    }

    public void createNewUser(JsonNode userDetails) throws NoSuchAlgorithmException, InvalidKeySpecException {

        System.out.println("User Datils: " + userDetails);
//        service.addUser(new Users());
        Context ctx = null;
        try {
            ctx = new InitialContext();
            UserServiceLocal us = (UserServiceLocal) ctx.lookup("java:global/flipmart-webapp_-_ear/flipmart-webapp-ejb/UserService");
            us.addUser(null);
        } catch (NamingException e) {
            e.printStackTrace();
            // logger.log(Level.SEVERE,"Unable to retrieve the UserService.",e);
        } finally {
            if (ctx != null) {
                try {
                    ctx.close();
                } catch (Throwable t) {
                }
            }
        }

        // String password = new
        // String(userDetails.get(FlipmartConstants.KEY_PASSWORD).textValue());
        // password = PasswordHash.generatePasswordHash(password);

        /*
		 * State state = new State(); state.setStateName("Gujarat");
		 * 
		 * City city = new City(); city.setState(state); city.setCityName("Nadiad");
		 * 
		 * Pincode pincode = new Pincode(); pincode.setPincode(387001);
		 * pincode.setCity(city);
		 * 
		 * Users user = new Users();
		 * user.setFirstName(userDetails.get(FlipmartConstants.KEY_FIRST_NAME).textValue
		 * ());
		 * user.setLastName(userDetails.get(FlipmartConstants.KEY_LAST_NAME).textValue()
		 * ); user.setEmail(userDetails.get(FlipmartConstants.KEY_EMAIL).textValue());
		 * user.setStreetAddress(userDetails.get(FlipmartConstants.KEY_STREET_ADDRESS).
		 * textValue());
		 * user.setContactNo(userDetails.get(FlipmartConstants.KEY_CONTACT_NUMBER).
		 * textValue()); user.setPassword(password); user.setPincode(pincode);
		 * user.setActive(true);
		 * 
		 * // userManager = new UserManagerBean(); UserManagerBean bean = new
		 * UserManagerBean(); //bean.initialize(); bean.addUser(user);
         */
    }

}
