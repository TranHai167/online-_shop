package com.example.productmanagmentmodule.service.impl;

import com.example.productmanagmentmodule.entity.Products;
import com.example.productmanagmentmodule.entity.ShoppingCart;
import com.example.productmanagmentmodule.model.request.AddShoppingCartInfoRequest;
import com.example.productmanagmentmodule.repository.ShoppingCartRepository;
import com.example.productmanagmentmodule.service.ShoppingCartService;
import com.example.productmanagmentmodule.exception.CommonException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;

    @Override
    public String createShoppingCart(AddShoppingCartInfoRequest request) {
        String id = request.getId();
        String cartId = request.getCartId();
        Products product = request.getProducts();

        // logic to save to db ShoppingCartRepository
        ShoppingCart shoppingCart = new ShoppingCart(id, cartId, product.getId(), request.getQuantity());

        shoppingCartRepository.save(shoppingCart);
        return id;
    }


    @Override
    public String updateShoppingCart(AddShoppingCartInfoRequest request) {
        String id = request.getId();
        String cartId = request.getCartId();
        Products product = request.getProducts();

        // logic to update to db ShoppingCartRepository
        ShoppingCart updateShoppingCart = shoppingCartRepository.findById(id).orElse(null);
        if (updateShoppingCart != null){
            updateShoppingCart.setQuantity(updateShoppingCart.getQuantity() + 1);
            shoppingCartRepository.save(updateShoppingCart);
            return  id;
        }
        throw new CommonException("400", "shopping cart doesn't exist");
    }


    @Override
    public String deleteShoppingCart(AddShoppingCartInfoRequest request) {
        String id = request.getId();
        String cartId = request.getCartId();
        Products product = request.getProducts();

        // logic to update to db ShoppingCartRepository
        ShoppingCart updateShoppingCart = shoppingCartRepository.findById(id).orElse(null);
        if (updateShoppingCart != null){
            if (updateShoppingCart.getQuantity() != 1){
                updateShoppingCart.setQuantity(updateShoppingCart.getQuantity() - 1);
                shoppingCartRepository.save(updateShoppingCart);
                return cartId;
            }
            shoppingCartRepository.delete(updateShoppingCart);
            return cartId;
        }
        throw new CommonException("400", "shopping cart doesn't exist");
    }

}
