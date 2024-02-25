package com.skillstorm.grocerygrabber.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.grocerygrabber.models.Customer;
import com.skillstorm.grocerygrabber.models.OrderInfo;
import com.skillstorm.grocerygrabber.repositories.CustomerRepository;
import com.skillstorm.grocerygrabber.repositories.OrderInfoRepository;

@Service
@Transactional
public class OrderInfoServiceImpl implements OrderInfoService {

    @Autowired
    private OrderInfoRepository orderRepo;

    @Autowired
    CustomerRepository customerRepo;

    @Override
    public List<OrderInfo> findAll() {
        return orderRepo.findAll();
    }

    @Override
    public OrderInfo findById(Long id) {
        return orderRepo.getReferenceById(id);
    }

    @Override
    public OrderInfo save(OrderInfo order) {
        Optional<Customer> customer = customerRepo.findById(order.getCustomer().getCustomerId());
        if (customer.isPresent()) {
            order.setCustomer(customer.get());
        } else {
            throw new RuntimeException("Customer with ID " + order.getCustomer().getCustomerId() + " not found");
        }
        return orderRepo.save(order);
    }

}
