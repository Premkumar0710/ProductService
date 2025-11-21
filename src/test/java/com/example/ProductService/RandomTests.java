package com.example.ProductService;

import com.example.ProductService.Controller.ProductController;
import com.example.ProductService.Exceptions.ProductNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class RandomTests {

    // it's a method which gets executed automatically at the time of building or deployment
    private ProductController productController;

    @Test
    @DisplayName("Add testCase")
    public void sampleTest(){
        // arrange
        int a = 10 , b = 7;

        // act
        int result = a+b;

        // assert
       // assert result == 17;
        assertEquals(17,result);

        //assertNotEquals(a,b);
        //assertNull();
        /* assertThrows(
                ProductNotFoundException.class,
                ()->productController.getSingleProduct(-1L)
        );*/

        /* assertTimeout(
                Duration.ofSeconds(1),
                productController.getSingleProduct(10L)
        );*/
    }


    /*
    *  AAA Framework
    *
    * A - Arrange (input params)
    * A - Act (call the function that we want to test)
    * A - Assert (Validate the actual output against the expected output)
    *
    * */
}
