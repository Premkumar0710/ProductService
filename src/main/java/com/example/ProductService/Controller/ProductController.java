package com.example.ProductService.Controller;

import com.example.ProductService.Models.Product;
import com.example.ProductService.Service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    // constructor injection
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/{productId}")
    public Product getSingleProduct(@PathVariable Long productId){
        return productService.getSingleProduct(productId);
    }

    @GetMapping()
    public Product getAllProducts(){
        return null;
    }

    @PostMapping()
    public Product createProduct(@RequestBody Product product){
        return null;
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable Long productId, @RequestBody Product product){
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long productId){

    }


}
