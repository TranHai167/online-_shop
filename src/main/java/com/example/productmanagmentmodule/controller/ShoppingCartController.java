package com.example.productmanagmentmodule.controller;

import com.example.productmanagmentmodule.model.dto.ShoppingCartDTO;
import com.example.productmanagmentmodule.model.request.AddShoppingCartInfoRequest;
import com.example.productmanagmentmodule.model.request.UpdateShoppingCartRequest;
import com.example.productmanagmentmodule.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shopping-cart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @PostMapping("/new-cart")
    public ResponseEntity<String> createShoppingCart(@RequestBody AddShoppingCartInfoRequest payLoad) {
         return ResponseEntity.ok(shoppingCartService.createShoppingCart(payLoad));
    }

    @DeleteMapping("")
    public ResponseEntity<String> deleteShoppingCart(@RequestBody AddShoppingCartInfoRequest request){
        return ResponseEntity.ok(shoppingCartService.deleteShoppingCart(request));
    }

    @GetMapping("/getById")
    public ResponseEntity<ShoppingCartDTO> getShoppingCartDetail(@RequestParam String cartId){
        return ResponseEntity.ok(shoppingCartService.getShoppingCartDetail(cartId));
    }

    @PostMapping("/update-cart")
    public ResponseEntity<?> updateShoppingCart(@RequestBody UpdateShoppingCartRequest request) {
        return ResponseEntity.ok(shoppingCartService.updateShoppingCart(request));
    }
}
