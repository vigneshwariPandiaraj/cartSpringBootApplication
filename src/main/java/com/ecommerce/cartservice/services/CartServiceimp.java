package com.ecommerce.cartservice.services;

import com.ecommerce.cartservice.Models.Basket;
import com.ecommerce.cartservice.Models.item;
import com.ecommerce.cartservice.Repositories.BasketRepository;
import com.ecommerce.cartservice.Repositories.ItemRepository;
import com.ecommerce.cartservice.Repositories.ProductRepository;
import com.ecommerce.cartservice.Repositories.UserRepository;
import lombok.Builder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Builder
public class CartServiceimp implements CartService{
    private BasketRepository basketRepository;
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    @Override
    public Optional<item> findItem(final Long itemId) {
        return itemRepository.findById(itemId);
    }

    @Override
    public void updateBasket(Long itemId, Long basketId) {

    }

    @Override
    public Optional<Basket> findBasketById(Long basketId) {
        return this.basketRepository.findById(basketId);
    }

    @Override
    public Optional<Basket> findBasketByIdAndDeletedFalse(Long basketId) {
        return this.basketRepository.findById(basketId);
    }

    @Override
    public void deleteBasket(Basket existingBasket) {
this.basketRepository.delete(existingBasket);
    }
}
