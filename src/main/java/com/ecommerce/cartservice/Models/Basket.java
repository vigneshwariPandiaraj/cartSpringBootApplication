package com.ecommerce.cartservice.Models;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Basket extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @OneToMany
    private Collection<item> items;

    @NotNull
    @ManyToOne
    private User user;


}
