package com.course.cleanarchitecture.domain.ownerPet.adapters.out.postgres;

import com.course.cleanarchitecture.domain.ownerPet.core.model.OwnerPet;
import com.course.cleanarchitecture.domain.shared.Address;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OwnerPetJpaMapper {

    OwnerPet toOwnerPet(OwnerPetEntity ownerPetEntity, List<UUID> petIds) {
        Address address = mapToAddress(ownerPetEntity);

        return OwnerPet.reStore(
                ownerPetEntity.getId(),
                ownerPetEntity.getName(),
                ownerPetEntity.getPhone(),
                ownerPetEntity.getRegistrationDate(),
                address,
                petIds == null ? new ArrayList<>() : petIds
        );
    }


    OwnerPetEntity toOwnerPetEntity(OwnerPet ownerPet) {
        OwnerPetEntity ownerPetEntity = OwnerPetEntity
                .builder()
                .id(ownerPet.getId())
                .phone(ownerPet.getPhone())
                .name(ownerPet.getName())
                .registrationDate(ownerPet.getRegistrationDate())
                .city(ownerPet.getAddress().getCity())
                .street(ownerPet.getAddress().getStreet())
                .numberHouse(ownerPet.getAddress().getNumberHouse())
                .build();

        return ownerPetEntity;
    }


    private Address mapToAddress(OwnerPetEntity entity) {
        if (entity == null) {
            return null;
        }

        return Address.createAddress(
                entity.getCity(),
                entity.getStreet(),
                entity.getNumberHouse()
        );
    }
}
