package com.ecommerce.cartservice.services;

import com.ecommerce.cartservice.Models.Basket;
import com.ecommerce.cartservice.Models.item;

import java.util.Optional;

public interface CartService {
    Optional<item> findItem(Long itemId);

    void updateBasket(Long itemId, Long basketId);

    Optional<Basket> findBasketById(Long basketId);

    Optional<Basket> findBasketByIdAndDeletedFalse(Long basketId);

    void deleteBasket(Basket existingBasket);
}
