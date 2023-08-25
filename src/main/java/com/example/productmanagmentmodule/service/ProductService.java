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

    public ProductsResponse getProductById(Integer id);

    public String deleteProductById(Integer id);

    public String createProduct(Products theProduct);

    public String updateProductById(Integer id, ProductsResponse productsResponse);

    public Page<ProductsResponse> getProductByCategory(
            Integer page,
            Integer size,
            String category);

    Integer updateProduct(UpdateProductRequest request);
}
