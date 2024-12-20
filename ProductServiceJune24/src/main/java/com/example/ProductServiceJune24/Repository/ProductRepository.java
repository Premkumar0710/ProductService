package com.example.ProductServiceJune24.Repository;

import com.example.ProductServiceJune24.Models.Product;
import com.example.ProductServiceJune24.Projections.ProductWithIdAndTitle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
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
    @Override
   Page<Product> findAll(Pageable pageable);

   // HQL
   @Query("select p.id as id, p.title as title from Product p where p.id = :id")
   List<ProductWithIdAndTitle> randomSearchMethod(Long id);

    // Native or normal SQL
    @Query(value = "select p.id as id , p.title as title from product p where p.id = :id", nativeQuery = true)
    List<ProductWithIdAndTitle> randomSearchMethod2(Long id);
}


/*
1. Repository should be an Interface
2. Repository should extend JPA Repository
*/
