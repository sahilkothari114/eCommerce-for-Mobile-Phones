<<<<<<< HEAD

=======
>>>>>>> 48fadaf210e99cc27a1da3e3031e53a512fc56f0
package com.ecom.dao;

public class ColorProduct {
    
    private int colorProductId;
    private int colorId;
    private int productId;
    private int stock;

    public ColorProduct() {
    }

    public ColorProduct(int colorId, int productId, int stock) {
        this.colorId = colorId;
        this.productId = productId;
        this.stock = stock;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public int getColorProductId() {
        return colorProductId;
    }
        
}
