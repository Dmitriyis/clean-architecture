package com.course.cleanarchitecture.domain.deiver.service.mapper;

import com.course.cleanarchitecture.domain.pet.model.OwnerPetEntity;
import com.course.cleanarchitecture.domain.deiver.service.dto.DriverDto;

public class DriverMapper {
    public OwnerPetEntity toPetEntity(DriverDto petRequestDto) {
        return new OwnerPetEntity();
    }
}
