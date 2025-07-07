package com.example.ProductService.Controller;

import com.example.ProductService.Exceptions.ProductNotFoundException;
import com.example.ProductService.Model.Product;
import com.example.ProductService.Service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
// make sure controller is as light as possible
public class ProductController {

    private ProductService productService;

    // Constructor injection
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long productId)throws ProductNotFoundException{
//        try{
//           return new ResponseEntity<>(
//                    productService.getSingleProduct(productId),
//                   HttpStatus.OK
//            );
//        }
//        catch (ProductNotFoundException e){
//            return new ResponseEntity<>(
//                    HttpStatus.NOT_FOUND
//            );
//        }
//
//        catch (RuntimeException e){
//            return new ResponseEntity<>(
//                   HttpStatus.BAD_REQUEST
//            );
//        }

        return new ResponseEntity<>(
                productService.getSingleProduct(productId),
                HttpStatus.OK
        );

    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping
    public Product createProduct(Product product){
        return productService.createProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long productId){
         productService.deleteProduct(productId);
    }

    @PatchMapping("/{id}")
    public void updateProduct(@PathVariable("id") Long ProductId, @RequestBody Product product){
        productService.updateProduct(ProductId, product);
    }

    @PutMapping("/{id}")
    public void replaceProduct(@PathVariable("id") Long ProductId, @RequestBody Product product){
        productService.replaceProduct(ProductId,product);
    }
}



