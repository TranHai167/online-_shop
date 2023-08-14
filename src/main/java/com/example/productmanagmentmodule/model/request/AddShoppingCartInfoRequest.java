package com.example.productmanagmentmodule.model.request;

import com.example.productmanagmentmodule.entity.Products;
import lombok.Data;

@Data
public class AddShoppingCartInfoRequest {
    private String cartId;
    private Products products;
    private Integer quantity;

    public AddShoppingCartInfoRequest(String cartId, Products products) {
        this.cartId = cartId;
        this.products = products;
        this.quantity = 1;
    }
}
