package com.example.ProductService.Service;

import com.example.ProductService.Exceptions.ProductNotFoundException;
import com.example.ProductService.Models.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    Product getSingleProduct(Long productId) throws ProductNotFoundException;
    Product createProduct(Product product);
    Product replaceProduct(Long productId, Product product);

}
