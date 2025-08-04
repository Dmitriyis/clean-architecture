package com.course.cleanarchitecture.entity.medicalRecord.service.mapper;

import com.course.cleanarchitecture.entity.medicalRecord.service.dto.PetRequestDto;
import com.course.cleanarchitecture.entity.pet.model.OwnerPetEntity;

public class PetMapper {
    public OwnerPetEntity toPetEntity(PetRequestDto petRequestDto) {
        return new OwnerPetEntity();
    }
}
