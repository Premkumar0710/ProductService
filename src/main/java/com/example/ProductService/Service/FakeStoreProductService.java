package com.example.ProductService.Service;

import com.example.ProductService.Dtos.FakeStoreProductDto;
import com.example.ProductService.Exceptions.ProductNotFoundException;
import com.example.ProductService.Model.Category;
import com.example.ProductService.Model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate; // comes from Spring web dependency

    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException{
       // throw new ProductNotFoundException("Something went out of control.. as " + productId + " is invalid."); // try to catch the exception by passing product id
        throw new ProductNotFoundException(productId);

//        // gives output in fakeStoreDto
//       FakeStoreProductDto fakeStoreProductDto =  restTemplate.getForObject("https://fakestoreapi.com/products/" + productId, FakeStoreProductDto.class); // in product service we have different attributes , for inviokng 3rd part we cannot hamper our structure , so we use fakestoreDto
//        // convert fakeStoreDto object to product object
//       return convertFakeStoreObjectToProductObject(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {

        // Type Erasure
        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject(
                "https://fakestoreapi.com/products",FakeStoreProductDto[].class
        );
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos){
            products.add(convertFakeStoreObjectToProductObject(fakeStoreProductDto));
        }
        return products;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long productId) {

    }

    @Override
    public void updateProduct(Long productId, Product product) {

    }

    @Override
    public void replaceProduct(Long productId, Product product) {

    }

    private Product convertFakeStoreObjectToProductObject(FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(new Category()); // we have passed category as object in product
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImage());

        return product;
    }
}
