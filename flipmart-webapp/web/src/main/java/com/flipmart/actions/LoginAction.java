package com.flipmart.actions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipmart.persistence.City;
import com.flipmart.persistence.Pincode;
import com.flipmart.persistence.State;
import com.flipmart.persistence.Users;
import com.flipmart.service.PincodeServiceLocal;
import com.flipmart.service.UserServiceLocal;
import com.flipmart.util.FlipmartConstants;
import com.flipmart.util.PasswordHash;
import com.opensymphony.xwork2.ActionSupport;
import java.util.logging.Level;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import org.apache.log4j.Logger;

@Action(value = "login", results = {
    @Result(name = FlipmartConstants.SUCCESS, location = FlipmartConstants.CLIENT_URI + "login.jsp")})
public class LoginAction extends ActionSupport {

    private static HttpServletRequest request;
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(LoginAction.class);

    @Override
    public String execute() {

        return SUCCESS;
    }

    @Action("user")
    public void addUserDetails() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        ObjectMapper mapper = new ObjectMapper();

        request = ServletActionContext.getRequest();
        String jsonResponse = IOUtils.toString(request.getInputStream(), FlipmartConstants.CHARACTER_ENCODING);
        LOGGER.info("JSON DATA : " + jsonResponse);
        Users user = mapper.readValue(jsonResponse, Users.class);
        createNewUser(user);
    }

    public void createNewUser(Users userDetails) throws NoSuchAlgorithmException, InvalidKeySpecException {

        System.out.println("User Datils: " + userDetails);
        Context ctx = null;
        try {
            ctx = new InitialContext();
            UserServiceLocal us = (UserServiceLocal) ctx.lookup("java:global/flipmart-webapp-ear/flipmart-webapp-ejb/UserService!com.flipmart.service.UserServiceLocal");

            String password = userDetails.getPassword();
            password = PasswordHash.generatePasswordHash(password);
            userDetails.setPassword(password);

            State state = new State();
            state.setStateName("Rajasthan");

            City city = new City();
            city.setState(state);
            city.setCityName("jaipur");

            Pincode pincode = new Pincode();
            pincode.setPincode(387001);
            pincode.setCity(city);

            userDetails.setPincode(pincode);

            us.addUser(userDetails);
        } catch (NamingException e) {
            System.out.println(e.getMessage());
        } finally {
            if (ctx != null) {
                try {
                    ctx.close();
                } catch (NamingException t) {
                }
            }
        }
    }

    @Action("pincode")
    public void findPincode() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        request = ServletActionContext.getRequest();

        String jsonResponse = IOUtils.toString(request.getInputStream(), FlipmartConstants.CHARACTER_ENCODING);
        Pincode pincode = mapper.readValue(jsonResponse, Pincode.class);

        Context ctx = null;
        try {
            ctx = new InitialContext();
            PincodeServiceLocal pincodeService = (PincodeServiceLocal) ctx.lookup("java:global/flipmart-webapp-ear/flipmart-webapp-ejb/PincodeService!com.flipmart.service.PincodeServiceLocal");

            Pincode pincodeObject = pincodeService.findByPincode(pincode.getPincode());
            System.out.println("----------------------------------------");
            System.out.println(pincodeObject.getCity().getCityName());
            System.out.println(pincodeObject.getCity().getState().getStateName());
            System.out.println("----------------------------------------");
        } catch (NamingException e) {
            // logger.log(Level.SEVERE,"Unable to retrieve the UserService.",e);
            System.out.println("----" + e.getMessage());
        } finally {
            if (ctx != null) {
                try {
                    ctx.close();
                } catch (NamingException t) {
                }
            }
        }
    }

    @Action(value = "validate", results = {
        @Result(name = FlipmartConstants.SUCCESS, location = FlipmartConstants.CLIENT_URI + "products.jsp")})
    public String validateUser() throws IOException, JsonProcessingException {
        request = ServletActionContext.getRequest();
        String jsonResponse = IOUtils.toString(request.getInputStream(), FlipmartConstants.CHARACTER_ENCODING);

        ObjectMapper mapper = new ObjectMapper();
        LOGGER.info("JSON response -> " + jsonResponse);

        Users user = mapper.readValue(jsonResponse, Users.class);

        if (user != null) {
            Context ctx = null;
            try {
                ctx = new InitialContext();
                UserServiceLocal userService = (UserServiceLocal) ctx.lookup(FlipmartConstants.JNDI_LOOKUP + "UserService!com.flipmart.service.UserServiceLocal");

                Users us = userService.findByEmail(user.getEmail());

                String originalPassword = us.getPassword();
                String password = user.getPassword();
                boolean valid = PasswordHash.validatePassword(password, originalPassword);

                if (!valid) {
                    addActionError("Invalid username or password");
                } 
            } catch (NamingException | NoSuchAlgorithmException | InvalidKeySpecException ex) {
                //java.util.logging.Logger.getLogger(LoginAction.class.getName()).log(Level.SEVERE, null, ex);
                LOGGER.error(ex);
            }
            addActionError("Invalid username or password");
        }
        return FlipmartConstants.SUCCESS;
    }
}
