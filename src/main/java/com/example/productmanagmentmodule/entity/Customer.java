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
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

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
