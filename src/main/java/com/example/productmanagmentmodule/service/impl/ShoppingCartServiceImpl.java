package com.example.productmanagmentmodule.service.impl;

import com.example.productmanagmentmodule.entity.PlacedOrders;
import com.example.productmanagmentmodule.entity.Products;
import com.example.productmanagmentmodule.entity.ShoppingCart;
import com.example.productmanagmentmodule.model.ShoppingCartItem;
import com.example.productmanagmentmodule.model.dto.ShoppingCartDTO;
import com.example.productmanagmentmodule.model.request.AddShoppingCartInfoRequest;
import com.example.productmanagmentmodule.model.request.UpdateShoppingCartRequest;
import com.example.productmanagmentmodule.repository.PlacedOrdersRepository;
import com.example.productmanagmentmodule.repository.ProductRepository;
import com.example.productmanagmentmodule.repository.ShoppingCartRepository;
import com.example.productmanagmentmodule.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductRepository productRepository;

    private final PlacedOrdersRepository placedOrdersRepository;

    @Autowired
    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, ProductRepository productRepository, PlacedOrdersRepository placedOrdersRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.productRepository = productRepository;
        this.placedOrdersRepository = placedOrdersRepository;
    }

    @Override
    public ShoppingCartDTO getShoppingCartDetail(String cartId) {
        List<ShoppingCart> cart = shoppingCartRepository.findAllByCartId(cartId).orElse(null);
        if (cart == null) return null;
        List<ShoppingCartItem> items = new ArrayList<>();
        for (ShoppingCart inCart: cart) {
            Products product = productRepository.findFirstById(inCart.getProductId());
            if (product == null)
                continue;
            ShoppingCartItem item = new ShoppingCartItem(product, inCart.getQuantity());
            items.add(item);
        }

        ShoppingCartItem[] shoppingCartItems = items.toArray(new ShoppingCartItem[0]);
        return new ShoppingCartDTO(cartId, shoppingCartItems);
    }

    @Override
    @Transactional
    public void createShoppingCart(String cartId) {
        shoppingCartRepository.deleteAllByCartId(cartId);
        createDefaultShoppingCart(cartId);
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
    @Transactional
    public void deleteShoppingCart(String cartId, String orderId) {
        List<ShoppingCart> shoppingCartList = shoppingCartRepository.findAllByCartId(cartId).orElse(null);
        if(shoppingCartList == null) return;
        List<PlacedOrders> placedOrders = new ArrayList<>();
        for (ShoppingCart item: shoppingCartList) {
            if (item.getQuantity() < 1) continue;
            PlacedOrders placed = new PlacedOrders(UUID.randomUUID().toString(), orderId, item.getProductId(), item.getQuantity());
            placedOrders.add(placed);
        }

        placedOrdersRepository.saveAll(placedOrders);
        shoppingCartRepository.deleteAllByCartId(cartId);
        createDefaultShoppingCart(cartId);
    }

    @Override
    @Transactional
    public void clearShoppingCart(String cartId) {
        List<ShoppingCart> shoppingCartList = shoppingCartRepository.findAllByCartId(cartId).orElseThrow();
        for (ShoppingCart item: shoppingCartList) {
            item.setQuantity(0);
        }
        shoppingCartRepository.saveAll(shoppingCartList);
    }

    @Override
    public void addNewProductToShoppingCart(Integer productId) {
        List<String> cartIds = shoppingCartRepository.findDistinctCartId();
        List<ShoppingCart> shoppingCartList = new ArrayList<>();
        for (String id: cartIds) {
            ShoppingCart shoppingCart = new ShoppingCart(id, productId, 0);
            shoppingCartList.add(shoppingCart);
        }

        shoppingCartRepository.saveAll(shoppingCartList);
    }
}
