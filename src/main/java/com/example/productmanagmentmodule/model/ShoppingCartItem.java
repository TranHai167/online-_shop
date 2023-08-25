package com.example.productmanagmentmodule.model;

import com.example.productmanagmentmodule.entity.Products;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartItem {

    @JsonProperty("products")
    private Products products;

    @JsonProperty("quantity")
    private Integer quantity;
}
