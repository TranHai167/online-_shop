package com.example.productmanagmentmodule.repository;

import com.example.productmanagmentmodule.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {
    @Query(value = "SELECT * FROM products WHERE category = :category", nativeQuery = true)
    List<Products> getProductByCategory(@Param("category") String category);

    Products findFirstById(Integer productId);

    @Query("select distinct p.id from Products p")
    List<Integer> findAllProducts();
}
