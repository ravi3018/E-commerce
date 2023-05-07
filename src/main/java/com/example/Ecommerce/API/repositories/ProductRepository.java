package com.example.Ecommerce.API.repositories;

import com.example.Ecommerce.API.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByCategory(String category);  // find all products in a certain category

    List<Product> findAllByBrand(String brand); // find all products from a certain brand

    List<Product> findAllByPriceLessThan(int price); // find all products with a price less than a certain amount

    List<Product> findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String keyword, String keyword1);
}
