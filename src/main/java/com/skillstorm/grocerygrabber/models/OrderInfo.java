package com.skillstorm.grocerygrabber.models;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "order_info")
public class OrderInfo {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(name = "scheduledTime")
    private LocalDateTime scheduledTime;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "groceryId")
    private List<GroceryItem> groceryItems;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
        result = prime * result + ((scheduledTime == null) ? 0 : scheduledTime.hashCode());
        result = prime * result + ((customer == null) ? 0 : customer.hashCode());
        result = prime * result + ((groceryItems == null) ? 0 : groceryItems.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OrderInfo other = (OrderInfo) obj;
        if (orderId == null) {
            if (other.orderId != null)
                return false;
        } else if (!orderId.equals(other.orderId))
            return false;
        if (scheduledTime == null) {
            if (other.scheduledTime != null)
                return false;
        } else if (!scheduledTime.equals(other.scheduledTime))
            return false;
        if (customer == null) {
            if (other.customer != null)
                return false;
        } else if (!customer.equals(other.customer))
            return false;
        if (groceryItems == null) {
            if (other.groceryItems != null)
                return false;
        } else if (!groceryItems.equals(other.groceryItems))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "OrderInfo [orderId=" + orderId + ", scheduledTime=" + scheduledTime + ", customer=" + customer
                + ", groceryItems=" + groceryItems + "]";
    }

}
