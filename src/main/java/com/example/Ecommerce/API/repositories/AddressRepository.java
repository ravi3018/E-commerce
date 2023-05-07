package com.example.Ecommerce.API.repositories;

import com.example.Ecommerce.API.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findAllByUserId(Long userId); // find all addresses belonging to a certain user

    List<Address> findByUserId(Long userId); //

}
