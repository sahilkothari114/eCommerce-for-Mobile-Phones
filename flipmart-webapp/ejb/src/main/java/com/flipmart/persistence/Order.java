/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flipmart.persistence;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author sahil
 */
@Entity
@Table(name = "Order")
public class Order implements Serializable {

    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="order_id")
    private Long orderId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id", nullable=false)
    private Users user;
    
    @Column(name="order_date")
    private Date orderDate;
    
    @Column(name="Status")
    private String status;
    
    @Column(name="total_amt")
    private String totalAmountt;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "order_items", joinColumns = @JoinColumn(name = "order_id"))
    private List<ColorProduct> colorProductOrder = new ArrayList<ColorProduct>();

    public List<ColorProduct> getColorProductOrder() {
        return colorProductOrder;
    }

    public void setColorProductOrder(List<ColorProduct> colorProductOrder) {
        this.colorProductOrder = colorProductOrder;
    }
    
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalAmountt() {
        return totalAmountt;
    }

    public void setTotalAmountt(String totalAmountt) {
        this.totalAmountt = totalAmountt;
    }
    
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Order)) {
            return false;
        }
        Order other = (Order) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.flipmart.persistence.Order[ id=" + orderId + " ]";
    }
    
}
