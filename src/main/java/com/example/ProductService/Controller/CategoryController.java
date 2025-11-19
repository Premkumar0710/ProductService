package com.example.ProductService.Controller;

import com.example.ProductService.Models.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @GetMapping("/{categoryId}")
    public Category getCategoryById(@PathVariable Long categoryId){
        throw new RuntimeException();
    }
}
