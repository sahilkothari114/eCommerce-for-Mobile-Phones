package com.flipmart.actions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.flipmart.persistence.Users;
import com.flipmart.service.UserServiceLocal;
import com.flipmart.util.FlipmartConstants;
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
    private static HttpServletResponse response;
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(LoginAction.class);

    @Override
    public String execute() {
        // String sample = "Shagufta";
        return SUCCESS;
    }

    @Action(value = "validate")
    public void validateUser() throws IOException, JsonProcessingException {

        request = ServletActionContext.getRequest();
        String jsonResponse = IOUtils.toString(request.getInputStream(), FlipmartConstants.CHARACTER_ENCODING);

        ObjectMapper mapper = new ObjectMapper();
        LOGGER.info(" -> " + jsonResponse);

        Users user = mapper.readValue(jsonResponse, Users.class);

        Context ctx = null;
        try {
            ctx = new InitialContext();
            UserServiceLocal us = (UserServiceLocal) ctx.lookup("java:global/flipmart-webapp-ear/flipmart-webapp-ejb/UserService!com.flipmart.service.UserServiceLocal");
            Users validUser = us.findUserByEmailAndPassword(user);
            LOGGER.info("Valid user from Database: " + validUser);

            response = ServletActionContext.getResponse();
            response.setContentType("application/json");

            if (validUser != null) {
                String responseJSON = mapper.writeValueAsString(validUser);

                JsonNode jsonNode = mapper.readTree(responseJSON);
                ObjectNode objectNode = (ObjectNode) jsonNode;
                objectNode.put("valid", true);

                LOGGER.info("Response: " + objectNode.toString());

                response.getWriter().write(objectNode.toString());
            } else {
                String responseJSON = "{\"valid\":false}";
                response.getWriter().write(responseJSON);
            }
        } catch (NamingException ex) {
            //java.util.logging.Logger.getLogger(LoginAction.class.getName()).log(Level.SEVERE, null, ex);
            LOGGER.error(ex);
        }

    }

}
