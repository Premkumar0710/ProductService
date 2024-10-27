package com.example.ProductServiceJune24.Repository;

import com.example.ProductServiceJune24.Models.Product;
import com.example.ProductServiceJune24.Projections.ProductWithIdAndTitle;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {
    // Product Repo should contain all the methods (CRUD) related to Product model
    List<Product> findByPriceIsGreaterThan(Double price);
    //select * from products where price > ?

    List<Product> findProductByTitleLike(String word); // case sensitive
    //select * from products where title like '%iphone%'

    List<Product> findByTitleLikeIgnoreCase(String word); // case insensitive.

    List<Product> findTop5ByTitleContains(String word);
    //select * from products where title like '' LIMIT 5

//    List<Product> findTopByTitleContains(int top, String word);

    List<Product> findProductsByTitleContainsAndPriceGreaterThan(
            String word,
            Double price
    );

    List<Product> findProductsByTitleContainsOrderById(String word);

   Optional<Product> findById(Long id);

   List<Product> findAll(Sort sort);

   // HQL
    @Query("select p.id , p.title from product p where p.id = :id")
    List<ProductWithIdAndTitle> randomSearchMethod(Long id);

    // Native
    @Query(value = "select p.id , p.title as title from product p where p.id = :id", nativeQuery = true)
    List<ProductWithIdAndTitle> randomSearchMethod2(Long id);
}


/*
1. Repository should be an Interface
2. Repository should extend JPA Repository
*/
