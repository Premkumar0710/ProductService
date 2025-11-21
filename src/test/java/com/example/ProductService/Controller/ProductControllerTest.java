package com.example.ProductService.Controller;

import com.example.ProductService.Exceptions.ProductNotFoundException;
import com.example.ProductService.Models.Category;
import com.example.ProductService.Models.Product;
import com.example.ProductService.Service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/*
* General Note : Here we won't mock controller since e have to test controller in controller test package
* So we will mock services & other stuffs
* When we move to service tests , there we won't mock service flow
* */

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @Test
    public void testGetSingleProductPositive() throws ProductNotFoundException {
        Long productId = 10L;
        Product expected = new Product();
        when(productService.getSingleProduct(productId)).thenReturn(expected);

        var response = productController.getSingleProduct(productId);
        assertNotNull(response);
        assertEquals(expected, response.getBody()); // only works if equals is implemented
    }

    @Test
    public void testGetSingleProductNegative() throws ProductNotFoundException {
        Long productId = -1L;
        Product expected = new Product();
        when(productService.getSingleProduct(productId)).thenThrow(ProductNotFoundException.class);

        assertThrows(ProductNotFoundException.class,
                ()->productService.getSingleProduct(productId));
    }

    @Test
    public void testGetAllProductsPositive(){
        // stub
        Product p1 = new Product();
        p1.setCategory(new Category());
        p1.setId(1L);
        p1.setImageUrl("aaa");
        p1.setPrice(10.0);

        Product p2 = new Product();
        p2.setCategory(new Category());
        p2.setId(2L);
        p2.setImageUrl("bbb");
        p2.setPrice(20.0);

        List<Product> expectedProducts = Arrays.asList(p1,p2);

        when(productService.getAllProducts()).thenReturn(expectedProducts);
        List<Product> actualProducts = productService.getAllProducts();
        assertArrayEquals(expectedProducts.toArray(),actualProducts.toArray());
    }
}
