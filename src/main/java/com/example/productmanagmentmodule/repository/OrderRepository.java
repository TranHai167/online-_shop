package com.example.productmanagmentmodule.repository;

import com.example.productmanagmentmodule.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends JpaRepository<Orders, String> {

    List<Orders> findAllByCartIdOrderByCreateDateDesc(String cartId);

    @Query(value = "select * from Orders o order by o.create_date desc", nativeQuery = true)
    List<Orders> findAllOrderByCreateDateDesc();

    List<Orders> findAllByNameLikeAndAddress1LikeAndCityLikeAndCreateDateBetweenOrderByCreateDateDesc(String name, String address, String phoneNumber, Date fromDate, Date toDate);
}
