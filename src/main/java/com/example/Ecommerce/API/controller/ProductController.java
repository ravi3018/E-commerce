

package com.example.Ecommerce.API.controller;

import com.example.Ecommerce.API.models.Product;
import com.example.Ecommerce.API.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    public ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.findAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Integer id) {
        Optional<Product> product = productService.findProductById(id);
        return product.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(params = "category")
    public ResponseEntity<List<Product>> getProductsByCategory(@RequestParam("category") String category) {
        List<Product> products = productService.findAllProductsByCategory(category);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping(params = "brand")
    public ResponseEntity<List<Product>> getProductsByBrand(@RequestParam("brand") String brand) {
        List<Product> products = productService.findAllProductsByBrand(brand);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping(params = "price")
    public ResponseEntity<List<Product>> getProductsByPriceLessThan(@RequestParam("price") int price) {
        List<Product> products = productService.findAllProductsByPriceLessThan(price);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping(params = "keyword")
    public ResponseEntity<List<Product>> getProductsByKeyword(@RequestParam("keyword") String keyword) {
        List<Product> products = productService.findProductsByKeyword(keyword);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product savedProduct = productService.saveProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Integer id, @RequestBody Product product) {
        Optional<Product> existingProduct = productService.findProductById(id);
        if (existingProduct.isPresent()) {
            product.setId(existingProduct.get().getId());
            Product updatedProduct = productService.saveProduct(product);
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Integer id) {
        Optional<Product> product = productService.findProductById(id);
        if (product.isPresent()) {
            productService.deleteProductById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
