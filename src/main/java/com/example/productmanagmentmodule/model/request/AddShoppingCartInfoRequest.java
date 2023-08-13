package com.example.productmanagmentmodule.model.request;

import com.example.productmanagmentmodule.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddShoppingCartInfoRequest {
    private String cartId;
    private Product product;
}
