package com.skillstorm.grocerygrabber.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.grocerygrabber.models.OrderInfo;
import com.skillstorm.grocerygrabber.services.OrderInfoService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderInfoService service;

    @GetMapping
    public List<OrderInfo> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public OrderInfo findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public OrderInfo save(@RequestBody OrderInfo order) {
        return service.save(order);
    }

}
