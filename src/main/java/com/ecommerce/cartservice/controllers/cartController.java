package com.ecommerce.cartservice.controllers;

import com.ecommerce.cartservice.Models.Basket;
import com.ecommerce.cartservice.Models.Product;
import com.ecommerce.cartservice.Models.User;
import com.ecommerce.cartservice.Models.item;
import com.ecommerce.cartservice.services.CartService;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.google.common.base.Preconditions.checkArgument;

@RestController
@RequestMapping("/cart/")
//@CrossOrigin("localhost://3000") // Allow only front end server to access the backend server.
public class cartController {

    private final CartService cartService;


    @Autowired
    public cartController(CartService cartService) {
        this.cartService = cartService;

    }

  //  @PreAuthorize("hasAnyRole('ROLE_NOTE_UPDATE', 'ROLE_ALL')")
    //Enable API Call based on roles only.
    @PutMapping("/{id:\\d+}")
    public ResponseEntity<?> addItemToBasket(@PathVariable("itemId") Long itemId,@PathVariable("basketId") Long basketId) {
        final Optional<item> item = this.cartService.findItem(itemId);
        checkArgument(item != null, "Note %s is not valid.", itemId);

        this.cartService.updateBasket(itemId, basketId);
        return ResponseEntity.ok().build();
    }

  //  @PreAuthorize("hasAnyRole('ROLE_NOTE_VIEW', 'ROLE_ALL')")
  //Enable API Call based on roles only.
    @GetMapping("/{id:\\d+}")
    public ResponseEntity<Basket> findBasket(@PathVariable("basketId") Long basketId) {
        final Optional<Basket> basket = this.cartService.findBasketById(basketId);
        return basket != null ? ResponseEntity.ok(basket.get()) : ResponseEntity.notFound().build();
    }

   // @PreAuthorize("hasRole('ROLE_POS_DELETE')")
   //Enable API Call based on roles only.
    @DeleteMapping("/{id:\\d+}")
    public ResponseEntity<?> deleteBasket(@PathVariable("basketId") Long basketId) {
        final Optional<Basket> existingBasket = this.cartService.findBasketByIdAndDeletedFalse(basketId);
        checkArgument(existingBasket != null, "retailerPos.update.error.invalidId");

        this.cartService.deleteBasket(existingBasket.get());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/createBasket")
    public  Basket createBasket(@PathVariable("basker") Basket basket) {
      return  this.cartService.createBasket(basket);
    }

    @PostMapping("/createItem")
    public item createItem(@PathVariable("Item") item item) {
        return  this.cartService.createItem(item);
    }

    @PostMapping("/createUser")
    public User createUser(@PathVariable("User") User user) {
        return  this.cartService.createUser(user);
    }

    @PostMapping("/createProduct")

    public Product createProduct(@PathVariable("Product") Product product) {
        return  this.cartService.createProduct(product);
    }


    }

