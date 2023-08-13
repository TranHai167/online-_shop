package com.example.productmanagmentmodule.model.request;

import com.example.productmanagmentmodule.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;

@Data
public class AddShoppingCartInfoRequest {
    private String cartId;
    private Product product;
    private Integer quantity;

    public AddShoppingCartInfoRequest(String cartId, Product product) {
        this.cartId = cartId;
        this.product = product;
        this.quantity = 1;
    }
}
