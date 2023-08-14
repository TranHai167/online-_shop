package com.example.productmanagmentmodule.repository;

import com.example.productmanagmentmodule.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
