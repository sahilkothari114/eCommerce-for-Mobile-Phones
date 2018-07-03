package com.flipmart.actions;

import com.fasterxml.jackson.core.JsonProcessingException;
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
import com.flipmart.persistence.City;
import com.flipmart.persistence.Pincode;
import com.flipmart.persistence.State;
import com.flipmart.persistence.Users;
import com.flipmart.service.UserServiceLocal;
import com.flipmart.util.FlipmartConstants;
import com.flipmart.util.PasswordHash;
import com.opensymphony.xwork2.ActionSupport;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.log4j.Logger;

@Action(value = "login", results = {
    @Result(name = FlipmartConstants.SUCCESS, location = FlipmartConstants.CLIENT_URI + "login.jsp")})
public class LoginAction extends ActionSupport {

    private static HttpServletRequest request;
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(LoginAction.class);

    @Override
    public String execute() {

        return SUCCESS;
    }

    @Action("user")
    public void addUserDetails() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        ObjectMapper mapper = new ObjectMapper();

        request = ServletActionContext.getRequest();
        String jsonResponse = IOUtils.toString(request.getInputStream(), FlipmartConstants.CHARACTER_ENCODING);
        System.out.println("JSON DATA : " + jsonResponse);
        try {
            Users user1 = mapper.readValue(jsonResponse, Users.class);

            System.out.print("Object : ");
            System.out.println(user1);
        } 
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createNewUser(Users user) throws NoSuchAlgorithmException, InvalidKeySpecException {

        logger.info(user);
        Context ctx = null;
        try {
            ctx = new InitialContext();
            UserServiceLocal us = (UserServiceLocal) ctx.lookup("java:global/flipmart-webapp-ear/flipmart-webapp-ejb/UserService!com.flipmart.service.UserServiceLocal");

            String password = user.getPassword();
            user.setPassword(PasswordHash.generatePasswordHash(password));
            us.addUser(user);
            
        } catch (NamingException e) {
            logger.error(e);
        } finally {
            if (ctx != null) {
                try {
                    ctx.close();
                } catch (NamingException t) {
                    logger.error(t);
                }
            }
        }
    }

    @Action("validate")
    public void validateUser() throws IOException,JsonProcessingException{
            request = ServletActionContext.getRequest();
            String jsonResponse = IOUtils.toString(request.getInputStream(), FlipmartConstants.CHARACTER_ENCODING);
            ObjectMapper mapper = new ObjectMapper();   
            System.out.println("-> " + jsonResponse);
            Users user1 = mapper.readValue(jsonResponse, Users.class);            
            System.out.println(user1);
    }
}
