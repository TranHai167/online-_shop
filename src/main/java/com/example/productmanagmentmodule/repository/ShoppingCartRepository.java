package com.example.productmanagmentmodule.repository;

import com.example.productmanagmentmodule.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

// db for ShoppingCart entity
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

    Optional<List<ShoppingCart>> findAllByCartId(String cartId);

    @Query("update ShoppingCart s set s.quantity = :quantity where s.cartId = :cartId and s.productId = :productId")
    void updateQuantityFromCartId(String cartId, int productId, int quantity);

    ShoppingCart findFirstByCartIdAndProductId(String cartId, int productId);

    void deleteAllByCartId(String cartId);

    @Query("UPDATE ShoppingCart s set s.quantity = 0 where s.cartId = :cartId")
    void clearCart(@Param("cartId") String cartId);

    void deleteAllByProductId(int productId);

    @Query("SELECT distinct s.cartId from ShoppingCart s")
    List<String> findDistinctCartId();
}
