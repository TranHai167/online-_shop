package com.example.productmanagmentmodule.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Orders")
public class Orders {
    // define fields
    @Id
    @Column(name = "order_id")
    private String orderId;

    @Column(name = "customer_name")
    private String name;

    @Column(name = "address1")
    private String address1;

    @Column(name = "address2")
    private String address2;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "city")
    private String city;

    @Column(name = "cart_id")
    private String cartId;
}
