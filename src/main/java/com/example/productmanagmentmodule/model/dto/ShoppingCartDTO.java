package com.example.productmanagmentmodule.model.dto;

import com.example.productmanagmentmodule.model.ShoppingCartItem;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartDTO {

    String cartId;
    ShoppingCartItem[] items;
}
