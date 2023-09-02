package com.example.productmanagmentmodule.model.dto;

import com.example.productmanagmentmodule.entity.Products;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderPlacedDto {
    private String orderId;
    private Products product;
    private Integer quantity;
}
