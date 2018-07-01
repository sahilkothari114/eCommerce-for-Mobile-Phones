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
import com.flipmart.persistence.City;
import com.flipmart.persistence.Pincode;
import com.flipmart.persistence.State;
import com.flipmart.persistence.Users;
import com.flipmart.service.UserServiceLocal;
import com.flipmart.util.FlipmartConstants;
import com.flipmart.util.PasswordHash;
import com.opensymphony.xwork2.ActionSupport;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Action(value = "login", results = {
    @Result(name = FlipmartConstants.SUCCESS, location = FlipmartConstants.CLIENT_URI + "login.jsp")})
public class LoginAction extends ActionSupport {

    static HttpServletRequest request;
    private static final long serialVersionUID = 1L;

    @Override
    public String execute() {
        System.out.println("Called");
        return SUCCESS;
    }

    @Action("user")
    public void addUserDetails() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        ObjectMapper mapper = new ObjectMapper();

        request = ServletActionContext.getRequest();
        String jsonResponse = IOUtils.toString(request.getInputStream(), FlipmartConstants.CHARACTER_ENCODING);
        System.out.println(jsonResponse);

        /*try {
            Users user1 = mapper.readValue(jsonData, Users.class);

            System.out.println("Palak");
            System.out.println(user1);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        JsonNode data = mapper.readTree(jsonResponse);
        // logger.info("Consuming data from client: " + data);
        System.out.println("Creating user");
        createNewUser(data);
    }

    public void createNewUser(JsonNode userDetails) throws NoSuchAlgorithmException, InvalidKeySpecException {

        System.out.println("User Datils: " + userDetails);
//        service.addUser(new Users());
        Context ctx = null;
        try {
            ctx = new InitialContext();
            UserServiceLocal us = (UserServiceLocal) ctx.lookup("java:global/flipmart-webapp-ear/flipmart-webapp-ejb/UserService!com.flipmart.service.UserServiceLocal");

            String password = userDetails.get(FlipmartConstants.KEY_PASSWORD).textValue();
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
            user.setLastName(userDetails.get(FlipmartConstants.KEY_LAST_NAME).textValue()
            );
            user.setEmail(userDetails.get(FlipmartConstants.KEY_EMAIL).textValue());
            user.setStreetAddress(userDetails.get(FlipmartConstants.KEY_STREET_ADDRESS).
                    textValue());
            user.setContactNo(userDetails.get(FlipmartConstants.KEY_CONTACT_NUMBER).
                    textValue()
            );
            user.setPassword(password);
            user.setPincode(pincode);
            user.setActive(true);

            us.addUser(user);
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

        // userManager = new UserManagerBean(); UserManagerBean bean = new
        //UserManagerBean(); //bean.initialize(); bean.addUser(user);
    }

}
