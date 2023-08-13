package com.example.productmanagmentmodule.service.impl;

import com.example.productmanagmentmodule.entity.Product;
import com.example.productmanagmentmodule.model.request.AddShoppingCartInfoRequest;
import com.example.productmanagmentmodule.service.ShoppingCartService;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Override
    public String createShoppingCart(AddShoppingCartInfoRequest request) {
        String cartId = request.getCartId();
        Product product = request.getProduct();

        // logic to save to db ShoppingCartRepository
        return cartId;
    }

    @Override
    public String updateShoppingCart(AddShoppingCartInfoRequest request) {
        String cartId = request.getCartId();
        Product product = request.getProduct();

        // logic to update to db ShoppingCartRepository
        return cartId;
    }
}
