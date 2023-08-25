package com.example.productmanagmentmodule.model.request;

import com.example.productmanagmentmodule.entity.Products;
import lombok.Data;

@Data
public class UpdateShoppingCartRequest {
    private String cartId;
    private Products product;
    private Integer change;
}
