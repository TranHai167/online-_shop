package com.example.productmanagmentmodule.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsResponse {
    private String id;
    private String title;
    private String category;
    private double price;
    private String imageUrl;
}
