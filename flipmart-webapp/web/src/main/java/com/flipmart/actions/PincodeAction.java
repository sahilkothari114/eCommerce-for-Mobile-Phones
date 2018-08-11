/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flipmart.actions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.flipmart.persistence.Pincode;
import com.flipmart.service.PincodeServiceLocal;
import com.flipmart.util.FlipmartConstants;
import java.io.IOException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;

/**
 *
 * @author Sahil
 */
public class PincodeAction {

    private static HttpServletRequest request;
    private static HttpServletResponse response;
    private static final Logger LOGGER = Logger.getLogger(PincodeAction.class);

    @Action("pincode")
    public void findPincode() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        request = ServletActionContext.getRequest();
        String jsonResponse = IOUtils.toString(request.getInputStream(), FlipmartConstants.CHARACTER_ENCODING);

        LOGGER.info("jsonResponse : " + jsonResponse);
        JsonNode data = mapper.readTree(jsonResponse);
        long pincode = 0;
        if (data.get("pincode").get("pincode") != null) {
            pincode = data.get("pincode").get("pincode").asLong();
        }

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
            JsonNode responseData;
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
}
