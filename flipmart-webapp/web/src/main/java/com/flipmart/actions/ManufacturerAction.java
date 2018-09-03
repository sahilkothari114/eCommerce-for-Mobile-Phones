package com.flipmart.actions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.flipmart.persistence.Admin;
import com.flipmart.persistence.Manufacturer;
import com.flipmart.service.AdminServiceLocal;
import com.flipmart.service.ManufacturerServiceLocal;
import com.flipmart.util.FlipmartConstants;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

/**
 *
 * @author Shagufta
 */
@Action(value = "addManufacturer", results = {
    @Result(name = FlipmartConstants.SUCCESS, location = FlipmartConstants.ADMIN_URI + "addManufacturer.jsp")})
public class ManufacturerAction extends ActionSupport {

    private static final Logger LOGGER = Logger.getLogger(ManufacturerAction.class);
    private static HttpServletResponse response;

    @Override
    public String execute() {
        LOGGER.info("Manufacturer service called");

        try {
            fetchManufacturers();
        } catch (JsonProcessingException ex) {
            java.util.logging.Logger.getLogger(ManufacturerAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SUCCESS;
    }

    private void fetchManufacturers() throws JsonProcessingException {
        LOGGER.info("Preparing to fetch manufacturers");
        ObjectMapper mapper = new ObjectMapper();
        Context ctx = null;
        try {
            ctx = new InitialContext();
            ManufacturerServiceLocal manufacturerService = (ManufacturerServiceLocal) ctx.lookup("java:global/flipmart-webapp-ear/flipmart-webapp-ejb/ManufacturerService!com.flipmart.service.ManufacturerServiceLocal");
            List<Manufacturer> manufacturers = manufacturerService.getManufacturers();
            String res = mapper.writeValueAsString(manufacturers);
            
            response = ServletActionContext.getResponse();
            response.setContentType(FlipmartConstants.CONTENT_TYPE);
            response.getWriter().write(res);
            
        } catch (NamingException e) {
            LOGGER.error(e.getMessage());
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(ManufacturerAction.class.getName()).log(Level.SEVERE, null, ex);
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
