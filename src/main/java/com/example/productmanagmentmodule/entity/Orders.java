package com.example.productmanagmentmodule.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Orders")
public class Orders {
    // define fields
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orderId")
    private String orderId;

    @Column(name = "customerName")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "cartId")
    private String cartId;
}
