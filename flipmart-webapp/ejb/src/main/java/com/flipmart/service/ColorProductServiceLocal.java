/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flipmart.service;

import com.flipmart.persistence.ColorProduct;
import com.flipmart.persistence.ColorProductId;
import javax.ejb.Local;

/**
 *
 * @author sahil
 */
@Local
public interface ColorProductServiceLocal {
    public ColorProduct findColorProductById(ColorProductId colorProductId);

   
}
