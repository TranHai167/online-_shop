package com.example.productmanagmentmodule.service;

import com.example.productmanagmentmodule.model.response.ProductsResponse;

import java.util.List;

public interface ProductService {

    ProductsResponse[] getAllProducts();

    ProductsResponse getProductById(String id);
}
