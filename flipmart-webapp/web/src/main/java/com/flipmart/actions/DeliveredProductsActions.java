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
@Action(value = "deliveredProducts", results = {
    @Result(name = FlipmartConstants.SUCCESS, location = FlipmartConstants.ADMIN_URI + "DeliveredProducts.jsp")})
public class DeliveredProductsActions extends ActionSupport{
    
    private static final Logger LOGGER = Logger.getLogger(DeliveredProductsActions.class);

    @Override
    public String execute() {
        LOGGER.info("Delivered Product called");
        return SUCCESS;
    }
    
}