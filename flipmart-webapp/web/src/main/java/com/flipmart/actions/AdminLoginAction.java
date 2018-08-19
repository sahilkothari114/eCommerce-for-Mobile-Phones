package com.flipmart.actions;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.flipmart.util.FlipmartConstants;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.flipmart.persistence.Admin;
import com.flipmart.service.AdminServiceLocal;
import java.util.logging.Level;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Shagufta
 */
@Action(value = "adminLogin", results = {
    @Result(name = FlipmartConstants.SUCCESS, location = FlipmartConstants.ADMIN_URI + "adminLogin.jsp")})
public class AdminLoginAction extends ActionSupport {

    private static HttpServletRequest request;
    private static HttpServletResponse response;
    private static final long serialVersionUID = 778787878L;
    private static final Logger LOGGER = Logger.getLogger(AdminLoginAction.class);

    @Override
    public String execute() {
        LOGGER.info("Admin Login service called");
       /* try {
            // String sample = "Shagufta";
            validateAdmin();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(AdminLoginAction.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        return SUCCESS;
    }

    @Action("validateAdmin")
    public void validateAdmin() throws IOException {
        LOGGER.info("Validate Called!!!!!");
        ObjectMapper mapper = new ObjectMapper();
        request = ServletActionContext.getRequest();
        String jsonResponse = IOUtils.toString(request.getInputStream(), FlipmartConstants.CHARACTER_ENCODING);

        LOGGER.info(" -> " + jsonResponse);

        Admin admin = mapper.readValue(jsonResponse, Admin.class);

        /*Admin admin = new Admin();
        admin.setEmail("enna@gmail.com");
        admin.setPassword("eeeee");*/
        Context ctx = null;
        try {
            ctx = new InitialContext();
            AdminServiceLocal adminService = (AdminServiceLocal) ctx.lookup("java:global/flipmart-webapp-ear/flipmart-webapp-ejb/AdminService!com.flipmart.service.AdminServiceLocal");
            Admin validUser = adminService.findAdminByEmailAndPassword(admin);
            LOGGER.info("Valid admin from Database: " + validUser);

            response = ServletActionContext.getResponse();
            response.setContentType(FlipmartConstants.CONTENT_TYPE);

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
