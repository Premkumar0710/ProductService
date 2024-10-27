package com.example.ProductServiceJune24.Services;

import com.example.ProductServiceJune24.CustomExceptions.ProductNotFoundException;
import com.example.ProductServiceJune24.Models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long id) throws ProductNotFoundException;
    List<Product> getAllProducts();

    Product updateProduct(Long id, Product product) throws ProductNotFoundException;
    Product replaceProduct(Long id, Product product);
    void deleteProduct(Long id);
    Product addNewProduct(Product product);

}
