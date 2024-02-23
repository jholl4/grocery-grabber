package com.skillstorm.grocerygrabber.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.grocerygrabber.models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
