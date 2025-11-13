package com.course.cleanarchitecture.domain.medicalRecord.service.mapper;

import com.course.cleanarchitecture.domain.medicalRecord.service.dto.PetRequestDto;
import com.course.cleanarchitecture.domain.pet.model.OwnerPetEntity;

public class PetMapper {
    public OwnerPetEntity toPetEntity(PetRequestDto petRequestDto) {
        return new OwnerPetEntity();
    }
}
