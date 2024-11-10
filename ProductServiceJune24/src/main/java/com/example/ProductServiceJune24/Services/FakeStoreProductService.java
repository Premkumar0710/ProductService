package com.example.ProductServiceJune24.Services;

import com.example.ProductServiceJune24.CustomExceptions.ProductNotFoundException;
import com.example.ProductServiceJune24.Models.Category;
import com.example.ProductServiceJune24.Models.Product;
import com.example.ProductServiceJune24.dtos.FakeStoreProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("FakeStoreProductService")
//@Primary
public class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate;
    private RedisTemplate<String, Object> redisTemplate;

      public FakeStoreProductService(RestTemplate restTemplate, RedisTemplate redisTemplate){
          this.restTemplate = restTemplate;
          this.redisTemplate = redisTemplate;
    }

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        //  throw new ArithmeticException();

        // try to fetch the product from redis
        Product product =  (Product) redisTemplate.opsForHash().get("PRODUCTS","PRODUCT_" + productId);
        if(product!=null){
            // cache Hit
            return product;
        }

        // cache miss

        // call FakeStore to fetch the Product with given id. -> HTTP call
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + productId ,
                FakeStoreProductDto.class
        );

        if(fakeStoreProductDto == null){
            throw new ProductNotFoundException("Product with id " + productId + " doesn't exist",productId);
        }

        // Convert FakeStoreProductDto into product

        // Cache MISS
        product = convertFakeStoreProductToProduct(fakeStoreProductDto);
        redisTemplate.opsForHash().put("PRODUCTS","PRODUCT_" + productId, product);
        return product;
    }

    @Override
    public Page<Product> getAllProducts(int pageNumber , int pageSize) {
          FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject(
                "https://fakestoreapi.com/products" ,
                  FakeStoreProductDto[].class
        );

                //Convert list of FakeStoreProductDto into list of product
                List<Product> products = new ArrayList<>();
                for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos){
                    products.add(convertFakeStoreProductToProduct(fakeStoreProductDto));
                }
                return new PageImpl<>(products);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(product, FakeStoreProductDto.class);
        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor = new HttpMessageConverterExtractor(FakeStoreProductDto.class, restTemplate.getMessageConverters());
        FakeStoreProductDto response =  restTemplate.execute("https://fakestoreapi.com/products" + id,
                HttpMethod.PATCH, requestCallback, responseExtractor);

        return convertFakeStoreProductToProduct(response);

    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }

    @Override
    public Product addNewProduct(Long id, Product product) {
        return null;
    }

    private Product convertFakeStoreProductToProduct(FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setCreatedAt(fakeStoreProductDto.getCreatedAt());
        product.setUpdatedAt(fakeStoreProductDto.getUpdatedAt()); // given createdDate only as of now.
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());


        Category category = new Category();
        category.setDescription(fakeStoreProductDto.getCategory());
        product.setCategory(category);

        return product;
    }
}
