package com.course.cleanarchitecture.domain.ownerPet.core.model.valueObject;

import jakarta.persistence.Column;
import lombok.Getter;


@Getter
public class Address {

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "number_house")
    private String numberHouse;

    private Address() {

    }

    public Address(String city, String street, String numberHouse) {

        this.city = city;
        this.street = street;
        this.numberHouse = numberHouse;
    }
}
