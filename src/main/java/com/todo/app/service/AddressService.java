package com.todo.app.service;

import com.todo.app.entity.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AddressService {

    public Address save(Address address) {
        System.out.println("Coming here and printing");
        return null;
    }
}
