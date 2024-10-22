package com.example.ProductServiceJune24.Services;

import com.example.ProductServiceJune24.Models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long id);
    List<Product> getAllProducts();

}
