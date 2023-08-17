package com.example.productmanagmentmodule.controller;

import com.example.productmanagmentmodule.dto.ShoppingCartDTO;
import com.example.productmanagmentmodule.model.request.AddShoppingCartInfoRequest;
import com.example.productmanagmentmodule.service.ShoppingCartService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shopping-cart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @PostMapping("create")
    @ApiOperation("Create new shopping cart")
    public ResponseEntity<String> createShoppingCart(@RequestBody AddShoppingCartInfoRequest request) {
         return ResponseEntity.ok(shoppingCartService.createShoppingCart(request));
    }

    @PutMapping("update")
    @ApiOperation("Update shopping cart")
    public ResponseEntity<String> updateShoppingCart(@RequestBody AddShoppingCartInfoRequest request) {
        return ResponseEntity.ok(shoppingCartService.updateShoppingCart(request));
    }

    @DeleteMapping("delete")
    @ApiOperation("Delete shopping cart")
    public ResponseEntity<String> deleteShoppingCart(@RequestBody AddShoppingCartInfoRequest request){
        return ResponseEntity.ok(shoppingCartService.deleteShoppingCart(request));
    }

    @GetMapping("getById")
    @ApiOperation("Get shopping cart by specified ID")
    public ResponseEntity<ShoppingCartDTO> getShoppingCartDetail(@RequestParam String cartId){
        return null;
    }
}
