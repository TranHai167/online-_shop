package com.example.productmanagmentmodule.service.impl;

import com.example.productmanagmentmodule.entity.Products;
import com.example.productmanagmentmodule.entity.ShoppingCart;
import com.example.productmanagmentmodule.model.ShoppingCartItem;
import com.example.productmanagmentmodule.model.dto.ShoppingCartDTO;
import com.example.productmanagmentmodule.model.request.AddShoppingCartInfoRequest;
import com.example.productmanagmentmodule.model.request.UpdateShoppingCartRequest;
import com.example.productmanagmentmodule.repository.ProductRepository;
import com.example.productmanagmentmodule.repository.ShoppingCartRepository;
import com.example.productmanagmentmodule.service.ShoppingCartService;
import com.example.productmanagmentmodule.exception.CommonException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductRepository productRepository;

    @Autowired
    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, ProductRepository productRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.productRepository = productRepository;
    }

    @Override
    public ShoppingCartDTO getShoppingCartDetail(String cartId) {
        List<ShoppingCart> cart = shoppingCartRepository.findAllByCartId(cartId).orElse(null);
        if (cart == null) return null;
        List<ShoppingCartItem> items = new ArrayList<>();
        for (ShoppingCart inCart: cart) {
            Products product = productRepository.findFirstById(inCart.getProductId());
            ShoppingCartItem item = new ShoppingCartItem(product, inCart.getQuantity());
            items.add(item);
        }

        ShoppingCartItem[] shoppingCartItems = items.toArray(new ShoppingCartItem[0]);
        return new ShoppingCartDTO(cartId, shoppingCartItems);
    }

    @Override
    public String createShoppingCart(AddShoppingCartInfoRequest request) {
        String cartId = request.getCartId();
        Products product = request.getProducts();

        // logic to save to db ShoppingCartRepository
        ShoppingCart shoppingCart = new ShoppingCart(cartId, product.getId(), request.getQuantity());

        shoppingCartRepository.save(shoppingCart);
        return cartId;
    }


    @Override
    public int updateShoppingCart(UpdateShoppingCartRequest request) {
        String cartId = request.getCartId();
        int change = request.getChange();
        int productId = request.getProduct().getId();
        ShoppingCart cart = shoppingCartRepository.findFirstByCartIdAndProductId(cartId, productId);
        int newQuantity = cart.getQuantity() + change;
        cart.setQuantity(newQuantity);
        shoppingCartRepository.save(cart);
        return newQuantity;
    }

    @Override
    public void createDefaultShoppingCart(String cartId) {
        List<Integer> productIds = productRepository.findAllProducts();
        List<ShoppingCart> shoppingCartList = new ArrayList<>();
        for (Integer id: productIds) {
            ShoppingCart defaultCart = new ShoppingCart(cartId, id, 0);
            shoppingCartList.add(defaultCart);
        }

        shoppingCartRepository.saveAll(shoppingCartList);
    }

    @Override
    public String deleteShoppingCart(AddShoppingCartInfoRequest request) {
        String cartId = request.getCartId();
        Products product = request.getProducts();

        // logic to update to db ShoppingCartRepository
//        ShoppingCart updateShoppingCart = shoppingCartRepository.findAllByCartId(cartId).orElse(null);
//        if (updateShoppingCart != null){
//            if (updateShoppingCart.getQuantity() != 1){
//                updateShoppingCart.setQuantity(updateShoppingCart.getQuantity() - 1);
//                shoppingCartRepository.save(updateShoppingCart);
//                return cartId;
//            }
//            shoppingCartRepository.delete(updateShoppingCart);
//            return cartId;
//        }
//        throw new CommonException("400", "shopping cart doesn't exist");
        return null;
    }
}
