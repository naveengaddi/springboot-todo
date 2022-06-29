package com.todo.app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.todo.app.entity.Address;
import com.todo.app.service.AddressService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

class AddressControllerTest {
    private AddressController addressController;
    private AddressService addressService;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        addressService = mock(AddressService.class);
        addressController = new AddressController(addressService);

    }

    @Test
    void shouldSaveTheAddress() throws Exception {
        Address address = new Address("dummyStreet", "dummyCity", 123543, "dummyCountry", "dummyWareHouseName");
        when(addressService.save(any(Address.class))).thenReturn(address);
        String javaAddressJSON = objectMapper.writeValueAsString(address);

        ResponseEntity<Object> addressResponse = addressController.save(address);

        verify(addressService).save(address);
        Assertions.assertEquals(HttpStatus.CREATED, addressResponse.getStatusCode());
        Assertions.assertEquals(address, addressResponse.getBody());
    }

}
