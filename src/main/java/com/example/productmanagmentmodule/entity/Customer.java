package com.example.productmanagmentmodule.entity;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customer_id;

    @Column(name = "customer_name")
    private String customer_name;

    @Column(name = "address")
    private String address;

//    @OneToMany(mappedBy = "customer",
//            fetch = FetchType.EAGER,
//            cascade = {CascadeType.DETACH, CascadeType.MERGE,
//                    CascadeType.PERSIST, CascadeType.REFRESH})
//    private List<Order> orderList;
//
//    public void addOrder(Order theOrder){
//        if (orderList == null){
//            orderList = new ArrayList<>();
//        }
//
//        orderList.add(theOrder);
//
//        theOrder.setCustomer(this);
//    }
}
