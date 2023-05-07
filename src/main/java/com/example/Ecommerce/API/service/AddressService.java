package com.example.Ecommerce.API.service;

import com.example.Ecommerce.API.models.Address;
import com.example.Ecommerce.API.repositories.AddressRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    public AddressRepository addressRepository;



    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Address getAddressById(Integer id) {
        Optional<Address> optionalAddress = addressRepository.findById(Long.valueOf(id));
        if (optionalAddress.isPresent()) {
            return optionalAddress.get();
        } else {
            throw new EntityNotFoundException("Address not found with id: " + id);
        }
    }

    public List<Address> getAddressesByUserId(Integer userId) {
        return addressRepository.findByUserId(Long.valueOf(userId));
    }

    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address updateAddress(Integer id, Address address) {
        Optional<Address> optionalAddress = addressRepository.findById(Long.valueOf(id));
        if (optionalAddress.isPresent()) {
            Address existingAddress = optionalAddress.get();
            existingAddress.setName(address.getName());
            existingAddress.setLandmark(address.getLandmark());
            existingAddress.setPhoneNumber(address.getPhoneNumber());
            existingAddress.setZipcode(address.getZipcode());
            existingAddress.setState(address.getState());
            existingAddress.setUser(address.getUser());
            return addressRepository.save(existingAddress);
        } else {
            throw new EntityNotFoundException("Address not found with id: " + id);
        }
    }

    public void deleteAddressById(Integer id) {
        addressRepository.deleteById(Long.valueOf(id));
    }
}
