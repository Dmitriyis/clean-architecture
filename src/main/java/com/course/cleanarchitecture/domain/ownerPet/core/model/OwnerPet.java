package com.course.cleanarchitecture.domain.ownerPet.core.model;

import com.course.cleanarchitecture.common.utils.checkvalue.ValidationValueUtils;
import com.course.cleanarchitecture.ddd.Aggregate;
import com.course.cleanarchitecture.domain.shared.Address;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Getter
public class OwnerPet extends Aggregate<UUID> {

    private String name;

    private String phone;

    private LocalDate registrationDate;

    private Address address;

    private List<UUID> petsId = new ArrayList<>();

    private OwnerPet() {
    }

    private OwnerPet(UUID id, String name, String phone, LocalDate registrationDate, Address address) {
        super(id);
        this.name = name;
        this.registrationDate = registrationDate;
        this.address = address;
        this.phone = phone;
    }

    private OwnerPet(UUID id, String name, String phone, LocalDate registrationDate, Address address, List<UUID> petsId) {
        super(id);
        this.name = name;
        this.registrationDate = registrationDate;
        this.address = address;
        this.petsId = petsId;
        this.phone = phone;
    }

    public static OwnerPet create(UUID id, String name, String phone, LocalDate registrationDate, Address address) {
        ValidationValueUtils.againstNull(id, "uuid");
        ValidationValueUtils.againstNull(name, "name");
        ValidationValueUtils.againstNull(registrationDate, "registrationDate");
        ValidationValueUtils.againstDateEqualCurrent(registrationDate, "registrationDate");
        ValidationValueUtils.againstNull(address, "address");

        return new OwnerPet(id, name, phone, registrationDate, address);
    }

    public static OwnerPet reStore(UUID uuid, String name, String phone, LocalDate registrationDate, Address address, List<UUID> petsId) {
        return new OwnerPet(uuid, name, phone, registrationDate, address, petsId);
    }
}