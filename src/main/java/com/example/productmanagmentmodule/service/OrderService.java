package com.example.productmanagmentmodule.service;

import com.example.productmanagmentmodule.dto.OrderDTO;

import java.util.UUID;

public interface OrderService {
    public String createOrder(OrderDTO orderDTO);
}
