package com.example.productmanagmentmodule.entity;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "ShoppingCartItem")
public class ShoppingCartItem {
    @Column(name = "product")
    private Product product;

    @Column(name = "quantity")
    private int quantity;
}
