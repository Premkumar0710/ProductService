package com.example.ProductService.Controller;

import com.example.ProductService.Model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/{id}")
    public Product getSingleProduct(){
        return new Product();
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return new ArrayList<>();
    }

    @PostMapping
    public Product createProduct(){
        return new Product();
    }

    @DeleteMapping("/{id}")
    public Product deleteProduct(){
        return new Product();
    }
}
