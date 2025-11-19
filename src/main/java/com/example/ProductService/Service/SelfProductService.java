package com.example.ProductService.Service;

import com.example.ProductService.Exceptions.ProductNotFoundException;
import com.example.ProductService.Models.Category;
import com.example.ProductService.Models.Product;
import com.example.ProductService.Repository.CategoryRepository;
import com.example.ProductService.Repository.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("SelfProductService")
// @Primary - since we used qualifier - commenting it out
public class SelfProductService implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository,CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Product> getAllProducts() {
       List<Product> getAllProducts =  productRepository.findAll();
        return getAllProducts;
    }

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        Optional<Product> optionalProduct =  productRepository.findById(productId);
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException(productId);
        }
        return optionalProduct.get();
    }

    @Override
    public Product createProduct(Product product) {
        // add validations if required

        // here we will handle category which is the internal object , so while creating the object we should save category first & then we should save product

        Category category = product.getCategory();
        Optional<Category> optionalCategory = categoryRepository.findByTitle(category.getTitle());

        if(optionalCategory.isEmpty()){
            // create a category
            Category savedCategory = categoryRepository.save(category);
            // after saving category set it product. That's all
            product.setCategory(savedCategory);
        }

        return productRepository.save(product);
    }

    @Override
    public Product replaceProduct(Long productId, Product product) {
        return null;
    }
}
