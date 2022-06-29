package com.todo.app.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.todo.app.entity.Address;
import com.todo.app.repository.AddressRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class AddressServiceTest {
    private AddressService addressService;
    private ObjectMapper objectMapper;
    private AddressRepository addressRepository;

    @BeforeEach
    void setUp() {
        addressRepository = mock(AddressRepository.class);
        addressService = new AddressService(addressRepository);
        objectMapper = new ObjectMapper();


    }

    @Test
    void shouldSaveAddress() throws Exception {
        Address address = new Address("dummyStreet", "dummyCity", 123543, "dummyCountry", "dummyWareHouseName");
        when(addressRepository.save(any(Address.class))).thenReturn(address);

        Address addressResponse = addressService.save(address);

        verify(addressRepository).save(address);
    }
}
