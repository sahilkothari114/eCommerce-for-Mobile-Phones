<<<<<<< HEAD

package com.ecom.dao;

=======
package com.ecom.dao;
>>>>>>> 48fadaf210e99cc27a1da3e3031e53a512fc56f0

public class Cart {
    private int userId;
    private int colorProductId;

    public Cart(int userId, int colorProductId) {
        this.userId = userId;
        this.colorProductId = colorProductId;
    }

    public Cart() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getColorProductId() {
        return colorProductId;
    }

    public void setColorProductId(int colorProductId) {
        this.colorProductId = colorProductId;
    }
    
    
    
}
