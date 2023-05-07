package com.example.Ecommerce.API.repositories;

import com.example.Ecommerce.API.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByUserId(Long userId); //find all orders belonging to a certain user

    List<Order> findAllByProductId(Long productId); //find all orders containing a certain product
}
