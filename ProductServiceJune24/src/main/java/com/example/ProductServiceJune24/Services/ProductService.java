package com.example.ProductServiceJune24.Services;

import com.example.ProductServiceJune24.CustomExceptions.ProductNotFoundException;
import com.example.ProductServiceJune24.Models.Product;
import org.springframework.data.domain.Page;

public interface ProductService {
    Product getSingleProduct(Long id) throws ProductNotFoundException;
    Page<Product> getAllProducts(int pageNumber , int pageSize);

    Product updateProduct(Long id, Product product) throws ProductNotFoundException;
    Product replaceProduct(Long id, Product product);
    void deleteProduct(Long id) throws ProductNotFoundException;
    Product addNewProduct(Long id, Product product);

}
