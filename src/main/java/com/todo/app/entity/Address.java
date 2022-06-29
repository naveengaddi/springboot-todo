package com.todo.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long partnerId;
    private String street;
    private String city;
    private int zipCode;
    private String country;
    private String wareHouseName;

    public Address(String street, String city, int zipCode, String country, String wareHouseName) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
        this.wareHouseName = wareHouseName;
    }
}
