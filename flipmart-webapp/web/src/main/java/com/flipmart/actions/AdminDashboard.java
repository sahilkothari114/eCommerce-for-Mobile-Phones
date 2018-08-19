package com.flipmart.actions;

import com.flipmart.util.FlipmartConstants;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

/**
 *
 * @author Shagufta
 */
@Action(value = "adminDashboard", results = {
    @Result(name = FlipmartConstants.SUCCESS, location = FlipmartConstants.ADMIN_URI + "dashboard.jsp")})
public class AdminDashboard extends ActionSupport {

    private static final Logger LOGGER = Logger.getLogger(AdminDashboard.class);

    @Override
    public String execute() {
        LOGGER.info("Admin Dashboard service called");
        return SUCCESS;
    }
}
