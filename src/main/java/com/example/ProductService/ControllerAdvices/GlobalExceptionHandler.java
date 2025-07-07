package com.example.ProductService.ControllerAdvices;

import com.example.ProductService.Dtos.ProductNotFoundExceptionDtos;
import com.example.ProductService.Exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    private ResponseEntity<ProductNotFoundExceptionDtos> handleProductNotFound(ProductNotFoundException ex){
        ProductNotFoundExceptionDtos dto = new ProductNotFoundExceptionDtos();
        dto.setMessage("Product not found with the given id : " + ex.getProductId());
        dto.setResolution("Please pass a valid input.");
        dto.setProductId(ex.getProductId());
        return new ResponseEntity<>(
                dto,
                HttpStatus.UNAUTHORIZED
        );
    }

    @ExceptionHandler(RuntimeException.class)
    private void handleRuntimeException(){

    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    private void handleArrayIndexOutOfBoundsException(){

    }


}
