package com.example.ProductServiceJune24.Repository;

import com.example.ProductServiceJune24.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category save(Category category);
}
