package com.example.ProductService.Service;

import com.example.ProductService.Models.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    Product getSingleProduct(Long productId);
    Product createProduct(Product product);
    Product replaceProduct(Long productId, Product product);

}
