package com.course.cleanarchitecture.domain.ownerPet.core.model.valueObject;

import jakarta.persistence.Column;
import lombok.Getter;


@Getter
public class Address {

    private String city;

    private String street;

    private String numberHouse;

    private Address() {

    }

    public Address(String city, String street, String numberHouse) {

        this.city = city;
        this.street = street;
        this.numberHouse = numberHouse;
    }
}
