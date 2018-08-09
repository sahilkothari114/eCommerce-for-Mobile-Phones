package com.flipmart.actions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipmart.persistence.ColorProduct;
import com.flipmart.persistence.ColorProductId;
import com.flipmart.persistence.Product;
import com.flipmart.service.ColorProductServiceLocal;
import com.flipmart.service.ProductServiceLocal;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.flipmart.util.FlipmartConstants;
import com.opensymphony.xwork2.ActionSupport;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;
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
        public void getAllProducts() throws IOException
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
                response = ServletActionContext.getResponse();
                response.setContentType("application/json");
                response.getWriter().write(new String(data));           
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
        @Action(value = "getProduct")
        public void getProduct() throws IOException
        {
            ObjectMapper mapper = new ObjectMapper();
            
            Context ctx = null;
            try {
                ctx = new InitialContext();
                ColorProductServiceLocal cps = (ColorProductServiceLocal) ctx.lookup("java:global/flipmart-webapp-ear/flipmart-webapp-ejb/ColorProductService!com.flipmart.service.ColorProductServiceLocal");
                ColorProductId cpID = new ColorProductId();
                cpID.setColorId(1);
                cpID.setProductId(1);
                ColorProduct product= cps.findColorProductById(cpID);
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                //mapper.writeValue(out, list);
                //final byte[] data = out.toByteArray();
                
                //response = ServletActionContext.getResponse();
                //response.setContentType("application/json");
                //response.getWriter().write(new String(data));
                LOG.info("this is the color product"+product.toString());
            } 
            catch (NamingException e) {                
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
        }
    private static final Logger LOG = Logger.getLogger(ProductAction.class.getName());
}
