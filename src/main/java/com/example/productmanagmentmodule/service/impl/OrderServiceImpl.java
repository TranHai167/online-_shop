package com.example.productmanagmentmodule.service.impl;

import com.example.productmanagmentmodule.dto.OrderDTO;
import com.example.productmanagmentmodule.dto.ShippingDTO;
import com.example.productmanagmentmodule.dto.ShoppingCartDTO;
import com.example.productmanagmentmodule.entity.Orders;
import com.example.productmanagmentmodule.repository.OrderRepository;
import com.example.productmanagmentmodule.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    @Override
    public UUID createOrder(OrderDTO orderDTO) {
        LocalDateTime localDateTime = orderDTO.getOrderDate();
        ShippingDTO shippingDTO = orderDTO.getShipping();
        ShoppingCartDTO shoppingCartDTO = orderDTO.getItems();
        UUID newUUID = UUID.randomUUID();
        return newUUID;
    }
}
