package com.skillstorm.grocerygrabber.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "grocery_item")
public class GroceryItem {

    @Id
    @Column(name = "grocery_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groceryId;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderInfo order;

    @Column(name = "name")
    private String name;

    public GroceryItem() {
        super();
    }

    public GroceryItem(Long groceryId, String description, int quantity, OrderInfo order, String name) {
        this.groceryId = groceryId;
        this.description = description;
        this.quantity = quantity;
        this.order = order;
        this.name = name;
    }

}
