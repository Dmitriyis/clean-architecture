package com.course.cleanarchitecture.entity.ownerPet.application.useCase.mapper;

import com.course.cleanarchitecture.entity.ownerPet.application.useCase.dto.OwnerPetRequestDto;
import com.course.cleanarchitecture.entity.ownerPet.application.useCase.dto.OwnerPetSearchParamsDto;
import com.course.cleanarchitecture.entity.ownerPet.application.useCase.dto.OwnerPetUpdateDto;
import com.course.cleanarchitecture.entity.ownerPet.model.GenerateOwnerPetEntity;
import com.course.cleanarchitecture.entity.ownerPet.model.OwnerPetEntity;
import com.course.cleanarchitecture.entity.ownerPet.model.valueObject.Address;
import com.course.cleanarchitecture.entity.ownerPet.infrastructure.adapter.database.repository.OwnerPetSearchParamsSpecification;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OwnerPetMapper {

    public OwnerPetEntity toPetEntity(OwnerPetRequestDto ownerPet, UUID ownerPetId) {
        Address address = Address.from(ownerPet.getCity(), ownerPet.getStreet(), ownerPet.getNumberHouse());
        return GenerateOwnerPetEntity.generate(ownerPetId, ownerPet.getName(), ownerPet.getRegistrationDate(), address);
    }


    public OwnerPetEntity toPetEntity(OwnerPetUpdateDto ownerPet, OwnerPetEntity ownerPetEntity) {
        Address address = Address.from(ownerPet.getCity(), ownerPet.getStreet(), ownerPet.getNumberHouse());
        return GenerateOwnerPetEntity.generate(ownerPetEntity.getId(), ownerPet.getName(), ownerPetEntity.getRegistrationDate(), address);
    }
    public OwnerPetSearchParamsSpecification toOwnerPetSearchParamsInfra(OwnerPetSearchParamsDto ownerPet) {
        return null;
    }
}
