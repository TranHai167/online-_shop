package com.example.productmanagmentmodule.service;

import com.example.productmanagmentmodule.entity.Products;
import com.example.productmanagmentmodule.model.request.UpdateProductRequest;
import com.example.productmanagmentmodule.model.response.ProductsResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

//    ProductsResponse[] getAllProducts();
//
//    ProductsResponse getProductById(String id);
//    Page<ProductsResponse> getAllProducts(Integer page, Integer size, String keyWord);

    List<ProductsResponse> getAllProducts();

    ProductsResponse getProductById(Integer id);

    String deleteProductById(Integer id);

    String createProduct(Products theProduct);

    String updateProductById(Integer id, ProductsResponse productsResponse);

    Page<ProductsResponse> getProductByCategory(
            Integer page,
            Integer size,
            String category);

    Integer updateProduct(UpdateProductRequest request);
}
