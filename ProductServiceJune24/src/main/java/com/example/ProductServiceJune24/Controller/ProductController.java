package com.example.ProductServiceJune24.Controller;

import com.example.ProductServiceJune24.Models.Product;
import com.example.ProductServiceJune24.Services.FakeStoreProductService;
import com.example.ProductServiceJune24.Services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    // here product is given as return type because we are going return all the attr of products
    @GetMapping("/{id}")
    public Product getSingleProduct(@PathVariable("id") Long id){
        return productService.getSingleProduct(id);
    }

    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
}
