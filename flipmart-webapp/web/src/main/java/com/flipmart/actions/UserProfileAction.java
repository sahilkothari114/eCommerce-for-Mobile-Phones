package com.flipmart.actions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipmart.persistence.Users;
import com.flipmart.service.UserServiceLocal;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.flipmart.util.FlipmartConstants;
import com.flipmart.util.PasswordHash;
import com.opensymphony.xwork2.ActionSupport;
import java.io.IOException;
import java.util.logging.Level;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

@Action(value = "userprofile", results = {
    @Result(name = FlipmartConstants.SUCCESS, location = FlipmartConstants.CLIENT_URI + "profile.jsp")})
public class UserProfileAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private static HttpServletRequest request;
    private static final Logger logger = Logger.getLogger(UserProfileAction.class);

    @Override
    public String execute() {
        System.out.println("Called");
        return SUCCESS;
    }

    @Action("userdetails")
    public JsonNode fetchUserDetails() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        request = ServletActionContext.getRequest();
        String jsonResponse = IOUtils.toString(request.getInputStream(), FlipmartConstants.CHARACTER_ENCODING);
        JsonNode data = mapper.readTree(jsonResponse);

        String userName = data.get("userName").asText();
        logger.info("user name: " + userName);

        JsonNode response = fetchUserDetails(userName);
        return response;
    }

    private JsonNode fetchUserDetails(String userName) {
        Context ctx = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            ctx = new InitialContext();
            UserServiceLocal user = (UserServiceLocal) ctx.lookup("java:global/flipmart-webapp-ear/flipmart-webapp-ejb/UserService!com.flipmart.service.UserServiceLocal");

            Users us = user.findByUserName(userName);

            try {
                String json = mapper.writeValueAsString(us);
                JsonNode data = mapper.readTree(json);

                return data;
            } catch (JsonProcessingException ex) {
                logger.error(ex);
            } catch (IOException ex) {
                logger.error(ex);
            }
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
        return null;
    }

}
