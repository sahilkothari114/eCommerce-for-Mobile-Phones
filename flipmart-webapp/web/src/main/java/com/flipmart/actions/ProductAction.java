package com.flipmart.actions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipmart.persistence.Product;
import com.flipmart.service.ProductServiceLocal;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.flipmart.util.FlipmartConstants;
import com.opensymphony.xwork2.ActionSupport;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;

/**
 * @author jayesh
 *
 */
@Action(value = "product", results = {
		@Result(name = FlipmartConstants.SUCCESS, location = FlipmartConstants.CLIENT_URI + "products.jsp") })
public class ProductAction extends ActionSupport {
        private static HttpServletRequest request;
        private static HttpServletResponse response;
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() {
		System.out.println("product Action called");
		return SUCCESS;
	}
        
        @Action(value = "allProducts")
        public String getAllProducts() throws IOException
        {
            ObjectMapper mapper = new ObjectMapper();
            
            Context ctx = null;
            try {
                ctx = new InitialContext();
                ProductServiceLocal pService = (ProductServiceLocal) ctx.lookup("java:global/flipmart-webapp-ear/flipmart-webapp-ejb/ProductService!com.flipmart.service.ProductServiceLocal");

                List<Product> list = pService.getProducts();
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                mapper.writeValue(out, list);
                final byte[] data = out.toByteArray();
                return (new String(data));           // sending out the list of all products     
            } 
            catch (IOException | NamingException e) {                
                System.out.println(e.getMessage());                
            } 
            finally 
            {
                if (ctx != null) {
                    try {
                        ctx.close();
                    } catch (NamingException t) {
                    }
                }
            } 
            return "";
        }
        @Action("addProduct")
        public void addProduct()
        {
            Context ctx = null;
            try{
                request = ServletActionContext.getRequest();
                String jsonResponse = IOUtils.toString(request.getInputStream(), FlipmartConstants.CHARACTER_ENCODING);
                ctx = new InitialContext();
                Product product = new ObjectMapper().readValue(jsonResponse, Product.class);
                
                ProductServiceLocal pService = (ProductServiceLocal) ctx.lookup("java:global/flipmart-webapp-ear/flipmart-webapp-ejb/ProductService!com.flipmart.service.ProductServiceLocal");
                pService.addProduct(product);
            }
            catch(IOException | NamingException e)
            {
                System.out.println(e.getMessage());
            }
            finally{
                try {
                    ctx.close();
                } catch (NamingException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
}
