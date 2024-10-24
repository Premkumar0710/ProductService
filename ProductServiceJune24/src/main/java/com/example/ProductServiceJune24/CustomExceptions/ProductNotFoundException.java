package com.example.ProductServiceJune24.CustomExceptions;

public class ProductNotFoundException extends Exception{

    public ProductNotFoundException(String message){
        super(message);
    }

}
