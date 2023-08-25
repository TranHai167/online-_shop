package com.example.productmanagmentmodule.controller;

import com.example.productmanagmentmodule.entity.Products;
import com.example.productmanagmentmodule.model.request.UpdateProductRequest;
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
    public ResponseEntity<ProductsResponse> getProductDetail(@RequestParam Integer productId) {
        return ResponseEntity.ok(productService.getProductById(productId));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteProduct(@RequestParam Integer productId) {
        System.out.println(productId);
        return ResponseEntity.ok(productService.deleteProductById(productId));
    }

    // đang có lỗi đ add thêm đc product mới
    @PostMapping("/create")
    public ResponseEntity<String> createProduct(@RequestBody Products products){
        return ResponseEntity.ok(productService.createProduct(products));
    }

    @PutMapping("/update")
    public ResponseEntity<Integer> updateProduct(
            @RequestBody UpdateProductRequest request
            ){
        return ResponseEntity.ok(productService.updateProduct(request));
    }

    @GetMapping("/getByCategory")
    public ResponseEntity<Page<ProductsResponse>> getProductByCategory(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size,
            @RequestParam(required = false) String category
    ){
        return ResponseEntity.ok(productService.getProductByCategory(page, size, category));
    }
}
