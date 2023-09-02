package com.example.productmanagmentmodule.repository;

import com.example.productmanagmentmodule.entity.PlacedOrders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlacedOrdersRepository extends JpaRepository<PlacedOrders, String> {

    List<PlacedOrders> findAllByOrderId(String orderId);

}
