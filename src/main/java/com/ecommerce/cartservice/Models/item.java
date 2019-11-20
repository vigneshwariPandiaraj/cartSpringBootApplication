package com.ecommerce.cartservice.Models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


public class item extends BaseModel  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @ManyToOne
    private Product product;
}
