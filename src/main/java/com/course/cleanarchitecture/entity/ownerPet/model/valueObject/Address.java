package com.course.cleanarchitecture.entity.ownerPet.model.valueObject;

import com.course.cleanarchitecture.entity.ownerPet.exceptions.OwnerPetInvalidFieldException;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
public class Address {

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "number_house")
    private String numberHouse;

    public Address(String city, String street, String numberHouse) {
        validate(city, street, numberHouse);
        this.city = city;
        this.street = street;
        this.numberHouse = numberHouse;
    }

    public static Address from(String city, String street, String numberHouse) {
        validate(city, street, numberHouse);
        return new Address(city, street, numberHouse);
    }

    private static void validate(String city, String street, String numberHouse) {
        if (city == null) {
            String message = OwnerPetInvalidFieldException.prepareMessage("city", null, "Не можеть быть null");
            throw new OwnerPetInvalidFieldException(message);
        }

        if (street == null) {
            String message = OwnerPetInvalidFieldException.prepareMessage("street", null, "Не можеть быть null");
            throw new OwnerPetInvalidFieldException(message);
        }

        if (numberHouse == null) {
            String message = OwnerPetInvalidFieldException.prepareMessage("numberHouse", null, "Не можеть быть null");
            throw new OwnerPetInvalidFieldException(message);
        }

        if (city.isEmpty()) {
            String message = OwnerPetInvalidFieldException.prepareMessage("city", "", "Не можеть быть empty");
            throw new OwnerPetInvalidFieldException(message);
        }

        if (street.isEmpty()) {
            String message = OwnerPetInvalidFieldException.prepareMessage("street", "", "Не можеть быть empty");
            throw new OwnerPetInvalidFieldException(message);
        }

        if (numberHouse.isEmpty()) {
            String message = OwnerPetInvalidFieldException.prepareMessage("street", "", "Не можеть быть empty");
            throw new OwnerPetInvalidFieldException(message);
        }
    }
}
