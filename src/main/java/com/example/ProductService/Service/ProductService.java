package com.example.ProductService.Service;

import com.example.ProductService.Exceptions.ProductNotFoundException;
import com.example.ProductService.Model.Product;

import java.util.List;

public interface ProductService {

    Product getSingleProduct(Long productId) throws ProductNotFoundException;
    List<Product> getAllProducts();
    Product createProduct(Product product);
    void deleteProduct(Long productId);
    void updateProduct(Long productId,Product product);
    void replaceProduct(Long productId,Product product);
}
