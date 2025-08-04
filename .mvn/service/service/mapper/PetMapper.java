package com.course.cleanarchitecture.entity.service.service.mapper;

import com.course.cleanarchitecture.entity.pet.model.OwnerPetEntity;
import com.course.cleanarchitecture.entity.service.service.dto.PetRequestDto;

public class PetMapper {
    public OwnerPetEntity toPetEntity(PetRequestDto petRequestDto) {
        return new OwnerPetEntity();
    }
}
