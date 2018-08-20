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

@Action(value = "adminProfile", results = {
    @Result(name = FlipmartConstants.SUCCESS, location = FlipmartConstants.ADMIN_URI + "adminProfile.jsp")})
public class AdminProfileAction extends ActionSupport{
    
    private static final Logger LOGGER = Logger.getLogger(AdminProfileAction.class);

    @Override
    public String execute() {
        LOGGER.info("Admin Profile service called");
        return SUCCESS;
    }
}
