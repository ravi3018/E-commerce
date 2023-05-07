package com.example.Ecommerce.API.service;

import com.example.Ecommerce.API.models.Address;
import com.example.Ecommerce.API.models.Order;
import com.example.Ecommerce.API.models.Product;
import com.example.Ecommerce.API.models.User;
import com.example.Ecommerce.API.repositories.AddressRepository;
import com.example.Ecommerce.API.repositories.OrderRepository;
import com.example.Ecommerce.API.repositories.ProductRepository;
import com.example.Ecommerce.API.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class OrderService {

    @Autowired
    public OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private AddressRepository addressRepository;

    public Order createOrder(Integer userId, Integer productId, Integer addressId, Integer productQuantity) {
        User user = userRepository.findById(Long.valueOf(userId)).orElseThrow(() -> new IllegalArgumentException("User not found with id " + userId));
        Product product = productRepository.findById(Long.valueOf(productId)).orElseThrow(() -> new IllegalArgumentException("Product not found with id " + productId));
        Address address = addressRepository.findById(Long.valueOf(addressId)).orElseThrow(() -> new IllegalArgumentException("Address not found with id " + addressId));
        Order order = new Order();
        order.setUser(user);
        order.setProduct(product);
        order.setAddress(address);
        order.setProductQuantity(productQuantity);
        return orderRepository.save(order);
    }

    public Order getOrderById(Integer orderId) {
        return orderRepository.findById(Long.valueOf(orderId)).orElseThrow(() -> new IllegalArgumentException("Order not found with id " + orderId));
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepository.findAllByCategory(category);
    }

    public void deleteProductById(Integer productId) {
        productRepository.deleteById(Long.valueOf(productId));
    }

}

