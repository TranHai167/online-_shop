package com.example.productmanagmentmodule.service;

import com.example.productmanagmentmodule.model.dto.ShoppingCartDTO;
import com.example.productmanagmentmodule.model.request.UpdateShoppingCartRequest;

public interface ShoppingCartService {

    void createShoppingCart(String request);

    int updateShoppingCart(UpdateShoppingCartRequest request);

    void deleteShoppingCart(String cartId, String orderId);

    ShoppingCartDTO getShoppingCartDetail(String cartId);

    void createDefaultShoppingCart(String id);

    void clearShoppingCart(String cartId);

    void addNewProductToShoppingCart(Integer productId);
}
