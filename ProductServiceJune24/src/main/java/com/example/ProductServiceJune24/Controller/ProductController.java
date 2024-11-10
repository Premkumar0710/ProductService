package com.example.ProductServiceJune24.Controller;

import com.example.ProductServiceJune24.CustomExceptions.ProductNotFoundException;
import com.example.ProductServiceJune24.Models.Product;
import com.example.ProductServiceJune24.Services.FakeStoreProductService;
import com.example.ProductServiceJune24.Services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    // @Qualifier("FakeStoreProductService") , @Qualifier("SelfProductService")
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
    // Implementing Pagination
    public Page<Product> getAllProducts(@RequestParam("pageNumber") int pageNumber , @RequestParam("pageSize") int pageSize) {
        return productService.getAllProducts(pageNumber,pageSize);
        // also try to do : return List by converting page of objects to list
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) throws ProductNotFoundException {
       productService.deleteProduct(id);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) throws ProductNotFoundException {
        return productService.updateProduct(id, product);
    }

    // this method will change its current entry to new entry , if we try to replace product with id : 2 , it will accept all changes ; deletes current entry & gets created as a new entry
    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.addNewProduct(id,product);
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
//    @PostMapping
//    public Product addNewProduct(@RequestBody Product product){
//        return productService.addNewProduct(product);
//    }

}


