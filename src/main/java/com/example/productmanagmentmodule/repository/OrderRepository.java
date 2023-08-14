package com.example.productmanagmentmodule.repository;

import com.example.productmanagmentmodule.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Integer> {
}
