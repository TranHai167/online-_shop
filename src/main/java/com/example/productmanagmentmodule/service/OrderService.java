package com.example.productmanagmentmodule.service;

import com.example.productmanagmentmodule.model.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    String createOrder(OrderDTO orderDTO);

    List<OrderDTO> getDetailOrder(String cartId);
}
