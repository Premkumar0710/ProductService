package com.example.ProductServiceJune24.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
    private String title;
    private Double price;

    @ManyToOne(cascade = CascadeType.PERSIST)
    // 1 product can be part of 1 category ; i category has m products -> m:1
    private Category category;

}
