package com.springbootjpa.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springbootjpa.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByName(String name);
    
    @Query(value = "SELECT * FROM PRODUCT_TBL", nativeQuery = true)
    List<Product> findAllProducts();
    
    @Query(value = "SELECT * FROM PRODUCT_TBL WHERE price > ?1", nativeQuery = true)
    List<Product> findselectedProducts(Double price);
    
    @Query(value = "SELECT * FROM PRODUCT_TBL WHERE price BETWEEN  ?1 AND ?2", nativeQuery = true)
    List<Product> findselectedProducts2(Double gprice, Double lprice);
}