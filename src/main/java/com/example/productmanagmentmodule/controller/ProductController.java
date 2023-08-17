package com.example.productmanagmentmodule.controller;

import com.example.productmanagmentmodule.entity.Products;
import com.example.productmanagmentmodule.model.response.ProductsResponse;
import com.example.productmanagmentmodule.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/getAll")
    @ApiOperation("Get all products of our online shop")
    public ResponseEntity<Page<ProductsResponse>> getCategories(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size,
            @RequestParam(required = false) String keyWord) {
        return ResponseEntity.ok(productService.getAllProducts(page, size, keyWord));
    }

    @GetMapping("/get")
    @ApiOperation("Get product by specified ID")
    public ResponseEntity<ProductsResponse> getProductDetail(@RequestParam Integer productId) {
        return ResponseEntity.ok(productService.getProductById(productId));
    }

    @DeleteMapping("/delete")
    @ApiOperation("Delete product by specified ID")
    public ResponseEntity<String> deleteProduct(@RequestParam Integer productId) {
        System.out.println(productId);
        return ResponseEntity.ok(productService.deleteProductById(productId));
    }

    @PostMapping("create")
    @ApiOperation("Create new product")
    public ResponseEntity<String> createProduct(@RequestBody Products products){
        return ResponseEntity.ok(productService.createProduct(products));
    }

    @PutMapping("/update")
    @ApiOperation("Update product by specified ID")
    public ResponseEntity<String> updateProduct(
            @RequestParam Integer productId,
            @RequestBody ProductsResponse productsResponse
    ){
        return ResponseEntity.ok(productService.updateProductById(productId, productsResponse));
    }

    @GetMapping("/getByCategory")
    @ApiOperation("Get all products by category")
    public ResponseEntity<Page<ProductsResponse>> getProductByCategory(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size,
            @RequestParam(required = false) String category
    ){
        return ResponseEntity.ok(productService.getProductByCategory(page, size, category));
    }
}
