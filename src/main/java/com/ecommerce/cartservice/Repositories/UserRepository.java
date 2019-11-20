package com.ecommerce.cartservice.Repositories;

import com.ecommerce.cartservice.Models.Basket;
import com.ecommerce.cartservice.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, Long>, JpaSpecificationExecutor<User> {

}
