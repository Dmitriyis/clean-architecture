package com.course.cleanarchitecture.domain.service.service.mapper;

import com.course.cleanarchitecture.domain.pet.model.OwnerPetEntity;
import com.course.cleanarchitecture.domain.service.service.dto.PetRequestDto;

public class PetMapper {
    public OwnerPetEntity toPetEntity(PetRequestDto petRequestDto) {
        return new OwnerPetEntity();
    }
}
