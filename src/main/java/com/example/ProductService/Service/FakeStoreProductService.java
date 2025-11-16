package com.example.ProductService.Service;

import com.example.ProductService.Dtos.FakeStoreProductDto;
import com.example.ProductService.Models.Category;
import com.example.ProductService.Models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product getSingleProduct(Long productId) {
        // make a http call to fakestoreapi to get the product with given id

       // RestTemplate restTemplate = new RestTemplate(); -> added this in configs package to make it globally available
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.getForEntity("https://fakestoreapi.com/products/" + productId, FakeStoreProductDto.class);
      //  FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();

        // convert fakeStoreProductDto to product
        return convertFakeStoreProductDtoToProduct(responseEntity.getBody());
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long productId, Product product) {
        return null;
    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto){

        if(fakeStoreProductDto == null){
            return null;
        }

        Product product = new Product();
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImageUrl(fakeStoreProductDto.getImage());

        Category category = new Category();
        category.setTitle(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        product.setId(fakeStoreProductDto.getId());

        return product;
    }
}
