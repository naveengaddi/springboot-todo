package com.todo.app.controller;

import com.todo.app.entity.Address;
import com.todo.app.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class AddressController {

    private AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/address")
    public ResponseEntity<Object> save(@RequestBody Address address) {
        Address response = addressService.save(address);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
