package com.example.productmanagmentmodule.service;

import com.example.productmanagmentmodule.entity.Product;
import com.example.productmanagmentmodule.model.response.ProductsResponse;
import org.springframework.data.domain.Page;
import com.example.productmanagmentmodule.dto.*;

public interface ProductService {

//    ProductsResponse[] getAllProducts();
//
//    ProductsResponse getProductById(String id);
public Page<ProductDTO> getAllProducts(
        Integer page,
        Integer size,
        String keyWord
);

    public ProductsResponse getProductById(String id);

    public String deleteProductById(String id);

    public BaseResponseNw<Product> createProduct(Product theItem);

    public BaseResponseNw<Product> updateProductById(int id, ProductDTO theProductDTO);

    public BaseResponseNw<Page<ProductDTO>> getProductByCategory(
            Integer page,
            Integer size,
            String category);
}
