package com.example.productmanagmentmodule.controller;

import com.example.productmanagmentmodule.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/getAll")
    @ApiOperation("Get all categories of our online shop")
    public List<String> getAllCategories() {
        return categoryService.getAllCategories();
    }
}
