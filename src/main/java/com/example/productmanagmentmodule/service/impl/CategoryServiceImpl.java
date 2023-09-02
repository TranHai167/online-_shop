package com.example.productmanagmentmodule.service.impl;

import com.example.productmanagmentmodule.entity.Category;
import com.example.productmanagmentmodule.repository.CategoryRepository;
import com.example.productmanagmentmodule.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<String> getAllCategories() {
        List<Category> categoryList = categoryRepository.findAll();
        List<String> res = new ArrayList<>();
        for (Category category : categoryList){
            res.add(category.getTitle());
        }
        return res;
    }
}
