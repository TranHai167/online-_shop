package com.example.productmanagmentmodule.service.impl;

import com.example.productmanagmentmodule.entity.Products;
import com.example.productmanagmentmodule.exception.CommonException;
import com.example.productmanagmentmodule.model.request.UpdateProductRequest;
import com.example.productmanagmentmodule.model.response.ProductsResponse;
import com.example.productmanagmentmodule.repository.ProductRepository;
import com.example.productmanagmentmodule.service.ProductService;
import com.example.productmanagmentmodule.service.RawQueryService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

import static com.example.productmanagmentmodule.util.JsonUtil.applyPaging;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final RawQueryService rawQueryService;

    private final ProductRepository productRepository;
//    @Override
//    public Page<ProductsResponse> getAllProducts(Integer page, Integer size, String keyWord) {
//        List<Products> products;
//        List<ProductsResponse> productsResponseList;
//
//        products = rawQueryService.searchItem(page, size, keyWord);
//        productsResponseList = new ArrayList<>();
//
//        for (Products item : products){
//            ProductsResponse productsResponse = convertToResponse(item);
//            productsResponseList.add(productsResponse);
//        }
//        return applyPaging(productsResponseList, page, size);
//    }


    @Override
    public List<ProductsResponse> getAllProducts() {
        List<ProductsResponse> responses = new ArrayList<>();
        List<Products> products = productRepository.findAll();
        for (Products p: products) {
            ProductsResponse productsResponse = new ProductsResponse();
            BeanUtils.copyProperties(p, productsResponse);
            responses.add(productsResponse);
        }

        return responses;
    }

    @Override
    public ProductsResponse getProductById(Integer id) {
        Products products = productRepository.findById(id).orElse(null);
        if (products != null){
            ProductsResponse productsResponse = convertToResponse(products);
            return productsResponse;
        }
        throw new CommonException("200", "Product doesn't exist");
    }

    @Override
    public String deleteProductById(Integer id) {
        productRepository.deleteById(id);
        return String.valueOf(id);
    }

    @Override
    public String createProduct(Products theProduct) {
        productRepository.save(theProduct);
        return String.valueOf(theProduct.getId());
    }

    @Override
    public String updateProductById(Integer id, ProductsResponse productsResponse) {
        Products updateProduct = productRepository.findById(id).orElseThrow(() -> new CommonException("400", "product doesn't exist"));
        boolean updated = false;

        if (productsResponse.getCategory() != null) {
            updateProduct.setCategory(productsResponse.getCategory());
            updated = true;
        }
        if (productsResponse.getTitle() != null) {
            updateProduct.setTitle(productsResponse.getTitle());
            updated = true;
        }
        if (productsResponse.getPrice() != 0) {
            updateProduct.setPrice(productsResponse.getPrice());
            updated = true;
        }
        if (productsResponse.getImageUrl() != null){
            updateProduct.setImageUrl((productsResponse.getImageUrl()));
            updated = true;
        }
        if (updated) {
            productRepository.save(updateProduct);
        }

        return String.valueOf(id);
    }

    @Override
    public Page<ProductsResponse> getProductByCategory(Integer page, Integer size, String category) {
        List<Products> productsList = productRepository.getProductByCategory(category);
        List<ProductsResponse> productsResponseList = new ArrayList<>();

        if (productsList != null){
            for (Products item : productsList){
                ProductsResponse productsResponse = convertToResponse(item);
                productsResponseList.add(productsResponse);
            }
            return applyPaging(productsResponseList, page, size);
        }
        throw new CommonException("400", "Product doesn't exist");
    }

    private static ProductsResponse convertToResponse(Products products) {
        if (products == null){
            return null;
        }
        return ProductsResponse
                .builder()
                .id(products.getId())
                .title(products.getTitle())
                .category(products.getCategory())
                .price(products.getPrice())
                .imageUrl(products.getImageUrl())
                .build();
    }


    @Override
    public Integer updateProduct(UpdateProductRequest request) {
        Integer productId = request.getProductId();
        Products product = request.getProduct();
        productRepository.deleteById(productId);
        productRepository.save(product);
        return request.getProductId();
    }
}
