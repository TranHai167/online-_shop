package com.example.productmanagmentmodule.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ShoppingCartItem")
public class ShoppingCartItem {

    @Column(name = "products")
    private Products products;

    @Column(name = "quantity")
    private int quantity;
}
