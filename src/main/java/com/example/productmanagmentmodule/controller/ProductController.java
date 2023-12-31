package com.example.productmanagmentmodule.controller;

import com.example.productmanagmentmodule.entity.Products;
import com.example.productmanagmentmodule.exception.CommonException;
import com.example.productmanagmentmodule.model.request.UpdateProductRequest;
import com.example.productmanagmentmodule.model.response.ProductsResponse;
import com.example.productmanagmentmodule.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/getAll")
    public ResponseEntity<List<ProductsResponse>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

//    public ResponseEntity<Page<ProductsResponse>> getAllProducts(
//            @RequestParam(required = false) Integer page,
//            @RequestParam(required = false) Integer size,
//            @RequestParam(required = false) String keyWord) {
//        return ResponseEntity.ok(productService.getAllProducts(page, size, keyWord));
//    }

    @GetMapping("/get")
    public ResponseEntity<ProductsResponse> getProductDetail(@RequestParam Integer productId) throws CommonException {
        return ResponseEntity.ok(productService.getProductById(productId));
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer productId) {
        System.out.println(productId);
        return ResponseEntity.ok(productService.deleteProductById(productId));
    }

    @PostMapping("/create")
    public ResponseEntity<String> createProduct(@RequestBody Products product){
        return ResponseEntity.ok(productService.createProduct(product));
    }

    @PutMapping("/update")
    public ResponseEntity<Integer> updateProduct(@RequestBody UpdateProductRequest request) {
        return ResponseEntity.ok(productService.updateProduct(request));
    }

    @GetMapping("/getByCategory")
    public ResponseEntity<Page<ProductsResponse>> getProductByCategory(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size,
            @RequestParam(required = false) String category
    ) throws CommonException {
        return ResponseEntity.ok(productService.getProductByCategory(page, size, category));
    }
}
