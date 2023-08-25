package com.example.productmanagmentmodule.model.request;

import com.example.productmanagmentmodule.entity.Products;
import lombok.Data;

@Data
public class UpdateProductRequest {

    private Integer productId;
    private Products product;
}
