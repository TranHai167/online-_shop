package com.example.productmanagmentmodule.service.impl;

import com.example.productmanagmentmodule.model.dto.OrderDTO;
import com.example.productmanagmentmodule.model.dto.ShippingDTO;
import com.example.productmanagmentmodule.model.dto.ShoppingCartDTO;
import com.example.productmanagmentmodule.entity.Orders;
import com.example.productmanagmentmodule.repository.OrderRepository;
import com.example.productmanagmentmodule.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    @Override
    public String createOrder(OrderDTO orderDTO) {
        UUID newUUID = UUID.randomUUID();
        ShippingDTO shippingDTO = orderDTO.getShipping();

        String cartId = orderDTO.getCartId();

        Orders order = new Orders(newUUID.toString(), shippingDTO.getName(), shippingDTO.getAddressLine1(), shippingDTO.getAddressLine2(), new Date(), shippingDTO.getCity(), cartId);
        orderRepository.save(order);
        return newUUID.toString();
    }

    @Override
    public List<OrderDTO> getDetailOrder(String cartId) {
        List<Orders> orders = orderRepository.findAllByCartIdOrderByCreateDateDesc(cartId);
        List<OrderDTO> response = orders.stream().map(order -> new OrderDTO(order.getCreateDate(),
                new ShippingDTO(order.getName(), order.getAddress1(), order.getAddress2(), order.getCity()),
                order.getCartId())).collect(Collectors.toList());
        return response;
    }
}
