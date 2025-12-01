package com.example.ProductService.Service;

import com.example.ProductService.Dtos.FakeStoreProductDto;
import com.example.ProductService.Exceptions.ProductNotFoundException;
import com.example.ProductService.Models.Category;
import com.example.ProductService.Models.Product;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("FakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Product> getAllProducts() {

      //  ResponseEntity<List<FakeStoreProductDto>> responseEntity = restTemplate.getForEntity("https://fakestoreapi.com/products",List<FakeStoreProductDto>.class); In runtime we cannot use List<Fakestore> because of type erasure concept
        ResponseEntity<FakeStoreProductDto[]> responseEntity =
                restTemplate.getForEntity("https://fakestoreapi.com/products",FakeStoreProductDto[].class);

        FakeStoreProductDto[] fakeStoreProductDtos = responseEntity.getBody();
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos){
            products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
        }

        return products;
    }

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {

        // make a http call to fakestoreapi to get the product with given id
       // RestTemplate restTemplate = new RestTemplate(); -> added this in configs package to make it globally available
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.getForEntity("https://fakestoreapi.com/products/" + productId, FakeStoreProductDto.class);
      //  FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();

        // convert fakeStoreProductDto to product
       // return convertFakeStoreProductDtoToProduct(responseEntity.getBody());

        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();

        if(fakeStoreProductDto == null){
            // invalid productId
            throw new ProductNotFoundException(productId);
        }

        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public Product createProduct(Product product) {

        FakeStoreProductDto dto = convertProductToFakeStoreProductDto(product);

        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.postForEntity(
                        "https://fakestoreapi.com/products",
                        dto,
                        FakeStoreProductDto.class
                );

        return convertFakeStoreProductDtoToProduct(responseEntity.getBody());
    }


    @Override
    public Product replaceProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public Page<Product> getProductsByTitle(String title, int pageNumber, int pageSize) {
        return null;
    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto){

//        if(fakeStoreProductDto == null){
//            return null;
//        }

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

    private FakeStoreProductDto convertProductToFakeStoreProductDto(Product product) {
        FakeStoreProductDto dto = new FakeStoreProductDto();
        dto.setId(product.getId());
        dto.setTitle(product.getTitle());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setImage(product.getImageUrl());
        dto.setCategory(product.getCategory().toString());
        return dto;
    }

}
