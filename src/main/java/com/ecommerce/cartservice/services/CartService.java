package com.ecommerce.cartservice.services;

import com.ecommerce.cartservice.Models.Basket;
import com.ecommerce.cartservice.Models.Product;
import com.ecommerce.cartservice.Models.User;
import com.ecommerce.cartservice.Models.item;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CartService {
    Optional<item> findItem(Long itemId);

    void updateBasket(Long itemId, Long basketId);

    Optional<Basket> findBasketById(Long basketId);

    Optional<Basket> findBasketByIdAndDeletedFalse(Long basketId);

    void deleteBasket(Basket existingBasket);
   

    Basket createBasket(Basket basket);

    item createItem(item item);

    User createUser(User user);

    Product createProduct(Product product);
}
