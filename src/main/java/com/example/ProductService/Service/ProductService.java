package com.example.ProductService.Service;

import com.example.ProductService.Exceptions.ProductNotFoundException;
import com.example.ProductService.Models.Product;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAllProducts();
    Product getSingleProduct(Long productId) throws ProductNotFoundException;
    Product createProduct(Product product);
    Product replaceProduct(Long productId, Product product);
    Page<Product> getProductsByTitle(String title, int pageNumber, int pageSize);

}
