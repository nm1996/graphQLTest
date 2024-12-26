package com.nm.graphql.demo.repository;

import com.nm.graphql.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.category.id = :categoryId")
    List<Product> findByCategoryId(@Param("categoryId") Long category);



    @Query("SELECT p FROM Product p ORDER BY p.price DESC LIMIT 1")
    Optional<Product> findMostExpensive();
}
