package com.example.Ecommerce.API.repositories;

import com.example.Ecommerce.API.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


     Optional<User> findByEmail(String email);   // find a user by their email address
    Optional<User> findByPhoneNumber(String phoneNumber); //find a user by their phone number

}
