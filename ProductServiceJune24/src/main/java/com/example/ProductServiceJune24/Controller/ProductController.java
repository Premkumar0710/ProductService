package com.example.ProductServiceJune24.Controller;

import com.example.ProductServiceJune24.CustomExceptions.ProductNotFoundException;
import com.example.ProductServiceJune24.Models.Product;
import com.example.ProductServiceJune24.Services.FakeStoreProductService;
import com.example.ProductServiceJune24.Services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(@Qualifier("SelfProductService") ProductService productService) {
        this.productService = productService;
    }

    // here product is given as return type because we are going return all the attr of products
    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long id) throws ProductNotFoundException {
        ResponseEntity<Product> response = new ResponseEntity<>(
                productService.getSingleProduct(id),
                HttpStatus.OK
        );
        return response;
    }

    @GetMapping()
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
       productService.deleteProduct(id);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) throws ProductNotFoundException {
        return productService.updateProduct(id, product);
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable Long id, @RequestBody Product product) {
        return null;
    }

//    public ResponseEntity<String> handleArithmeticException(){
//        public ResponseEntity<String> handleArithmeticException(){
//            ResponseEntity<String> response = new ResponseEntity<>(
//                    "Arithmetic exception has happened, inside product controller" , HttpStatus.NOT_FOUND
//            );
//            return response;
//        }
//    }

    // CRUD OPERATIONS
    @PostMapping
    public Product addNewProduct(@RequestBody Product product){
        return productService.addNewProduct(product);
    }


}


