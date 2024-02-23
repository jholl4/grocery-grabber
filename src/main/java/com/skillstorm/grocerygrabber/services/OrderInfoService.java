package com.skillstorm.grocerygrabber.services;

import java.util.List;

import com.skillstorm.grocerygrabber.models.OrderInfo;

public interface OrderInfoService {

    public List<OrderInfo> findAll();

    public OrderInfo findById(Long id);

    public OrderInfo save(OrderInfo order);

}
