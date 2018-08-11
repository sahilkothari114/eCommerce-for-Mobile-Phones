/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flipmart.actions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipmart.persistence.City;
import com.flipmart.persistence.Pincode;
import com.flipmart.persistence.State;
import com.flipmart.persistence.Users;
import com.flipmart.service.UserServiceLocal;
import com.flipmart.util.FlipmartConstants;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;

/**
 *
 * @author Sahil
 */
public class CreateUserAction {

    private static HttpServletRequest request;
    private static final Logger LOGGER = Logger.getLogger(LoginAction.class);

    @Action("user")
    public void addUserDetails() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        ObjectMapper mapper = new ObjectMapper();

        request = ServletActionContext.getRequest();

        String jsonResponse = IOUtils.toString(request.getInputStream(), FlipmartConstants.CHARACTER_ENCODING);
        LOGGER.info("JSON DATA : " + jsonResponse);
        Users user = mapper.readValue(jsonResponse, Users.class);
        createNewUser(user);
        //findPincode(310041);
    }

    public void createNewUser(Users userDetails) throws NoSuchAlgorithmException, InvalidKeySpecException {

        System.out.println("User Datils: " + userDetails);

        Context ctx = null;
        try {
            ctx = new InitialContext();
            UserServiceLocal us = (UserServiceLocal) ctx.lookup("java:global/flipmart-webapp-ear/flipmart-webapp-ejb/UserService!com.flipmart.service.UserServiceLocal");

            //String password = userDetails.getPassword();
            //password = PasswordHash.generatePasswordHash(password);
            userDetails.setPassword(userDetails.getPassword());

            State state = new State();
            state.setStateName("Rajasthan");

            City city = new City();
            city.setState(state);
            city.setCityName("jaipur");

            Pincode pincode = new Pincode();
            pincode.setPincode(310041);
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
}
