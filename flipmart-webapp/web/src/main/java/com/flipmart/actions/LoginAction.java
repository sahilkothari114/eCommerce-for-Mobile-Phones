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
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.flipmart.persistence.City;
import com.flipmart.persistence.Pincode;
import com.flipmart.persistence.State;
import com.flipmart.persistence.Users;
import com.flipmart.service.PincodeServiceLocal;
import com.flipmart.service.UserServiceLocal;
import com.flipmart.util.FlipmartConstants;
import com.opensymphony.xwork2.ActionSupport;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletResponse;
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

    @Action("pincode")
    public void findPincode() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        request = ServletActionContext.getRequest();
        String jsonResponse = IOUtils.toString(request.getInputStream(), FlipmartConstants.CHARACTER_ENCODING);

        LOGGER.info("jsonResponse : " + jsonResponse);
        JsonNode data = mapper.readTree(jsonResponse);
        long pincode = 0;
            if(data.get("pincode").get("pincode")!=null)
                pincode= data.get("pincode").get("pincode").asLong();
        
             
        //System.out.println("pincode fron json= " + pincode);
        response = ServletActionContext.getResponse();
        response.setContentType(FlipmartConstants.CONTENT_TYPE);
        LOGGER.info("response:" + response);

        response.getWriter().write(findPincode(pincode).toString());
    }

    
    public JsonNode findPincode(long pincode) throws JsonProcessingException, IOException {
        //LOGGER.info("Pincode : " + pincode);
        System.out.println("pincode from json = " + pincode);
        ObjectMapper mapper = new ObjectMapper();
        Context ctx = null;
        try {
            ctx = new InitialContext();
            PincodeServiceLocal pincodeService = (PincodeServiceLocal) ctx.lookup("java:global/flipmart-webapp-ear/flipmart-webapp-ejb/PincodeService!com.flipmart.service.PincodeServiceLocal");

            Pincode pincodeObject = pincodeService.findByPincode(pincode);
            JsonNode responseData = null;
            if (pincodeObject != null) {
                String jsonInString = mapper.writeValueAsString(pincodeObject);
                responseData = mapper.readTree(jsonInString);

                ObjectNode objectNode = (ObjectNode) responseData;
                objectNode.put("valid", true);

                LOGGER.info("Response: " + objectNode.toString());

//                response.getWriter().write(objectNode.toString());
            } else {
                String responseJSON = "{\"valid\":false}";
                responseData = mapper.readTree(responseJSON);
            }

            // {"pincode":310041,"city":{"cityId":1,"cityName":"udaipur","state":{"stateId":1,"stateName":"rajasthan"}}}
            return responseData;
        } catch (NamingException e) {
            // logger.log(Level.SEVERE,"Unable to retrieve the UserService.",e);
            LOGGER.info("----" + e.getMessage());
        } finally {
            if (ctx != null) {
                try {
                    ctx.close();
                } catch (NamingException t) {
                }
            }
        }
        return null;
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

                LOGGER.info("Respinse: " + objectNode.toString());

                response.getWriter().write(objectNode.toString());
            } else {
                String responseJSON = "{\"valid\":false}";
                response.getWriter().write(responseJSON);
            }

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
