package com.example.productmanagmentmodule.controller;

import com.example.productmanagmentmodule.dto.ProductDTO;
import com.example.productmanagmentmodule.model.response.ProductsResponse;
import com.example.productmanagmentmodule.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/getAll")
    public ResponseEntity<Page<ProductDTO>> getCategories(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size,
            @RequestParam(required = false) String keyWord) {
        return ResponseEntity.ok(productService.getAllProducts(page, size, keyWord));
    }

    @GetMapping("/get")
    public ResponseEntity<ProductsResponse> getProductDetail(@RequestParam String productId) {
        return ResponseEntity.ok(productService.getProductById(productId));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteProduct(@RequestParam String productId) {
        System.out.println(productId);
        return ResponseEntity.ok("Success!");
    }
}
