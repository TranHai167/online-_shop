package com.example.productmanagmentmodule.repository;

import com.example.productmanagmentmodule.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartEntriesRepository extends JpaRepository<ShoppingCart, Integer> {
}
