package com.example.productmanagmentmodule.service;

import com.example.productmanagmentmodule.model.request.AddShoppingCartInfoRequest;

public interface ShoppingCartService {

    String createShoppingCart(AddShoppingCartInfoRequest request);

    String updateShoppingCart(AddShoppingCartInfoRequest request);
}
