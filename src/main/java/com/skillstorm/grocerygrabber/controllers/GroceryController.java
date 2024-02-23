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

import com.skillstorm.grocerygrabber.models.GroceryItem;
import com.skillstorm.grocerygrabber.services.GroceryItemService;

@RestController
@RequestMapping("/groceries")
public class GroceryController {

    @Autowired
    private GroceryItemService service;

    @GetMapping
    public List<GroceryItem> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public GroceryItem findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public GroceryItem save(@RequestBody GroceryItem item) {
        return service.save(item);
    }

}
