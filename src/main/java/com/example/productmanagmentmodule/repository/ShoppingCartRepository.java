package com.example.productmanagmentmodule.repository;

import com.example.productmanagmentmodule.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

// db for ShoppingCart entity
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, String> {
}
