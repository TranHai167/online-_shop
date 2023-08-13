package com.example.productmanagmentmodule.service.impl;

import com.example.productmanagmentmodule.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Override
    public List<String> getAllCategories() {
        return List.of("Bread", "Vegetable", "Fruit", "Food");
    }
}
