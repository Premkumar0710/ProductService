package com.example.ProductServiceJune24.Services;

import com.example.ProductServiceJune24.CustomExceptions.ProductNotFoundException;
import com.example.ProductServiceJune24.Models.Category;
import com.example.ProductServiceJune24.Models.Product;
import com.example.ProductServiceJune24.Repository.CategoryRepository;
import com.example.ProductServiceJune24.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("SelfProductService")
public class SelfProductService implements ProductService {
   private ProductRepository productRepository;
   private CategoryRepository categoryRepository;

   public SelfProductService(ProductRepository productRepository , CategoryRepository categoryRepository){
       this.productRepository = productRepository;
       this.categoryRepository = categoryRepository;
   }

    @Override
    public Product getSingleProduct(Long id) throws ProductNotFoundException {
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isEmpty()){
            throw new ProductNotFoundException("Product with id : " + id + "doesn't exist");
        }
        return productOptional.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product updateProduct(Long id, Product product) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("Product with id : " + id + "doesn't exist");
        }
        Product productInDB = optionalProduct.get();
        if(product.getTitle()!= null){
            productInDB.setTitle(product.getTitle());
        }
        if(product.getPrice()!= null){
            productInDB.setPrice(product.getPrice());
        }
        return productRepository.save(productInDB);
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override

    // not working properly .... fix this
    public Product addNewProduct(Product product) {
        // need to check whether we have category or not else it will create transient save issues

        Category category = product.getCategory();
//       if(category.getId() == null){
//           // create a new category obj in db first
//           category = categoryRepository.save(category);
//           product.setCategory(category);
//       }
        return productRepository.save(product);
    }
}
