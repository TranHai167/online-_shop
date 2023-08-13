package com.example.productmanagmentmodule.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order")
public class Order {
    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int order_id;

    @Column(name = "order_date")
    private LocalDateTime order_date;

//    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
//            CascadeType.PERSIST, CascadeType.REFRESH})
//    @JoinColumn(name = "customer_id")
//    private Customer customer;
//
//    @OneToMany(mappedBy = "order",
//            fetch = FetchType.EAGER,
//            cascade = {CascadeType.DETACH, CascadeType.MERGE,
//                    CascadeType.PERSIST, CascadeType.REFRESH})
//    private List<ShoppingCart> ShoppingCartList;
//
//    public void addCartEntries(ShoppingCart cartEntries){
//        if (ShoppingCartList == null){
//            ShoppingCartList = new ArrayList<>();
//        }
//
//        ShoppingCartList.add(cartEntries);
//
//        cartEntries.setOrder(this);
//    }
}
