package com.course.cleanarchitecture.domain.ownerPet.adapters.out.postgres;

import com.course.cleanarchitecture.domain.ownerPet.core.model.OwnerPet;

public class OwnerPetToOwnerPetEntityMapper {

    public static OwnerPetEntity OwnerPetToOwnerPetEntity(OwnerPet ownerPet) {

        return OwnerPetEntity
                .builder()
                .id(ownerPet.getId())
                .name(ownerPet.getName())
                .phone(ownerPet.getPhone())
                .address(ownerPet.getAddress())
                .registrationDate(ownerPet.getRegistrationDate())
                .build();
    }
}
