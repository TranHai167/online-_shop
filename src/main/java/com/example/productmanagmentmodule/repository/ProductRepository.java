package com.example.productmanagmentmodule.repository;

import com.example.productmanagmentmodule.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    @Query(value = "SELECT * FROM item WHERE category = :category", nativeQuery = true)
    List<Product> getItemByCategory(@Param("category") String category);
}
