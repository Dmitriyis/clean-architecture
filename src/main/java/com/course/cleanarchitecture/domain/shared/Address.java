package com.course.cleanarchitecture.domain.shared;

import com.course.cleanarchitecture.common.utils.checkvalue.ValidationValueUtils;
import com.course.cleanarchitecture.ddd.ValueObject;
import lombok.Getter;

import java.util.List;


@Getter
public class Address extends ValueObject<Address> {

    private String city;

    private String street;

    private String numberHouse;

    private Address() {

    }

    private Address(String city, String street, String numberHouse) {
        this.city = city;
        this.street = street;
        this.numberHouse = numberHouse;
    }

    public static Address createAddress(String city, String street, String numberHouse) {
        ValidationValueUtils.againstNull(city, "address.city");
        ValidationValueUtils.againstNull(street, "address.street");
        ValidationValueUtils.againstNull(numberHouse, "address.numberHouse");
        ValidationValueUtils.againstNegative(Integer.parseInt(numberHouse), "address.numberHouse");

        return new Address(city, street, numberHouse);
    }

    @Override
    protected List<Object> equalityComponents() {
        return List.of(city, street, numberHouse);
    }
}
