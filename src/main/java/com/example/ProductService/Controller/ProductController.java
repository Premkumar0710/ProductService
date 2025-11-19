package com.example.ProductService.Controller;

import com.example.ProductService.Exceptions.ProductNotFoundException;
import com.example.ProductService.Models.Product;
import com.example.ProductService.Service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    // constructor injection
    public ProductController(@Qualifier("SelfProductService") ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable Long productId) throws ProductNotFoundException {
          Product product = productService.getSingleProduct(productId);
          return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping()
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable Long productId, @RequestBody Product product){
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long productId){

    }


}
