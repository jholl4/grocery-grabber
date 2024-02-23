package com.skillstorm.grocerygrabber.services;

import java.util.List;

import com.skillstorm.grocerygrabber.models.Customer;

public interface CustomerService {

    public List<Customer> findAll();

    public Customer findById(Long id);

    public Customer save(Customer customer);

}
