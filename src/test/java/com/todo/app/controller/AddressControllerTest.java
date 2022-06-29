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

    @Test
    void shouldReturnAddressById() throws Exception {
        Address address = new Address("dummyStreet", "dummyCity", 123543, "dummyCountry", "dummyWareHouseName");
        when(addressService.getById(any(Long.class))).thenReturn(java.util.Optional.of(address));

        ResponseEntity<Object> addressResponse = addressController.getById(1L);

        verify(addressService).getById(1L);
        Assertions.assertEquals(HttpStatus.OK, addressResponse.getStatusCode());
        Assertions.assertEquals(java.util.Optional.of(address), addressResponse.getBody());
    }

}
