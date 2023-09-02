package com.example.productmanagmentmodule.service.impl;

import com.example.productmanagmentmodule.model.dto.*;
import com.example.productmanagmentmodule.entity.Orders;
import com.example.productmanagmentmodule.repository.OrderRepository;
import com.example.productmanagmentmodule.repository.PlacedOrdersRepository;
import com.example.productmanagmentmodule.repository.ProductRepository;
import com.example.productmanagmentmodule.repository.UserRepository;
import com.example.productmanagmentmodule.service.EmailService;
import com.example.productmanagmentmodule.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    @Autowired
    private final OrderRepository orderRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    private final PlacedOrdersRepository placedOrdersRepository;

    @Autowired
    private final UserRepository userRepository;

    @Override
    public String createOrder(OrderDTO orderDTO) {
        UUID newUUID = UUID.randomUUID();
        ShippingDTO shippingDTO = orderDTO.getShipping();
        String cartId = orderDTO.getCartId();
        Orders order = new Orders(newUUID.toString(), shippingDTO.getName(), shippingDTO.getAddressLine1(), shippingDTO.getAddressLine2(), new Date(), shippingDTO.getCity(), cartId);
        orderRepository.save(order);
        sendEmail(newUUID.toString(), cartId);
        return newUUID.toString();
    }

    @Override
    public List<OrderDTO> getDetailOrder(String cartId) {
        List<Orders> orders = orderRepository.findAllByCartIdOrderByCreateDateDesc(cartId);
        List<OrderDTO> response = orders.stream().map(order -> new OrderDTO(order.getCreateDate(),
                new ShippingDTO(order.getName(), order.getAddress1(), order.getAddress2(), order.getCity()),
                order.getCartId(), order.getOrderId())).collect(Collectors.toList());
        return response;
    }

    @Override
    public List<OrderPlacedDto> getPlacedOrders(String orderId) {
        return placedOrdersRepository.findAllByOrderId(orderId).stream().map(
                (placedOrders -> new OrderPlacedDto(
                        placedOrders.getOrderId(),
                        productRepository.findFirstById(placedOrders.getProductId()),
                        placedOrders.getQuantity()
                ))
        ).collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> getAllPlacedOrders() {
        List<Orders> orders = orderRepository.findAllOrderByCreateDateDesc();
        return orders.stream().map(order -> new OrderDTO(order.getCreateDate(),
                new ShippingDTO(order.getName(), order.getAddress1(), order.getAddress2(), order.getCity()),
                order.getCartId(), order.getOrderId())).collect(Collectors.toList());
    }

    private void sendEmail(String orderId, String identity) {
        String email = userRepository.findFirstById(identity).getEmail();
        EmailDetails emailDetails = EmailDetails.builder()
                .subject("Your order: " + orderId + " has been received.")
                .msgBody("Thank you so very much!, we received your order and will process this within 24 hours")
                .recipient(email)
                .build();
        this.emailService.sendSimpleMail(emailDetails);
    }
}