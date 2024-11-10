package com.example.ProductServiceJune24.CustomExceptions;

public class ProductNotFoundException extends Exception{

    private Long productId;
    public ProductNotFoundException(String message,Long productId){
        super(message);
        this.productId = productId;
    }
    public Long getProductId() {
        return productId;
    }


}
