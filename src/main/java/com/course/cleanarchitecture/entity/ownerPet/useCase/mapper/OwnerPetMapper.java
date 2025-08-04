package com.course.cleanarchitecture.entity.ownerPet.useCase.mapper;

import com.course.cleanarchitecture.entity.ownerPet.model.OwnerPetEntity;
import com.course.cleanarchitecture.entity.ownerPet.plugins.database.repository.OwnerPetSearchParamsSpecification;
import com.course.cleanarchitecture.entity.ownerPet.useCase.dto.OwnerPetRequestDto;
import com.course.cleanarchitecture.entity.ownerPet.useCase.dto.OwnerPetSearchParamsDto;
import com.course.cleanarchitecture.entity.ownerPet.useCase.dto.OwnerPetUpdateDto;

import java.util.UUID;


public interface OwnerPetMapper {
    OwnerPetEntity toPetEntity(OwnerPetRequestDto ownerPet, UUID ownerPetId);

    OwnerPetEntity toPetEntity(OwnerPetUpdateDto ownerPet, OwnerPetEntity ownerPetEntity);

    OwnerPetSearchParamsSpecification toOwnerPetSearchParamsInfra(OwnerPetSearchParamsDto ownerPet);
}
