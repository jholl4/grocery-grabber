package com.skillstorm.grocerygrabber.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "customer")
    @JsonManagedReference
    private List<OrderInfo> orders;

    public Customer() {
        super();
    }

    public Customer(Long customerId, String name, String address, List<OrderInfo> orders) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.orders = orders;
    }
}
