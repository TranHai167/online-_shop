package com.example.productmanagmentmodule.repository;

import com.example.productmanagmentmodule.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

// db for ShoppingCart entity
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {

    Optional<List<ShoppingCart>> findAllByCartId(String cartId);

    @Query("update ShoppingCart s set s.quantity = :quantity where s.cartId = :cartId and s.productId = :productId")
    void updateQuantityFromCartId(String cartId, int productId, int quantity);

    ShoppingCart findFirstByCartIdAndProductId(String cartId, int productId);
}
