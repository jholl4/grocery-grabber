package com.skillstorm.grocerygrabber.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.grocerygrabber.models.GroceryItem;
import com.skillstorm.grocerygrabber.repositories.GroceryItemRepository;

@Service
public class GroceryItemServiceImpl implements GroceryItemService {

    @Autowired
    private GroceryItemRepository groceryItemRepo;

    @Override
    public List<GroceryItem> findAll() {
        return groceryItemRepo.findAll();
    }

    @Override
    public GroceryItem findById(Long id) {
        return groceryItemRepo.getReferenceById(id);
    }

    @Override
    public GroceryItem save(GroceryItem groceryItem) {
        return groceryItemRepo.save(groceryItem);
    }

}
