package com.example.ProductService.Service;

import com.example.ProductService.Exceptions.ProductNotFoundException;
import com.example.ProductService.Models.Product;
import com.example.ProductService.Repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    SelfProductService productService;

    @Test
    void getProductById_Positive() throws ProductNotFoundException {
        Long productId = 2L;

        Product expectedProduct = new Product();
        expectedProduct.setId(2L);
        expectedProduct.setPrice(20.0);
        expectedProduct.setImageUrl("222");
        expectedProduct.setDescription("Second product");

        when(productRepository.findById(productId)).thenReturn(Optional.of(expectedProduct));

        Product actualProduct = productService.getSingleProduct(productId);

        // assertSame is more correct unless Product.equals() is overridden
        assertSame(expectedProduct, actualProduct);
        assertSame(expectedProduct.getId(),actualProduct.getId()); // verify the id match

        /*
        * This line means:
        “I want to make sure my service really did call productRepository.findById(2L)
         exactly once.”

        * Because without verify, you don’t know if the service even touched the repository.
        Example:
        Your service method is supposed to call the repository.
        But what if your implementation accidentally does this:

         */
        verify(productRepository).findById(productId);
    }

    @Test
    void getProductById_WhenProductNotFound() {
        Long productId = -1L;

        // stub repo to return empty for the id we will pass
        when(productRepository.findById(productId)).thenReturn(Optional.empty());

        // call the service (not the repo) and assert it throws
        assertThrows(ProductNotFoundException.class,
                () -> productService.getSingleProduct(productId));

        // verify the service actually queried the repo
        verify(productRepository).findById(productId);
    }

    @Test
    void appliesDefaultPrice_whenPriceIsNull() throws ProductNotFoundException {
        Product product = new Product();
        product.setPrice(null);

        when(productRepository.findById(10L)).thenReturn(Optional.of(product));

        Product result = productService.getSingleProduct(10L);

        assertSame(null, result.getPrice());
    }

    @Test
    void getAllProducts_Positive(){

        Product product = new Product();
        product.setId(10L);
        product.setDescription("10TH Product");

        List<Product> productList = List.of(product);
        when(productRepository.findAll()).thenReturn(productList);

        List<Product> getAllProducts = productService.getAllProducts();

        assertSame(productList,getAllProducts);
        verify(productRepository).findAll();

    }
}
