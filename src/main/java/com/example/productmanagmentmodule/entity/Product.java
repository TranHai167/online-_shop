package com.example.productmanagmentmodule.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String id;
    private String title;
    private String category;
    private double price;
    private String imageUrl;
}
