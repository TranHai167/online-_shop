package com.example.productmanagmentmodule.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Orders")
public class Orders {
    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId")
    private Integer orderId;

    @Column(name = "orderDate")
    private LocalDateTime orderDate;

    @Column(name = "shoppingCart")
    private ShoppingCart[] shoppingCart;

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
