package com.example.productmanagmentmodule.service;

import com.example.productmanagmentmodule.model.response.ProductsResponse;

import java.util.List;

public interface ProductService {

    ProductsResponse[] getAllProduct();

    ProductsResponse getProductById(String id);
}
