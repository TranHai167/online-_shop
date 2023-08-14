package com.example.productmanagmentmodule.service;

import com.example.productmanagmentmodule.entity.Products;
import com.example.productmanagmentmodule.model.response.ProductsResponse;
import org.springframework.data.domain.Page;

public interface ProductService {

//    ProductsResponse[] getAllProducts();
//
//    ProductsResponse getProductById(String id);
public Page<ProductsResponse> getAllProducts(
        Integer page,
        Integer size,
        String keyWord
);

    public ProductsResponse getProductById(String id);

    public String deleteProductById(String id);

    public String createProduct(Products theProduct);

    public String updateProductById(String id, ProductsResponse productsResponse);

    public Page<ProductsResponse> getProductByCategory(
            Integer page,
            Integer size,
            String category);
}
