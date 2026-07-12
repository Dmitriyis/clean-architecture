package com.course.cleanarchitecture.domain.ownerPet.core.application.commands;

import com.course.cleanarchitecture.common.utils.checkvalue.ValidationValueUtils;
import com.course.cleanarchitecture.domain.shared.Address;
import lombok.Getter;

@Getter
public class CreateOwnerPetCommand {

    private String phone;

    private String name;

    private Address address;

    private CreateOwnerPetCommand() {
    }

    public CreateOwnerPetCommand(String phone, String name, String city, String street, String numberHouse) {
        ValidationValueUtils.againstNull(phone, "phone");
        ValidationValueUtils.againstNull(name, "name");

        Address address = Address.createAddress(city, street, numberHouse);

        this.phone = phone;
        this.name = name;
        this.address = address;
    }
}
