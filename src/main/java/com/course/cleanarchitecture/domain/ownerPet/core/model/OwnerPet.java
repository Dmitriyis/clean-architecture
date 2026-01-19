package com.course.cleanarchitecture.domain.ownerPet.core.model;

import com.course.cleanarchitecture.ddd.Aggregate;
import com.course.cleanarchitecture.domain.ownerPet.core.model.valueObject.Address;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Getter
public class OwnerPet extends Aggregate<UUID> {

    private String name;

    private LocalDate registrationDate;

    private Address address;

    List<UUID> petsId = new ArrayList<>();

    private OwnerPet() {
    }

    public OwnerPet(UUID uuid, String name, LocalDate registrationDate, Address address, List<UUID> petsId) {
        super(uuid);
        this.name = name;
        this.registrationDate = registrationDate;
        this.address = address;
        this.petsId = petsId;
    }

    public static OwnerPet reStore(UUID uuid, String name, LocalDate registrationDate, Address address, List<UUID> petsId) {
        return new OwnerPet(uuid, name, registrationDate, address, petsId);
    }
}
