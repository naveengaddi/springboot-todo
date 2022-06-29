package com.todo.app.service;

import com.todo.app.entity.Address;
import com.todo.app.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {
    private AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address save(Address address) {
        return addressRepository.save(address);
    }

    public Optional<Address> getById(Long id) {
        return addressRepository.findById(id);
    }
}
