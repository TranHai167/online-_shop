package com.example.productmanagmentmodule.service.impl;

import com.example.productmanagmentmodule.entity.Products;
import com.example.productmanagmentmodule.exception.CommonException;
import com.example.productmanagmentmodule.model.response.ProductsResponse;
import com.example.productmanagmentmodule.repository.ProductRepository;
import com.example.productmanagmentmodule.service.ProductService;
import com.example.productmanagmentmodule.service.RawQueryService;
import lombok.RequiredArgsConstructor;
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
    @Override
    public Page<ProductsResponse> getAllProducts(Integer page, Integer size, String keyWord) {
        List<Products> products;
        List<ProductsResponse> productsResponseList;

        products = rawQueryService.searchItem(page, size, keyWord);
        productsResponseList = new ArrayList<>();

        for (Products item : products){
            ProductsResponse productsResponse = convertToResponse(item);
            productsResponseList.add(productsResponse);
        }
        return applyPaging(productsResponseList, page, size);
    }

    @Override
    public ProductsResponse getProductById(Integer id) {
        Products products = productRepository.findById(id).orElse(null);
        if (products != null){
            ProductsResponse productsResponse = convertToResponse(products);
            return productsResponse;
        }
        throw new CommonException("400", "Product doesn't exist");
    }

    @Override
    public String deleteProductById(Integer id) {
        Products products = productRepository.findById(id).orElse(null);
        if (products != null){
            productRepository.deleteById(id);
            return String.valueOf(id);
        }
        throw new CommonException("400", "Product doesn't exist");
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


//    @Override
//    public ProductsResponse[] getAllProducts() {
//        ProductsResponse c1 = new ProductsResponse("1", "Bread", "bread", 22.3, "data:image/jpeg;base64,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");
//        ProductsResponse c2 = new ProductsResponse("2", "Carrot", "vegetable", 5.2, "https://th.bing.com/th?id=OIP.ynEZ3ToAUqjCaK7m86DZNQHaFj&w=288&h=216&c=8&rs=1&qlt=90&o=6&dpr=1.3&pid=3.1&rm=2");
//        ProductsResponse c3 = new ProductsResponse("3", "Rice", "food", 12.5, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4Fbg0spCIkHZCjbCI4dpUIEnEbbK_3pHVAzO9myCFoQ&s");
//        ProductsResponse c4 = new ProductsResponse("4", "Noodle", "food", 20.3, "data:image/jpeg;base64,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");
//        ProductsResponse c5 = new ProductsResponse("5", "Mango", "fruit", 12.6, "data:image/jpeg;base64,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");        ProductsResponse c6 = new ProductsResponse("6", "Bread2", "bread", 21.2, "https://th.bing.com/th?id=OSK.c2598c55b115fa9f3cc23347ed8d6645&w=196&h=140&rs=2&qlt=80&o=6&cdv=1&dpr=1.3&pid=16.1");
//        return new ProductsResponse[]{c1, c2, c3, c4, c5, c6};
//    }
//
//    @Override
//    public ProductsResponse getProductById(String id) {
//        ProductsResponse c4 = new ProductsResponse("4", "Noodle", "food", 20.3, "data:image/jpeg;base64,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");
//        return c4;
//    }
}
