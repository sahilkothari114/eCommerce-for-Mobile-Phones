package com.flipmart.actions;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipmart.persistence.Users;
import com.flipmart.service.UserServiceLocal;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.flipmart.util.FlipmartConstants;
import com.opensymphony.xwork2.ActionSupport;
import java.io.IOException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

@Action(value = "userprofile", results = {
    @Result(name = FlipmartConstants.SUCCESS, location = FlipmartConstants.CLIENT_URI + "profile.jsp")})
public class UserProfileAction extends ActionSupport {

    private static final long serialVersionUID = 12563256L;
    private static HttpServletRequest request;
    private static HttpServletResponse response;
    private static final Logger LOGGER = Logger.getLogger(UserProfileAction.class);

    @Override
    public String execute() {
        LOGGER.info("Profile Called");
 
        /*try {
            fetchUserDetails();
        updateUserDetails();
        } catch (IOException ex) {
            LOGGER.error(ex);
        }*/
        return SUCCESS;
    }

    /*public void fetchUserDetails() throws IOException {
        LOGGER.info("user details called");
        return SUCCESS;
    }

    @Action("userdetails")
    public JsonNode fetchUserDetails() throws IOException {
        logger.info("user details called");

        ObjectMapper mapper = new ObjectMapper();
        request = ServletActionContext.getRequest();
        String jsonResponse = IOUtils.toString(request.getInputStream(), FlipmartConstants.CHARACTER_ENCODING);

        JsonNode data = mapper.readTree(jsonResponse);

        String userId = data.get("userId").asText();
        LOGGER.info("user id: " + userId);

        response = ServletActionContext.getResponse();
        response.setContentType(FlipmartConstants.CONTENT_TYPE);
        JsonNode responseJSON = fetchUserDetails(userId);

        LOGGER.info("response:" + responseJSON);
        response.getWriter().write(responseJSON.toString());
    }

    private JsonNode fetchUserDetails(String userId) {
        Context ctx = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            ctx = new InitialContext();
            UserServiceLocal user = (UserServiceLocal) ctx.lookup(FlipmartConstants.JNDI_LOOKUP + "UserService!com.flipmart.service.UserServiceLocal");

            Users us = user.findByUserId(Long.valueOf(userId));

            try {
                String json = mapper.writeValueAsString(us);
                JsonNode data = mapper.readTree(json);
                LOGGER.info("response: " + data);
                return data;
            } catch (JsonProcessingException ex) {
                LOGGER.error(ex);
            } catch (IOException ex) {
                LOGGER.error(ex);
            }
        } catch (NamingException e) {
            LOGGER.error(e);
        } finally {
            if (ctx != null) {
                try {
                    ctx.close();
                } catch (NamingException t) {
                    LOGGER.error(t);
                }
            }
        }
        return null;
    }*/

    @Action("updateuser")
    public void updateUserDetails() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        request = ServletActionContext.getRequest();
        String jsonResponse = IOUtils.toString(request.getInputStream(), FlipmartConstants.CHARACTER_ENCODING);

        Users updateDetails = mapper.readValue(jsonResponse, Users.class);
       /* Users updateDetails = new Users();
        updateDetails.setUserId(102);
        updateDetails.setContactNo("98989898989");
        updateDetails.setEmail("abc@gmail.com");
        updateDetails.setFirstName("Shagufta");
        updateDetails.setLastName("Shaikh");
        updateDetails.setPassword("test");
        updateDetails.setActive(true);*/
        
        if (updateDetails != null) {
            Context ctx = null;
            try {
                ctx = new InitialContext();
                UserServiceLocal us = (UserServiceLocal) ctx.lookup("java:global/flipmart-webapp-ear/flipmart-webapp-ejb/UserService!com.flipmart.service.UserServiceLocal");
                
                us.updateUser(updateDetails);
                
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
        } else {
            LOGGER.error("User details are null "+updateDetails);
        }
    }
}
