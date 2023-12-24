package com.example.productmanagmentmodule.controller;

import com.example.productmanagmentmodule.entity.PlacedOrders;
import com.example.productmanagmentmodule.model.dto.EmailPayload;
import com.example.productmanagmentmodule.model.dto.OrderDTO;
import com.example.productmanagmentmodule.model.dto.OrderPlacedDto;
import com.example.productmanagmentmodule.model.response.OrderIdResponse;
import com.example.productmanagmentmodule.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<OrderIdResponse> createOrder(@RequestBody OrderDTO orderDTO){
        return ResponseEntity.ok(new OrderIdResponse(orderService.createOrder(orderDTO)));
    }

    @GetMapping("/get-order")
    public ResponseEntity<List<OrderDTO>> getDetailOrder(@RequestParam String cartId) {
        return ResponseEntity.ok(orderService.getDetailOrder(cartId));
    }

    @PostMapping("/send-email")
    public ResponseEntity<String> confirmationEmail(@RequestBody EmailPayload payload) {
        orderService.sendEmail(payload.getOrderId(), payload.getCartId());
        return ResponseEntity.ok("Oke");
    }

    @GetMapping("/get-orders/placed")
    public ResponseEntity<List<OrderPlacedDto>> getPlacedOrders(@RequestParam String orderId) {
        return ResponseEntity.ok(orderService.getPlacedOrders(orderId));
    }

    // pagination
    @GetMapping("/admin-get-orders")
    public ResponseEntity<List<OrderDTO>> getAllPlacedOrders() {
        return ResponseEntity.ok(orderService.getAllPlacedOrders());
    }

    @GetMapping("/filter-orders")
    public ResponseEntity<List<OrderDTO>> filterPlacedOrders(
            @RequestParam String customer,
            @RequestParam String address,
            @RequestParam String phoneNumber
    ) {
        return ResponseEntity.ok(orderService.filterOrders(customer, address, phoneNumber));
    }
}
