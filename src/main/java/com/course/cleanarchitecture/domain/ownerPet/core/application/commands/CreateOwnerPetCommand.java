package com.course.cleanarchitecture.domain.ownerPet.core.application.commands;

import com.course.cleanarchitecture.common.utils.checkvalue.ValidationValueUtils;
import com.course.cleanarchitecture.domain.ownerPet.core.model.valueObject.Address;
import lombok.Data;

@Data
public class CreateOwnerPetCommand {

    private String phone;

    private String name;

    private Address address;

    private CreateOwnerPetCommand() {
    }

    public CreateOwnerPetCommand(String phone, String name, Address address) {
        ValidationValueUtils.againstNull(phone, "phone");
        ValidationValueUtils.againstNull(name, "name");
        ValidationValueUtils.againstNull(address, "address");
        ValidationValueUtils.againstNull(address.getCity(), "address.city");
        ValidationValueUtils.againstNull(address.getStreet(), "address.street");
        ValidationValueUtils.againstNull(address.getNumberHouse(), "address.numberHouse");

        this.phone = phone;
        this.name = name;
        this.address = address;
    }
}
