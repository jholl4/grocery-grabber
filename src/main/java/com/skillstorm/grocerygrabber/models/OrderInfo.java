package com.skillstorm.grocerygrabber.models;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "order_info")
public class OrderInfo {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(name = "scheduled_time")
    private LocalDateTime scheduledTime;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonBackReference
    private Customer customer;

    @OneToMany(mappedBy = "groceryId", cascade = CascadeType.ALL)
    private List<GroceryItem> groceryItems;

    public OrderInfo() {
        super();
    }

    public OrderInfo(Long orderId, LocalDateTime scheduledTime, Customer customer, List<GroceryItem> groceryItems) {
        this.orderId = orderId;
        this.scheduledTime = scheduledTime;
        this.customer = customer;
        this.groceryItems = groceryItems;
    }

}
