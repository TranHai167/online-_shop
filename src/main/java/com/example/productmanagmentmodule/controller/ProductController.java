package com.example.productmanagmentmodule.controller;

import com.example.productmanagmentmodule.model.response.ProductsResponse;
import com.example.productmanagmentmodule.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService categoryService;

    @GetMapping("/getAll")
    public ResponseEntity<ProductsResponse[]> getCategories() {
        return ResponseEntity.ok(categoryService.getAllProduct());
    }

    @GetMapping("/get")
    public ResponseEntity<ProductsResponse> getProductDetail(@RequestParam String productId) {
        return ResponseEntity.ok(categoryService.getProductById(productId));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteProduct(@RequestParam String productId) {
        System.out.println(productId);
        return ResponseEntity.ok("Success!");
    }
}
