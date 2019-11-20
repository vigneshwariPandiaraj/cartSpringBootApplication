package com.ecommerce.cartservice.Repositories;

import com.ecommerce.cartservice.Models.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BasketRepository extends CrudRepository<Basket, Long>, JpaSpecificationExecutor<Basket> {

}
