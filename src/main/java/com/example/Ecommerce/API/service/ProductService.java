package com.example.Ecommerce.API.service;

import com.example.Ecommerce.API.models.Product;
import com.example.Ecommerce.API.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    @Autowired
    public ProductRepository productRepository;

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> findProductById(Integer id) {
        return productRepository.findById(Long.valueOf(id));
    }

    public List<Product> findAllProductsByCategory(String category) {
        return productRepository.findAllByCategory(category);
    }

    public List<Product> findAllProductsByBrand(String brand) {
        return productRepository.findAllByBrand(brand);
    }

    public List<Product> findAllProductsByPriceLessThan(int price) {
        return productRepository.findAllByPriceLessThan(price);
    }

    public List<Product> findProductsByKeyword(String keyword) {
        return productRepository.findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(keyword, keyword);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProductById(Integer id) {
        productRepository.deleteById(Long.valueOf(id));
    }
}
