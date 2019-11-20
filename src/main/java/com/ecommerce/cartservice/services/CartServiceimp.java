package com.ecommerce.cartservice.services;

import com.ecommerce.cartservice.Models.Basket;
import com.ecommerce.cartservice.Models.Product;
import com.ecommerce.cartservice.Models.User;
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

    @Override
    public Basket createBasket(Basket basket) {
        return this.basketRepository.save(basket);
    }

    @Override
    public item createItem(item item) {
        return this.itemRepository.save(item);
    }

    @Override
    public User createUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public Product createProduct(Product product) {
        return this.productRepository.save(product);
    }
}
