package com.example.productmanagmentmodule.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ShoppingCart")
public class ShoppingCart {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private String id;

    @Column(name = "cartId")
    private String cartId;

    @Column(name = "productId")
    private Integer productId;

    @Column(name = "quantity")
    private Integer quantity;

}
