package com.skillstorm.grocerygrabber.services;

import java.util.List;

import com.skillstorm.grocerygrabber.models.GroceryItem;

public interface GroceryItemService {

    public List<GroceryItem> findAll();

    public GroceryItem findById(Long id);

    public GroceryItem save(GroceryItem groceryItem);

}
