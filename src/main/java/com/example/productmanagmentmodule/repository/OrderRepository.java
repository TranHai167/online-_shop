package com.example.productmanagmentmodule.repository;

import com.example.productmanagmentmodule.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders, String> {

    List<Orders> findAllByCartIdOrderByCreateDateDesc(String cartId);
}
