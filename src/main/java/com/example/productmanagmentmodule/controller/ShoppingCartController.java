package com.example.productmanagmentmodule.controller;

import com.example.productmanagmentmodule.dto.ShoppingCartDTO;
import com.example.productmanagmentmodule.model.request.AddShoppingCartInfoRequest;
import com.example.productmanagmentmodule.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shopping-cart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @PostMapping("")
    public ResponseEntity<String> createShoppingCart(@RequestBody AddShoppingCartInfoRequest request) {
         return ResponseEntity.ok(shoppingCartService.createShoppingCart(request));
    }

    @PutMapping("")
    public ResponseEntity<String> updateShoppingCart(@RequestBody AddShoppingCartInfoRequest request) {
        return ResponseEntity.ok(shoppingCartService.updateShoppingCart(request));
    }

    @DeleteMapping("")
    public ResponseEntity<String> deleteShoppingCart(@RequestBody AddShoppingCartInfoRequest request){
        return ResponseEntity.ok(shoppingCartService.deleteShoppingCart(request));
    }

    @GetMapping("")
    public ResponseEntity<ShoppingCartDTO> getShoppingCartDetail(@RequestParam String cartId){
        return null;
    }
}
