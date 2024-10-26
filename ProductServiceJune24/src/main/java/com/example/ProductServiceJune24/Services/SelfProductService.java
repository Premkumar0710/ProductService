package com.example.ProductServiceJune24.Services;

import com.example.ProductServiceJune24.CustomExceptions.ProductNotFoundException;
import com.example.ProductServiceJune24.Models.Product;
import com.example.ProductServiceJune24.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelfProductService implements ProductService {
   private ProductRepository productRepository;

   public SelfProductService(ProductRepository productRepository){
       this.productRepository = productRepository;
   }

    @Override
    public Product getSingleProduct(Long id) throws ProductNotFoundException {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }
}
