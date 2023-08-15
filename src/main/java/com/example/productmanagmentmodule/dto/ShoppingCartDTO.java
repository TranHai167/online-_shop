package com.example.productmanagmentmodule.dto;

import com.example.productmanagmentmodule.model.ShoppingCartItem;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ShoppingCartDTO {

    @JsonProperty("cartId")
    String cartId;

    @JsonProperty("items")
    ShoppingCartItem[] items;

}
