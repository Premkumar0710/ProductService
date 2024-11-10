package com.example.ProductServiceJune24.ControllerAdvice;

import com.example.ProductServiceJune24.CustomExceptions.ProductNotFoundException;
import com.example.ProductServiceJune24.dtos.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDto> handleArithmeticException() {
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Arithmetic exception has happened");
        exceptionDto.setSolution("I don't know, please try again");

        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(
                exceptionDto, HttpStatus.NOT_FOUND
        );
        return response;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleProductNotFoundException(ProductNotFoundException exception) {
        ExceptionDto exceptionDto = new ExceptionDto();
        // Todo : Pass the input id in the exception message -> done
        exceptionDto.setMessage("Product with id: "+ exception.getProductId()+ " Not Found");
        exceptionDto.setSolution("Please try again..with a valid id");

        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(
                exceptionDto, HttpStatus.NOT_FOUND
        );
        return response;
    }
}




//    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
//    public ResponseEntity<String> handleArrayOutOfBoundException(){
//        ResponseEntity<String> response = new ResponseEntity<>(
//                "Array Out Of Bound exception has happened" , HttpStatus.NOT_FOUND
//        );
//        return response;
//    }
//
//    @ExceptionHandler(NullPointerException.class)
//    public ResponseEntity<String> handleNullPointerException(){
//        ResponseEntity<String> response = new ResponseEntity<>(
//                "Null Pointer Exception has happened" , HttpStatus.NOT_FOUND
//        );
//        return response;

