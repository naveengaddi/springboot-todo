package com.todo.app.controller;

import com.todo.app.entity.Address;
import com.todo.app.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("/address/{id}")
    public ResponseEntity<Object> getById(@PathVariable("id") long id) {
        Optional<Address> address = addressService.getById(id);

        return ResponseEntity.status(HttpStatus.OK).body(address);
    }
}
