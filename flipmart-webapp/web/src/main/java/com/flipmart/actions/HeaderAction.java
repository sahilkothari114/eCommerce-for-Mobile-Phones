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
@Action(value = "adminHeader", results = {
    @Result(name = FlipmartConstants.SUCCESS, location = FlipmartConstants.ADMIN_URI + "header.jsp")})
public class HeaderAction extends ActionSupport{
    
    private static final Logger LOGGER = Logger.getLogger(HeaderAction.class);

    @Override
    public String execute() {
        LOGGER.info("Header Action called");
        return SUCCESS;
    }
}
