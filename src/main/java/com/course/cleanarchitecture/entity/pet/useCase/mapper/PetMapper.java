package com.course.cleanarchitecture.entity.pet.useCase.mapper;

import com.course.cleanarchitecture.entity.pet.model.PetEntity;
import com.course.cleanarchitecture.entity.pet.plugins.database.repository.PetSearchParamsSpecification;
import com.course.cleanarchitecture.entity.pet.useCase.dto.PetRequestDto;
import com.course.cleanarchitecture.entity.pet.useCase.dto.PetSearchParamsDto;
import com.course.cleanarchitecture.entity.pet.useCase.dto.PetUpdateDto;

import java.util.UUID;


public interface PetMapper {
    PetEntity toPetEntity(PetRequestDto pet, UUID petId);

    PetEntity toPetEntity(PetUpdateDto pet, PetEntity petEntity);

    PetSearchParamsSpecification toPetSearchParamsInfra(PetSearchParamsDto pet);
}
