package com.example.productmanagmentmodule.service;

import com.example.productmanagmentmodule.model.dto.ShoppingCartDTO;
import com.example.productmanagmentmodule.model.request.AddShoppingCartInfoRequest;
import com.example.productmanagmentmodule.model.request.UpdateShoppingCartRequest;

public interface ShoppingCartService {

    String createShoppingCart(AddShoppingCartInfoRequest request);

    int updateShoppingCart(UpdateShoppingCartRequest request);

    String deleteShoppingCart(AddShoppingCartInfoRequest request);

    ShoppingCartDTO getShoppingCartDetail(String cartId);

    void createDefaultShoppingCart(String id);
}
