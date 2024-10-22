package com.example.ProductServiceJune24.Services;

import com.example.ProductServiceJune24.Models.Category;
import com.example.ProductServiceJune24.Models.Product;
import com.example.ProductServiceJune24.dtos.FakeStoreProductDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate;

      public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long productId) {
        // call FakeStore to fetch the Product with given id. -> HTTP call
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + productId ,
                FakeStoreProductDto.class
        );

        // Convert FakeStoreProductDto into product
        return covertFakeStoreProductToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
          FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject(
                "https://fakestoreapi.com/products" ,
                  FakeStoreProductDto[].class
        );

                //Convert list of FakeStoreProductDto into list of product
                List<Product> products = new ArrayList<>();
                for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos){
                    products.add(covertFakeStoreProductToProduct(fakeStoreProductDto));
                }
                return products;
    }

    private Product covertFakeStoreProductToProduct(FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());

        Category category = new Category();
        category.setDescription(fakeStoreProductDto.getCategory());
        product.setCategory(category);

        return product;
    }
}
