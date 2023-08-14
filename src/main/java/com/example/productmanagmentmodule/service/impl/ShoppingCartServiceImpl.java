package com.example.productmanagmentmodule.service.impl;

import com.example.productmanagmentmodule.model.request.AddShoppingCartInfoRequest;
import com.example.productmanagmentmodule.repository.ShoppingCartRepository;
import com.example.productmanagmentmodule.service.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;

//    @Override
//    public String createShoppingCart(AddShoppingCartInfoRequest request) {
//        String cartId = request.getCartId();
//        Product product = request.getProduct();
//
//        // logic to save to db ShoppingCartRepository
//        ShoppingCart shoppingCart = new ShoppingCart();
//        shoppingCart.setCartId(cartId);
//        shoppingCart.setQuantity(request.getQuantity());
//        shoppingCart.setProductId(product.getId());
//
//        shoppingCartRepository.save(shoppingCart);
//        return cartId;
//    }

    @Override
    public String createShoppingCart(AddShoppingCartInfoRequest request) {
        return null;
    }

    @Override
    public String updateShoppingCart(AddShoppingCartInfoRequest request) {
        return null;
    }

//    @Override
//    public String updateShoppingCart(AddShoppingCartInfoRequest request) {
//        String cartId = request.getCartId();
//        Product product = request.getProduct();
//
//        // logic to update to db ShoppingCartRepository
//        ShoppingCart updateShoppingCart = shoppingCartRepository.findById(cartId).orElse(null);
//        if (updateShoppingCart != null){
//            updateShoppingCart.setQuantity(updateShoppingCart.getQuantity() + 1);
//            return cartId;
//        }
//        throw new CommonException("400", "shopping cart doesn't exist");
//    }

    @Override
    public String deleteShoppingCart(AddShoppingCartInfoRequest request) {
        return null;
    }

//    @Override
//    public String deleteShoppingCart(AddShoppingCartInfoRequest request) {
//        String cartId = request.getCartId();
//        Product product = request.getProduct();
//
//        // logic to update to db ShoppingCartRepository
//        ShoppingCart updateShoppingCart = shoppingCartRepository.findById(cartId).orElse(null);
//        if (updateShoppingCart != null){
//            if (updateShoppingCart.getQuantity() == 1){
//                shoppingCartRepository.delete(updateShoppingCart);
//                return cartId;
//            }
//            updateShoppingCart.setQuantity(updateShoppingCart.getQuantity() - 1);
//            return cartId;
//        }
//        throw new CommonException("400", "shopping cart doesn't exist");
//    }

}
