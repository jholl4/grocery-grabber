package com.skillstorm.grocerygrabber.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.grocerygrabber.models.OrderInfo;
import com.skillstorm.grocerygrabber.repositories.OrderInfoRepository;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    @Autowired
    private OrderInfoRepository orderRepo;

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
        return orderRepo.save(order);
    }

}
