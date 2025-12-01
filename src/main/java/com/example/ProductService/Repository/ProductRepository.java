package com.example.ProductService.Repository;

import com.example.ProductService.Models.Category;
import com.example.ProductService.Models.Product;
import com.example.ProductService.Projections.ProductWithTitleAndPrice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    // declared queries
    @Override // @Override isn't mandatory
    Optional<Product> findById(Long productId);

    @Override
    List<Product> findAll();

    // select * product where lower(title like '%iphone17%');
    Page<Product> findByTitleContainsIgnoreCase(String title, Pageable pageable);

    List<Product> findByPriceBetween(Double start,Double end);

    // custom methods
    Optional<Product> findByTitleIgnoreCaseAndPriceBetween(String title,Double start,Double end);
    List<Product> findByCreatedAtBetween(Date start, Date end);


    @Override
    void deleteById(Long productId);

    Product save(Product product);

    // HQL - we can also use custom queries , but HQL is something even if we migrate database still it works , if DB isn't changed we can also prefer native query.
    // Here 'ProductWithTitleAndPrice' is a projection
//    @Query("select p.title,p.price from Product p where p.title='iphone' and p.price<100000")
//    List<ProductWithTitleAndPrice> findByTitleAndPriceById();

    @Query("select p.title as title, p.price as price " +
            "from Product p " +
            "where p.title = :title and p.price < :price")
    List<ProductWithTitleAndPrice> findTitleAndPriceByTitleAndPriceLessThan(
            @Param("title") String title,
            @Param("price") Double price
    );

    Optional<Product> findByCategory(Category category);
    // if we use _ then we can filter out inner attributes of an object
    Optional<Product> findByCategory_Title(String title);

}
