package com.example.productmanagmentmodule.controller;

import com.example.productmanagmentmodule.model.dto.OrderDTO;
import com.example.productmanagmentmodule.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestBody OrderDTO orderDTO){
        return ResponseEntity.ok(orderService.createOrder(orderDTO));
    }

    @GetMapping("/get-order")
    public ResponseEntity<List<OrderDTO>> getDetailOrder(@RequestParam String cartId) {
        return ResponseEntity.ok(orderService.getDetailOrder(cartId));
    }
}
