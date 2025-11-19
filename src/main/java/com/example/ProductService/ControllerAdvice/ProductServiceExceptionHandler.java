package com.example.ProductService.ControllerAdvice;

import com.example.ProductService.Exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductServiceExceptionHandler {

    // this method would be triggered if any method in controller gets Runtime exception
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Void> handleRunTimeException(){
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException(){
        return new ResponseEntity<>("Please enter a valid product id.",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException productNotFoundException){
        return new ResponseEntity<>(productNotFoundException.getProductId() + " is an invalid product id.", HttpStatus.INTERNAL_SERVER_ERROR);
    }






}
