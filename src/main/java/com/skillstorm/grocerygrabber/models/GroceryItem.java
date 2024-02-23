package com.skillstorm.grocerygrabber.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((groceryId == null) ? 0 : groceryId.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + quantity;
        result = prime * result + ((order == null) ? 0 : order.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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
        GroceryItem other = (GroceryItem) obj;
        if (groceryId == null) {
            if (other.groceryId != null)
                return false;
        } else if (!groceryId.equals(other.groceryId))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (quantity != other.quantity)
            return false;
        if (order == null) {
            if (other.order != null)
                return false;
        } else if (!order.equals(other.order))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "GroceryItem [groceryId=" + groceryId + ", description=" + description + ", quantity=" + quantity
                + ", order=" + order + ", name=" + name + "]";
    }

}
