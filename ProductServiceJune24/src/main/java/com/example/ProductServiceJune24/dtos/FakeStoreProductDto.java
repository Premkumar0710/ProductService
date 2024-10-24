package com.example.ProductServiceJune24.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class FakeStoreProductDto {
    private long id;
    private Date createdAt = new Date();
    private Date updatedAt = new Date();
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;


}
