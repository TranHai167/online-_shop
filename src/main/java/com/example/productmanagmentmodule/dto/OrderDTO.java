package com.example.productmanagmentmodule.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class OrderDTO {
    @JsonProperty("orderDate")
    private LocalDateTime orderDate;

    @JsonProperty("shipping")
    private ShippingDTO shipping;

    @JsonProperty("items")
    private ShoppingCartDTO items;
}
