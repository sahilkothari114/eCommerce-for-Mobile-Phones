/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flipmart.actions;

import com.flipmart.util.FlipmartConstants;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

/**
 *
 * @author Shagufta
 */
@Action(value = "addManufacturer", results = {
    @Result(name = FlipmartConstants.SUCCESS, location = FlipmartConstants.ADMIN_URI + "addManufacturer.jsp")})
public class ManufacturerAction extends ActionSupport{
    
    private static final Logger LOGGER = Logger.getLogger(ManufacturerAction.class);

    @Override
    public String execute() {
        LOGGER.info("Manufacturer service called");
        
        
        return SUCCESS;
    }
}
