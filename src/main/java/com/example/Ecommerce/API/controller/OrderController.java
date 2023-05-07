package com.example.Ecommerce.API.controller;


import com.example.Ecommerce.API.models.Order;
import com.example.Ecommerce.API.models.Product;
import com.example.Ecommerce.API.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    public OrderService orderService;


    @PostMapping("")
    public ResponseEntity<Order> createOrder(@RequestParam Integer userId,
                                             @RequestParam Integer productId,
                                             @RequestParam Integer addressId,
                                             @RequestParam Integer productQuantity) {
        Order order = orderService.createOrder(userId, productId, addressId, productQuantity);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable Integer orderId) {
        Order order = orderService.getOrderById(orderId);
        return ResponseEntity.ok(order);
    }

    @GetMapping("")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = orderService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/products/category")
    public ResponseEntity<List<Product>> getProductsByCategory(@RequestParam String category) {
        List<Product> products = orderService.getProductsByCategory(category);
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Integer productId) {
        orderService.deleteProductById(productId);
        return ResponseEntity.noContent().build();
    }
}

