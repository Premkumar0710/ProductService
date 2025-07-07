package com.example.ProductService.Exceptions;

import lombok.Getter;

public class ProductNotFoundException extends Exception{

    // constructor
//    public ProductNotFoundException(String message){
//        super(message);
//    }
    @Getter
    private Long productId;
    public ProductNotFoundException(Long productId){
        super("Product not found with ID : " + productId);
        this.productId = productId;
    }

}
