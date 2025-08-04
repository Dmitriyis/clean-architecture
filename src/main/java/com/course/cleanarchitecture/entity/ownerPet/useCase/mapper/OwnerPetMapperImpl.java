package com.course.cleanarchitecture.entity.ownerPet.useCase.mapper;

import com.course.cleanarchitecture.entity.ownerPet.model.GenerateOwnerPetEntity;
import com.course.cleanarchitecture.entity.ownerPet.model.OwnerPetEntity;
import com.course.cleanarchitecture.entity.ownerPet.model.valueObject.Address;
import com.course.cleanarchitecture.entity.ownerPet.plugins.database.repository.OwnerPetSearchParamsSpecification;
import com.course.cleanarchitecture.entity.ownerPet.useCase.dto.OwnerPetRequestDto;
import com.course.cleanarchitecture.entity.ownerPet.useCase.dto.OwnerPetSearchParamsDto;
import com.course.cleanarchitecture.entity.ownerPet.useCase.dto.OwnerPetUpdateDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OwnerPetMapperImpl implements OwnerPetMapper {
    @Override
    public OwnerPetEntity toPetEntity(OwnerPetRequestDto ownerPet, UUID ownerPetId) {
        Address address = Address.from(ownerPet.getCity(), ownerPet.getStreet(), ownerPet.getNumberHouse());
        return GenerateOwnerPetEntity.generate(ownerPetId, ownerPet.getName(), ownerPet.getRegistrationDate(), address);
    }

    @Override
    public OwnerPetEntity toPetEntity(OwnerPetUpdateDto ownerPet, OwnerPetEntity ownerPetEntity) {
        Address address = Address.from(ownerPet.getCity(), ownerPet.getStreet(), ownerPet.getNumberHouse());
        return GenerateOwnerPetEntity.generate(ownerPetEntity.getId(), ownerPet.getName(), ownerPetEntity.getRegistrationDate(), address);
    }

    @Override
    public OwnerPetSearchParamsSpecification toOwnerPetSearchParamsInfra(OwnerPetSearchParamsDto ownerPet) {
        return null;
    }
}
